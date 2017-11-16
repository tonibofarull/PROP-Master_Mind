package Dominio;

import java.util.*;

/**
 * Maquina implementa las acciones de CodeBreaker y CodeMaker conforme a las reglas segun la dificultad.
 * Para el CodeBreaker se utiliza el algoritmo de FiveGuess.
 * Para el CodeMaker se genera la solucion de forma aleatoria.
 *
 * @author Antoni Bofarull
 */
public class Maquina {

    private boolean primer_turno;
    private TreeSet<String> S;
    private TreeSet<String> candidatos_restantes;

    private Normas normas;

    /**
     * Inicializa S y candidatos_restantes con todas las combinaciones de candidatos validos.
     * Un candidato es valido si los digitos estan comprendidos entre [1..max_val] y en caso de
     * prohibido_rep ser cierto, no se repiten digitos.
     *
     * @param pos           Indica en que cifra del numero se encuentra la recursion.
     * @param num           Contiene el valor acumulado del candidato.
     * @param asign         Indica para cada digito si este se ha usado anteriormente en la generacion del candidato
     *                      actual. Solo se utiliza cuando esta prohibido la repeticion de digitos.
     * @param max_val       Valor maximo que puede ser asignado a un digito.
     * @param prohibido_rep Indica si esta prohibido la repeticion de digitos.
     *
     * @pre Cierto.
     * @post Se han inicializado S y candidatos_restantes con todas las combinaciones de candidatos validos.
     */
    private void inicializarDatos(int pos, int num, ArrayList<Boolean> asign, int max_val, boolean prohibido_rep) {
        if (pos == 4) {
            S.add(Integer.toString(num));
            candidatos_restantes.add(Integer.toString(num));
            return;
        }
        for (int i = 1; i <= max_val; ++i) {
            if (!prohibido_rep || !asign.get(i - 1)) {
                if (prohibido_rep) asign.set(i - 1, true);
                inicializarDatos(pos + 1, num * 10 + i, asign, max_val, prohibido_rep);
                if (prohibido_rep) asign.set(i - 1, false);
            }
        }
    }

    /**
     * Algoritmo minimax del FiveGuess.
     *
     * @pre Cierto.
     * @post Se devuelve el mejor candidato posible aplicando minimax para los datos de S y candidatos_restantes actuales.
     */
    private String minimax() {
        TreeSet<String> guesses = new TreeSet<>();
        int max = Integer.MIN_VALUE;
        for (String g : candidatos_restantes) {
            Map<String, Integer> NB_g = new HashMap<>();
            // NB_g contedra el numero de veces que aparecen los distintos NB's resultantes de comparar:
            //    g con los elementos de S
            for (String s : S) {
                String val = normas.calcularNB(g, s);
                if (NB_g.containsKey(val)) {
                    Integer int_aux = NB_g.get(val);
                    NB_g.put(val, int_aux + 1);
                } else NB_g.put(val, 1);
            }
            int min = Integer.MAX_VALUE;
            Collection<Integer> col = NB_g.values();
            // calculamos el minimo numero de elementos de S que eliminaria g si lo usaramos como proximo candidato
            for (Integer valit : col) {
                if (min > S.size() - valit) min = S.size() - valit;
            }
            // en caso de eliminar los mismos elementos de S lo anadimos como posible candidato
            //    si elimina mas, vaciariamos los posibles candidatos hasta ahora y este seria el nuevo candidato
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

    /**
     * @param candidato Valor a comparar con los elementos de S.
     * @param NB        Evaluacion obtenida al comparar el candidato con la solucion real.
     *
     * @pre NB es la evaluacion de candidato con la solucion real.
     * @post Se han eliminado de s los candidatos tales que evaluacion(s,candidato) != NB.
     */
    private void nuevaNB(String candidato, String NB) {
        Iterator<String> it = S.iterator();
        while (it.hasNext()) {
            String g = it.next();
            String nb = normas.calcularNB(g, candidato);
            if (!NB.equals(nb)) it.remove();
        }
    }

    // FUNCIONES PUBLICAS

    /**
     * Constructor de Maquina
     *
     * @param normas           Instancia de Normas
     * @param dificultad       Dificultad de la partida
     * @param rolJugadorHumano Rol escogido por la persona
     *
     * @pre Cierto.
     * @post Se ha creado instancia de Maquina.
     */
    public Maquina(Normas normas, Dificultad dificultad, Rol rolJugadorHumano) {
        this.normas = normas;
        if (rolJugadorHumano == Rol.CODEMAKER) {
            this.primer_turno = true;
            S = new TreeSet<>();
            candidatos_restantes = new TreeSet<>();

            int max_val = 6;
            if (dificultad == Dificultad.DIFICIL) max_val = 7;

            ArrayList<Boolean> asign = new ArrayList<>(max_val);
            boolean prohibido_rep = dificultad == Dificultad.FACIL;
            if (prohibido_rep) for (int i = 1; i <= max_val; ++i) asign.add(false);
            inicializarDatos(0, 0, asign, max_val, prohibido_rep);
        }
    }

    /**
     * Actualiza las estructuras de datos necesarias para ejecutar el FiveGuess y devuelve el mejor candidato actual
     *
     * @param ultimoCandidato Es valido para la dificultad dada
     * @param ultimaNB        Es valido para la dificultad dada y corresponde a las NB de evaluar:
     *                        el ultimoCandidato con la solucion real
     * @param dificultad      Dificultad de la partida
     *
     * @pre ultimaNB es la evaluacion del ultimoCandidato con la solucion de la partida.
     * @post Se devuelve la mejor candidato posible actualmente.
     */
    public String generarCandidato(String ultimoCandidato, String ultimaNB, Dificultad dificultad) {
        if (primer_turno) {
            primer_turno = false;

            String candidato = "1122";
            if (dificultad == Dificultad.FACIL) candidato = "1234"; // Valor arbitrario

            S.remove(candidato);
            candidatos_restantes.remove(candidato);
            return candidato;
        }
        // si no es el primer turno es debido a que hemos propuesto un candidato que no era la solcion,
        //    como paremetro obtenemos el ultimo candidato con las NB y actualizamos las estructuras de datos
        nuevaNB(ultimoCandidato, ultimaNB);

        // obtenemos el mejor candidato segun el algoritmo de minimax y actualizamos los datos pertinentes
        String r = minimax();
        S.remove(r);
        candidatos_restantes.remove(r);
        return r;
    }

    /**
     * Genera una solucion valida para la partida.
     *
     * @param dificultad Dificultad de la partida.
     *
     * @pre Cierto.
     * @post Solucion random valida para la dificultad recibida.
     */
    public String generarSolucion(Dificultad dificultad) {
        int max_val = 7;
        int solucion = 0;
        Random rand = new Random(); // nextInt(bound) -> [0..bound)
        switch (dificultad) {
            case FACIL: // no repeticion y de 1..6
                ArrayList<Integer> list = new ArrayList<>(6);
                for (int i = 1; i <= 6; ++i) list.add(i);
                for (int i = 0; i < 4; ++i) {
                    int index = rand.nextInt(list.size());
                    solucion = solucion * 10 + list.get(index);
                    list.remove(index);
                }
                break;
            case MEDIO: // repeticion y de 1..6
                max_val = 6;
            case DIFICIL: // repeticion y de 1..7
                for (int i = 0; i < 4; ++i) {
                    solucion = solucion * 10 + rand.nextInt(max_val) + 1;
                }
                break;
            default:
                break;
        }
        return Integer.toString(solucion);
    }

    // TODO: pedirAyuda
}
