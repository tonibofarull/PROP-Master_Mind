package Test.Tablero;

import java.util.Scanner;

public class Driver_Tablero {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Tablero t = null;
        System.out.println("1 - Crear instancia\n2 - Set candidato\n3 - Set NB\n4 - Get Candidato\n5 - Opciones\n0 - Salir");
        int opcion = scan.nextInt();
        while (opcion!=0){
            int i;
            switch (opcion){
                case 1:
                    t=new Tablero();
                    System.out.println("Instancia creada");
                    break;
                case 2:
                    System.out.print("candidato: ");
                    String candidato=scan.next();
                    t.setNuevoCandidato(candidato);
                    break;
                case 3:
                    System.out.print("nb: ");
                    String nb=scan.next();
                    t.setNuevoNB(nb);
                    break;
                case 4:
                    System.out.println(t.getUltimoCandidato());
                    break;

                case 5:
                    System.out.println("1 - Crear instancia\n2 - Set candidato\n3 - Set NB\n4 - Get Candidato\n5 - Opciones\n0 - Salir");
                    break;
                default: break;
            }
            System.out.print("opcion: ");
            opcion=scan.nextInt();
        }
    }
}
