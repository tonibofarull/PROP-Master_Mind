package Dominio;

import java.util.*;

public class Maquina {

    private TreeSet<String> S;
    private TreeSet<String> candidatos_restantes;
    private boolean primer_turno;

    private Tablero tablero;
    private Normas normas;

    private Dificultad dificultad;

    private void inicializarDatos(int pos, int num, ArrayList<Boolean> asign, boolean prohibido_rep) {
        int max_val = 6;
        if (dificultad == Dificultad.DIFICIL) max_val = 7;
        if (pos == 4) {
            S.add(Integer.toString(num));
            candidatos_restantes.add(Integer.toString(num));
            return;
        }
        for (int i = 1; i <= max_val; ++i) {
            if (!prohibido_rep || !asign.get(i-1)) {
                if (prohibido_rep) asign.set(i-1,true);
                inicializarDatos(pos+1,num*10+i, asign, prohibido_rep);
                if (prohibido_rep) asign.set(i-1,false);
            }
        }
    }

    private String minimax() {
        TreeSet<String> guesses = new TreeSet<>();
        int max = Integer.MIN_VALUE;
        for (String g: candidatos_restantes) {
            Map<String,Integer> Z_g = new HashMap<>();
            for (String s : S) {
                String val = normas.calcularNB(g,s);
                if (Z_g.containsKey(val)) {
                    Integer int_aux = Z_g.get(val);
                    Z_g.replace(val, int_aux+1);
                }
                else Z_g.put(val,1);
            }
            int min = Integer.MAX_VALUE;
            Collection<Integer> col = Z_g.values();
            for (Integer valit : col) {
                if (min > S.size()-valit) min = S.size()-valit;
            }
            if (max == min) guesses.add(g);
            else if (max < min) {
                guesses.clear();
                max = min;
                guesses.add(g);
            }
        }
        for (String r : guesses) {
            if (S.contains(r)) return r;
        }
        return guesses.first();
    }

    private void nuevaBN(String candidato, String NB) {
        TreeSet<String> Saux = (TreeSet<String>) S.clone();
        for (String a : Saux) {
            String r = normas.calcularNB(a,candidato);
            if (!NB.equals(r)) S.remove(a);
        }
    }

    // PUBLIC functions

    public Maquina(Tablero tablero, Normas normas, Dificultad dif, Rol rolJugadorHumano) {
        dificultad = dif;
        this.tablero = tablero;
        this.normas = normas;
        if (rolJugadorHumano == Rol.CODEMAKER) {
            this.primer_turno = true;
            S = new TreeSet<>();
            candidatos_restantes = new TreeSet<>();
            int capacidad = 6;
            if (dif == Dificultad.DIFICIL) capacidad = 7;
            ArrayList<Boolean> asign = new ArrayList<>(capacidad);
            boolean prohibido_rep = dificultad == Dificultad.FACIL;
            if (prohibido_rep) for (int i = 1; i <= capacidad; ++i) asign.add(false);
            inicializarDatos(0,0,asign,prohibido_rep);
        }
    }

    public void reanudarMaquina() {
        int numero_lineas = tablero.getNumLineas();
        if (numero_lineas == 0) primer_turno = false; // TODO revisar como sabremos si se ha reiniciado
        for (int i = 0; i < numero_lineas; ++i) {
            String can = tablero.getCandidato(i);
            if (tablero.existsNB(i)) {
                String eval = tablero.getNB(i);
                nuevaBN(can,eval);
            }
        }
    }

    public String generarCandidato() {
        if (primer_turno) {
            primer_turno = false;
            String r = "1122";
            if (dificultad == Dificultad.FACIL) r = "1234";
            S.remove(r);
            candidatos_restantes.remove(r);
            return r;
        }
        // actualizamos la info de la ultima jugada hecha
        String ultimoCandidato = tablero.getUltimoCandidato();
        String ultimaBN = tablero.getUltimoNB();
        nuevaBN(ultimoCandidato,ultimaBN);

        String r = minimax();
        S.remove(r);
        candidatos_restantes.remove(r);
        return r;
    }

    public String generarSolucion() {
        int max_val = 7;
        int res = 0;
        Random rand = new Random(); // nextInt(bound) -> [0..bound)
        switch (dificultad) {
            case FACIL: // no repeticion y de 1..6
                ArrayList<Integer> list = new ArrayList<>(6);
                for (int i = 1; i <= 6; ++i) list.add(i);
                for (int i = 0; i < 4; ++i) {
                    int index = rand.nextInt(list.size());
                    res = res*10 + list.get(index);
                    list.remove(index);
                }
                break;
            case MEDIO: // repeticion y de 1..6
                max_val = 6;
            case DIFICIL: // repeticion y de 1..7
                for (int i = 0; i < 4; ++i) {
                    res = res*10 + rand.nextInt(max_val)+1;
                }
                break;
            default:
                break;
        }
        return Integer.toString(res);
    }

    public String evaluarCandidato(String candidato, String solucion) { // TODO pensar si deberia hacerlo la norma
        return normas.calcularNB(candidato, solucion);
    }

}

