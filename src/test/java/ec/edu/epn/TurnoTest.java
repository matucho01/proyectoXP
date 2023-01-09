package ec.edu.epn;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TurnoTest {
    Turno turno;
    @Before
    public void setUp(){
        turno = new Turno("02/10/22",541378.43,787678.23,
                354801.41,541459.32,787723.98,354922.12,1);
    }
    @Test
    public void given_gallons_when_subtraction_then_ok() {
        ArrayList<Double> expected = new ArrayList<Double>(Arrays.asList(80.89, 45.75, 120.71));
        ArrayList<Double> actual = turno.calcularVentasEnGalonesPorProducto();
        for(int i=0; i<expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i), 0.01);
        }
    }

    @Test
    public void given_total_gallons_when_conversion_then_ok() {
        ArrayList<Double> expected = new ArrayList<>(Arrays.asList(330.84, 109.8, 205.21));
        ArrayList<Double> actual = turno.calcularVentasEnDolares();
        for(int i=0; i<expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i), 0.05);
        }
    }

    @Test
    public void given_data_of_shift_when_calculate_sales_then_ok(){
        double expected = 645.84;
        assertEquals(expected,turno.obtenerVentasTotales(),0.01);
    }

}