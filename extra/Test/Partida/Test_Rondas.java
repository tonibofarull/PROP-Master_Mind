package Test.Partida;

//imports junit
import org.junit.Test;
import static org.junit.Assert.*;
//imports  proyecto
import Dominio.*;
import static Dominio.Dificultad.*;
import static Dominio.Rol.*;


public class Test_Rondas {
    @Test
    public void test_rondas(){
        Partida p=new Partida(FACIL,CODEMAKER);

        for (int i=0;i<10;i++) {
            assertEquals("Error en el numero de rondas",i,p.getRonda());
            p.setNuevoCandidato("123");
            p.setNuevaNB("BN");
        }
    }
}
