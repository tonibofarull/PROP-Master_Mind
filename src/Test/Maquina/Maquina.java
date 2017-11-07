package Test.Maquina;

import Dominio.Dificultad;
import Dominio.Rol;

import java.util.*;

public class Maquina {

    private boolean primer_turno;
    private TreeSet<String> S;
    private TreeSet<String> candidatos_restantes;

    private Dificultad dificultad;

    private Stub_Tablero tablero;
    private Stub_Normas normas;

    private void inicializarDatos(int pos, int num, ArrayList<Boolean> asign, int max_val, boolean prohibido_rep) {
        if (pos == 4) {
            S.add(Integer.toString(num));
            candidatos_restantes.add(Integer.toString(num));
            return;
        }
        for (int i = 1; i <= max_val; ++i) {
            if (!prohibido_rep || !asign.get(i-1)) {
                if (prohibido_rep) asign.set(i-1,true);
                inicializarDatos(pos+1,num*10+i, asign, max_val, prohibido_rep);
                if (prohibido_rep) asign.set(i-1,false);
            }
        }
    }

    private String minimax() {
        TreeSet<String> guesses = new TreeSet<>();
        int max = Integer.MIN_VALUE;
        for (String g: candidatos_restantes) {
            Map<String,Integer> NB_g = new HashMap<>();
            // NB_g contedra el numero de veces que aparecen los distintos NB's resultantes de comparar:
            // -- g con los elementos de S
            for (String s : S) {
                String val = normas.calcularNB(g,s);
                if (NB_g.containsKey(val)) {
                    Integer int_aux = NB_g.get(val);
                    NB_g.replace(val, int_aux+1);
                }
                else NB_g.put(val,1);
            }
            int min = Integer.MAX_VALUE;
            Collection<Integer> col = NB_g.values();
            // calculamos el minimo numero de elementos de S que eliminaria g si lo usaramos como proximo candidato
            for (Integer valit : col) {
                if (min > S.size()-valit) min = S.size()-valit;
            }
            // en caso de eliminar los mismos elementos de S lo anadimos como posible candidato
            // -- si elimina mas, vaciariamos los posibles candidatos hasta ahora y este seria el nuevo candidato
            if (max == min) guesses.add(g);
            else if (max < min) {
                guesses.clear();
                max = min;
                guesses.add(g);
            }
        }
        // de entre todas los posibles candidatos en orden creciente, escogemos el primero que sea de S
        for (String r : guesses) {
            if (S.contains(r)) return r;
        }
        // si no hay candidato que este en S escogemos el de valor menor
        return guesses.first();
    }

    private void nuevaNB(String candidato, String NB) {
        Iterator<String> it = S.iterator();
        while (it.hasNext()) {
            String g = it.next();
            String nb = normas.calcularNB(g,candidato);
            if (!NB.equals(nb)) it.remove();
        }
    }

    // PUBLIC functions

    public Maquina(Stub_Tablero tablero, Stub_Normas normas, Dificultad dif, Rol rolJugadorHumano) {
        dificultad = dif;
        this.tablero = tablero;
        this.normas = normas;
        if (rolJugadorHumano == Rol.CODEMAKER) {
            this.primer_turno = true;
            S = new TreeSet<>();
            candidatos_restantes = new TreeSet<>();

            int max_val = 6;
            if (dif == Dificultad.DIFICIL) max_val = 7;

            ArrayList<Boolean> asign = new ArrayList<>(max_val);
            boolean prohibido_rep = dificultad == Dificultad.FACIL;
            if (prohibido_rep) for (int i = 1; i <= max_val; ++i) asign.add(false);
            inicializarDatos(0,0,asign,max_val,prohibido_rep);
        }
    }

    public String generarCandidato() {
        if (primer_turno) {
            primer_turno = false;

            String candidato = "1122";
            if (dificultad == Dificultad.FACIL) candidato =  "1234"; // Valor arbitrario

            S.remove(candidato);
            candidatos_restantes.remove(candidato);
            return candidato;
        }
        // si no es el primer turno es debido a que hemos propuesto un candidato que no era la solcion,
        // -- obtenemos el ultimo candidato con las NB y actualizamos las estructuras de datos
        String ultimoCandidato = tablero.getUltimoCandidato();
        String ultimaNB = tablero.getUltimoNB();
        nuevaNB(ultimoCandidato,ultimaNB);

        // obtenemos el mejor candidato segun el algoritmo de minimax y actualizamos los datos pertinentes
        String r = minimax();
        S.remove(r);
        candidatos_restantes.remove(r);
        return r;
    }

    public String generarSolucion() {
        int max_val = 7;
        int solucion = 0;
        Random rand = new Random(); // nextInt(bound) -> [0..bound)
        switch (dificultad) {
            case FACIL: // no repeticion y de 1..6
                ArrayList<Integer> list = new ArrayList<>(6);
                for (int i = 1; i <= 6; ++i) list.add(i);
                for (int i = 0; i < 4; ++i) {
                    int index = rand.nextInt(list.size());
                    solucion = solucion*10 + list.get(index);
                    list.remove(index);
                }
                break;
            case MEDIO: // repeticion y de 1..6
                max_val = 6;
            case DIFICIL: // repeticion y de 1..7
                for (int i = 0; i < 4; ++i) {
                    solucion = solucion*10 + rand.nextInt(max_val)+1;
                }
                break;
            default: break;
        }
        return Integer.toString(solucion);
    }

    public String evaluarCandidato(String candidato, String solucion) { // TODO: deberia estar en Normas (?)
        return normas.calcularNB(candidato, solucion);
    }

}

