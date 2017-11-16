package Test.Maquina;

import Dominio.Dificultad;
import Dominio.Rol;

import Test.Stubs.Stub_Normas;

import java.util.Scanner;

public class Driver_Maquina {

    private static void mostrarMenu() {
        System.out.println("0 - crear instancia Maquina");
        System.out.println("1 - generarCandidato");
        System.out.println("2 - generarSolucion");
        System.out.println("3 - visualizar Menu");
        System.out.println("4 - salir");
    }

    private static void testConstructor() {
        Scanner scan = new Scanner(System.in);

        System.out.print("dificultad (0 - Facil, 1 - Medio, 2 - Dificil): ");
        int dif = scan.nextInt();
        Dificultad dificultad = Dificultad.FACIL;
        if (dif == 1) dificultad = Dificultad.MEDIO;
        else if (dif == 2) dificultad = Dificultad.DIFICIL;

        System.out.print("rol (0 - CodeBreaker, 1 - CodeMaker): ");
        int r = scan.nextInt();
        Rol rol = Rol.CODEBREAKER;
        if (r == 1) rol = Rol.CODEMAKER;

        Stub_Normas normas = new Stub_Normas();
        Maquina maquina = new Maquina(normas,dificultad,rol);
    }

    private static void testGenerarCandidato() {
        Scanner scan = new Scanner(System.in);

        System.out.print("ultimoCandidato: ");
        String ultimoCandidato = scan.next();
        System.out.print("ultimaNB: ");
        String ultimaNB = scan.next();
        System.out.print("dificultad (0 - Facil, 1 - Medio, 2 - Dificil): ");
        int dif = scan.nextInt();
        Dificultad dificultad = Dificultad.FACIL;
        if (dif == 1) dificultad = Dificultad.MEDIO;
        else if (dif == 2) dificultad = Dificultad.DIFICIL;

        Stub_Normas normas = new Stub_Normas();
        Maquina maquina = new Maquina(normas,dificultad,Rol.CODEMAKER);
        String candidato = maquina.generarCandidato(ultimoCandidato,ultimaNB,dificultad);
        System.out.println(candidato);
    }

    private static void testGenerarSolucion() {
        Scanner scan = new Scanner(System.in);

        System.out.print("dificultad (0 - Facil, 1 - Medio, 2 - Dificil): ");
        int dif = scan.nextInt();
        Dificultad dificultad = Dificultad.FACIL;
        if (dif == 1) dificultad = Dificultad.MEDIO;
        else if (dif == 2) dificultad = Dificultad.DIFICIL;

        Stub_Normas normas = new Stub_Normas();
        Maquina maquina = new Maquina(normas,dificultad,Rol.CODEBREAKER);
        String solucion = maquina.generarSolucion(dificultad);
        System.out.println(solucion);
    }

    public static void main(String[] args) {
        mostrarMenu();
        System.out.println();
        Scanner scan = new Scanner(System.in);
        System.out.print("opcion: ");
        int opcion = scan.nextInt();
        while (opcion != 4) {
            switch (opcion) {
                case 0:
                    testConstructor();
                    break;
                case 1:
                    testGenerarCandidato();
                    break;
                case 2:
                    testGenerarSolucion();
                    break;
                case 3:
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
