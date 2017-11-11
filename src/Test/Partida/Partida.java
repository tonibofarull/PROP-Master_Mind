package Test.Partida;

import Dominio.Dificultad;
import Dominio.Rol;
import Dominio.Tablero;

public class Partida {

    private int ronda;//ronda son las rondas que se han jugado hasta el momento
    private String Solucion;
    private Rol rol;
    private Dificultad dificultad;
    private Stub_Tablero tablero;

    public Partida(Dificultad dificultad, Rol rol){
        this.dificultad=dificultad;
        this.rol=rol;
        this.ronda=0;
        this.tablero=new Stub_Tablero();
    }
    public Partida(){this.tablero=new Stub_Tablero();}

    public void setSolucion(String Solucion){
        this.Solucion=Solucion;
    }

    public void setNuevoCandidato(String candidato){
        tablero.setNuevoCandidato(candidato);
        ronda++;
    }
    public void setNuevaNB(String NB){
        tablero.setNuevoNB(NB);
    }

    //getters
    public int getRonda(){
        return ronda;
    }

    public Dificultad getDificultad(){
        return dificultad;
    }

    public Rol getRol(){
        return rol;
    }

    public String getSolucion(){
        return Solucion;
    }

    public String getUltimoCandidato(){
        return tablero.getUltimoCandidato();
    }

    public String getUltimaNB(){
        return tablero.getUltimoNB();
    }

}
