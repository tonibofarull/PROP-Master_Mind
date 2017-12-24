package Presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class vistaIntroducirSecreto extends javax.swing.JPanel {

    private CtrlPresentacion CP;
    private VistaPrincipal VP;
    
    public vistaIntroducirSecreto(VistaPrincipal VP, CtrlPresentacion CP) {
        this.VP = VP;
        this.CP = CP;
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
                .addGap(116, 116, 116)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton5))
                .addGap(124, 124, 124))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel1)
                .addGap(75, 75, 75)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(43, 43, 43)
                .addComponent(jButton6)
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
            VP.goCodeMaker(solucion,candidato);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    protected void inicializarPanelEntrada(JPanel panel) {
        for (int i = 0; i < 4; ++i) {
            JButton but = new JButton();
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
