package Presentacion;

import javax.swing.JOptionPane;

public class vistaConfiguracion extends javax.swing.JPanel {

    private VistaPrincipal VP; 
    private CtrlPresentacion CP;
    
    public vistaConfiguracion(VistaPrincipal VP, CtrlPresentacion CP) {
        this.VP = VP;
        this.CP = CP;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        volver = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Facil");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Dificil");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Medio");

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("CodeMaker");

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("CodeBreaker");

        jLabel1.setText("Selecciona una dificultad");

        jLabel2.setText("Selecciona un rol");

        jButton2.setText("Iniciar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(218, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton4)
                        .addGap(134, 134, 134))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jRadioButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(jButton2)
                                .addComponent(jLabel2)
                                .addComponent(jRadioButton2)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jRadioButton3))
                        .addComponent(jRadioButton5)))
                .addGap(136, 136, 136)
                .addComponent(volver)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton2))
                .addGap(54, 54, 54)
                .addComponent(jLabel2)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton4))
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volver)
                    .addComponent(jButton2))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        VP.goMenuPrincipal();
    }//GEN-LAST:event_volverActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if ((jRadioButton1.isSelected() || jRadioButton2.isSelected() || jRadioButton3.isSelected()) && 
            (jRadioButton4.isSelected() || jRadioButton5.isSelected())) {
            String dificultad_s = "FACIL";
            if (jRadioButton2.isSelected()) dificultad_s = "MEDIO";
            else if (jRadioButton3.isSelected()) dificultad_s = "DIFICIL";
            String rol_s = "CODEMAKER";
            if (jRadioButton5.isSelected()) rol_s = "CODEBREAKER";
            CP.empezarPartida(dificultad_s, rol_s);
            // Se ha indicado a dominio que empiece una partida con la configuracion escogida

            if (rol_s.equals("CODEMAKER")) {
                VP.goIntroCodeMaker(dificultad_s);
            }
            else {
                VP.goCodeBreaker(dificultad_s);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Selecciona rol y dificultad");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
