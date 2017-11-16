package Test.Tablero;

import Test.Stubs.Stub_Linea;

import java.util.ArrayList;

/**
 * Tablero representa el conjunto de lineas que se han jugado actualmente en la partida
 * Para todas las lineas excepto la ultima hay una evaluacion realizada
 * En caso que la ultima este sin evaluar es debido a que es el turno del CodeMaker
 *
 * @author Sergi Avila
 */
public class Tablero {

    private ArrayList<Stub_Linea> lineas; // contiene las lineas en el orden en que se han jugado

    /**
     * @pre Cierto
     * @post Se ha creado instancia de Tablero
     */
    public Tablero() { lineas = new ArrayList<>(); }

    // SETTERS

    /**
     * @pre Cierto
     * @post Se ha anadido a tablero una nueva linea con el candidato
     */
    public void setNuevoCandidato(String candidato) { lineas.add(new Stub_Linea(candidato)); }

    /**
     * @pre El ultimo candidato anadido no tiene evaluacion
     * @post Se ha asignado a la ultima linea la evaluacion NB
     */
    public void setNuevoNB(String NB) { lineas.get(lineas.size() - 1).setNB(NB); }

    // GETTERS

    /**
     * @pre Previamente se ha anadido un candidato
     * @post Se devuelve el candidato de la ultima linea
     */
    public String getUltimoCandidato() { return lineas.get(lineas.size() - 1).getCandidato(); }


    // TODO: guardarPartida
}
