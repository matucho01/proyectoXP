package ec.edu.epn;

import org.junit.Test;

import static org.junit.Assert.*;

public class InventarioTest {
    @Test
    public void given_fuel_levels_when_inserting_levels_then_ok(){
        Inventario inventario = new Inventario();
        inventario.ingresarNivelTanques(0.265f, 0.78f, 0.56f);
        assertEquals(571.6f, inventario.getGalonesSuper(), 0.1);
        assertEquals(2733.6f, inventario.getGalonesExtra(), 0.1);
        assertEquals(1422.9f, inventario.getGalonesDiesel(), 0.1);
    }
    @Test
    public void given_fuel_dumping_when_inserting_data_then_ok(){
        Inventario inventario = new Inventario();
        inventario.registrarDescarga(0, 6000, 3000);
        assertEquals(0.0f, inventario.getGalonesSuper(), 0.1);
        assertEquals(6000.0f, inventario.getGalonesExtra(), 0.1);
        assertEquals(3000.0f, inventario.getGalonesDiesel(),0.1);
    }
}