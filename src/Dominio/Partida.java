package Dominio;

public class Partida {
    private int ronda;//ronda son las rondas que se han jugado hasta el momento
    private String secreto;
    private String rol;
    private int dificultad;
    Tablero tablero;
    public Partida(int dificultad,String rol){
        this.dificultad=dificultad;
        this.rol=rol;
        this.ronda=0;
        this.tablero=new Tablero();
    }

    //todo acabarPartida
    //todo guardar

    //setters
    public void setSecreto(String secreto){ this.secreto=secreto; }
    public void setNuevoCandidato(String candidato){
        tablero.setNuevoCandidato(candidato);
        ronda++;
    }
    public void setNuevaEvaluacion(String evaluacion){tablero.setNuevaEvaluacion(evaluacion);}

    //getters
    public int getRonda(){ return ronda; }
    public int getDificultad(){return dificultad;}
    public String getRol(){return rol;}
    public String getSecreto(){return secreto;}
    public String getUltimoCandidato(){return tablero.getUltimoCandidato();}
    public String getUltimaEvaluacion(){return tablero.getUltimaEvaluacion();}




}
