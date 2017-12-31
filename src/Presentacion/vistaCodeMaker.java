package Presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    
    public vistaCodeMaker(CtrlPresentacion CP, String solucion, String candidato, String dif) {
        super(CP,dif);
        VA.mostrarAyudaCM();
        this.solucion = solucion;
        this.candidato = candidato;
        inicializarSolucion();
        inicializarTablero();
        // introducimos en el tablero el primer candidato del codebreaker
        for (int i = 0; i < 4; ++i) {
            tablero_act.getComponent(i).setBackground(intToColor(Character.getNumericValue(candidato.charAt(i))));
            tablero_act.getComponent(i).setVisible(true);
        }
        inicializarNB();
        inicializarNum();
        ((JButton) num_act.getComponent(0)).setText("1");
        ((JButton) num_act.getComponent(0)).setVisible(true); // introducimos el numero "1" al primer boton
        
        text_sol.setVisible(true);
        index = 1;
    }
    
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
            ArrayList<Color> al = stringToColor(candidato);
            for (int i = 0; i < 4; ++i) { // actualizamos el tablero con los colores del nuevo candidato del codebreaker
                tablero_act.getComponent(4*(index%6)+i).setBackground(al.get(i));
                tablero_act.getComponent(4*(index%6)+i).setVisible(true);
            }
            // introducimos el numero de la ronda
            ((JButton) num_act.getComponent(index%6)).setText(Integer.toString(index+1));
            num_act.getComponent(index%6).setVisible(true);
            ++index;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    protected void inicializarPanelEntrada(JPanel panel, String dif) {
        for (int i = 0; i < 4; ++i) { // Inicializamos los botones del candidato
            JButton but = new JButton();
            but.setBackground(Color.gray);
            but.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    Color cbut = ((JButton) evt.getSource()).getBackground();
                    if (cbut == Color.white) but.setBackground(Color.black);
                    else if (cbut == Color.black) but.setBackground(Color.gray);
                    else but.setBackground(Color.white);
                }
            });
            panel.add(but);
        }
    }
    
    
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
        CP.volverMenuPrincipal();
    }
    
    protected void mostrarAyuda() {
        VA.setVisible(true);
    }
    
    private void inicializarSolucion() {
        jPanel_sol.setBorder(javax.swing.BorderFactory.createEtchedBorder()); // borde para la solucion
        for (int i = 0; i < 4; ++i) { // rellenamos el panel de solucion
            Color c = intToColor(Character.getNumericValue(solucion.charAt(i)));
            JButton but = new JButton();
            but.setBackground(c);
            jPanel_sol.add(but);
        }
    }
    
    private ArrayList<Color> stringToColor(String s) {
        ArrayList<Color> al = new ArrayList<>(4);
        for (int i = 0; i < 4; ++i) {
            Color c = intToColor(Character.getNumericValue(s.charAt(i)));
            al.add(c);
        }
        return al;
    }
    
}
