package Dominio;

import java.util.ArrayList;

public class Linea {
    private String code;
    private String eval;
    int nb,nw;
    public Linea(String code){
        this.code=code;
    }
    public void setEvaluacion(String eval){
        this.eval=eval;
    }
    public String getCode(){
        return code;
    }
    public String getEvaluacion(){
        return eval;
    }
    //ya veré si lo hago así
    public void setEvaluacion(Linea sol){
        ArrayList<Boolean> found=new ArrayList<>();
        for (int i=0;i<code.length();i++)found.add(false);

        for (int i=0;i<code.length();i++){//busco cada elemento del codigo en la solucion
            for (int j=0;j<sol.code.length();j++){
                if (!found.get(j)){//si aun no he encontrado ese elemento, para codigos con elementos repetidos
                    if (code.charAt(i)==sol.code.charAt(j)){//si son del mismo 'color'
                        found.set(j,true);
                        if(i==j)nb++;//si estan en la misma posicion añado negra
                        else nw++; //sino blanca
                    }
                }
            }
        }
    }

}
