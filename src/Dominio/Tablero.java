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
    public void setNuevoCandidato(Codigo candidato) { lineas.add(new Linea(candidato)); }

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
    public Codigo getUltimoCandidato() { return lineas.get(lineas.size() - 1).getCandidato(); }

    /**
     * @pre Todas, excepto quizas la ultima linea tienen una evaluacion
     * @post Devuelve un arraylist con todos los candidatos y evaluaciones
     */
    public ArrayList<String> guardarPartida(){
        ArrayList <String> datos=new ArrayList<>();
        for (Linea l:lineas){
            datos.add(l.getCandidato().getCodigo());
            if (l.getNB() != null) datos.add(l.getNB());
        }
        return datos;
    }
    
    /**
     * @pre Los elementos de datos tienen el formato [candidato,NB,...]
     * @post Se ha cargado la partida con los datos recibidos.
     */
    public void cargarPartida(ArrayList<String> datos){
        for (int i = 4; i < datos.size(); i += 2) {
            Codigo candidato = new Codigo(datos.get(i));
            Linea l = new Linea(candidato);
            if (i+1 < datos.size()) {
                String NB = datos.get(i+1);
                l.setNB(NB);
            }
            lineas.add(l);
        }
    }

}
