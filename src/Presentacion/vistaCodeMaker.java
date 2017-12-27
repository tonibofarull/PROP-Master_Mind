package Presentacion;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
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
    
    public vistaCodeMaker(VistaPrincipal VP, CtrlPresentacion CP, String solucion, String candidato, String dif) {
        super(CP,VP,dif);
        jPanel_sol.setBorder(javax.swing.BorderFactory.createEtchedBorder()); // borde para la solucion
        for (int i = 0; i < 4; ++i) {
            Color c = intToColor(Character.getNumericValue(solucion.charAt(i)));
            JButton but = new JButton();
            but.setBackground(c);
            jPanel_sol.add(but);
        }
        
        tablero_act = new JPanel(new GridLayout(6,4));
        inicializarTablero(tablero_act);
        jPanel_tablero.add(tablero_act);
        ((CardLayout) jPanel_tablero.getLayout()).next(jPanel_tablero);

        NB_act = new JPanel(new GridLayout(12,2));
        inicializarTablero(NB_act);
        jPanel_NB.add(NB_act);
        ((CardLayout) jPanel_NB.getLayout()).next(jPanel_NB);
        
        
        for (int i = 0; i < 4; ++i) {
            tablero_act.getComponent(i).setVisible(true);
            tablero_act.getComponent(i).setBackground(intToColor(Character.getNumericValue(candidato.charAt(i))));
        }

        num_act = new JPanel(new GridLayout(6,1));
        for (int q = 0; q < 6; ++q) {
            JButton but = new JButton();
            but.setVisible(false);

            but.setOpaque(false);
            but.setContentAreaFilled(false);
            but.setBorderPainted(false);

            num_act.add(but);
        }
        jPanel_num.add(num_act);
        ((CardLayout) jPanel_num.getLayout()).next(jPanel_num);
        ((JButton) num_act.getComponent(0)).setText("1");
        ((JButton) num_act.getComponent(0)).setVisible(true);
        
        
        this.solucion = solucion;
        this.candidato = candidato;
        jLabel1.setVisible(true);
        j = 1;
    }
    
    public void cargarPartida(ArrayList<String> info) {
        super.cargarPartida(info);
    }
    
    protected void datosIntroducidos() {
        try {
            int num_N = 0, num_B = 0;
            for (int i = 0; i < 4; ++i) {
                Color c = ((JButton) jPanel_entrada.getComponent(i)).getBackground();
                if (c == Color.black) ++num_N;
                if (c == Color.white) ++num_B;
            }
            
            
            
            String NB = num_N + "" + num_B;
            System.out.println(NB);
            
            String candidato = CP.evaluarCandidato(NB);
            
            for (int i = 0; i < 4; ++i) {
                int k = j-1;
                if (i < num_N) {
                    NB_act.getComponent(4*(k%6)+i).setVisible(true);
                    NB_act.getComponent(4*(k%6)+i).setBackground(Color.black);
                }
                else if (i-num_N < num_B) {
                    NB_act.getComponent(4*(k%6)+i).setVisible(true);
                    NB_act.getComponent(4*(k%6)+i).setBackground(Color.white);
                }
            }
            
            
            // Si NB == 40 -> Se ha acabado el juego
            // Custom button text
            if (NB.equals("40")) {
                String msj = "Partida finalizada\nPuntuacion: " + CP.getRondas();
                Object[] options = {"Volver al menu principal"};
                 int n = JOptionPane.showOptionDialog(this,
                        msj,
                        "Mensaje",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                VP.goMenuPrincipal();
            }
            
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
                    
                    but.setOpaque(false);
                    but.setContentAreaFilled(false);
                    but.setBorderPainted(false);
                    
                    num_act.add(but);
                }
                jPanel_num.add(num_act);
                ((CardLayout) jPanel_num.getLayout()).next(jPanel_num);
                
            }
           
            ArrayList<Color> al = stringToColor(candidato);
            for (int i = 0; i < 4; ++i) {
               tablero_act.getComponent(4*(j%6)+i).setVisible(true);
               if (i == 0) tablero_act.getComponent(4*(j%6)+i).setBackground(al.get(i));
               if (i == 1) tablero_act.getComponent(4*(j%6)+i).setBackground(al.get(i));
               if (i == 2) tablero_act.getComponent(4*(j%6)+i).setBackground(al.get(i));
               if (i == 3) tablero_act.getComponent(4*(j%6)+i).setBackground(al.get(i));
            }
            
            
            ((JButton) num_act.getComponent(j%6)).setText(Integer.toString(j+1));
            num_act.getComponent(j%6).setVisible(true);
            ++j;
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
    
    private ArrayList<Color> stringToColor(String s) {
        ArrayList<Color> al = new ArrayList<>(4);
        for (int i = 0; i < 4; ++i) {
            Color c = intToColor(Character.getNumericValue(s.charAt(i)));
            al.add(c);
        }
        return al;
    }

    protected void mostrarAyuda() {                                         
        vistaAyuda va = new vistaAyuda();
        va.mostrarAyudaCM();
        va.setLocationRelativeTo(this);
        va.setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
