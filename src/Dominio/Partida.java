package Dominio;

import java.util.ArrayList;

/**
 * Partida representa las caracteristicas generales:
 *      - solucion
 *      - rondas jugadas
 *      - rol del jugador humano
 *      - dificultad
 *      - tablero
 *
 * @author Sergi Avila
 */
public class Partida {
    private Codigo solucion;
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
    public void setSolucion(Codigo solucion) { this.solucion = solucion; }

    /**
     * @pre candidato cumple con las normas para la dificultad de la partida
     * @post Se ha anadido a tablero el candidato y se ha aumentado el numero de rondas en 1
     */
    public void setNuevoCandidato(Codigo candidato) {
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
     * @post Se devuelve la solucion
     */
    public Codigo getSolucion() { return solucion; }

    /**
     * @pre Se ha anadido un candidato anteriormente
     * @post Se devuelve el ultimo candidato anadido al tablero
     */
    public Codigo getUltimoCandidato() { return tablero.getUltimoCandidato(); }


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

    /*
     * formato de los datos a guardar: arraylist de string
     *
     * {rol,dificultad,ronda,solucion,candidato1,NB1......candidatoN,NBN}
     */
    public ArrayList<String> guardarPartida(){
        ArrayList<String> datos = new ArrayList<>();
        switch (rol){
            case CODEMAKER:
                datos.add("CODEMAKER");
                break;
            default:
                datos.add("CODEBREAKER");
                break;
        }
        switch (dificultad){
            case FACIL:
                datos.add("FACIL");
                break;
            case MEDIO:
                datos.add("MEDIO");
                break;
            default:
                datos.add("DIFICIL");
                break;
        }
        datos.add(String.valueOf(ronda));
        datos.add(solucion.getCodigo());
        //todo adall los inserta en orden?
        datos.addAll(tablero.guardarPartida());
        return datos;
    }
    // TODO: cargarPartida
}
