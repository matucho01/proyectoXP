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
        reporteTurno.ingresarLubricantesVendidos(14);
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

    @Test
    public void given_date_shift_when_get_payments_then_ok(){
        reporteTurno.obtenerPagosTarjeta("02/10/22","1");
        double expected = 340.13;
        assertEquals(expected,reporteTurno.getVentasTarjeta(),0.01);
    }

    @Test
    public void given_number_lubricants_when_insert_then_ok(){
        int expected = 14;
        assertEquals(expected,reporteTurno.getLubricantesVendidos());
    }

    @Test
    public void given_number_lubricants_when_calculate_sales_then_ok(){
        reporteTurno.calcularVentasLubricantes();
        double expected = 49;
        assertEquals(expected,reporteTurno.getVentasLubricantes(),0.01);
    }

    @Test
    public void given_money_withdrawal_when_subtraction_then_ok() {
        reporteTurno.registrarRetiro(25);
        double expected = -25.0;
        assertEquals(expected, reporteTurno.getCobrosRetiros(), 0.01);
    }
    @Test
    public void given_money_payment_when_addition_then_ok() {
        reporteTurno.registrarCobro(25);
        double expected = 25.0;
        assertEquals(expected, reporteTurno.getCobrosRetiros(), 0.01);
    }

    @Test
    public void given_date_shift_when_get_payments_credits_then_ok(){
        reporteTurno.obtenerPagosCredito("02/10/22","2");
        double expected[] = {0,39.15,71.20};
        assertEquals(expected[0],reporteTurno.getVentasCreditoSuper(),0.01);
        assertEquals(expected[1],reporteTurno.getVentasCreditoExtra(),0.01);
        assertEquals(expected[2],reporteTurno.getVentasCreditoDiesel(),0.01);
    }

}