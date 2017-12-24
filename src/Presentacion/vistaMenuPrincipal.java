package Presentacion;

import static java.lang.System.exit;

public class vistaMenuPrincipal extends javax.swing.JPanel {

    private VistaPrincipal VP;
    
    public vistaMenuPrincipal(VistaPrincipal VP) {
        this.VP = VP;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        iniciar = new javax.swing.JButton();
        continuar = new javax.swing.JButton();
        ranking = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setMaximumSize(null);
        setMinimumSize(null);

        jPanel1.setLayout(new java.awt.GridLayout(4, 1, 0, 20));

        iniciar.setText("Iniciar Partida");
        iniciar.setAlignmentX(1.0F);
        iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarActionPerformed(evt);
            }
        });
        jPanel1.add(iniciar);

        continuar.setText("Continuar Partida");
        continuar.setAlignmentX(1.0F);
        continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarActionPerformed(evt);
            }
        });
        jPanel1.add(continuar);

        ranking.setText("Consultar Ranking");
        ranking.setAlignmentX(1.0F);
        ranking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rankingActionPerformed(evt);
            }
        });
        jPanel1.add(ranking);

        salir.setText("Salir del Juego");
        salir.setAlignmentX(1.0F);
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel1.add(salir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(233, 233, 233))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void rankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rankingActionPerformed
        VP.goRanking();
    }//GEN-LAST:event_rankingActionPerformed

    private void continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarActionPerformed
        VP.goReanudar();
    }//GEN-LAST:event_continuarActionPerformed

    private void iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarActionPerformed
        VP.goIniciar();
    }//GEN-LAST:event_iniciarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton continuar;
    private javax.swing.JButton iniciar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton ranking;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
