package Dominio;

/**
 * CtrlDominio
 *
 * @author Ferran Martinez
 */
public class CtrlDominio {

    private Maquina maquina;
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
     * @post Se han creado instancias de Maquina, Codigo y Partida con los parametros indicados
     */
    public void empezarPartida(String dificultad_s, String rol_s) {
        Dificultad dif = Dificultad.valueOf(dificultad_s);
        Rol rol = Rol.valueOf(rol_s);
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
        partida.setNuevoCandidato(new Codigo(siguiente_candidato));
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

    // TODO: pedirAyuda
    // TODO: consultarRanking
    // TODO: guardarPartida
    // TODO: cargarPartida
}
