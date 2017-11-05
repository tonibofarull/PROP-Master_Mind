package Dominio;

import java.util.*;

public class Maquina {

    private TreeSet<String> S;
    private TreeSet<String> candidatos_restantes;
    private boolean primer_turno;

    private Tablero tablero;
    private Normas normas;

    private Dificultad dificultad;

    private class Pair {
        private int x;
        private int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Pair aux = (Pair) obj;
            return this.x == aux.x && this.y == aux.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x,y);
        }
    }

    private void inicializarDatos(int pos, int num, ArrayList<Boolean> asign, boolean repetition) {
        int max_val = 6;
        if (dificultad == Dificultad.DIFICIL) max_val = 7;
        if (pos == 4) {
            S.add(Integer.toString(num));
            candidatos_restantes.add(Integer.toString(num));
            return;
        }
        for (int i = 1; i <= max_val; ++i) {
            if (!repetition || !asign.get(i)) {
                asign.set(i,false);
                inicializarDatos(pos+1,num*10+i, asign, repetition);
            }
        }
    }

    // PONER EN NORMAS
    private Pair calcularBN(String a, String b) {
        Pair res = new Pair(0,0);
        ArrayList<Boolean> vis_a = new ArrayList<>(Arrays.asList(false,false,false,false));
        ArrayList<Boolean> vis_b = new ArrayList<>(Arrays.asList(false,false,false,false));
        for (int i = 0; i < 4; ++i) {
            if (a.charAt(i) == b.charAt(i)) {
                vis_a.set(i,true);
                vis_b.set(i,true);
                res.setX(res.getX()+1);
            }
        }
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (a.charAt(i) == b.charAt(j) && !vis_a.get(i) && !vis_b.get(j)) {
                    vis_a.set(i,true);
                    vis_b.set(j,true);
                    res.setY(res.getY()+1);
                }
            }
        }
        return res;
    }

    private String minimax() {
        TreeSet<String> guesses = new TreeSet<>();
        int max = Integer.MIN_VALUE;
        for (String g: candidatos_restantes) {
            Map<Pair,Integer> Z_g = new HashMap<>();
            for (String s : S) {
                Pair val = calcularBN(g,s);
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

    private void nuevaBN(String candidato, String BN) {
        int x = Character.getNumericValue(BN.charAt(0));
        int y = Character.getNumericValue(BN.charAt(1));
        Pair lg = new Pair(x,y);
        TreeSet<String> Saux = (TreeSet<String>) S.clone();
        for (String a : Saux) {
            Pair p = calcularBN(a,candidato);
            if (!p.equals(lg)) S.remove(a);
        }
    }

    // PUBLIC functions

    public Maquina(Tablero tablero, Normas normas, Dificultad dif, Rol rol) {
        dificultad = dif;
        if (rol == Rol.CODEBREAKER) {
            this.tablero = tablero;
            this.normas = normas;
            this.primer_turno = true;
            S = new TreeSet<>();
            candidatos_restantes = new TreeSet<>();
            ArrayList<Boolean> asign = new ArrayList<>(6);
            boolean no_rep = dificultad == Dificultad.FACIL;
            if (no_rep) {
                for (int i = 1; i <= 6; ++i) asign.add(false);
            }
            inicializarDatos(0,0,asign,no_rep);
        }
    }

    public void reanudarMaquina() {
        int numero_lineas = tablero.getNumLineas();
        if (numero_lineas == 0) primer_turno = false; // revisar
        for (int i = 0; i < numero_lineas; ++i) {
            String can = tablero.getCandidato(i);
            if (tablero.existsBN(i)) {
                String eval = tablero.getBN(i);
                nuevaBN(can,eval);
            }
        }
    }

    public String generarCandidato() {
        if (primer_turno) {
            primer_turno = false;
            String r = "1122";
            S.remove(r);
            candidatos_restantes.remove(r);
            return r;
        }
        // actualizamos la info de la ultima jugada hecha
        String ultimoCandidato = tablero.getUltimoCandidato();
        String ultimaBN = tablero.getUltimoBn();
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

    public String evaluarCandidato(String candidato, String solucion) {
        Pair p = calcularBN(candidato, solucion);
        return p.getX() + "" + p.getY();
    }

}

