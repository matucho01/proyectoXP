package ec.edu.epn;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GestorPedidoTest {

    GestorPedido gestorPedido;
    @Before
    public void setUp(){
        gestorPedido = new GestorPedido();
    }

    @Test
    public void given_a_path_when_making_a_query_then_ok() {
        boolean expected = true;
        assertEquals(expected, gestorPedido.listarPedidos());
    }

    @Test
    public void given_a_string_when_reading_file_then_ok() {
        boolean expected = true;
        String nombreArchivo = "pedido_02-10-22.txt";
        assertEquals(expected, gestorPedido.mostrarPedido(nombreArchivo));
    }
}