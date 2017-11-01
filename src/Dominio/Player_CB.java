package Dominio;

public class Player_CB {

    public Player_CB() {

    }

    public boolean comprobarCandidato(String codigo) {
        try {
            if (codigo.length() == 4) {
                for (int i = 0; i < codigo.length(); ++i) {
                    if (Character.getNumericValue(codigo.charAt(i)) < 1 || Character.getNumericValue(codigo.charAt(i)) > 6) {
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
}
