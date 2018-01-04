package Presentacion;

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
    
    /**
     * @pre Cierto.
     * @post Se ha inicializado la vista
    */
    public vistaIntroducirSecreto(CtrlPresentacion CP) {
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

        jLabel1.setFont(jLabel1.getFont().deriveFont((float)17));
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
                .addContainerGap(164, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton5)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(103, 103, 103)
                .addComponent(jButton6)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLabel1)
                .addGap(84, 84, 84)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton5))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        CP.irConfiguracionPartida();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            String solucion = "";
            for (int i = 0; i < 4; ++i) {
                Bola b = ((Bola) jPanel1.getComponent(i));
                solucion += b.getValue();
            }
            
            String candidato = CP.generarSolucion(solucion);
            CP.irPartidaCodeMaker(solucion,candidato);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @pre Cierto.
     * @post Se ha inicializado el panel.
     */
    private void inicializarPanelEntrada(JPanel panel) {
        for (int i = 0; i < 4; ++i) {
            JButton but = null;
            if (CP.getDificultad().equals("DIFICIL")) but = new Bola7();
            else but = new Bola6();
            but.setVisible(true);
            panel.add(but);
        }
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
