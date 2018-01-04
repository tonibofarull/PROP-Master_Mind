package Dominio;

import java.util.*;

/**
 * Codigo tiene las funcionalidades para comprobar el cumplimiento de las normas segun la dificultad
 * y proporcionar utilidades sobre ellas (calcularNB)
 *
 * @author Ferran Martinez
 */
public class Codigo implements Comparable<Codigo> {

    private String codigo;

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
                    throw new Exception("El código contiene valores fuera del rango permitido.");
                else {
                    int num_reps = repeticiones_canicas.get(val - 1);
                    repeticiones_canicas.set(val - 1, num_reps + 1);
                    if (repeticiones_canicas.get(val - 1) >= max_rep + 1)
                        throw new Exception("El número de repeticiones supera al máximo permitido.");
                }
            }
        } else throw new Exception("El tamaño del código introducido no corresponde con el tamaño adecuado.");
    }

    /**
     * @pre Cierto
     * @post Se ha creado instancia de Codigo con el valor del candidato
     */
    public Codigo(String candidato) {
        codigo = candidato;
    }

    public String getCodigo() {
        return codigo;
    }

    /**
     * @pre El candidato y solucion han sido validados previamente.
     * @post Se devuelve las NB entre candidato y solucion
     */
    public String calcularNB(Codigo candidato) {
        int nNegras = 0;
        int nBlancas = 0;
        ArrayList<Boolean> vis_candidato = new ArrayList<>(Arrays.asList(false, false, false, false));
        ArrayList<Boolean> vis_solucion = new ArrayList<>(Arrays.asList(false, false, false, false));
        for (int i = 0; i < 4; ++i) {
            if (candidato.codigo.charAt(i) == codigo.charAt(i)) {
                vis_candidato.set(i, true);
                vis_solucion.set(i, true);
                ++nNegras;
            }
        }
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (candidato.codigo.charAt(i) == codigo.charAt(j) && !vis_candidato.get(i) && !vis_solucion.get(j)) {
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
    public void comprobarLinea(Dificultad dificultad) throws Exception {
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
    public void comprobarNB(Codigo candidato, String nb) throws Exception {
        if (nb.length() != 2)
            throw new Exception("El código introducido tiene una cantidad de elementos inválida.");
        int nvalue = Character.getNumericValue(nb.charAt(0));
        int bvalue = Character.getNumericValue(nb.charAt(1));
        if (nvalue < 0 || nvalue > 4 || bvalue < 0 || bvalue > 4)
            throw new Exception ("El codigo introducido tiene valores fuera del rango válido.");
        String NB_correcto = this.calcularNB(candidato);
        if (!NB_correcto.equals(nb))
            throw new Exception("La evaluación introducida no corresponde con la correcta.");
    }

    @Override
    public boolean equals(Object o) {
        return codigo.equals(((Codigo) o).codigo);
    }

   /**
     * @pre El atributo codigo no es nulo.
     * @post Se devuelve el codigo hash referente al string que corresponde al código
     * @return String correspondiente al código hash del código atributo
     */
    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

    /**
     * 
     * @param s Instáncia de código a comparar con esta instancia de la clase código
     * @pre El atributo codigo de esta instancia ha sido inicializado
     * @post Se devuelve la comparación
     * @return True si los códigos son iguales. False en cualquier otro caso.
     */
    @Override
    public int compareTo(Codigo s) {
        return codigo.compareTo(s.codigo);
    }

        /**
     * @pre Se ha introducido un codigo.
     * @post Se devuelve el string correspondiente al código
     * @return Código en formato string correspondiente al código atributo de la clase
     */
    @Override
    public String toString() {
        return codigo;
    }
   
}
