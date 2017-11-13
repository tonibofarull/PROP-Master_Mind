package Test.Tablero;


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

}
