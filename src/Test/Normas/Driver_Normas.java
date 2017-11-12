package Test.Normas;

import Dominio.Dificultad;

import java.util.Scanner;

public class Driver_Normas {
    private static void mostrarMenu() {
        System.out.println("0 - crear instancia Normas");
        System.out.println("1 - checkCodigo");
        System.out.println("2 - calcularNB");
        System.out.println("3 - comprobarLinea");
        System.out.println("4 - comprobarNB");
        System.out.println("5 - visualizar Menu");
        System.out.println("6 - salir");
    }

    public static void main(String[] args) {
        mostrarMenu();
        System.out.println();
        Scanner scan = new Scanner(System.in);
        System.out.print("opcion: ");
        int opcion = scan.nextInt();
        scan.nextLine();
        Normas normas = new Normas();
        Dificultad dif;
        while (opcion != 6) {
            switch(opcion){
                case 0:
                    normas = new Normas();
                    System.out.println("Instancia de normas creada correctamente");
                    break;
                case 1:
                    try {
                        System.out.println("Introduzca código a comprobar (Conjunto de enteros de la forma " + '"' + "1423413" + '"' + "):");
                        String codigo = scan.nextLine();
                        System.out.println();
                        System.out.println("Introduzca valor mínimo del rango de valores aceptados:");
                        int val_minimo = scan.nextInt();
                        scan.nextLine();
                        System.out.println();
                        System.out.println("Introduzca valor máximo del rango de valores aceptados:");
                        int val_maximo = scan.nextInt();
                        scan.nextLine();
                        System.out.println();
                        System.out.println("Introduzca el tamaño del código a comprobar:");
                        int size_codigo = scan.nextInt();
                        scan.nextLine();
                        System.out.println();
                        System.out.println("Introduzca el número máximo de repeticiones aceptado:");
                        int max_rep = scan.nextInt();
                        scan.nextLine();
                        System.out.println();
                        normas.checkCodigo(codigo, val_minimo, val_maximo, size_codigo, max_rep);
                        System.out.println("Código correcto.");
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Introduzca el candidato a comprobar:");
                        String candidato = scan.nextLine();
                        System.out.println();
                        System.out.println("Introduzca la solución sobre la que comparar:");
                        String solucion = scan.nextLine();
                        System.out.println();
                        String nb = normas.calcularNB(candidato, solucion);
                        System.out.println("Valor de NB: " + nb);
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Introduzca el codigo a comprobar:");
                        String codigo = scan.nextLine();
                        System.out.println();
                        System.out.println("Introduzca la dificultad:");
                        System.out.println("0 - FACIL");
                        System.out.println("1 - MEDIO");
                        System.out.println("2 - DIFICIL");
                        int dificultad = scan.nextInt();
                        scan.nextLine();
                        System.out.println();
                        if (dificultad == 0) dif = Dificultad.FACIL;
                        else if (dificultad == 1) dif = Dificultad.MEDIO;
                        else dif = Dificultad.DIFICIL;
                        normas.comprobarLinea(codigo, dif);
                        System.out.println("Código correcto");
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Introduzca el candidato a comprobar:");
                        String codigo = scan.nextLine();
                        System.out.println();
                        System.out.println("Introduzca la solucion sobre la que comparar:");
                        String solucion = scan.nextLine();
                        System.out.println();
                        System.out.println("Introduzca el código NB correspondiente:");
                        String nb = scan.nextLine();
                        System.out.println();
                        normas.comprobarNB(codigo, solucion, nb);
                        System.out.println("Código correcto");
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
            scan.nextLine();
        }
    }
}
