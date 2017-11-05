package Dominio;

public class CtrlDominio {
    private Maquina maquina;
    private Normas normas;
    private Partida partida;

    public CtrlDominio() {}

    /*public String pedirAyuda() {
        //Por ahora no hace nada
    }*/

    public boolean empezarPartida(String dificultad_s,String rol_s) {
        Dificultad dif = Dificultad.valueOf(dificultad_s);
        Rol rol = Rol.valueOf(rol_s);
        partida = new Partida(dif, rol);
        normas = new Normas();
        maquina = new Maquina(partida.getTablero(), normas, dif, rol);
        if (rol == Rol.CODEBREAKER) {
            String solucion = maquina.generarSolucion();
            partida.setSolucion(solucion);
        }
        return true;
    }
    public String generarSolucion(String solucion) {
        if (normas.comprobarLinea(solucion, partida.getDificultad())) {
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
            String siguiente_candidato = maquina.generarCandidato();
            partida.setNuevoCandidato(siguiente_candidato);
            return siguiente_candidato;
        }
        return "";
    }

    public String generarCandidato(String candidato) {
        if (normas.comprobarLinea(candidato, partida.getDificultad())) {
            partida.setNuevoCandidato(candidato);
            String bn_ultima_jugada = maquina.evaluarCandidato(candidato, partida.getSolucion());
            partida.setNuevaBn(bn_ultima_jugada);
            return bn_ultima_jugada;
        }
        return "";
    }




}
