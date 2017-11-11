package Test.Tablero;

import java.util.Scanner;

public class Driver_Tablero {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Tablero t = null;
        System.out.println("1 - Crear instancia\n2 - Set candidato\n3 - Set NB\n4 - Get Candidato\n5 - Get NB\n6 - Get n.Lineas\n7 - Get i-esimo candidato\n8 - Get i-esimo NB\n9 - Opciones\n0 - Salir");
        int opcion = scan.nextInt();
        while (opcion!=0){
            int i;
            switch (opcion){
                case 1:
                    t=new Tablero();
                    break;
                case 2:
                    String candidato=scan.next();
                    t.setNuevoCandidato(candidato);
                    break;
                case 3:
                    String nb=scan.next();
                    t.setNuevoNB(nb);
                    break;
                case 4:
                    System.out.println(t.getUltimoCandidato());
                    break;
                case 5:
                    System.out.println(t.getUltimoNB());
                    break;
                case 6:
                    System.out.println(t.getNumLineas());
                    break;
                case 7:
                    i=scan.nextInt();
                    System.out.println(t.getCandidato(i));
                    break;
                case 8:
                    i=scan.nextInt();
                    System.out.println(t.getNB(i));
                    break;
                case 9:
                    System.out.println("1 - Crear instancia\n2 - Set candidato\n3 - Set NB\n4 - Get Candidato\n5 - Get NB\n6 - Get n.Lineas\n7 - Get i-esimo candidato\n8 - Get i-esimo NB\n9 - Opciones\n0 - Salir");
                    break;
                default: break;
            }
            opcion=scan.nextInt();
        }
    }
}
