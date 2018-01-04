package Persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Sergi Avila
 */
public class OpPersistencia {
      /**
     * @pre datos codifica una partida
     * @post se ha guardado la partida en un archivo
     */
    public static void guardarPartida(ArrayList<String> datos){
        File archivo= new File("datos");
        try {
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(datos);
            oos.flush();
            oos.close();
            fos.close();
        } catch (Exception e) {}


    }
    
    /**
     * @pre cierto
     * @post Devuelve un arraylist con la ultima partida guardada, en caso de no haber, el arraylist esta vacio (NO null,vacio)
     */
    public static ArrayList<String> cargarPartida() throws Exception {
        ArrayList<String> datosPartida=new ArrayList<>();
        File archivo= new File("datos");
        try {
            FileInputStream fis ;
            fis= new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            datosPartida = (ArrayList<String>)ois.readObject();
            ois.close();
            fis.close();
        }
        catch (Exception e){
            throw new Exception("No se ha encontrado ninguna partida.");
        }
        return datosPartida;
    }
    /**
     * @pre cierto
     * @post borra el archivo guardado con la informacion de la partida
     */    
    public static void borrarPartida(){
        try {
            File f = new File("datos");
            f.delete();
        }
        catch (Exception e) {}
    }
    /**
     * @pre ranking codifica el ranking
     * @post se ha guardado el ranking en un archivo
     */
    public static void guardarRanking(ArrayList<ArrayList<String>> ranking){
        File archivo= new File("ranking");
        try {
            FileOutputStream fos;
            fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ranking);
            oos.flush();
            oos.close();
            fos.close();
        } catch (Exception e) {}
    }
    /**
     * @pre cierto
     * @post Devuelve un arraylist con el ranking
     */    
    public static ArrayList<ArrayList<String>> cargarRanking(){
        ArrayList<ArrayList<String>> datosRanking=new ArrayList<>();
        File archivo= new File("ranking");
        try {
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            datosRanking = (ArrayList<ArrayList<String>>)ois.readObject();
            ois.close();
            fis.close();
        }catch (Exception e){}
        return datosRanking;
    }
}
