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

    // Partida
    
    public String getRondas() {
        return dominio.getRondas();
    }
    
    public void guardarPartida() {
        dominio.guardarPartida();
    }
    
    public ArrayList<String> cargarPartida() throws Exception {
        ArrayList<String> gp = dominio.cargarPartida();
        return gp;
    }
    
    // ----- CodeBreaker
    
    public String generarCandidato(String mov) throws Exception {
        String NB = dominio.generarCandidato(mov);
        return NB;
    }
    
    // ---- CodeMaker
    
    public String evaluarCandidato(String nb) throws Exception {
        return dominio.evaluarCandidato(nb);
    }
    
    // Configuracion
    
    public void empezarPartida(String dificultad_s, String rol_s) {
        dominio.empezarPartida(dificultad_s, rol_s);
    }
    
    public void irPartidaCodeMaker(String solucion, String candidato, String dif) {
        vista.irPartidaCodeMaker(solucion, candidato, dif);
    }
    
    public void irPartidaCodeBreaker(String dificultad_s) {
        vista.irPartidaCodeBreaker(dificultad_s);
    }
    
    public void irIntroducirSecreto(String dificultad_s) {
        vista.irIntroducirSecreto(dificultad_s);
    }
    
    // Introducir Secreto
    
    public String generarSolucion(String solucion) throws Exception {
        return dominio.generarSolucion(solucion);
    }
    
    // Menu Principal

    public void irRanking() {                                        
        vista.irRanking();
    }                                        

    public void irCargarPartida() {                                        
        vista.irCargarPartida();
    } 
    
    public void irConfiguracionPartida() {                                        
        vista.irConfiguracionPartida();
    }   
    
    // Ranking
    
    public ArrayList<ArrayList<String>> getRanking() {
        return dominio.consultarRanking();
    }
    
    public void anadirPuntuacion(String user, String punt) {
        dominio.anadirPuntuacion(user, punt);
    }
    
    public void volverMenuPrincipal() {
        vista.irMenuPrincipal();
    }
    
}