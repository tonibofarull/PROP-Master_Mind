package Dominio;

import java.util.ArrayList;

public class Test_ranking {
    public static void main(String[] args) {
        Ranking r=new Ranking();
        r.anadirPuntiacion("aaa","10");
        r.anadirPuntiacion("che","13");
        r.anadirPuntiacion("toni","25");
        r.anadirPuntiacion("ferran","15");
        r.anadirPuntiacion("racso","7");

        r.anadirPuntiacion("jutge","5");
        r.anadirPuntiacion("keeny","10");
        r.anadirPuntiacion("gente de SI","50");
        r.anadirPuntiacion("Rito","8");
        r.anadirPuntiacion("ChechiOP","2");

        r.anadirPuntiacion("Cartman","30");
        r.anadirPuntiacion("green unit","99");
        r.anadirPuntiacion("lucker","1");
        for (ArrayList<String> as: r.consultaRanking()){
            System.out.println(as.get(0)+" "+as.get(1));
        }
    }
    public static Ranking init_ranking(){
        Ranking r=new Ranking();
        r.anadirPuntiacion("aaa","10");
        r.anadirPuntiacion("che","13");
        r.anadirPuntiacion("toni","25");
        r.anadirPuntiacion("ferran","15");
        r.anadirPuntiacion("racso","7");

        r.anadirPuntiacion("jutge","5");
        r.anadirPuntiacion("keeny","10");
        r.anadirPuntiacion("gente de SI","50");
        r.anadirPuntiacion("Rito","8");
        r.anadirPuntiacion("ChechiOP","2");

        r.anadirPuntiacion("Cartman","30");
        r.anadirPuntiacion("green unit","99");
        r.anadirPuntiacion("lucker","1");
        return  r;
    }
}
