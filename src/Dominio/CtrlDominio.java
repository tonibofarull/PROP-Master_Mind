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

    public String evaluarCandidato(String nb) {
        String candidato = partida.getUltimoCandidato();
        String solucion = partida.getSolucion();
        if (normas.comprobarNB(candidato, solucion, nb)) {
            partida.setNuevaNB(nb);
            String siguiente_candidato = maquina.generarCandidato();
            partida.setNuevoCandidato(siguiente_candidato);
            return siguiente_candidato;
        }
        return "";
    }

    public String generarCandidato(String candidato) {
        if (normas.comprobarLinea(candidato, partida.getDificultad())) {
            partida.setNuevoCandidato(candidato);
            String nb_ultima_jugada = maquina.evaluarCandidato(candidato, partida.getSolucion());
            partida.setNuevaNB(nb_ultima_jugada);
            return nb_ultima_jugada;
        }
        return "";
    }




}
