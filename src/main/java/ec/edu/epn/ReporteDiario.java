package ec.edu.epn;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ReporteDiario {

    public String cuadreTurnos(String fecha, ArrayList<ReporteTurno> reporteTurno, ArrayList<Turno> turnos){
        int posReporte = posFecha(fecha, turnos);
        String cuadre = "";

        for(int i=0; i<3; i++){
            double diferencia = turnos.get(posReporte).obtenerVentasTotales() - reporteTurno.get(posReporte).obtenerVentasTotales();
            if(diferencia < 0){
                cuadre = "\nEn el turno del "+ fecha + " en la " + obtenerTipoTurno(i) + " sobran: $" + Math.abs(diferencia);
            }else if(diferencia > 0){
                cuadre = "\nEn el turno del "+ fecha + " en la " + obtenerTipoTurno(i) +  " faltan: $" + Math.abs(diferencia);
            }else{
                cuadre = "\nEn el turno del "+ fecha  + " en la " + obtenerTipoTurno(i) + " no falta dinero.";
            }
        }
        return cuadre;
    }

    private String obtenerTipoTurno(int tipo){
        if(tipo == 0){
            return "mañana";
        }else if(tipo == 1){
            return "tarde";
        }else{
            return "noche";
        }
    }

    private int posFecha(String fecha, ArrayList<Turno> turnos) {
        int pos = 0;
        Iterator var4 = turnos.iterator();
        Turno turno;
        do {
            if (!var4.hasNext()) {
                return pos;
            }

            turno = (Turno)var4.next();
        } while(!turno.getFecha().equals(fecha));

        pos = turnos.indexOf(turno);
        return pos;
    }

    public void crearReporteDiario(String fecha, ArrayList<ReporteTurno> reporteTurno, ArrayList<Turno> turnos) {
        int posReporte = posFecha(fecha, turnos);
        String reporte = "";
        reporte = "Reporte diario: " + fecha +
                "\nDetalle del turno de la mañana:" +
                "\nEfectivo: $" + reporteTurno.get(posReporte).getVentasEfectivo() +
                "\nTarjeta: $" + reporteTurno.get(posReporte).getVentasTarjeta()+
                "\nCrédito: $" + reporteTurno.get(posReporte).getVentasCreditos() +
                "\nVenta lubricantes: $" + reporteTurno.get(posReporte).getVentasLubricantes() +
                "\nVentas totales: $" + (reporteTurno.get(posReporte).obtenerVentasTotales() + reporteTurno.get(posReporte).getVentasLubricantes()) +
                "\nObservaciones: " + cuadreTurnos(fecha, reporteTurno, turnos);
        generarArchivoReporteDiario(fecha, reporte);
    }
    public boolean generarArchivoReporteDiario(String fecha, String reporteDiario) {
        try {
            String nombreArchivo = "reporte_diario_"+ fecha +".txt";
            File archivo = new File("./reportes/", nombreArchivo);
            if(archivo.createNewFile()) {
                System.out.println("Archivo creado exitosamente");
                FileWriter fw = new FileWriter(nombreArchivo);
                String pedido = reporteDiario;
                fw.write(pedido);
                fw.close();
                return true;
            }
        } catch (IOException e) {
            System.out.println("No se puede crear el archivo con el pedido, error: ");
            e.printStackTrace();
        }
        return false;
    }
}
