package Dominio;

public class CtrlDominio {
    private Maquina maquina;
    private Normas normas;
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
        if (normas.comprobarBN(candidato, solucion, bn)) {
            partida.setNuevaBn(bn);
            maquina.nuevaBN(candidato,bn);
            String siguiente_candidato = maquina.generarCandidato();
            partida.setNuevoCandidato(siguiente_candidato);
            return siguiente_candidato;
        }
        return "";
    }

    public String generarCandidato(String candidato) {
        if (normas.comprobarLinea(candidato, this.dificultad)) {
            partida.setNuevoCandidato(candidato);
            String bn_ultima_jugada = maquina.evaluarCandidato(candidato, partida.getSolucion());
            partida.setNuevaBn(bn_ultima_jugada);
            return bn_ultima_jugada;
        }
        return "";
    }


    public boolean empezarPartida(int dificultad,String rol) {
        partida = new Partida(dificultad, rol);
        normas = new Normas();
        if (rol.equals("CodeBreaker")) {
            String solucion = maquina.generarSolucion();
            partida.setSolucion(solucion);
        }
        maquina = new Maquina(, normas, dificultad, rol);
        return true;
    }

}
