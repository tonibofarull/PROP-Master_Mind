package Dominio;

public class CtrlDominio {
    private IA_CB ia_cb;
    private IA_CM ia_cm;
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
            String candidato = ia_cb.generarCandidato();
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
            ia_cb.nuevaEvaluacion(candidato,bn);
            String siguiente_candidato = ia_cb.generarCandidato();
            partida.setNuevoCandidato(siguiente_candidato);
            return siguiente_candidato;
        }
        return "";
    }

    public String generarCandidato(String candidato) {
        if (player_cb.comprobarCandidato(candidato)) {
            partida.setNuevoCandidato(candidato);
            String bn_ultima_jugada = ia_cm.evaluarCandidato(candidato, partida.getSolucion());
            partida.setNuevaBn(bn_ultima_jugada);
            return bn_ultima_jugada;
        }
        return "";
    }


    public boolean empezarPartida(int dificultad,String rol) {
        partida = new Partida(dificultad, rol);
        if (rol.equals("CodeMaker")) {
            player_cm = new Player_CM();
            ia_cb = new IA_CB();
        }
        else {
            player_cb = new Player_CB();
            ia_cm = new IA_CM();
            String solucion = ia_cm.generarSecreto();
            partida.setSolucion(solucion);
        }
        return true;
    }

}
