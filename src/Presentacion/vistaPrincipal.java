package Presentacion;

import java.awt.CardLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * vistaPrincipal es la clase encargada de actualizar el JPanel
 *
 * @author Ferran Martinez
 */
public class vistaPrincipal extends javax.swing.JFrame {

    private CtrlPresentacion CP;
    
    /**
     * @param CP instancia del CtrlPresentación que estamos usando.
     * @pre Cierto.
     * @post Se genera la ventana de la aplicación, mostrando la vista correspondiente al
     * menú principal
    */
    public vistaPrincipal(CtrlPresentacion CP) {
        this.CP = CP;
        initComponents();
        
        this.setTitle("MasterMind");
        this.setLocationRelativeTo(null);
        
        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("res/favicon.png")));
        } 
        catch (Exception e) {}
        
        ventana.add(new vistaMenuPrincipal(CP));
        
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ventana = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(null);
        setResizable(false);
        setSize(new java.awt.Dimension(640, 480));

        ventana.setMaximumSize(new java.awt.Dimension(640, 480));
        ventana.setMinimumSize(new java.awt.Dimension(640, 480));
        ventana.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ventana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ventana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        /**
     * @pre Ventana ha sido inicializada.
     * @post Se cambia la vista a la vista correspondiente a los ranking
    */
    public void irRanking() {
        ventana.removeAll();
        ventana.add(new vistaRanking(CP));
        ((CardLayout) ventana.getLayout()).last(ventana);
    }
    
        /**
     * @pre Ventana ha sido inicializada.
     * @post Se cambia la vista a la vista correspondiente al menú principal
    */
    public void irMenuPrincipal() {
        ventana.removeAll();
        ventana.add(new vistaMenuPrincipal(CP));
        ((CardLayout) ventana.getLayout()).last(ventana);
    }
    
    /**
     * @pre Ventana ha sido inicializada.
     * @post Se cambia la vista a la vista correspondiente a la configuración de la partida
    */
    public void empezarPartida() {
        ventana.removeAll();
        ventana.add(new vistaConfiguracion(CP));
        ((CardLayout) ventana.getLayout()).last(ventana);
    }
    
    /**
     * @param dif dificultad asociada a la partida
     * @pre Ventana ha sido inicializada.
     * @post Se cambia la vista a la vista correspondiente a la partida con el usuario
     * como rol CodeBreaker
    */
    public void irPartidaCodeBreaker(String dif) {
        ventana.removeAll();
        ventana.add(new vistaCodeBreaker(CP, dif));
        ((CardLayout) ventana.getLayout()).last(ventana);
    }
    
    /**
     * @param solucion String con el codigo solucion a la partida
     * @param candidato String con el código candidato 
     * @param dif dificultad asociada a la partida
     * @pre Ventana ha sido inicializada.
     * @post Se cambia la vista a la vista correspondiente a la partida con el usuario
     * como rol de CodeMaker
    */
    public void irPartidaCodeMaker(String solucion, String candidato, String dif) {
        ventana.removeAll();
        ventana.add(new vistaCodeMaker(CP,solucion,candidato, dif));
        ((CardLayout) ventana.getLayout()).last(ventana);
    }
    
    /**
     * @param dif String con la dificultad asociada a la partida
     * @pre Ventana ha sido inicializada.
     * @post Se cambia la vista a la vista correspondiente a introducir secreto.
    */
    public void irIntroducirSecreto(String dif) {
        ventana.removeAll();
        ventana.add(new vistaIntroducirSecreto(CP,dif));
        ((CardLayout) ventana.getLayout()).last(ventana);
    }
    
    /**
     * @pre ventana ha sido inicializada. Hay una partida guardada.
     * @post Se carga la partida. Se cambia la vista a la correspondiente en función
     * de la partida guardada.
    */
    public void irCargarPartida() {
        try {
            ArrayList<String> al = CP.cargarPartida();
            
            ventana.removeAll();
            if (al.get(1).equals("CODEMAKER")) {
                vistaCodeMaker cm = new vistaCodeMaker(CP,al.get(3),al.get(4),al.get(0));
                cm.cargarPartida(al);
                ventana.add(cm);
            }
            else {
                vistaCodeBreaker cb = new vistaCodeBreaker(CP,al.get(0));
                cb.cargarPartida(al);
                ventana.add(cb);
            }
            ((CardLayout) ventana.getLayout()).last(ventana);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
   /**
     * @pre ventana ha sido inicializada.
     * @post Se cambia la vista a la vista correspondiente a la configuración de la partida.
    */
    public void irConfiguracionPartida() {
        ventana.removeAll();
        ventana.add(new vistaConfiguracion(CP));
        ((CardLayout) ventana.getLayout()).last(ventana);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ventana;
    // End of variables declaration//GEN-END:variables
}
