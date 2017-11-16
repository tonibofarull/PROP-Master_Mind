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
     * @throws Exception si no se cumplen las condiciones segun la dificultad
     * @pre Cierto
     * @post Se ha comprobado que el codigo cumple las normas de dificultad
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
        } else throw new Exception("El tamano del codigo introducido no corresponde con el tamano adecuado.");
    }

    /**
     * @pre Cierto
     * @post Se ha creado instancia de Normas
     */
    public Normas() {

    }

    /**
     * @pre El candidato y solucion han sido validados previamente.
     * @post Se devuelve las NB entre candidato y solucion
     */
    public String calcularNB(String candidato, String solucion) {
        int nNegras = 0;
        int nBlancas = 0;
        ArrayList<Boolean> vis_candidato = new ArrayList<>(Arrays.asList(false, false, false, false));
        ArrayList<Boolean> vis_solucion = new ArrayList<>(Arrays.asList(false, false, false, false));
        for (int i = 0; i < 4; ++i) {
            if (candidato.charAt(i) == solucion.charAt(i)) {
                vis_candidato.set(i, true);
                vis_solucion.set(i, true);
                ++nNegras;
            }
        }
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (candidato.charAt(i) == solucion.charAt(j) && !vis_candidato.get(i) && !vis_solucion.get(j)) {
                    vis_candidato.set(i, true);
                    vis_solucion.set(j, true);
                    ++nBlancas;
                }
            }
        }
        return Integer.toString(nNegras) + Integer.toString(nBlancas);
    }

    /**
     * @throws Exception si no se cumplen las condiciones segun la dificultad
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
     * @throws Exception si el codigo nb introducido es de tamaño diferente a 2
     * @throws Exception si los valores del codigo nb son menores a 0 o mayores al numero de bolas
     * @pre Candidato y Solucion han sido comprobados previamente.
     * @post Se ha comprobado que NB corresponda a la evaluacion del candidato con la solucion
     */
    public void comprobarNB(String candidato, String solucion, String nb) throws Exception {
        if (nb.length() != 2)
            throw new Exception("El codigo nb introducido tiene un numero de valores diferente al esperado.");
        int nvalue = Character.getNumericValue(nb.charAt(0));
        int bvalue = Character.getNumericValue(nb.charAt(1));
        if (nvalue < 0 || nvalue > 4 || bvalue < 0 || bvalue > 4)
            throw new Exception ("El codigo nb introducido tiene valores fuera del rango valido (0 - 4).");
        String NB_correcto = calcularNB(candidato, solucion);
        if (!NB_correcto.equals(nb))
            throw new Exception("El codigo nb introducido no corresponde con el codigo nb real.");
    }

}
