//imports junit
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;
import static org.junit.Assert.*;
//imports  proyecto
import Dominio.*;
import static Dominio.Dificultad.*;
import static Dominio.Rol.*;
//imports java
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class Partida_Tablero_Test {


    @Parameter(0)
    public String candidato;
    @Parameter(1)
    public String NB;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { {"12354","N"}
        };
        return Arrays.asList(data);
    }

    public Partida p;

    @Before
    public void initialize(){
        p=new Partida(FACIL,CODEMAKER);

    }
    @Test
    public void test_varios(){
        p.setNuevoCandidato(candidato);
        p.setNuevaNB(NB);
        assertEquals("error al definir/obtener nuevo candidato",p.getUltimoCandidato(),candidato);
    }
}
