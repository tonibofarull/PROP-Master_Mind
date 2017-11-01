package Dominio;

import java.util.*;

public class IA_CB extends Dominio.IA {

    private TreeSet<String> S;
    private TreeSet<String> candidatos_restantes;
    private boolean primer_turno;

    private void inicializarDatos(int pos, int num) {
        if (pos == 4) {
            S.add(Integer.toString(num));
            candidatos_restantes.add(Integer.toString(num));
            return;
        }
        for (int i = 1; i <= 6; ++i) inicializarDatos(pos+1,num*10+i);
    }

    private String minimax() {
        TreeSet<String> guesses = new TreeSet<>();
        int max = Integer.MIN_VALUE;
        for (String g: candidatos_restantes) {
            Map<Pair,Integer> Z_g = new HashMap<>();
            for (String s : S) {
                Pair val = calcularNB(g,s);
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

    public IA_CB() {
        primer_turno = true;
        S = new TreeSet<>();
        candidatos_restantes = new TreeSet<>();
        inicializarDatos(0,0);
    }

    public IA_CB(ArrayList<ArrayList<String>> jugadas) { // TODO vigilar cuando llamar a esta funcion
        primer_turno = false;
        S = new TreeSet<>();
        candidatos_restantes = new TreeSet<>();
        inicializarDatos(0,0);
        for (int i = 0; i < jugadas.size(); ++i) {
            nuevaEvaluacion(jugadas.get(i).get(0),jugadas.get(i).get(1));
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
        String r = minimax();
        S.remove(r);
        candidatos_restantes.remove(r);
        return r;
    }

    public void nuevaEvaluacion(String candidato, String evaluacion) {
        int x = Character.getNumericValue(evaluacion.charAt(0));
        int y = Character.getNumericValue(evaluacion.charAt(1));
        Pair lg = new Pair(x,y);
        TreeSet<String> Saux = (TreeSet<String>) S.clone();
        for (String a : Saux) {
            Pair p = calcularNB(a,candidato);
            if (!p.equals(lg)) S.remove(a);
        }
    }

}

