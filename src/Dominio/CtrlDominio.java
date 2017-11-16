package Dominio;

/**
 * CtrlDominio
 *
 * @author Ferran Martinez
 */
public class CtrlDominio {

    private Maquina maquina;
    private Normas normas;
    private Partida partida;

    /**
     * @pre Cierto
     * @post Se ha creado instancia de CtrlDominio
     */
    public CtrlDominio() {

    }

    /**
     * @param dificultad_s String con valores: {"CODEMAKER","CODEBREAKER"}
     * @param rol_s        String con valores: {"FACIL","MEDIO","DIFICIL"}
     * @pre Cierto
     * @post Se han creado instancias de Maquina, Normas y Partida con los parametros indicados
     */
    public void empezarPartida(String dificultad_s, String rol_s) {
        Dificultad dif = Dificultad.valueOf(dificultad_s);
        Rol rol = Rol.valueOf(rol_s);
        partida = new Partida(dif, rol);
        normas = new Normas();
        maquina = new Maquina(normas, dif, rol);
        if (rol == Rol.CODEBREAKER) {
            String solucion = maquina.generarSolucion(partida.getDificultad());
            partida.setSolucion(solucion);
        }
    }

    /**
     * @throws Exception si solucion no es solucion valida
     * @pre Cierto
     * @post Se devuelve el primer candidato de la Maquina
     */
    public String generarSolucion(String solucion) throws Exception {
        normas.comprobarLinea(solucion, partida.getDificultad());
        partida.setSolucion(solucion);
        String candidato = maquina.generarCandidato(null, null, partida.getDificultad());
        partida.setNuevoCandidato(candidato);
        return candidato;
    }

    /**
     * @throws Exception si evaluacion no es valida
     * @pre Cierto
     * @post Se devuelve el siguiente candidato
     */
    public String evaluarCandidato(String nb) throws Exception {
        String candidato = partida.getUltimoCandidato();
        String solucion = partida.getSolucion();
        normas.comprobarNB(candidato, solucion, nb);
        partida.setNuevaNB(nb);
        String siguiente_candidato = maquina.generarCandidato(candidato, nb, partida.getDificultad());
        partida.setNuevoCandidato(siguiente_candidato);
        return siguiente_candidato;
    }

    /**
     * @throws Exception si candidato no es valido
     * @pre Cierto
     * @post Se devuelve la siguiente evaluacion
     */
    public String generarCandidato(String candidato) throws Exception {
        normas.comprobarLinea(candidato, partida.getDificultad());
        partida.setNuevoCandidato(candidato);
        String nb_ultima_jugada = normas.calcularNB(candidato, partida.getSolucion());
        partida.setNuevaNB(nb_ultima_jugada);
        return nb_ultima_jugada;
    }

    // TODO: pedirAyuda
    // TODO: consultarRanking
    // TODO: guardarPartida
    // TODO: cargarPartida
}
