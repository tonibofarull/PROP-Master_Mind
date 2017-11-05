import Dominio.CtrlDominio;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        CtrlDominio dom = new CtrlDominio();
        System.out.println("Escoge opcion: ");
        Scanner scan = new Scanner(System.in);
        int op = scan.nextInt();
        while (op != 0) {
            if (op == 1) { // empezar partida
                System.out.print("dificultad: ");
                int diff = scan.nextInt();
                System.out.print("rol: ");
                String rol = scan.next();
                String dif;
                if (diff == 0) dif = new String("FACIL");
                else if (diff == 0) dif = new String("MEDIO");
                else  dif = new String("DIFICIL");
                if (!dom.empezarPartida(dif,rol)) System.out.println("errorrrr");
            }
            else if (op == 2) {
                System.out.print("solucion: ");
                String sec = scan.next();
                System.out.println(dom.generarSolucion(sec));
            }
            else if (op == 3) {
                System.out.print("NB: ");
                String eva = scan.next();
                System.out.println(dom.evaluarCandidato(eva));
            }
            else if (op == 4) {
                System.out.print("candidato: ");
                String can = scan.next();
                System.out.println(dom.generarCandidato(can));
            }
            System.out.println("Escoge opcion: ");
            op = scan.nextInt();
        }
    }
}
