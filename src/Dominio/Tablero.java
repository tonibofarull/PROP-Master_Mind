package Dominio;

import java.util.ArrayList;

/**
 * Tablero representa el conjunto de lineas que se han jugado actualmente en la partida
 * Para todas las lineas excepto la ultima hay una evaluacion realizada
 * En caso que la ultima este sin evaluar es debido a que es el turno del CodeMaker
 *
 * @author Sergi Avila
 */
public class Tablero {

    private ArrayList<Linea> lineas; // contiene las lineas en el orden en que se han jugado

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
    public void setNuevoCandidato(String candidato) { lineas.add(new Linea(candidato)); }

    /**
     * @pre lineas.size() > 0
     * @post Se ha asignado a la ultima linea la evaluacion NB
     */
    public void setNuevoNB(String NB) { lineas.get(lineas.size() - 1).setNB(NB); }

    // GETTERS

    /**
     * @pre lineas.size() > 0
     * @post Se devuelve el candidato de la ultima linea
     */
    public String getUltimoCandidato() { return lineas.get(lineas.size() - 1).getCandidato(); }

    /**
     * @pre lineas.size() > 0
     * @post Se devuelve el NB de la ultima linea
     */
    public String getUltimoNB() { return lineas.get(lineas.size() - 1).getNB(); }


    // TODO: GetAllCandidatoNB
}
