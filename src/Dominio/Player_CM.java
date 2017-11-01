package Dominio;

public class Player_CM {
    public Player_CM () {

    }

    public boolean comprobarSolucion(String solucion) {
        try {
            if (solucion.length() == 4) {
                for (int i = 0; i < solucion.length(); ++i) {
                    if (Character.getNumericValue(solucion.charAt(i)) < 1 || Character.getNumericValue(solucion.charAt(i)) > 6) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        catch (Exception e) {
            return false;
        }
    }

    public boolean comprobarBN(String candidato, String solucion, String bn) {
        try {
            if (bn.length() == 2) {
                int totalbn = 0;
                for (int i = 0; i < bn.length(); ++i) {
                    if (Character.getNumericValue(bn.charAt(i)) < 0 || Character.getNumericValue(bn.charAt(i)) > 6) {
                        return false;
                    }
                    else {
                        totalbn += Character.getNumericValue(bn.charAt(i));
                    }
                }
                if (totalbn <= 6) {
                    int numb = 0;
                    int numn = 0;
                    for (int i = 0; i < solucion.length(); ++i) {
                        for (int j = 0; j < candidato.length(); ++j) {
                            if (Character.getNumericValue(solucion.charAt(i)) == Character.getNumericValue(candidato.charAt(j))) {
                                if (i == j) ++numn;
                                else ++numb;
                            }
                        }
                    }
                    if (numb == Character.getNumericValue(bn.charAt(0)) && numn == Character.getNumericValue(bn.charAt(1))) {
                        return true;
                    }
                    else return false;
                }
                else return false;
            }
            return false;
        }
        catch (Exception e) {
            return false;
        }
    }
}
