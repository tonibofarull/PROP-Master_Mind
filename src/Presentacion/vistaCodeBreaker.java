package Presentacion;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Se encarga de administrar el panel cuando el usuario juga como rol de CodeBreaker
 *
 * @author Antoni Bofarull
 */
public class vistaCodeBreaker extends vistaPartida {

    /**
     * @param CP ctrlpresentacion
     * @pre Cierto.
     * @post Se ha instancia la clase vistaCodeMaker.
     */
    public vistaCodeBreaker(CtrlPresentacion CP) {
        super(CP);
        VA.mostrarAyudaCB();
    }
    
    /**
     * @pre El usuario ha introducido datos.
     * @post Se han obtenido los datos introducidos en la pantalla
    */
    protected void datosIntroducidos() {
        try {
            String candidato = "";
            for (int i = 0; i < 4; ++i) {
                Bola b = ((Bola) jPanel_entrada.getComponent(i));
                candidato += b.getValue();
            }
            
            String NB = CP.generarCandidato(candidato);

            if (index%6 == 0) { inicializarTablero(); inicializarNB(); inicializarNum(); }

            anadirCandidato(candidato,index);
            anadirNB(NB,index);
            
            ((JButton) num_act.getComponent(index%6)).setText(Integer.toString(index+1));
            num_act.getComponent(index%6).setVisible(true);
            ++index;
            
            if (NB.equals("40")) finalizarPartida();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    /**
     * @param panel JPanel ha inicializar
     * 
     * @pre Cierto
     * @post Se ha inicializado el panel.
    */
    protected void inicializarPanelEntrada(JPanel panel) {
        for (int i = 0; i < 4; ++i) { // Inicializamos los botones del candidato
            JButton but = null;
            if (CP.getDificultad().equals("DIFICIL")) but = new Bola7();
            else but = new Bola6();
            but.setVisible(true);
            panel.add(but);
        }
    } 
    
    /**
     * @pre Cierto
     * @post Se muetra el mensaje de final de partida.
    */
    protected void finalizarPartida() {
        String msj = "Partida finalizada.\nFelicidades! Tienes una puntuación de: " + CP.getRondas();
        Object[] options = {"Registrar ranking",
                        "Volver al menú principal"};
        int n = JOptionPane.showOptionDialog(this,
               msj,
               "Mensaje",
               JOptionPane.YES_NO_CANCEL_OPTION,
               JOptionPane.QUESTION_MESSAGE,
               null,
               options,
               options[1]);
        if (n == 0) {
            String user = "";
            Boolean introducido_ok = false;
            while (!introducido_ok) {
                user = JOptionPane.showInputDialog(
                    this, 
                    "Introduce el nickname", 
                    "Registrar ranking", 
                    JOptionPane.WARNING_MESSAGE);
                if (user == null) introducido_ok = true;
                else if (user.length() > 0) {
                    CP.anadirPuntuacion(user, CP.getRondas());
                    introducido_ok = true;
                }
            }
        } 
        CP.volverMenuPrincipal();
    }

    /**
     * @pre Cierto
     * @post Muestra el mensaje de ayuda.
    */
    protected void mostrarAyuda() { 
        VA.setVisible(true);
    }
    
}
