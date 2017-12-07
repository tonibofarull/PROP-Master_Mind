package Persistencia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import Dominio.Test_ranking;

public class Test_persistencia {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int op=scan.nextInt();
        CtrlPersistencia CPer=new CtrlPersistencia();
        ArrayList<String> partida= new ArrayList<>();

        if (op==1){
            Collections.addAll(partida,"CODEMAKER","DIFICIL","1345","1146","03","3452","30");
            CPer.guardarPartida(partida);
        }
        else if (op==2){
            partida= CPer.cargarPartida();
            for (String s:partida){
                System.out.print(s+" ");
            }
            System.out.println("no ha petado. Partida length: "+partida.size() );
        }
        else if (op==3){
            CPer.guardarRanking(Test_ranking.init_ranking().consultaRanking());
            System.out.println("ranking guardado ");
        }
        else{
            ArrayList<ArrayList<String>> s=CPer.cargarRanking();
            for (ArrayList<String> as: s){
                System.out.println(as.get(0)+" "+as.get(1));
            }
            System.out.println("no ha petado. Ranking length: "+s.size());
        }

    }
}
