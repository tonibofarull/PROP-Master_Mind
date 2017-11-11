package Test.Partida;

//imports junit
import org.junit.Test;
import static org.junit.Assert.*;
//imports  proyecto
import Dominio.*;

import java.lang.reflect.Field;

import static Dominio.Dificultad.*;
import static Dominio.Rol.*;


public class Test_Rondas {
    @Test
    public void test_rondas() throws NoSuchFieldException, IllegalAccessException {
        final Partida p=new Partida(MEDIO,CODEBREAKER);
        int r=8;

        assertEquals("Error inicializar ronda",0,p.getRonda());

        final Field field= p.getClass().getDeclaredField("ronda");
        field.setAccessible(true);
        field.set(p,r);

        assertEquals("Error inicializar ronda",r,p.getRonda());
    }
}
