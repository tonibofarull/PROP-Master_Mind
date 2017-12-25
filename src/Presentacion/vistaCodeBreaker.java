package Presentacion;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class vistaCodeBreaker extends vistaPartida {

    public vistaCodeBreaker(VistaPrincipal VP, CtrlPresentacion CP, String dif) {
        super(CP,VP,dif);
    }
    
    protected void datosIntroducidos() {
        try {
            Color c1 = ((JButton) jPanel_entrada.getComponent(0)).getBackground();
            Color c2 = ((JButton) jPanel_entrada.getComponent(1)).getBackground();
            Color c3 = ((JButton) jPanel_entrada.getComponent(2)).getBackground();
            Color c4 = ((JButton) jPanel_entrada.getComponent(3)).getBackground();
            
            String candidato = colorToInt(c1) + "" + colorToInt(c2) + "" + colorToInt(c3) + "" + colorToInt(c4);
            
            String NB = CP.movimientoCB(candidato);
            // AÑADIMOS LA JUGADA A LA LISTA

            if (j%6 == 0) {
                tablero_act = new JPanel(new GridLayout(6,4));
                inicializarTablero(tablero_act);
                jPanel_tablero.add(tablero_act);
                ((CardLayout) jPanel_tablero.getLayout()).next(jPanel_tablero);
                
                NB_act = new JPanel(new GridLayout(12,2));
                inicializarTablero(NB_act);
                jPanel_NB.add(NB_act);
                ((CardLayout) jPanel_NB.getLayout()).next(jPanel_NB);
                
                
                num_act = new JPanel(new GridLayout(6,1));
                for (int q = 0; q < 6; ++q) {
                    JButton but = new JButton();
                    but.setVisible(false);
                    num_act.add(but);
                }
                jPanel_num.add(num_act);
                ((CardLayout) jPanel_num.getLayout()).next(jPanel_num);
                
            }
            
            int num_N = Character.getNumericValue(NB.charAt(0));
            int num_B = Character.getNumericValue(NB.charAt(1));
            for (int i = 0; i < 4; ++i) {
                tablero_act.getComponent(4*(j%6)+i).setVisible(true);
                if (i == 0) tablero_act.getComponent(4*(j%6)+i).setBackground(c1);
                if (i == 1) tablero_act.getComponent(4*(j%6)+i).setBackground(c2);
                if (i == 2) tablero_act.getComponent(4*(j%6)+i).setBackground(c3);
                if (i == 3) tablero_act.getComponent(4*(j%6)+i).setBackground(c4);
                
                if (i < num_N) {
                    NB_act.getComponent(4*(j%6)+i).setVisible(true);
                    NB_act.getComponent(4*(j%6)+i).setBackground(Color.black);
                }
                else if (i-num_N < num_B) {
                    NB_act.getComponent(4*(j%6)+i).setVisible(true);
                    NB_act.getComponent(4*(j%6)+i).setBackground(Color.white);
                }
            }
            ((JButton) num_act.getComponent(j%6)).setText(Integer.toString(j+1));
            num_act.getComponent(j%6).setVisible(true);
            ((JButton) num_act.getComponent(j%6)).setOpaque(false);
            ((JButton) num_act.getComponent(j%6)).setContentAreaFilled(false);
            ((JButton) num_act.getComponent(j%6)).setBorderPainted(false);
            ++j;
            
            
            // Si NB == 40 -> Se ha acabado el juego
            //Custom button text
            if (NB.equals("40")) {
                String msj = "Partida finalizada\nFelicidades! Tienes una puntuacion de: " + CP.getRondas();
                Object[] options = {"Registrar ranking",
                                "Volver al menu principal"};
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
                VP.goMenuPrincipal();
            }
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
                        else if (cbut == Color.yellow) but.setBackground(Color.orange);
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

}
