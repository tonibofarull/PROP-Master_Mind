package Test.CtrlDominio;

import Dominio.Dificultad;

public class Stub_Normas {

    private boolean checkCodigo(String codigo, int val_minimo, int val_maximo, int size_codigo, int max_rep) {
        return true;
    }

    // PUBLIC functions

    public Stub_Normas() {

    }

    public String calcularNB(String a, String b) {
        return "40";
    }

    public boolean comprobarLinea(String codigo, Dificultad dificultad) {
        return true;
    }

    public boolean comprobarNB(String candidato, String solucion, String nb) {
        return true;
    }

}
