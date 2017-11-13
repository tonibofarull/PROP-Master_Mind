package Test.Partida;
import Dominio.Partida;

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
import java.lang.reflect.Field;
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
        Object[][] data = new Object[][] { {FACIL,CODEMAKER,"1462"},
        {MEDIO,CODEBREAKER,"1111"}, {DIFICIL,CODEMAKER,"1674"},
        {MEDIO,CODEMAKER,"6666"}, {FACIL,CODEBREAKER,"5123"}
        };
        return Arrays.asList(data);
    }

    @Test
    public void test_setters() throws NoSuchFieldException, IllegalAccessException {
        final Partida p=new Partida(dificultad,rol);
        p.setSolucion(solucion);

        //probamos la inicializacion de dificultad
        Field field=p.getClass().getDeclaredField("dificultad");
        field.setAccessible(true);
        assertEquals("Error inicializar dificultad",field.get(p),dificultad);

        //probamos la inicializacion de rol
        field=p.getClass().getDeclaredField("rol");
        field.setAccessible(true);
        assertEquals("Error inicializar rol",field.get(p),rol);

        //probamos el setter de solucion
        p.setSolucion(solucion);
        field=p.getClass().getDeclaredField("solucion");
        field.setAccessible(true);
        assertEquals("Error inicializar dificultad",field.get(p),solucion);
    }

    @Test
    public final void test_getters() throws NoSuchFieldException, IllegalAccessException {
        final Partida p =new Partida(dificultad,rol);
        //probamos el getter de dificultad
        Field field=p.getClass().getDeclaredField("dificultad");
        field.setAccessible(true);
        field.set(p,dificultad);
        assertEquals("Error getter dificultad",p.getDificultad(),dificultad);

        //probamos getter de rol
        field=p.getClass().getDeclaredField("rol");
        field.setAccessible(true);
        field.set(p,rol);
        assertEquals("Error getter rol",p.getRol(),rol);

        //probamos getter de solucion
        field=p.getClass().getDeclaredField("solucion");
        field.setAccessible(true);
        field.set(p,solucion);
        assertEquals("Error getter solucion",p.getSolucion(),solucion);
    }


}
