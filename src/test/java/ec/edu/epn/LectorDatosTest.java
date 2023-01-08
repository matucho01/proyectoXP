package ec.edu.epn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
public class LectorDatosTest {

    @Test
    public void given_a_list_of_turns_when_comparing_then_ok() {
        LectorDatos l = new LectorDatos();
        Turno turno1 = new Turno("02/10/2022", 541245.23, 789543.55,
                354765.65, 541378.43, 787678.23, 354801.41, 0);
        Turno turno2 = new Turno("02/10/2022", 541378.43, 787678.23,
                354801.41, 541478.43, 787778.23, 354901.41, 1);
        Turno turno3 = new Turno("02/10/2022", 541478.43, 787778.23,
                354901.41, 541578.43, 787878.23, 355001.41, 2);
        ArrayList<Turno> expected = new ArrayList<>(Arrays.asList(turno1, turno2, turno3));
        ArrayList<Turno> actual = l.obtenerLecturasPorTurno();
        for(int i=0; i< expected.size(); i++) {
            assertEquals(expected.get(i).toString(), actual.get(i).toString());
        }
    }
}