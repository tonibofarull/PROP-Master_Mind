//imports junit
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
public class Partida_Init_Test {

    //parametros para las pruebas
    @Parameter(0)
    public Dificultad dificultad;
    @Parameter(1)
    public Rol rol;
    @Parameter(2)
    public String solucion;


    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { {FACIL,CODEMAKER,"0"},
        {MEDIO,CODEBREAKER,"1"}, {DIFICIL,CODEMAKER,"1233"},
        {MEDIO,CODEMAKER,"13234"}, {FACIL,CODEBREAKER,"111111111123"}
        };
        return Arrays.asList(data);
    }

    @Test
    public void test_solucion() {
        Partida p=new Partida(dificultad,rol);
        p.setSolucion(solucion);
        assertEquals("Error al definir/obtener la solucion",p.getSolucion(),solucion);
        assertEquals("Error al definir/obtener la dificultad",p.getDificultad(),dificultad);
        assertEquals("Error al definir/obtener el rol",p.getRol(),rol);
    }

}
