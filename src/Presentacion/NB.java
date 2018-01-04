package Presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Bola contiene las caracteristicas concretas de una bola de evaluacion
 *
 * @author Antoni Bofarull
 */
public class NB extends Bola {
    
    /**
     * @pre Cierto
     * @post Se ha inicializado la instancia con la transicion de colores indicada.
    */
    public NB() {
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Color cbut = ((JButton) evt.getSource()).getBackground();
                if (cbut == Color.white) setBackground(Color.black);
                else if (cbut == Color.black) setBackground(Color.gray);
                else setBackground(Color.white);
            }
        });
    }
    
}
