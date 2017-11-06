package Presentacion;

import Dominio.CtrlDominio;

public class CtrlPresentacion {

    private VistaPresentacion vista;
    private CtrlDominio dominio;

    public CtrlPresentacion() {
        vista = new VistaPresentacion();
        dominio = new CtrlDominio();
    }

    public void iniciarControlador() {
        int opcion = -1;
        while (opcion != 0) {
            opcion = vista.obtenerOpcion();
            switch (opcion) {
                case 0: break;
                case 1: empezarPartida(); break;
                default: break;
            }
        }
    }

    private void empezarPartida() {
        int d = vista.obtenerDificultad();
        int r = vista.obtenerRol();
        String dificultad;
        if (d == 0) dificultad = "FACIL";
        else if (d == 1) dificultad = "MEDIO";
        else dificultad = "DIFICIL";
        String rol = "CODEMAKER";
        if (r == 1) rol = "CODEBREAKER";
        dominio.empezarPartida(dificultad,rol);

        if (r == 0) partidaCodeMaker();
        else partidaCodeBreaker();
    }

    private void partidaCodeBreaker() {
        while (generarCandidato());
        System.out.println();
        System.out.println("**** Final de la partida ****");
        System.out.println();
    }

    private void partidaCodeMaker() {
        generarSolucion();
        while (evaluarCandidato());
        System.out.println();
        System.out.println("**** Final de la partida ****");
        System.out.println();
    }

    private void generarSolucion() {
        String solucion = vista.obtenerCandidatoSolucion(false);
        String candidato = dominio.generarSolucion(solucion);
        vista.mostrarCandidato(candidato);
    }

    private boolean evaluarCandidato() {
        String nb = vista.obtenerNB();
        if (nb.equals("40")) return false;
        String candidato = dominio.evaluarCandidato(nb);
        vista.mostrarCandidato(candidato);
        return true;
    }

    private boolean generarCandidato() {
        String candidato = vista.obtenerCandidatoSolucion(true);
        String nb = dominio.generarCandidato(candidato);
        vista.mostrarNB(nb);
        return !nb.equals("40");
    }

}
