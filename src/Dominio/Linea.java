package Dominio;

/**
 * Linea representa un candidato del CodeBreaker y la evaluacion (o aun no) del CodeMaker
 *
 * @author Sergi Avila
 */
public class Linea {

    private String candidato;
    private String NB;

    /**
     * @pre Cierto
     * @post Se ha creado instancia de Linea con el atributo candidato asignado
     */
    public Linea(String candidato) {
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
    public String getCandidato() { return candidato; }

    /**
     * @pre Cierto
     * @post Se devuelve nNBb
     */
    public String getNB() { return NB; }

}
