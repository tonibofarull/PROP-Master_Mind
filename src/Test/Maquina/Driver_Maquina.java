package Test.Maquina;

import Dominio.Dificultad;
import Dominio.Rol;

import java.util.Scanner;

public class Driver_Maquina {

    private static void mostrarMenu() {
        System.out.println("0 - crear instancia Maquina");
        System.out.println("1 - generarCandidato");
        System.out.println("2 - generarSolucion");
        System.out.println("3 - visualizar Menu");
        System.out.println("4 - salir");
    }

    public static void main(String[] args) {
        mostrarMenu();
        System.out.println();
        Scanner scan = new Scanner(System.in);
        System.out.print("opcion: ");
        int opcion = scan.nextInt();

        Stub_Normas normas = new Stub_Normas();
        Maquina maquina = new Maquina(normas,Dificultad.FACIL,Rol.CODEBREAKER);
        Dificultad dificultad = Dificultad.FACIL;
        String ultimoCandidato = "1234";
        String ultimaNB = "20";
        while (opcion != 4) {
            switch (opcion) {
                case 0:
                    System.out.println("0 - Facil");
                    System.out.println("1 - Medio");
                    System.out.println("2 - Dificil");
                    int dif = scan.nextInt();
                    if (dif == 1) dificultad = Dificultad.MEDIO;
                    if (dif == 2) dificultad = Dificultad.DIFICIL;
                    System.out.println("0 - CodeMaker");
                    System.out.println("1 - CodeBreaker");
                    int r = scan.nextInt();
                    Rol rol = Rol.CODEMAKER;
                    if (r == 1) rol = Rol.CODEBREAKER;
                    maquina = new Maquina(normas,dificultad,rol);
                    break;
                case 1:
                    String candidato = maquina.generarCandidato(ultimoCandidato,ultimaNB,dificultad);
                    System.out.println(candidato);
                    break;
                case 2:
                    String solucion = maquina.generarSolucion(dificultad);
                    System.out.println(solucion);
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
