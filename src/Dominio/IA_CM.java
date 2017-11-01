package Dominio;

import java.util.Random;

public class IA_CM extends Dominio.IA {

    public IA_CM() {}

    public String generarSecreto() {
        int res = 0;
        Random rand = new Random(); // nextInt(bound) -> [0..bound)
        for (int i = 0; i < 4; ++i) {
            res = res*10 + rand.nextInt(6)+1;
        }
        return Integer.toString(res);
    }

    public String evaluarCandidato(String candidato, String solucion) {
        Pair p = calcularNB(candidato, solucion);
        return p.getX() + "" + p.getY();
    }

}
