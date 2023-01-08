package ec.edu.epn;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ReporteTurnoTest {
    ReporteTurno reporteTurno;
    @Before
    public void setUp(){
        reporteTurno = new ReporteTurno();
        reporteTurno.ingresoEfectivoBilletes(1,1,8,12,21,26);
        reporteTurno.ingresoEfectivoMonedas(105,50,120,150,73,89);
    }
    @Test
    public void given_six_integers_when_inserting_number_bills_then_ok(){

        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1,1,8,12,21,26));
        assertArrayEquals(expected.toArray(),reporteTurno.getBilletes().toArray());
    }

    @Test
    public void given_six_integers_when_inserting_number_coins_then_ok(){

        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(105,50,120,150,73,89));
        assertArrayEquals(expected.toArray(),reporteTurno.getMonedas().toArray());
    }

    @Test
    public void given_numbers_bills_coins_when_calculate_cash_then_ok(){
        reporteTurno.calcularEfectivo();
        double expected = 740.54;
        assertEquals(expected,reporteTurno.getVentasEfectivo(),0.01);
    }

}