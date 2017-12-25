package Dominio;

/**
 * Linea representa un candidato del CodeBreaker y las NB del CodeMaker (si ya se ha realizado la evaluacion)
 *
 * @author Sergi Avila
 */
public class Linea {

    private Codigo candidato;
    private String NB;

    /**
     * @pre Cierto
     * @post Se ha creado instancia de Linea con el atributo candidato asignado, NB es null
     */
    public Linea(Codigo candidato) {
        this.candidato = candidato;
        this.NB = null;
    }

    // SETTERS

    /**
     * @pre Cierto
     * @post Se ha asignado NB
     */
    public void setNB(String NB) { this.NB = NB; }

    // GETTERS

    /**
     * @pre Cierto
     * @post Se devuelve candidato
     */
    public Codigo getCandidato() { return candidato; }

    /**
     * @pre Cierto
     * @post Se devuelve NB
     */
    public String getNB() { return NB; }

}
