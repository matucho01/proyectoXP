package ec.edu.epn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CombustibleTest {

    @Test
    public void given_three_fuel_prices_when_comparing_data_then_ok() {
        Combustible combustible = new Combustible();
        String expected = "Precios oficiales: " +
                "\nSuper: " + "4.09" +
                "\nExtra:" + "2.4" +
                "\nDiesel:" + "1.7";
        String actual = combustible.toString();
        assertEquals(expected, actual);
    }

}