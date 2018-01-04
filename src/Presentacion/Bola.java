package Presentacion;

import java.awt.Color;
import javax.swing.JButton;

/**
 * Bola contiene las caracteristicas generales de una bola del tablero
 *
 * @author Antoni Bofarull
 */
public class Bola extends JButton {
    
    /**
     * @pre Cierto
     * @post Se ha inicializado con las caracteristicas por defecto de una Bola.
    */
    public Bola() {
        this.setBackground(Color.gray);
        this.setVisible(false);
    }
    
    /**
     * @pre Color c es un color valido
     * @post Se ha inicializado la bola con el color del parametro
    */
    public Bola(Color c) {
        this.setBackground(c);
    }
    
    /**
     * @pre c es un valor numerico de un color valido
     * @post Se ha inicializado la bola con el color del parametro
    */
    public Bola(int c) {
        setBackground(intToColor(c));
    }
    
    /**
     * @pre c es un valor numerico de un color valido
     * @post Se ha puesto el color de fondo del color recibido
    */
    public void setBackground(int c) {
        setBackground(intToColor(c));
    }
    
    /**
     * @pre Cierto
     * @post Se obtiene el valor numerico del color de la Bola
    */
    public int getValue() {
        return colorToInt(this.getBackground());
    }
    
    /**
     * @pre Cierto
     * @post Se devuelve el valor numerico del color en caso de ser color valido.
    */
    public static int colorToInt(Color c) {
        if (c == Color.red) return 1;
        if (c == Color.green) return 2;
        if (c == Color.blue) return 3;
        if (c == Color.cyan) return 4;
        if (c == Color.magenta) return 5;
        if (c == Color.yellow) return 6;
        if (c.equals(new Color(0xff,0x99,0x00))) return 7;
        return Integer.MAX_VALUE;
    }

    /**
     * @param i valor numerico del color a obtener
     * 
     * @pre el valor numerico tiene asociado un color
     * @post Se devuelve la Bola asociada al valor numerico
    */
    public static Color intToColor(int i) {
        if (i == 1) return Color.red;
        if (i == 2) return Color.green;
        if (i == 3) return Color.blue;
        if (i == 4) return Color.cyan;
        if (i == 5) return Color.magenta;
        if (i == 6 )return Color.yellow;
        if (i == 7) return new Color(0xff,0x99,0x00);
        return null;
    }
    
}
