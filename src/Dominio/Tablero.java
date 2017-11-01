package Dominio;

import java.util.ArrayList;

public class Tablero {
    private ArrayList<Dominio.Linea> lineas;

    public Tablero(){lineas=new ArrayList<>();}

    public void setNuevoCandidato(String candidato){
        lineas.add(new Dominio.Linea(candidato));
    }
    public void setNuevaEvaluacion(String evaluacion){
        lineas.get(lineas.size()-1).setEvaluacion(evaluacion);
    }
    public String getUltimoCandidato(){
        return lineas.get(lineas.size()-1).getCandidato();
    }
    public String getUltimaEvaluacion(){
        return  lineas.get(lineas.size()-1).getEvaluacion();
    }
    //todo GetAllCandidatoEvaluacion
}
