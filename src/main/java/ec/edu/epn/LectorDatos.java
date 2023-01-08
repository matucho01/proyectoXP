package ec.edu.epn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class LectorDatos {
    public ArrayList obtenerLecturasPorTurno() {
        ArrayList turnos = new ArrayList<Turno>();
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("documents/lecturas_02-10-2022.txt"));
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(splitBy);
                turnos.add(new Turno(datos[0], parseDouble(datos[1]), parseDouble(datos[2]), parseDouble(datos[3]),
                        parseDouble(datos[4]), parseDouble(datos[5]), parseDouble(datos[6]), parseInt(datos[7])));
            }
        } catch (IOException e) {
            System.out.println("No se encuentra el archivo de lecturas: " + e);
        }
        return turnos;
    }

    public ArrayList obtenerPreciosActualizados() {
        ArrayList precios = new ArrayList<Double>();
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("documents/precios_enero.txt"));
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(splitBy);
                for(int i=0; i<datos.length; i++) {
                    precios.add(Double.parseDouble(datos[i]));
                }
            }
        } catch (IOException e) {
            System.out.println("No se encuentra el archivo de lecturas: " + e);
        }
        return precios;
    }

    public ArrayList obtenerVentasTarjeta(){
        ArrayList<ArrayList> ventas = new ArrayList<>();
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("documents/ventas_tarjeta.txt"));
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(splitBy);
                ArrayList<String> ventaTurno =  new ArrayList();
                for(int i=0; i<datos.length; i++) {
                    ventaTurno.add(datos[i]);
                }
                ventas.add(ventaTurno);
            }
        } catch (IOException e) {
            System.out.println("No se encuentra el archivo de lecturas: " + e);
        }
        return ventas;
    }

    public ArrayList obtenerVentasCredito(){
        ArrayList<ArrayList> ventas = new ArrayList<>();
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("documents/ventas_credito.txt"));
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(splitBy);
                ArrayList<String> ventaTurno =  new ArrayList();
                for(int i=0; i<datos.length; i++) {
                    ventaTurno.add(datos[i]);
                }
                ventas.add(ventaTurno);
            }
        } catch (IOException e) {
            System.out.println("No se encuentra el archivo de lecturas: " + e);
        }
        return ventas;
    }

    public double parseDouble(String dato) {
        return Double.parseDouble(dato);
    }

    public int parseInt(String dato) {
        return Integer.parseInt(dato);
    }
}
