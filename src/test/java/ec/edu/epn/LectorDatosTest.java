package ec.edu.epn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
public class LectorDatosTest {
    LectorDatos lectorDatos = new LectorDatos();
    @Test
    public void given_a_list_of_turns_when_comparing_then_ok() {
        Turno turno1 = new Turno("02-10-22", 443196.34, 286690.74,
                371706.48, 443207.39, 287192.01, 372008.05, 0);
        Turno turno2 = new Turno("02-10-22", 443207.39, 287192.01,
                372008.05, 443236.04, 287704.88, 372333.19, 1);
        Turno turno3 = new Turno("02-10-22", 443236.04, 287704.88,
                372333.19, 443260.49, 288799.46, 372845.79, 2);
        ArrayList<Turno> expected = new ArrayList<>(Arrays.asList(turno1, turno2, turno3));
        ArrayList<Turno> actual = lectorDatos.obtenerLecturasPorTurno();
        for(int i=0; i< expected.size(); i++) {
            assertEquals(expected.get(i).toString(), actual.get(i).toString());
        }
    }
    @Test
    public void given_list_prices_when_comparing_then_ok(){
        ArrayList<Double> actual = lectorDatos.obtenerPreciosActualizados();
        ArrayList<Double> expected = new ArrayList<>(Arrays.asList(4.09,2.40,1.70));
        assertArrayEquals(expected.toArray(), actual.toArray());
    }


}