package Presentacion;

import java.util.Scanner;

public class VistaPresentacion {

    VistaPresentacion() {}

    private void mostrarVista() {
        System.out.println("Menu del juego");
        System.out.println("0 - Salir");
        System.out.println("1 - Empezar partida");
    }

    public int obtenerOpcion() {
        mostrarVista();
        Scanner scan = new Scanner(System.in);
        int opcion = scan.nextInt();
        return opcion;
    }

    public int obtenerDificultad() {
        System.out.println();
        System.out.println("Dificultad");
        System.out.println("0 - Facil");
        System.out.println("1 - Medio");
        System.out.println("2 - Dificil");
        Scanner scan = new Scanner(System.in);
        int dificultad = scan.nextInt();
        return dificultad;
    }

    public int obtenerRol() {
        System.out.println();
        System.out.println("Rol");
        System.out.println("0 - CodeMaker");
        System.out.println("1 - CodeBreaker");
        Scanner scan = new Scanner(System.in);
        int rol = scan.nextInt();
        return rol;
    }

    public String obtenerCandidatoSolucion(boolean is_candidato) {
        if (is_candidato) System.out.print("Candidato: ");
        else System.out.print("Solucion: ");
        Scanner scan = new Scanner(System.in);
        String linea = scan.next();
        return linea;
    }

    public void mostrarCandidato(String cs) {
        System.out.println(cs);
    }

    public String obtenerNB() {
        System.out.print("NB: ");
        Scanner scan = new Scanner(System.in);
        String nb = scan.next();
        return nb;
    }

    public void mostrarNB(String nb) {
        System.out.println(nb);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println();
        System.out.println(mensaje);
    }

}
