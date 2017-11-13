package Test.CtrlDominio;

import Dominio.Dificultad;
import Dominio.Rol;

public class Stub_Maquina {

    public Stub_Maquina(Stub_Normas normas, Dificultad dificultad, Rol rolJugadorHumano) {}

    public String generarCandidato(String ultimoCandidato, String ultimaNB, Dificultad dificultad) {
        return "1234";
    }

    public String generarSolucion(Dificultad dificultad) {
        return "1234";
    }

}

