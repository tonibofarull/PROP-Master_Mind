package Test.Linea;
import Dominio.Linea;

import java.util.Scanner;

public class Driver_Linea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Linea l = null;
        System.out.println("1 - Crear instancia\n2 - Generar NB\n3 - Get Candidato\n4 - Get NB\n5 - Opciones\n0 - Salir");
        int opcion = scan.nextInt();
        while (opcion!=0){
            switch (opcion){
                case 1:
                    System.out.println("Escribe el candidato");
                    String candidato=scan.next();
                    l=new Linea(candidato);
                    break;
                case 2:
                    String nb=scan.next();
                    l.setNB(nb);
                    break;
                case 3:
                    System.out.println(l.getCandidato());
                    break;
                case 4:
                    System.out.println(l.getNB());
                    break;

                case 5:
                    System.out.println("1 - Crear instancia\n2 - Generar NB\n3 - Get Candidato\n4 - Get NB\n5 - Opciones\n0 - Salir");
                    break;
                default: break;
            }
            opcion=scan.nextInt();
        }
    }
}
