package Presentacion;

import static java.awt.event.KeyEvent.VK_ENTER;
import java.util.ArrayList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class VistaCodeBreaker extends javax.swing.JFrame {

    private CtrlPresentacion CP;
    private VistaPrincipal VP;
    
    private DefaultListModel listModel;
    
    public VistaCodeBreaker(CtrlPresentacion CP, VistaPrincipal VP) {
        listModel = new DefaultListModel();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("CodeBreaker");
        this.CP = CP;
        this.VP = VP;
        jTextField1.grabFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton7 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jList1.setModel(listModel);
        jList1.setCellRenderer(new DefaultListCellRenderer(){
            public int getHorizontalAlignment() {
                return CENTER;
            }
        });
        jScrollPane1.setViewportView(jList1);

        jButton7.setText("Jugar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jButton1.setText("Opciones");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addGap(115, 115, 115))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        datosIntroducidos();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String msj = "Selecciona opcion";
        Object[] options = {"Guardar","Salir y guardar","Salir"};
         int n = JOptionPane.showOptionDialog(this,
                msj,
                "Mensaje",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);
        switch (n) {
            case 2:
                VP.setVisible(true);
                this.dispose();
                break;
            case 1:
                CP.guardarPartida();
                VP.setVisible(true);
                this.dispose();
                break;
            case 0:
                CP.guardarPartida();
                break;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        switch (evt.getKeyCode()) {
            case VK_ENTER:
                datosIntroducidos();
                break;
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    public void cargarPartida(ArrayList<String> info) {
        for (int i = 4; i < info.size(); i += 2) {
            if (i+1 < info.size()) {
                listModel.addElement(info.get(i) + " - " + info.get(i+1));
                jList1.ensureIndexIsVisible(listModel.getSize()-1);
            }
            else {
                listModel.addElement(info.get(i) + " - ...");
                jList1.ensureIndexIsVisible(listModel.getSize()-1);
            }
        }
    }
    
    public void datosIntroducidos() {
        try {
            String code = jTextField1.getText();
            jTextField1.setText("");
            String NB = CP.movimientoCB(code);
            // AÑADIMOS LA JUGADA A LA LISTA
            listModel.addElement(code + " - " + NB);
            jList1.ensureIndexIsVisible(listModel.getSize()-1);
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
                    String user = JOptionPane.showInputDialog(
                                this, 
                                "Introduce el nickname", 
                                "Registrar ranking", 
                                JOptionPane.WARNING_MESSAGE);
                    CP.anadirPuntuacion(user, CP.getRondas());
                 } 
                VP.setVisible(true);
                this.dispose();
            }
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
