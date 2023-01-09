package ec.edu.epn;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class RegistroTest {
    @Test
    public void given_a_date_and_turns_when_totalizing_consumptions_then_ok() {
        Registro registro = new Registro();
        ArrayList<Turno> turnos = new ArrayList(Arrays.asList());
        registro.totalizarConsumosSemanales("", turnos);
        ArrayList<Float> expectedSuper = new ArrayList(Arrays.asList(0.5F, 0.6F, 0.2F));
        ArrayList<Float> expectedExtra = new ArrayList(Arrays.asList(0.5F, 0.6F, 0.2F));
        ArrayList<Float> expectedDiesel = new ArrayList(Arrays.asList(0.5F, 0.6F, 0.2F));

        for(int i = 0; i < expectedSuper.size(); ++i) {
            assertEquals(((Float)expectedSuper.get(i)).toString(), registro.getConsumoSuper().get(i), 0.5f);
        }

        for(int i = 0; i < expectedExtra.size(); ++i) {
            assertEquals(((Float)expectedExtra.get(i)).toString(), registro.getConsumoExtra().get(i), 0.5f);
        }

        for(int i = 0; i < expectedDiesel.size(); ++i) {
            assertEquals(((Float)expectedDiesel.get(i)).toString(), registro.getConsumoDiesel().get(i), 0.5f);
        }
    }

    @Test
    public void given_a_date_and_turns_and_inventory_when_projecting_sales_then_ok(){
        Registro registro = new Registro();
        ArrayList<Turno> turnos = new ArrayList(Arrays.asList());
        ArrayList actual = registro.proyectarVentas("", turnos, 0.5f, 0.5f, 0.5f);
        ArrayList expected = new ArrayList(Arrays.asList(0.5f, 0.5f, 0.5f));
        for(int i = 0; i < expected.size(); ++i) {
            assertEquals(expected.get(i).toString(), registro.getConsumoDiesel().get(i), 0.5f);
        }
    }

    @Test
    public void given_3_lists_of_fuel_consumption_when_comparing_then_ok(){
        Registro registro = new Registro();
        ArrayList<Turno> turnos = new ArrayList(Arrays.asList());
        registro.totalizarConsumosSemanales("", turnos);
        ArrayList<Float> expected = new ArrayList(Arrays.asList(0.5F, 0.6F, 0.2F));
        for(int i = 0; i < expected.size(); ++i) {
            assertEquals(expected.get(i), registro.obtenerMayor().get(i), 0.5f);
        }
    }
}