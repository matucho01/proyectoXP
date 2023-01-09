package ec.edu.epn;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GestorReporteTest {
    GestorReporte gestorReporte;
    @Before
    public void setUp(){
        gestorReporte = new GestorReporte();
    }
    @Test
    public void given_a_path_when_making_a_query_then_ok() {
        boolean expected = true;
        assertEquals(expected, gestorReporte.listarReportes());
    }

    @Test
    public void given_a_string_when_reading_file_then_ok() {
        boolean expected = true;
        String nombreArchivo = "prueba.txt";
        assertEquals(expected, gestorReporte.mostrarReporte(nombreArchivo));
    }

}