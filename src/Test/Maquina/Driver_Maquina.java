package Test.Maquina;

import Dominio.Dificultad;
import Dominio.Rol;

import java.util.Scanner;

public class Driver_Maquina {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("1 - Crear instancia\n2 - Generar Candidato\n3 - Generar solucion\n4 - Evaluar Candidato");
        int opcion = scan.nextInt();
        Stub_Tablero tablero = new Stub_Tablero();
        Stub_Normas normas = new Stub_Normas();
        Maquina maquina = new Maquina(tablero,normas,Dificultad.FACIL,Rol.CODEBREAKER);
        while (opcion != 0) {
            switch(opcion){
                case 1:
                    System.out.println("0 - Facil\n1 - Medio\n2 - Dificil");
                    int dif = scan.nextInt();
                    Dificultad dificultad = Dificultad.FACIL;
                    if (dif == 1) dificultad = Dificultad.MEDIO;
                    if (dif == 2) dificultad = Dificultad.DIFICIL;
                    System.out.println("0 - CodeMaker\n1 - CodeBreaker");
                    int r = scan.nextInt();
                    Rol rol = Rol.CODEMAKER;
                    if (r == 1) rol = Rol.CODEBREAKER;
                    maquina = new Maquina(tablero,normas,dificultad,rol);
                    break;
                case 2:
                    String candidato = maquina.generarCandidato();
                    System.out.println(candidato);
                    break;
                case 3:
                    String solucion = maquina.generarSolucion();
                    System.out.println(solucion);
                    break;
                case 4:
                    System.out.print("Candidato: ");
                    candidato = scan.next();
                    System.out.print("Solucion: ");
                    solucion = scan.next();
                    String NB = maquina.evaluarCandidato(candidato,solucion);
                    System.out.println(NB);
                default: break;
            }
            System.out.println();
            System.out.println();
            System.out.println("1 - Crear instancia\n2 - Generar Candidato\n3 - Generar solucion\n4 - Evaluar Candidato");
            opcion = scan.nextInt();
        }
    }

}
