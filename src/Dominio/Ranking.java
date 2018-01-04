package Dominio;

import java.util.ArrayList;

/**
 * Se encarga de administrar los usuarios y las puntuaciones
 *
 * @author Sergi Avila
 */
public class Ranking {

    private ArrayList<ArrayList<String>> top10;

    /**
     * @pre Cierto.
     * @post Se ha inicializado el ranking
    */
    public Ranking() {
        top10 = new ArrayList<>(10);
    }

    /**
     * @pre Cierto
     * @post Añade el nombre y la puntiacion al ranking si esta dentro del Top 10 mejores puntuaciones
     */
    public void anadirPuntuacion(String name, String score) {
        boolean found = false;
        int scoreval = Integer.parseInt(score);
        ArrayList<String> aux = new ArrayList<>(2);
        aux.add(name);
        aux.add(score);

        for (int i = 0; i < top10.size() && !found; i++) {
            if (Integer.parseInt(top10.get(i).get(1)) > scoreval) {
                found = true;
                top10.add(i, aux);
                if (top10.size() == 11) top10.remove(10);
            }
        }
        if (!found && top10.size() < 10) top10.add(aux);
    }

    /**
     * @pre Cierto
     * @post Devuelve el ranking.
     */
    public ArrayList<ArrayList<String>> consultaRanking() {
        return top10;
    }
    
}
