package ec.edu.epn;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PedidoTest {
    Pedido pedido;
    String fecha;
    @Before
    public void setUp(){
        ArrayList<Float> totalGalonesPedido = new ArrayList<>(Arrays.asList(0F, 4000F, 6000F));
        fecha = "02-10-22";
        pedido = new Pedido(totalGalonesPedido, fecha);
    }

    @Test
    public void given_fuel_gallons_when_file_creation_then_ok() {
        boolean expected = true;
        assertEquals(expected, pedido.generarArchivo());
    }

    @Test
    public void given_date_and_fuel_gallons_when_then_ok(){
        String actual = pedido.crearPedido();
        String expected = "El pedido es:" +
                "\nFecha: " + "02-10-22" +
                "\nSuper: " + 0 + "00" +
                "\nExtra: " + 4000 + "00" +
                "\nDiesel: " + 6000 + "00" +
                "\nRevisado por: Gerente";
        assertEquals(expected, actual);
    }
}