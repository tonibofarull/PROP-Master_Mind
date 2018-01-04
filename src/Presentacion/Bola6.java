package Presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Bola contiene las caracteristicas concretas de una bola de dificultad facil/media.
 *
 * @author Antoni Bofarull
 */
public class Bola6 extends Bola {
    
    /**
     * @pre Cierto
     * @post Se ha inicializado la instancia con la transicion de colores indicada.
    */
    public Bola6() {
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Color cbut = ((JButton) evt.getSource()).getBackground();
                if (cbut == Color.red) setBackground(Color.green);
                else if (cbut == Color.green) setBackground(Color.blue);
                else if (cbut == Color.blue) setBackground(Color.cyan);
                else if (cbut == Color.cyan) setBackground(Color.magenta);
                else if (cbut == Color.magenta) setBackground(Color.yellow);
                else setBackground(Color.red);
            }
        });
    }
    
    
}
