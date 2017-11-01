package Dominio;

import java.util.ArrayList;

public class Linea {
    private String candidato;
    private String eval;
    public Linea(String code){
        this.candidato=candidato;
        this.eval="";
    }
    public void setEvaluacion(String eval){
        this.eval=eval;
    }
    public String getCandidato(){
        return candidato;
    }
    public String getEvaluacion(){
        return eval;
    }


}
