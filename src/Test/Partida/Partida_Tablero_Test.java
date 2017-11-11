package Test.Partida;

//imports junit
import org.junit.Test;
import static org.junit.Assert.*;



public class Partida_Tablero_Test {

    @Test
    public void test_varios(){
        Partida p=new Partida();
        p.setNuevaNB("22");
        p.setNuevoCandidato("1432");
        assertEquals("error al obtener  candidato",p.getUltimoCandidato(),"1122");
        assertEquals("error al obtener NB",p.getUltimaNB(),"40");
    }
}
