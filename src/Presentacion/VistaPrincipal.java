package Presentacion;

import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class VistaPrincipal extends javax.swing.JFrame {

    private CtrlPresentacion CP;
    
    public VistaPrincipal(CtrlPresentacion CP) {
        this.CP = CP;
        initComponents();
        
        this.setTitle("MasterMind");
        this.setLocationRelativeTo(null);
        
        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("res/favicon.png")));
        } 
        catch (Exception e) {}
        
        ventana.add(new vistaMenuPrincipal(this));
        
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ventana = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);
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

    public void goRanking() {
        ventana.add(new vistaRanking(this,CP));
        ((CardLayout) ventana.getLayout()).last(ventana);
    }
    
    public void goMenuPrincipal() {
        ventana.removeAll();
        ventana.add(new vistaMenuPrincipal(this));
    }
    
    public void goIniciar() {
        ventana.add(new vistaConfiguracion(this,CP));
        ((CardLayout) ventana.getLayout()).last(ventana);
    }
    
    public void goCodeBreaker(String dif) {
        vistaCodeBreaker cb = new vistaCodeBreaker(this,CP, dif);
        ventana.add(cb);
        ((CardLayout) ventana.getLayout()).last(ventana);
    }
    
    public void goCodeMaker(String solucion, String candidato, String dif) {
        vistaCodeMaker cm = new vistaCodeMaker(this,CP,solucion,candidato, dif);
        ventana.add(cm);
        ((CardLayout) ventana.getLayout()).last(ventana);
    }
     
    public void goIntroCodeMaker(String dif) {
        vistaIntroducirSecreto cm = new vistaIntroducirSecreto(this,CP,dif);
        ventana.add(cm);
        ((CardLayout) ventana.getLayout()).last(ventana);
    }
    
    public void goReanudar() {
        try {
            ArrayList<String> al = CP.cargarPartida();
            if (al.get(1).equals("CODEMAKER")) {
                vistaCodeMaker cm = new vistaCodeMaker(this,CP,al.get(3),al.get(4),al.get(0));
                cm.cargarPartida(al);
                ventana.add(cm);
            }
            else {
                vistaCodeBreaker cb = new vistaCodeBreaker(this,CP,al.get(0));
                cb.cargarPartida(al);
                ventana.add(cb);
            }
            
            
            ((CardLayout) ventana.getLayout()).last(ventana);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ventana;
    // End of variables declaration//GEN-END:variables
}
