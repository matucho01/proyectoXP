package ec.edu.epn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TurnoTest {
    @Test
    public void given_gallons_when_subtraction_then_ok() {
        Turno turno = new Turno("02/10/2022",541378.43,787678.23,
                354801.41,541459.32,787723.98,354922.12,1);
        ArrayList<Double> expected = new ArrayList<Double>(Arrays.asList(80.89, 45.75, 120.71));
        ArrayList<Double> actual = turno.calcularVentasEnGalonesPorProducto();
        for(int i=0; i<expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i), 0.01);
        }
    }

    @Test
    public void given_total_gallons_when_conversion_then_ok() {
        Turno turno = new Turno("02/10/2022",541378.43,787678.23,
                354801.41,541459.32,787723.98,354922.12,1);
        ArrayList<Double> expected = new ArrayList<>(Arrays.asList(330.84, 109.8, 205.21));
        ArrayList<Double> actual = turno.calcularVentasEnDolares();
        for(int i=0; i<expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i), 0.05);
        }
    }

}