package Dominio;

/**
 * Partida representa las caracteristicas generales:
 *      solucion
 *      rondas jugadas
 *      rol del jugador humano
 *      dificultad
 *      y el tablero
 *
 * @author Sergi Avila
 */
public class Partida {

    private String solucion;
    private int ronda;
    private Rol rol;
    private Dificultad dificultad;
    private Tablero tablero;

    /**
     * @pre Cierto
     * @post Se ha creado instancia de Partida
     */
    public Partida(Dificultad dificultad, Rol rol) {
        this.ronda = 0;
        this.rol = rol;
        this.dificultad = dificultad;
        this.tablero = new Tablero();
    }

    // SETTERS

    /**
     * @pre Cierto
     * @post Se ha asignado la solucion
     */
    public void setSolucion(String solucion) { this.solucion = solucion; }

    /**
     * @pre candidato cumple con las normas para la dificultad de la partida
     * @post Se ha anadido a tablero el candidato y se ha aumentado el numero de rondas en 1
     */
    public void setNuevoCandidato(String candidato) {
        tablero.setNuevoCandidato(candidato);
        ronda++;
    }

    /**
     * @pre Se ha anadido un candidato anteriormente
     * @post Se ha anadido a tablero la evaluacion NB
     */
    public void setNuevaNB(String NB) { tablero.setNuevoNB(NB); }

    // GETTERS

    /**
     * @pre Cierto
     * @post Se devuelve la solcion
     */
    public String getSolucion() { return solucion; }

    /**
     * @pre Se ha anadido un candidato anteriormente
     * @post Se devuelve el ultimo candidato anadido al tablero
     */
    public String getUltimoCandidato() { return tablero.getUltimoCandidato(); }

    /**
     * @pre Se ha anadido una NB anteriormente
     * @post Se devuelve la ultima NB anadido al tablero
     */
    public String getUltimaNB() { return tablero.getUltimoNB(); }

    /**
     * @pre Cierto
     * @post Devuelve ronda
     */
    public int getRonda() { return ronda; }

    /**
     * @pre Cierto
     * @post Devuelve rol
     */
    public Rol getRol() { return rol; }

    /**
     * @pre Cierto
     * @post Devuelve dificultad
     */
    public Dificultad getDificultad() { return dificultad; }


    // TODO: acabarPartida
    // TODO: guardar
}
