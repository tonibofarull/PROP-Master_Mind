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
     * @param solucion String con la solución a la partida actual
     * @pre Cierto
     * @post Se devuelve el primer candidato de la Maquina
     * @return Primer candidato de la partida
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
     * @param nb String con la evaluación del último candidato
     * @throws Exception si evaluacion no es valida
     * @pre Cierto
     * @post Se devuelve el siguiente candidato
     * @return Siguiente candidato a evaluar.
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
     * @param cand Siguiente candidato a evaluar
     * @pre Cierto
     * @post Se devuelve la siguiente evaluacion
     * @return String con la siguiente evaluacion
     */
    public String generarCandidato(String cand) throws Exception {
        Codigo candidato = new Codigo(cand);
        candidato.comprobarLinea(partida.getDificultad());
        partida.setNuevoCandidato(candidato);
        String nb_ultima_jugada = candidato.calcularNB(partida.getSolucion());
        partida.setNuevaNB(nb_ultima_jugada);
        return nb_ultima_jugada;
    }
    
    /**
     * @pre Se ha empezado la partida
     * @post Se devuelven las rondas jugadas en la partida actual
     * @return Integer con el número de rondas jugadas
    */
    public String getRondas() {
        return Integer.toString(partida.getRonda());
    }
    
    /**
     * @param user usuario a guardar en el ranking
     * @param punt puntuación a guardar en el ranking
     * @pre Cierto
     * @post Se guarda al usuario en el ranking
    */
    public void anadirPuntuacion(String user, String punt) {
        ranking.anadirPuntuacion(user, punt);
        
        ArrayList<ArrayList<String>> top10 = ranking.consultaRanking();
        CP.guardarRanking(top10);
    }
    
    /**
     * @pre Existe un ranking guardado
     * @post Se carga el ranking guardado en la instancia de la clase ranking que tenemos
     * como atributo
    */
    public void cargarRanking() {
        ranking = new Ranking();
        ArrayList<ArrayList<String>> top10 = CP.cargarRanking();
        for (ArrayList<String> pos : top10) {
            String user = pos.get(0);
            String punt = pos.get(1);
            ranking.anadirPuntuacion(user,punt);
        }
    }
    
    /**
     * @pre La variable ranking ha sido inicializada
     * @post Se devuelve una matriz con los usuarios y puntuaciones guardados en el ranking
     * @return Matriz donde hay guardado el ranking (ArrayList de ArrayList de Strings)
    */
    public ArrayList<ArrayList<String>> consultarRanking() {
        ArrayList<ArrayList<String>> r = ranking.consultaRanking();
        return r;
    }
    
    /**
     * @pre Existe una partida en curso
     * @post La partida queda guardada
    */
    public void guardarPartida() {
        ArrayList<String> gp = partida.guardarPartida();
        CP.guardarPartida(gp);
    }
    
    /**
     * @throws Excepcion si no hay partida guardada
     * @pre Hay una partida guardada
     * @post Se carga la partida guardada y pasa a ser la partida actual.
    */
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
