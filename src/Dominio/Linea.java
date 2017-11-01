package Dominio;

public class Linea {
    private String candidato;
    private String bn;
    public Linea(String candidato){
        this.candidato=candidato;
        this.bn="";
    }
    public void setBn(String bn){
        this.bn=bn;
    }
    public String getCandidato(){
        return candidato;
    }
    public String getBn(){
        return bn;
    }


}
