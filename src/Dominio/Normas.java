package Dominio;

import java.util.*;

/**
 * Normas tiene las funcionalidades para comprobar el cumplimiento de las normas segun la dificultad
 * y proporcionar utilidades sobre ellas (calcularNB)
 *
 * @author Ferran Martinez
 */
public class Normas {

    /**
     * @throws Exception si no se cumplen las condiciones de dificultad
     * @pre Cierto
     * @post Se ha comprobado que el codigo cumpla las normas de dificultad
     */
    private void comprobarCodigo(String codigo, int val_minimo, int val_maximo, int size_codigo, int max_rep) throws Exception {
        if (codigo.length() == size_codigo) {
            ArrayList<Integer> repeticiones_canicas = new ArrayList<>();
            for (int i = 0; i <= val_maximo - val_minimo; ++i) repeticiones_canicas.add(0);
            for (int i = 0; i < codigo.length(); ++i) {
                int val = Character.getNumericValue(codigo.charAt(i));
                if (val < val_minimo || val > val_maximo)
                    throw new Exception("El codigo contiene valores fuera de los rangos permitidos.");
                else {
                    int num_reps = repeticiones_canicas.get(val - 1);
                    repeticiones_canicas.set(val - 1, num_reps + 1);
                    if (repeticiones_canicas.get(val - 1) >= max_rep + 1)
                        throw new Exception("El numero de repeticiones del codigo supera al numero maximo permitido.");
                }
            }
        } else throw new Exception("El tamaño del codigo introducido no corresponde con el tamano adecuado.");
    }

    /**
     * @pre Cierto
     * @post Se ha creado instancia de Normas
     */
    public Normas() {

    }

    /**
     * @pre Cierto
     * @post Se devuelve las NB entre los candidatos a y b.
     */
    public String calcularNB(String a, String b) {
        int nNegras = 0;
        int nBlancas = 0;
        ArrayList<Boolean> vis_a = new ArrayList<>(Arrays.asList(false, false, false, false));
        ArrayList<Boolean> vis_b = new ArrayList<>(Arrays.asList(false, false, false, false));
        for (int i = 0; i < 4; ++i) {
            if (a.charAt(i) == b.charAt(i)) {
                vis_a.set(i, true);
                vis_b.set(i, true);
                ++nNegras;
            }
        }
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (a.charAt(i) == b.charAt(j) && !vis_a.get(i) && !vis_b.get(j)) {
                    vis_a.set(i, true);
                    vis_b.set(j, true);
                    ++nBlancas;
                }
            }
        }
        return Integer.toString(nNegras) + Integer.toString(nBlancas);
    }

    /**
     * @throws Exception si no se cumplen las condiciones de dificultad
     * @pre Cierto
     * @post Se ha comprobado que el codigo cumpla las normas de dificultad
     */
    public void comprobarLinea(String codigo, Dificultad dificultad) throws Exception {
        switch (dificultad) {
            case FACIL:
                comprobarCodigo(codigo, 1, 6, 4, 1);
                break;
            case MEDIO:
                comprobarCodigo(codigo, 1, 6, 4, 4);
                break;
            case DIFICIL:
                comprobarCodigo(codigo, 1, 7, 4, 4);
                break;
        }
    }

    /**
     * @throws Exception si la evaluacion del candidato con la solucion es diferente de NB
     * @pre Cierto
     * @post Se ha comprobado que NB corresponda a la evaluacion del candidato con la solucion
     */
    public void comprobarNB(String candidato, String solucion, String nb) throws Exception {
        String NB_correcto = calcularNB(candidato, solucion);
        if (!NB_correcto.equals(nb))
            throw new Exception("El codigo nb introducido no corresponde con el codigo nb real.");
    }

}
