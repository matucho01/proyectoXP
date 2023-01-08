package ec.edu.epn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ReporteTurnoTest {

    ReporteTurno reporteTurno = new ReporteTurno();
    @Test
    public void given_six_integers_when_inserting_number_bills_then_ok(){
        reporteTurno.ingresoEfectivoBilletes(1,1,8,12,21,26);
        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1,1,8,12,21,26));
        assertArrayEquals(expected.toArray(),reporteTurno.getBilletes().toArray());
    }

    @Test
    public void given_six_integers_when_inserting_number_coins_then_ok(){
        reporteTurno.ingresoEfectivoMonedas(105,50,120,150,73,89);
        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(105,50,120,150,73,89));
        assertArrayEquals(expected.toArray(),reporteTurno.getMonedas().toArray());
    }

    @Test
    public void given_when_then_ok(){
        reporteTurno.ingresoEfectivoBilletes(1,1,8,12,21,26);
        reporteTurno.ingresoEfectivoMonedas(105,50,120,150,73,89);
        reporteTurno.calcularEfectivo();
        double expected = 12;
        assertEquals(expected,reporteTurno.getVentasEfectivo());
    }
}