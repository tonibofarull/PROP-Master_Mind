package Dominio;

public class Linea {
    private String candidato;
    private String nb;
    public Linea(String candidato){
        this.candidato=candidato;
        this.nb="";
    }
    public void setNB(String nb){
        this.nb=nb;
    }
    public String getCandidato(){
        return candidato;
    }
    public String getNB(){
        return nb;
    }


}
