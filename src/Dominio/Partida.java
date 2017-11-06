package Dominio;

public class Partida {

    private int ronda;//ronda son las rondas que se han jugado hasta el momento
    private String Solucion;
    private Rol rol;
    private Dificultad dificultad;
    private Tablero tablero;

    public Partida(Dificultad dificultad,Rol rol){
        this.dificultad=dificultad;
        this.rol=rol;
        this.ronda=0;
        this.tablero=new Tablero();
    }

    //todo acabarPartida
    //todo guardar

    //setters
    public void setSolucion(String Solucion){ this.Solucion=Solucion; }
    public void setNuevoCandidato(String candidato){
        tablero.setNuevoCandidato(candidato);
        ronda++;
    }
    public void setNuevaNB(String NB){tablero.setNuevoNB(NB);}

    //getters
    public int getRonda(){ return ronda; }
    public Dificultad getDificultad(){return dificultad;}
    public Rol getRol(){return rol;}
    public String getSolucion(){return Solucion;}
    public String getUltimoCandidato(){return tablero.getUltimoCandidato();}
    public String getUltimaNB(){return tablero.getUltimoNB();}
    public Tablero getTablero() {
        return tablero;
    }
}
