package Presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Se encarga de administrar el panel cuando el usuario juga como rol de CodeBreaker
 *
 * @author Antoni Bofarull
 */
public class vistaCodeBreaker extends vistaPartida {

    public vistaCodeBreaker(CtrlPresentacion CP, String dif) {
        super(CP,dif);
        VA.mostrarAyudaCB();
    }
    
    protected void datosIntroducidos() {
        try {
            Color c1 = ((JButton) jPanel_entrada.getComponent(0)).getBackground();
            Color c2 = ((JButton) jPanel_entrada.getComponent(1)).getBackground();
            Color c3 = ((JButton) jPanel_entrada.getComponent(2)).getBackground();
            Color c4 = ((JButton) jPanel_entrada.getComponent(3)).getBackground();
            ArrayList<Color> entrada_array = new ArrayList<>(); 
            entrada_array.add(c1); entrada_array.add(c2); entrada_array.add(c3); entrada_array.add(c4);
            
            String candidato = colorToInt(c1) + "" + colorToInt(c2) + "" + colorToInt(c3) + "" + colorToInt(c4);
            
            String NB = CP.generarCandidato(candidato);

            if (index%6 == 0) {
                inicializarTablero();
                inicializarNB();
                inicializarNum();
            }
            for (int i = 0; i < 4; ++i) {
                tablero_act.getComponent(4*(index%6)+i).setVisible(true);
                tablero_act.getComponent(4*(index%6)+i).setBackground(entrada_array.get(i));
            }
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
    
    protected void inicializarPanelEntrada(JPanel panel, String dif) {
        for (int i = 0; i < 4; ++i) { // Inicializamos los botones del candidato
            JButton but = new JButton();
            but.setBackground(Color.gray);
            if (dif.equals("DIFICIL")) {
                but.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        Color cbut = ((JButton) evt.getSource()).getBackground();
                        if (cbut == Color.red) but.setBackground(Color.green);
                        else if (cbut == Color.green) but.setBackground(Color.blue);
                        else if (cbut == Color.blue) but.setBackground(Color.cyan);
                        else if (cbut == Color.cyan) but.setBackground(Color.magenta);
                        else if (cbut == Color.magenta) but.setBackground(Color.yellow);
                        else if (cbut == Color.yellow) but.setBackground(new Color(0xff,0x99,0x00));
                        else but.setBackground(Color.red);
                    }
                });
            }
            else {
                but.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        Color cbut = ((JButton) evt.getSource()).getBackground();
                        if (cbut == Color.red) but.setBackground(Color.green);
                        else if (cbut == Color.green) but.setBackground(Color.blue);
                        else if (cbut == Color.blue) but.setBackground(Color.cyan);
                        else if (cbut == Color.cyan) but.setBackground(Color.magenta);
                        else if (cbut == Color.magenta) but.setBackground(Color.yellow);
                        else but.setBackground(Color.red);
                    }
                });
            }
            panel.add(but);
        }
    } 
    
        
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
            while (user.isEmpty()) {
                user = JOptionPane.showInputDialog(
                    this, 
                    "Introduce el nickname", 
                    "Registrar ranking", 
                    JOptionPane.WARNING_MESSAGE);
            }
            CP.anadirPuntuacion(user, CP.getRondas());
         } 
        CP.volverMenuPrincipal();
    }

    
    protected void mostrarAyuda() { 
        VA.setVisible(true);
    }
    
}
