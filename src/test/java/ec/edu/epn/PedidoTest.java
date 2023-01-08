package ec.edu.epn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PedidoTest {

    @Test
    public void given_a_when_file_creation_then_ok() {
        ArrayList<Integer> totalGalonesPedido = new ArrayList<>(Arrays.asList(0, 4000, 6000));
        String fecha = "02-10-22";
        Pedido pedido = new Pedido(totalGalonesPedido, fecha);
        boolean expected = true;
        assertEquals(expected, pedido.generarArchivo());
    }
}