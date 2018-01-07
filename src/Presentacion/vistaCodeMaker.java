package Presentacion;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Se encarga de administrar el panel cuando el usuario juga como rol de CodeMaker
 *
 * @author Antoni Bofarull
 */
public class vistaCodeMaker extends vistaPartida {

    private String solucion;
    private String candidato;
    
    /**
     * @param CP ctrlpresentacion
     * @param solucion solucion de la partida
     * @param candidato primer candidato del codebreaker
     * @pre Cierto.
     * @post Se ha instancia la clase vistaCodeMaker.
     */
    public vistaCodeMaker(CtrlPresentacion CP, String solucion, String candidato) {
        super(CP);
        VA.mostrarAyudaCM();
        this.solucion = solucion;
        this.candidato = candidato;
        inicializarSolucion();
        inicializarTablero();
        // introducimos en el tablero el primer candidato del codebreaker
        anadirCandidato(candidato,index);
        inicializarNB();
        inicializarNum();
        ((JButton) num_act.getComponent(0)).setText("1");
        ((JButton) num_act.getComponent(0)).setVisible(true); // introducimos el numero "1" al primer boton
        
        text_sol.setVisible(true);
        ++index;
    }

    /**
     * @pre El usuario ha introducido datos.
     * @post Se han obtenido los datos introducidos en la pantalla
    */
    protected void datosIntroducidos() {
        try {
            // calculamos el valor numerico de la evaluacion introducida por el usuario
            int num_N = 0, num_B = 0;
            for (int i = 0; i < 4; ++i) {
                Color c = ((JButton) jPanel_entrada.getComponent(i)).getBackground();
                if (c == Color.black) ++num_N;
                if (c == Color.white) ++num_B;
            }
            String NB = num_N + "" + num_B;

            // obtenemos el siguiente candidato del codebreaker
            String candidato = CP.evaluarCandidato(NB);
            
            anadirNB(NB,index-1);
            // Si NB == 40 -> Se ha acabado el juego.
            if (NB.equals("40")) finalizarPartida();
            
            if (index%6 == 0) {
                inicializarTablero();
                inicializarNB();
                inicializarNum();
            }
            anadirCandidato(candidato,index);
            // introducimos el numero de la ronda
            ((JButton) num_act.getComponent(index%6)).setText(Integer.toString(index+1));
            num_act.getComponent(index%6).setVisible(true);
            ++index;
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
            JButton but = new NB();
            but.setVisible(true);
            panel.add(but);
        }
    }

    /**
     * @pre Cierto
     * @post Se muetra el mensaje de final de partida.
    */
    protected void finalizarPartida() {
        String msj = "Partida finalizada.\nPuntuacion: " + CP.getRondas();
        Object[] options = {"Volver al menú principal"};
         int n = JOptionPane.showOptionDialog(this,
                msj,
                "Mensaje",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
        VA.dispose();
        CP.volverMenuPrincipal();
    }

    /**
     * @pre Cierto
     * @post Muestra el mensaje de ayuda.
    */
    protected void mostrarAyuda() {
        VA.setVisible(true);
    }
    
    /**
     * @pre Cierto.
     * @post Se ha inicializado el panel de la solucion.
     */
    private void inicializarSolucion() {
        jPanel_sol.setBorder(javax.swing.BorderFactory.createEtchedBorder()); // borde para la solucion
        for (int i = 0; i < 4; ++i) { // rellenamos el panel de solucion
            Bola b = new Bola(Character.getNumericValue(solucion.charAt(i)));
            b.setVisible(true);
            jPanel_sol.add(b);
        }
    }
    
}
