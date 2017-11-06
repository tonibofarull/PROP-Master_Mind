package Dominio;

import java.util.ArrayList;
import java.util.Arrays;

public class Normas {
    public Normas() {

    }

    public String calcularBN(String a, String b) {
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
                return checkCodigo(codigo, 1, 6, 4, 1);

            case MEDIO:
                return checkCodigo(codigo, 1, 6, 4, 4);

            case DIFICIL:
                return checkCodigo(codigo, 1, 7, 4, 4);
        }
        return false;
    }

    public boolean comprobarBN(String candidato, String solucion, String bn) {
        String solucion_correcta = calcularBN(candidato, solucion);
        if (!solucion_correcta.equals(bn)) return false;
        return true;
    }

    private boolean checkCodigo(String codigo, int val_minimo, int val_maximo, int size_codigo, int max_rep) {
        if (codigo.length() == size_codigo) {
            ArrayList<Integer> repeticiones_canicas = new ArrayList<>();
            for (int i = 0; i <= val_maximo-val_minimo; ++i) {
                repeticiones_canicas.add(0);
            }

            for (int i = 0; i < codigo.length(); ++i) {
                int val = Character.getNumericValue(codigo.charAt(i));
                if (val < val_minimo || val > val_maximo) {
                    return false;
                }
                else {
                    int num_reps = repeticiones_canicas.get(val-1);
                    repeticiones_canicas.set(val-1, num_reps+1);
                    if (repeticiones_canicas.get(val-1) >= max_rep + 1) return false;
                }
            }
            return true;
        }
        return false;
    }
}
