package Persistencia;

import java.util.ArrayList;
 
/**
 * CtrlPersistencia
 *
 * @author Sergi Avila
 */
public class CtrlPersistencia {
    /**
     * @pre datos codifica una partida
     * @post se ha guardado la partida en un archivo
     */
    public void guardarPartida(ArrayList<String> datos){
        OpPersistencia.guardarPartida(datos);

    }
    
    /**
     * @pre cierto
     * @post Devuelve un arraylist con la ultima partida guardada, en caso de no haber, el arraylist esta vacio (NO null,vacio)
     */
    public ArrayList<String> cargarPartida() throws Exception {
        return OpPersistencia.cargarPartida();
    }
    /**
     * @pre cierto
     * @post borra el archivo guardado con la informacion de la partida
     */    
    public void borrarPartida(){
        OpPersistencia.borrarPartida();
    }
    /**
     * @pre ranking codifica el ranking
     * @post se ha guardado el ranking en un archivo
     */
    public void guardarRanking(ArrayList<ArrayList<String>> ranking){
        OpPersistencia.guardarRanking(ranking);
    }
    /**
     * @pre cierto
     * @post Devuelve un arraylist con el ranking
     */    
    public ArrayList<ArrayList<String>> cargarRanking(){
        return OpPersistencia.cargarRanking();
    }
    
}
