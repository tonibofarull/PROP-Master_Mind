package Dominio;

import java.util.ArrayList;

public class Tablero {
    private ArrayList<Linea> lineas;

    public Tablero(){lineas=new ArrayList<>();}

    public void setNuevoCandidato(String candidato){
        lineas.add(new Linea(candidato));
    }
    public void setNuevoBn(String Bn){
        lineas.get(lineas.size()-1).setBn(Bn);
    }
    public String getUltimoCandidato(){
        return lineas.get(lineas.size()-1).getCandidato();
    }
    public String getUltimoBn(){
        return  lineas.get(lineas.size()-1).getBn();
    }
    //todo GetAllCandidatoBn
}
