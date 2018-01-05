package Presentacion;

import Dominio.CtrlDominio;
import java.util.ArrayList;
import javax.swing.UIManager;

/**
 * CtrlPresentacion
 *
 * @author Ferran Martinez
 */
public class CtrlPresentacion {
    
    private CtrlDominio dominio;
    private vistaPrincipal vista;
    
        /**
     * @pre Cierto
     * @post Se han creado instancias de CtrlDominio y vistaPrincipal. La apariencia de la interfaz
     * ha pasado a ser Nimbus de Java Swing.
     */
    public CtrlPresentacion() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        }
        catch (Exception ex) {
            ex.printStackTrace(); 
        }
        dominio = new CtrlDominio();
        vista = new vistaPrincipal(this);
    }
    
    /**
     * @pre Cierto.
     * @post Se muestra la vista principal.
    */
    public void inicializarPresentacion() {
        vista.setVisible(true);
    }

    // Partida
    /**
     * @pre CtrlDominio ha sido inicializado. Se ha empezado una partida.
     * @post Se obtiene el número de rondas jugadas.
     * @return String con el número de rondas de la partida
    */
    public String getRondas() {
        return dominio.getRondas();
    }
    
    /**
     * @pre CtrlDominio ha sido inicializado. Se ha empezado una partida.
     * @post La partida en curso es guardada por la capa de persistencia
    */
    public void guardarPartida() {
        dominio.guardarPartida();
    }
    
    /**
     * @throws Exception si no hay partida guardada
     * @pre CtrlDominio ha sido inicializado.
     * @post La partida se carga de la base de datos y pasa a ser la partida actual.
     * La copia guardada se borra del sistema.
     * @return Arraylist de Strings con los parámetros de la partida.
    */
    public ArrayList<String> cargarPartida() throws Exception {
        ArrayList<String> gp = dominio.cargarPartida();
        return gp;
    }
    
    // ----- CodeBreaker
    /**
     * @throws Exception si el candidato generado no es correcto.
     * @param mov String con el codigo correspondiente al siguiente candidato
     * @pre CtrlDominio ha sido inicializado. Hay una partida en curso
     * @post El candidato queda guardado.
     * @return Devuelve un string con la evaluación del candidato.
    */
    public String generarCandidato(String mov) throws Exception {
        String NB = dominio.generarCandidato(mov);
        return NB;
    }
    
    // ---- CodeMaker
    /**
     * @throws Exception si la evaluación generada no es correcta.
     * @param nb String con la evaluación correspondiente al último candidato
     * @pre CtrlDominio ha sido inicializado. Hay una partida en curso
     * @post La evaluación queda guardada
     * @return Devuelve un string con el nuevo candidato.
    */
    public String evaluarCandidato(String nb) throws Exception {
        return dominio.evaluarCandidato(nb);
    }
    
    // Configuracion
    /**
     * @param dificultad_s String con el nivel de dificultad escogido por el usuario.
     * @param rol_s String con el rol escogido por el usuario.
     * @pre CtrlDominio ha sido inicializado.
     * @post Se ha generado una nueva partida.
    */
    public void empezarPartida(String dificultad_s, String rol_s) {
        dominio.empezarPartida(dificultad_s, rol_s);
    }
    
    /**
     * @param solucion String con la solución a la partida.
     * @param candidato String con el candidato a solución
     * @pre vistaPrincipal ha sido inicializada.
     * @post Se cambia la vista a la vista de partida desde el punto de vista del
     * CodeMaker
    */
    public void irPartidaCodeMaker(String solucion, String candidato) {
        vista.irPartidaCodeMaker(solucion, candidato);
    }
    
       /**
     * @pre vistaPrincipal ha sido inicializada.
     * @post Se cambia la vista a la vista de partida desde el punto de vista del
     * CodeBreaker
    */
    public void irPartidaCodeBreaker() {
        vista.irPartidaCodeBreaker();
    }
    
    /**
     * @pre vistaPrincipal ha sido inicializada.
     * @post Se cambia la vista a la vista de partida de introducir secreto
     * (CodeMaker)
    */
    public void irIntroducirSecreto() {
        vista.irIntroducirSecreto();
    }
    
    // Introducir Secreto
       /**
     * @param dificultad_s String con la dificultad de la partida
     * @pre vistaPrincipal ha sido inicializada.
     * @post Se cambia la vista a la vista de partida de introducir secreto
     * (CodeMaker)
    */
    public String generarSolucion(String solucion) throws Exception {
        return dominio.generarSolucion(solucion);
    }
    
    // Menu Principal
   /**
     * @pre vistaPrincipal ha sido inicializada.
     * @post Se cambia la vista a la vista de ranking
    */
    public void irRanking() {                                        
        vista.irRanking();
    }                                        

    /**
     * @pre vistaPrincipal ha sido inicializada.
     * @post Se cambia la vista a la vista correspondiente a la partida guardada
    */
    public void irCargarPartida() {                                        
        vista.irCargarPartida();
    } 
    
        /**
     * @pre vistaPrincipal ha sido inicializada.
     * @post Se cambia la vista a la vista correspondiente a la configuración de
     * partida
    */
    public void irConfiguracionPartida() {                                        
        vista.irConfiguracionPartida();
    }   
    
    // Ranking
    /**
     * @pre CtrlDominio ha sido inicializado.
     * @post Se carga de la base de datos el ranking con los diferentes usuarios.
     * @return Matriz con los diferentes pares usuario - puntuación
    */
    public ArrayList<ArrayList<String>> getRanking() {
        return dominio.consultarRanking();
    }
    
    /**
     * @param user Nombre del usuario a guardar en el ranking
     * @param punt Puntuación obtenida por el usuario
     * @pre CtrlDominio ha sido inicializado. El usuario ha obtenido una de las mayores
     * puntuaciones
     * @post La puntuación ha sido añadida al ranking
    */
    public void anadirPuntuacion(String user, String punt) {
        dominio.anadirPuntuacion(user, punt);
    }
    
    /**
     * @pre vistaPrincipal ha sido inicializada.
     * @post Se cambia la vista a la vista correspondiente al menú principal.
    */
    public void volverMenuPrincipal() {
        vista.irMenuPrincipal();
    }
    
    /**
     * @pre Se ha empezado una partida.
     * @post Se devuelve el string asociado a la dificultad
    */
    public String getDificultad() {
        return dominio.getDificultad();
    }
    
}