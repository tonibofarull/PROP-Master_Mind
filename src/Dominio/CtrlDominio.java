package Dominio;

import Persistencia.CtrlPersistencia;
import java.util.ArrayList;

/**
 * CtrlDominio
 *
 * @author Ferran Martinez
 */
public class CtrlDominio {

    private Maquina maquina;
    private Partida partida;
    private Ranking ranking;
    
    private CtrlPersistencia CP;

    /**
     * @pre Cierto
     * @post Se ha creado instancia de CtrlDominio
     */
    public CtrlDominio() {
        CP = new CtrlPersistencia();
        cargarRanking();
    }

    /**
     * @param dificultad_s String con valores: {"CODEMAKER","CODEBREAKER"}
     * @param rol_s        String con valores: {"FACIL","MEDIO","DIFICIL"}
     * @pre Cierto
     * @post Se han creado instancias de Maquina, Codigo y Partida con los parametros indicados
     */
    public void empezarPartida(String dificultad_s, String rol_s) {
        Dificultad dif = Dificultad.valueOf(dificultad_s);
        Rol rol = Rol.valueOf(rol_s);
        CP = new CtrlPersistencia();
        partida = new Partida(dif, rol);
        maquina = new Maquina(dif, rol);
        if (rol == Rol.CODEBREAKER) {
            String solucion = maquina.generarSolucion(partida.getDificultad());
            partida.setSolucion(new Codigo(solucion));
        }
    }

    /**
     * @throws Exception si solucion no es solucion valida
     * @pre Cierto
     * @post Se devuelve el primer candidato de la Maquina
     */
    public String generarSolucion(String solucion) throws Exception {
        Codigo codigo = new Codigo(solucion);
        codigo.comprobarLinea(partida.getDificultad());
        partida.setSolucion(codigo);
        String candidato = maquina.generarCandidato(null, null, partida.getDificultad());
        partida.setNuevoCandidato(new Codigo(candidato));
        return candidato;
    }

    /**
     * @throws Exception si evaluacion no es valida
     * @pre Cierto
     * @post Se devuelve el siguiente candidato
     */
    public String evaluarCandidato(String nb) throws Exception {
        Codigo candidato = partida.getUltimoCandidato();
        Codigo solucion = partida.getSolucion();
        solucion.comprobarNB(candidato, nb);
        partida.setNuevaNB(nb);
        String siguiente_candidato = maquina.generarCandidato(candidato, nb, partida.getDificultad());
        if (!nb.equals("40")) partida.setNuevoCandidato(new Codigo(siguiente_candidato));
        return siguiente_candidato;
    }

    /**
     * @throws Exception si candidato no es valido
     * @pre Cierto
     * @post Se devuelve la siguiente evaluacion
     */
    public String generarCandidato(String cand) throws Exception {
        Codigo candidato = new Codigo(cand);
        candidato.comprobarLinea(partida.getDificultad());
        partida.setNuevoCandidato(candidato);
        String nb_ultima_jugada = candidato.calcularNB(partida.getSolucion());
        partida.setNuevaNB(nb_ultima_jugada);
        return nb_ultima_jugada;
    }
    
    public String getRondas() {
        return Integer.toString(partida.getRonda());
    }
    
    public void anadirPuntuacion(String user, String punt) {
        ranking.anadirPuntuacion(user, punt);
        
        ArrayList<ArrayList<String>> top10 = ranking.consultaRanking();
        CP.guardarRanking(top10);
    }
    
    public void cargarRanking() {
        ranking = new Ranking();
        ArrayList<ArrayList<String>> top10 = CP.cargarRanking();
        for (ArrayList<String> pos : top10) {
            String user = pos.get(0);
            String punt = pos.get(1);
            ranking.anadirPuntuacion(user,punt);
        }
    }
    
    public ArrayList<ArrayList<String>> consultarRanking() {
        ArrayList<ArrayList<String>> r = ranking.consultaRanking();
        return r;
    }
    
    public void guardarPartida() {
        ArrayList<String> gp = partida.guardarPartida();
        CP.guardarPartida(gp);
    }
    
    public ArrayList<String> cargarPartida() throws Exception {
        ArrayList<String> gp =  CP.cargarPartida();
        CP.borrarPartida();
        
        
        Dificultad dif = Dificultad.FACIL;
        if (gp.get(0).equals("MEDIO")) dif = Dificultad.MEDIO;
        else if (gp.get(0).equals("DIFICIL")) dif = Dificultad.DIFICIL;
        Rol rol = Rol.CODEBREAKER;
        if (gp.get(1).equals("CODEMAKER")) rol = Rol.CODEMAKER;
        
        // Reinicializamos las instancias de maquina y partida
        partida = new Partida(dif, rol); // creamos partida
        partida.cargarPartida(gp); // cargamos partida
        maquina = new Maquina(dif, rol);
        maquina.restablecerEstado(gp);
        
        return gp;
    }
    
}
