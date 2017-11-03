package Dominio;

public class CtrlDominio {
    private Maquina maquina;
    private Player_CB player_cb;
    private Player_CM player_cm;
    private Partida partida;

    public CtrlDominio() {}

    /*public String pedirAyuda() {
        //Por ahora no hace nada
    }*/

    public String generarSolucion(String solucion) {
        if (player_cm.comprobarSolucion(solucion)) {
            partida.setSolucion(solucion);
            String candidato = maquina.generarCandidato();
            partida.setNuevoCandidato(candidato);
            return candidato;
        }
        return "";
    }

    public String evaluarCandidato(String bn) {
        String candidato = partida.getUltimoCandidato();
        String solucion = partida.getSolucion();
        if (player_cm.comprobarBN(candidato, solucion, bn)) {
            partida.setNuevaBn(bn);
            maquina.nuevaBN(candidato,bn);
            String siguiente_candidato = maquina.generarCandidato();
            partida.setNuevoCandidato(siguiente_candidato);
            return siguiente_candidato;
        }
        return "";
    }

    public String generarCandidato(String candidato) {
        if (player_cb.comprobarCandidato(candidato)) {
            partida.setNuevoCandidato(candidato);
            String bn_ultima_jugada = maquina.evaluarCandidato(candidato, partida.getSolucion());
            partida.setNuevaBn(bn_ultima_jugada);
            return bn_ultima_jugada;
        }
        return "";
    }


    public boolean empezarPartida(int dificultad,String rol) {
        partida = new Partida(dificultad, rol);
        maquina = new Maquina();
        if (rol.equals("CodeMaker")) {
            player_cm = new Player_CM();
        }
        else {
            player_cb = new Player_CB();
            String solucion = maquina.generarSolucion();
            partida.setSolucion(solucion);
        }
        return true;
    }

}
