package Presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Permite al usuario elegir el codigo secreto para la partida cuando este ejerce de CodeMaker
 *
 * @author Antoni Bofarull
 */
public class vistaIntroducirSecreto extends javax.swing.JPanel {

    private CtrlPresentacion CP;
    private VistaPrincipal VP;
    
    private String dif;
    
    public vistaIntroducirSecreto(VistaPrincipal VP, CtrlPresentacion CP, String dif) {
        this.VP = VP;
        this.CP = CP;
        this.dif = dif;
        initComponents();
        
        inicializarPanelEntrada(jPanel1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(640, 480));

        jPanel1.setLayout(new java.awt.GridLayout(1, 4));

        jLabel1.setText("Introduce el secreto");

        jButton5.setText("Aceptar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Volver");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(165, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton5)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(103, 103, 103)
                .addComponent(jButton6)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel1)
                .addGap(71, 71, 71)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton5))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        VP.goIniciar();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            Color c1 = ((JButton) jPanel1.getComponent(0)).getBackground();
            Color c2 = ((JButton) jPanel1.getComponent(1)).getBackground();
            Color c3 = ((JButton) jPanel1.getComponent(2)).getBackground();
            Color c4 = ((JButton) jPanel1.getComponent(3)).getBackground();
            
            
            String solucion = colorToInt(c1) + "" + colorToInt(c2) + "" + colorToInt(c3) + ""  +colorToInt(c4);
            String candidato = CP.generarSolucion(solucion);
            VP.goCodeMaker(solucion,candidato,dif);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    protected void inicializarPanelEntrada(JPanel panel) {
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
    
    private int colorToInt(Color c) {
        if (c == Color.red) return 1;
        if (c == Color.green) return 2;
        if (c == Color.blue) return 3;
        if (c == Color.cyan) return 4;
        if (c == Color.magenta) return 5;
        if (c == Color.yellow) return 6;
        else return 7;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
