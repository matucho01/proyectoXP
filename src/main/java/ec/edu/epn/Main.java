package ec.edu.epn;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LectorDatos lectorDatos = new LectorDatos();
        ArrayList<Turno> turnos = lectorDatos.obtenerLecturasPorTurno();
    }
}