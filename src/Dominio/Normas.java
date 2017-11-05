package Dominio;

import java.util.ArrayList;
import java.util.Arrays;

public class Normas {
    public Normas() {

    }

    private String calcularBN(String a, String b) {
        int nNegras = 0;
        int nBlancas = 0;
        ArrayList<Boolean> vis_a = new ArrayList<>(Arrays.asList(false,false,false,false));
        ArrayList<Boolean> vis_b = new ArrayList<>(Arrays.asList(false,false,false,false));
        for (int i = 0; i < 4; ++i) {
            if (a.charAt(i) == b.charAt(i)) {
                vis_a.set(i,true);
                vis_b.set(i,true);
                ++nNegras;
            }
        }
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (a.charAt(i) == b.charAt(j) && !vis_a.get(i) && !vis_b.get(j)) {
                    vis_a.set(i,true);
                    vis_b.set(j,true);
                    ++nBlancas;
                }
            }
        }
        return Integer.toString(nBlancas) + Integer.toString(nNegras);
    }

    public boolean comprobarLinea(String codigo, Dificultad dificultad) {
        switch(dificultad) {
            case FACIL:
                if (codigo.length() == 4) {
                    ArrayList<Boolean> canicas_usadas = new ArrayList<>(Arrays.asList(false,false,false,false,false,false));
                    for (int i = 0; i < codigo.length(); ++i) {
                        if (Character.getNumericValue(codigo.charAt(i)) < 1 || Character.getNumericValue(codigo.charAt(i)) > 6) {
                            return false;
                        }
                        else {
                            if (!canicas_usadas.get(Character.getNumericValue(codigo.charAt(i)))) canicas_usadas.set(Character.getNumericValue(codigo.charAt(i)), true);
                            else return false;
                        }
                    }
                    return true;
                }
                return false;

            case MEDIO:
                if (codigo.length() == 4) {
                    ArrayList<Integer> repeticiones_canicas = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));
                    for (int i = 0; i < codigo.length(); ++i) {
                        if (Character.getNumericValue(codigo.charAt(i)) < 1 || Character.getNumericValue(codigo.charAt(i)) > 6) {
                            return false;
                        }
                        else {
                            repeticiones_canicas.set(Character.getNumericValue(codigo.charAt(i)), (repeticiones_canicas.get(Character.getNumericValue(codigo.charAt(i))) + 1));
                            if (repeticiones_canicas.get(Character.getNumericValue(codigo.charAt(i))) >= 2) return false;
                        }
                    }
                    return true;
                }
                return false;

            case DIFICIL:
                if (codigo.length() == 4) {
                    ArrayList<Integer> repeticiones_canicas = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0));
                    for (int i = 0; i < codigo.length(); ++i) {
                        if (Character.getNumericValue(codigo.charAt(i)) < 1 || Character.getNumericValue(codigo.charAt(i)) > 7) {
                            return false;
                        }
                        else {
                            repeticiones_canicas.set(Character.getNumericValue(codigo.charAt(i)), (repeticiones_canicas.get(Character.getNumericValue(codigo.charAt(i))) + 1));
                            if (repeticiones_canicas.get(Character.getNumericValue(codigo.charAt(i))) >= 2) return false;
                        }
                    }
                    return true;
                }
                return false;
        }
        return false;
    }

    public boolean comprobarBN(String candidato, String solucion, String bn) {
        String solucion_correcta = calcularBN(candidato, solucion);
        if (!solucion_correcta.equals(bn)) return false;
        return true;
    }
}
