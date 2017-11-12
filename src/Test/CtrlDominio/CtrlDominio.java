package Test.CtrlDominio;

import Dominio.*;

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
        maquina = new Maquina(normas, dif, rol);
        if (rol == Rol.CODEBREAKER) {
            String solucion = maquina.generarSolucion(partida.getDificultad());
            partida.setSolucion(solucion);
        }
        return true;
    }
    public String generarSolucion(String solucion) throws Exception{
        normas.comprobarLinea(solucion, partida.getDificultad());
        partida.setSolucion(solucion);
        String candidato = maquina.generarCandidato(null,null,partida.getDificultad());
        partida.setNuevoCandidato(candidato);
        return candidato;
    }

    public String evaluarCandidato(String nb) throws Exception{
        String candidato = partida.getUltimoCandidato();
        String NB = partida.getUltimaNB();
        String solucion = partida.getSolucion();
        normas.comprobarNB(candidato, solucion, nb);
        partida.setNuevaNB(nb);
        String siguiente_candidato = maquina.generarCandidato(candidato,NB,partida.getDificultad());
        partida.setNuevoCandidato(siguiente_candidato);
        return siguiente_candidato;
    }

    public String generarCandidato(String candidato) throws Exception {
        normas.comprobarLinea(candidato, partida.getDificultad());
        partida.setNuevoCandidato(candidato);
        String nb_ultima_jugada = normas.calcularNB(candidato, partida.getSolucion());
        partida.setNuevaNB(nb_ultima_jugada);
        return nb_ultima_jugada;
    }

}
