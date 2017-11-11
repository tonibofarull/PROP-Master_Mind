package Test.Tablero;

import Dominio.Linea;

import java.util.ArrayList;

public class Tablero {
    private ArrayList<Stub_Linea> lineas;

    public Tablero() { lineas=new ArrayList<>(); }

    public void setNuevoCandidato(String candidato){
        lineas.add(new Stub_Linea(candidato));
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

    public int getNumLineas(){
        return lineas.size();
    }

    public String getCandidato(int i){
        return lineas.get(i).getCandidato();
    }

    public Boolean existsNB(int i){
        return ! lineas.get(i).existsNB();
    }

    public String getNB(int i){
        return lineas.get(i).getNB();
    }
    //todo GetAllCandidatoNB
}
