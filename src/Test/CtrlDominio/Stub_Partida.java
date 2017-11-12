package Test.CtrlDominio;

import Dominio.Dificultad;
import Dominio.Rol;


public class Stub_Partida {


    public Stub_Partida(Dificultad dificultad, Rol rol){

    }
    public Stub_Partida(){}

    public void setSolucion(String Solucion){

    }

    public void setNuevoCandidato(String candidato){

    }
    public void setNuevaNB(String NB){

    }

    //getters


    public Dificultad getDificultad(){
        return Dificultad.FACIL;
    }

    public Rol getRol(){
        return Rol.CODEMAKER;
    }

    public String getSolucion(){
        return "1234";
    }

    public String getUltimoCandidato(){
        return "1243";
    }

    public String getUltimaNB(){
        return "NB";
    }

}
