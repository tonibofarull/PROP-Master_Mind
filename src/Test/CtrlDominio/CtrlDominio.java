package Test.CtrlDominio;

import Dominio.Dificultad;
import Dominio.Rol;

import Test.Stubs.Stub_Maquina;
import Test.Stubs.Stub_Normas;
import Test.Stubs.Stub_Partida;

public class CtrlDominio {
    private Stub_Maquina maquina;
    private Stub_Normas normas;
    private Stub_Partida partida;

    public CtrlDominio() {}

    /*public String pedirAyuda() {
        //Por ahora no hace nada
    }*/

    public boolean empezarPartida(String dificultad_s,String rol_s) {
        Dificultad dif = Dificultad.valueOf(dificultad_s);
        Rol rol = Rol.valueOf(rol_s);
        partida = new Stub_Partida(dif, rol);
        normas = new Stub_Normas();
        maquina = new Stub_Maquina(normas, dif, rol);
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
