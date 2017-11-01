package Dominio;

public class CtrlDominio {
    private IA_CB ia_cb;
    private IA_CM ia_cm;
    private Player_CB player_cb;
    private Player_CM player_cm;
    private Partida partida;

    public CtrlDominio(int dificultad, String rol) {
        if (rol.equals("Codemaker")) {
            player_cm = new Player_CM();
            ia_cb = new IA_CB();
        }
        else {
            player_cb = new Player_CB();
            ia_cm = new IA_CM();
        }
    }

    /*public String pedirAyuda() {
        //Por ahora no hace nada
    }*/

    public boolean generarCodigoSecreto(String solucion) {
        if (player_cm.comprobarSolucion(solucion)) {
            partida.setSolucion(solucion);
            return true;
        }
        return false;
    }

    public boolean generarJugada(String candidato) {
        if (player_cb.comprobarCandidato(candidato)) {
            partida.setNuevoCandidato(candidato);
            String bn_ultima_jugada = ia_cm.evaluarCandidato(candidato, partida.getSolucion());
            partida.setNuevaEvaluacion(bn_ultima_jugada);
            return true;
        }
        return false;
    }

    public boolean evaluarJugada(String bn) {
        String candidato = partida.getUltimoCandidato();
        String solucion = partida.getSolucion();
        if (player_cm.comprobarBN(candidato, solucion, bn)) {
            partida.setNuevaEvaluacion(bn);
            String siguiente_candidato = ia_cb.generarCandidato();
            partida.setNuevoCandidato(siguiente_candidato);
            return true;
        }
        return false;
    }

    public boolean empezarPartida(int dificultad,String rol) {
        partida = new Dominio.Partida(dificultad, rol);
    }

}
