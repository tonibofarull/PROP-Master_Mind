package Persistencia;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
 
/**
 * CtrlPersistencia
 *
 * @author Ferran Martinez
 */
public class CtrlPersistencia {

    public void guardarPartida(ArrayList<String> datos){
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
    public ArrayList<String> cargarPartida() throws Exception {
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
    
    public void borrarPartida(){
        try {
            File f = new File("datos");
            f.delete();
        }
        catch (Exception e) {}
    }

    //igual que para partida,pero con ranking
    public void guardarRanking(ArrayList<ArrayList<String>> ranking){
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
    public ArrayList<ArrayList<String>> cargarRanking(){
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
