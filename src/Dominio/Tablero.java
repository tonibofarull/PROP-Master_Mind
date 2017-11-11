package Dominio;

import java.util.ArrayList;

public class Tablero {
    private ArrayList<Dominio.Linea> lineas;

    public Tablero() { lineas=new ArrayList<>(); }

    public void setNuevoCandidato(String candidato){
        lineas.add(new Linea(candidato));
    }
    public void setNuevoNB(String NB){
        lineas.get(lineas.size()-1).setNB(NB);
    }
    public String getUltimoCandidato(){
        return lineas.get(lineas.size()-1).getCandidato();
    }
    public String getUltimoNB(){
        return  lineas.get(lineas.size()-1).getNB();
    }
    //todo GetAllCandidatoNB
}
