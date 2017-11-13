package Test.CtrlDominio;

import Dominio.CtrlDominio;

import java.util.Scanner;

public class Driver_CtrlDominio {
    private static void mostrarMenu() {
        System.out.println("0 - crear instancia CtrlDominio");
        System.out.println("1 - empezarPartida");
        System.out.println("2 - generarSolucion");
        System.out.println("3 - evaluarCandidato");
        System.out.println("4 - generarCandidato");
        System.out.println("5 - visualizar Menu");
        System.out.println("6 - salir");
    }

    public static void main(String[] args) {
        mostrarMenu();
        System.out.println();
        Scanner scan = new Scanner(System.in);
        System.out.print("opcion: ");
        int opcion = scan.nextInt();

        CtrlDominio ctrlDominio = new CtrlDominio();
        while (opcion != 6) {
            switch(opcion){
                case 0:
                    ctrlDominio = new CtrlDominio();
                    System.out.println("Instancia de CtrlDominio creada correctamente");
                    break;
                case 1:
                    System.out.println("Introduzca la dificultad:");
                    System.out.println("0 - Facil");
                    System.out.println("1 - Medio");
                    System.out.println("2 - Dificil");
                    int dif = scan.nextInt();
                    System.out.println();
                    String dificultad;
                    if (dif == 0) dificultad = "FACIL";
                    else if (dif == 1) dificultad = "MEDIO";
                    else dificultad = "DIFICIL";
                    System.out.println("0 - CodeMaker");
                    System.out.println("1 - CodeBreaker");
                    int r = scan.nextInt();
                    System.out.println();
                    String rol = "CODEMAKER";
                    if (r == 1) rol = "CODEBREAKER";
                    if (ctrlDominio.empezarPartida(dificultad, rol) ) System.out.println("Partida creada correctamente");
                    else System.out.println("Problemas al generar la partida");
                    break;

                case 2:
                    System.out.println("Introduzca la solución:");
                    String solucion = scan.next();
                    System.out.println();
                    try {
                        String candidato = ctrlDominio.generarSolucion(solucion);
                        System.out.println("Solucion introducida correctamente");
                        System.out.println("Candidato generado: " + candidato);
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Introduzca la evaluación del último candidato introducido:");
                    String nb = scan.next();
                    System.out.println();
                    try {
                        String candidato = ctrlDominio.evaluarCandidato(nb);
                        System.out.println("Candidato evaluado correctamente");
                        System.out.println("Siguiente candidato: " + candidato);
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Introduzca el siguiente candidato a solución:");
                    String candidato = scan.next();
                    System.out.println();
                    try {
                        String nb_s = ctrlDominio.generarCandidato(candidato);
                        System.out.println("Solucion introducida correctamente");
                        System.out.println("Evaluación: " + nb_s);
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    mostrarMenu();
                    break;
                default: break;
            }
            System.out.println();
            System.out.print("opcion: ");
            opcion = scan.nextInt();
        }
    }
}
