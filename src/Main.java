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
                int dif = scan.nextInt();
                String rol = scan.next();
                if (!dom.empezarPartida(dif,rol)) System.out.println("errorrrr");
            }
            else if (op == 2) {
                String sec = scan.next();
                System.out.println(dom.generarSolucion(sec));
            }
            else if (op == 3) {
                String eva = scan.next();
                System.out.println(dom.evaluarCandidato(eva));
            }
            else if (op == 4) {
                String can = scan.next();
                System.out.println(dom.generarCandidato(can));
            }
            System.out.println("Escoge opcion: ");
            op = scan.nextInt();
        }
    }
}
