package ec.edu.epn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CombustibleTest {

    @Test
    public void given_three_fuel_prices_when_inserting_data_then_ok() {
        Combustible combustible = new Combustible();
        ArrayList<Double> expected = new ArrayList<>(Arrays.asList(4.09, 2.40, 1.70));
        ArrayList<Double> actual = combustible.ingresarPreciosCombustible(4.09, 2.40, 1.70);
        assertEquals(expected, actual);
    }

}