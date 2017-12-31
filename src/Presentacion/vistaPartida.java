package Presentacion;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Panel comun a los distintos roles, administra las funcionalidades comunes
 *
 * @author Antoni Bofarull
 */
public abstract class vistaPartida extends javax.swing.JPanel {

    protected CtrlPresentacion CP;
    protected vistaAyuda VA;
    
    protected int index = 0;
    protected int card = 0;
    
    public vistaPartida(CtrlPresentacion CP, String dif) {
        this.CP = CP;
        VA = new vistaAyuda();
        VA.setLocationRelativeTo(null);
        initComponents();
        text_sol.setVisible(false);
        inicializarPanelEntrada(jPanel_entrada,dif);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opciones = new javax.swing.JButton();
        jugar = new javax.swing.JButton();
        jPanel_entrada = new javax.swing.JPanel();
        jPanel_tablero = new javax.swing.JPanel();
        up = new javax.swing.JButton();
        down = new javax.swing.JButton();
        jPanel_sol = new javax.swing.JPanel();
        jPanel_NB = new javax.swing.JPanel();
        text_sol = new javax.swing.JLabel();
        jPanel_num = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(640, 480));

        opciones.setText("Opciones");
        opciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionesActionPerformed(evt);
            }
        });

        jugar.setText("Jugar");
        jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarActionPerformed(evt);
            }
        });

        jPanel_entrada.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel_entrada.setLayout(new java.awt.GridLayout(1, 0));

        jPanel_tablero.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel_tablero.setLayout(new java.awt.CardLayout());

        up.setText("Up");
        up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upActionPerformed(evt);
            }
        });

        down.setText("Down");
        down.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downActionPerformed(evt);
            }
        });

        jPanel_sol.setLayout(new java.awt.GridLayout(1, 4));

        jPanel_NB.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel_NB.setLayout(new java.awt.CardLayout());

        text_sol.setText("Solución");

        jPanel_num.setMaximumSize(new java.awt.Dimension(60, 300));
        jPanel_num.setMinimumSize(new java.awt.Dimension(60, 300));
        jPanel_num.setPreferredSize(new java.awt.Dimension(60, 300));
        jPanel_num.setLayout(new java.awt.CardLayout());

        jButton1.setText("?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(text_sol)
                    .addComponent(jPanel_sol, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(up, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(down))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel_num, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel_tablero, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jugar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel_NB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(text_sol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel_tablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel_NB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(opciones)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(jPanel_num, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jugar)
                                .addGap(55, 55, 55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel_sol, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(up)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(down)
                        .addGap(260, 260, 260)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void opcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionesActionPerformed
        String msj = "Selecciona opción.";
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
            case 0:
                CP.guardarPartida();
                break;
            case 1:
                VA.dispose();
                CP.guardarPartida();
                CP.volverMenuPrincipal();
                break;
            case 2:
                VA.dispose();
                CP.volverMenuPrincipal();
                break;
        }
    }//GEN-LAST:event_opcionesActionPerformed

    private void jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarActionPerformed
        datosIntroducidos();
        ((CardLayout) jPanel_num.getLayout()).last(jPanel_num);
        ((CardLayout) jPanel_NB.getLayout()).last(jPanel_NB);
        ((CardLayout) jPanel_tablero.getLayout()).last(jPanel_tablero);
    }//GEN-LAST:event_jugarActionPerformed

    private void upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upActionPerformed
        ((CardLayout) jPanel_num.getLayout()).previous(jPanel_num);
        ((CardLayout) jPanel_NB.getLayout()).previous(jPanel_NB);
        ((CardLayout) jPanel_tablero.getLayout()).previous(jPanel_tablero);
        
    }//GEN-LAST:event_upActionPerformed

    private void downActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downActionPerformed
        ((CardLayout) jPanel_num.getLayout()).next(jPanel_num);
        ((CardLayout) jPanel_NB.getLayout()).next(jPanel_NB);
        ((CardLayout) jPanel_tablero.getLayout()).next(jPanel_tablero);
    }//GEN-LAST:event_downActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mostrarAyuda();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void cargarPartida(ArrayList<String> info) {
        index = 0;
        if (info.get(1).equals("CODEBREAKER")) {
            inicializarTablero();
            inicializarNB();
            inicializarNum();
        }
        for (int i = 4; i < info.size(); i += 2) {
            String candidato = info.get(i);
            String NB = null;
            if (i+1 < info.size()) NB = info.get(i+1);
            
            if (index != 0 && index%6 == 0) {
                inicializarTablero();
                inicializarNB();
                inicializarNum();
            }
            
            for (int u = 0; u < 4; ++u) { // introducimos el candidato en el tablero
                tablero_act.getComponent(4*(index%6)+u).setBackground(intToColor(Character.getNumericValue(candidato.charAt(u))));
                tablero_act.getComponent(4*(index%6)+u).setVisible(true);
            }
            
            ((JButton) num_act.getComponent(index%6)).setText(Integer.toString(index+1));
            num_act.getComponent(index%6).setVisible(true); // ponemos el numero de la ronda y lo hacemos visible
            
            if (NB == null) { ++index; return; }
            anadirNB(NB,index);
            ++index;
        }
    }
    
    protected void inicializarTableroNB(JPanel panel) {
        for (int i = 0; i < 4*6; ++i) { // Inicializamos los botones del tablero
            JButton but = new JButton();
            but.setVisible(false);
            panel.add(but);
        }
    } 
    
    protected void inicializarTablero() {
        tablero_act = new JPanel(new GridLayout(6,4));
        inicializarTableroNB(tablero_act);
        jPanel_tablero.add(tablero_act);
        ((CardLayout) jPanel_tablero.getLayout()).next(jPanel_tablero);
    }
    
    protected void inicializarNB() {
        NB_act = new JPanel(new GridLayout(12,2));
        inicializarTableroNB(NB_act);
        jPanel_NB.add(NB_act);
        ((CardLayout) jPanel_NB.getLayout()).next(jPanel_NB);
    }
    
    protected void inicializarNum() {
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
    
        
    protected abstract void datosIntroducidos();
    
    protected abstract void inicializarPanelEntrada(JPanel jPanel_entrada, String dif);
    
    protected abstract void finalizarPartida();
    
    protected abstract void mostrarAyuda();
   
    protected void anadirNB(String NB, int k) {
        int num_N = Character.getNumericValue(NB.charAt(0));
        int num_B = Character.getNumericValue(NB.charAt(1));
        for (int q = 0; q < 4; ++q) { // colocamos las bolas negras y blancas
            if (q < num_N) {
                NB_act.getComponent(4*(k%6)+q).setBackground(Color.black);
                NB_act.getComponent(4*(k%6)+q).setVisible(true);
            }
            else if (q-num_N < num_B) {
                NB_act.getComponent(4*(k%6)+q).setBackground(Color.white);
                NB_act.getComponent(4*(k%6)+q).setVisible(true);
            }
        }
    }
    
    protected int colorToInt(Color c) {
        if (c == Color.red) return 1;
        if (c == Color.green) return 2;
        if (c == Color.blue) return 3;
        if (c == Color.cyan) return 4;
        if (c == Color.magenta) return 5;
        if (c == Color.yellow) return 6;
        if (c.equals(new Color(0xff,0x99,0x00))) return 7;
        return 8;
    }
    
    protected Color intToColor(int i) {
        if (i == 1) return Color.red;
        if (i == 2) return Color.green;
        if (i == 3) return Color.blue;
        if (i == 4) return Color.cyan;
        if (i == 5) return Color.magenta;
        if (i == 6 )return Color.yellow;
        if (i == 7) return new Color(0xff,0x99,0x00);
        return null;
    }
   
    protected javax.swing.JPanel NB_act;
    protected javax.swing.JPanel tablero_act;
    protected javax.swing.JPanel num_act;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton down;
    protected javax.swing.JButton jButton1;
    protected javax.swing.JPanel jPanel_NB;
    protected javax.swing.JPanel jPanel_entrada;
    protected javax.swing.JPanel jPanel_num;
    protected javax.swing.JPanel jPanel_sol;
    protected javax.swing.JPanel jPanel_tablero;
    protected javax.swing.JButton jugar;
    protected javax.swing.JButton opciones;
    protected javax.swing.JLabel text_sol;
    protected javax.swing.JButton up;
    // End of variables declaration//GEN-END:variables
}
