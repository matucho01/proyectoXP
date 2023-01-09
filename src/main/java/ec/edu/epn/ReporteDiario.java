package ec.edu.epn;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ReporteDiario {

    public String cuadreTurnos(String fecha, ArrayList<ReporteTurno> reportesTurno, ArrayList<Turno> turnos){
        int posTurno = posFecha(fecha, turnos);
        int posReporteTurno = posFecha1(fecha, reportesTurno);
        String cuadre = "";

        for(int i=0; i<3; i++){
            double diferencia = turnos.get(posTurno+i).obtenerVentasTotales() - reportesTurno.get(posReporteTurno+i).obtenerVentasTotales();
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

    private int posFecha1(String fecha, ArrayList<ReporteTurno> reportesTurno) {
        int pos = 0;
        Iterator var4 = reportesTurno.iterator();
        ReporteTurno reporteTurno;
        do {
            if (!var4.hasNext()) {
                return pos;
            }

            reporteTurno = (ReporteTurno)var4.next();
        } while(!reporteTurno.getFecha().equals(fecha));

        pos = reportesTurno.indexOf(reporteTurno);
        return pos;
    }

    public void crearReporteDiario(String fecha, ArrayList<ReporteTurno> reportesTurno, ArrayList<Turno> turnos) {
        int posReporteTurno = posFecha1(fecha, reportesTurno);
        String reporte = "";
        reporte = "Reporte diario: " + fecha +
                "\nDetalle del turno de la mañana:" +
                "\nEfectivo: $" + reportesTurno.get(posReporteTurno).getVentasEfectivo() +
                "\nTarjeta: $" + reportesTurno.get(posReporteTurno).getVentasTarjeta()+
                "\nCrédito: $" + reportesTurno.get(posReporteTurno).getVentasCreditos() +
                "\nVenta lubricantes: $" + reportesTurno.get(posReporteTurno).getVentasLubricantes() +
                "\nVentas totales: $" + (reportesTurno.get(posReporteTurno).obtenerVentasTotales() + reportesTurno.get(posReporteTurno).getVentasLubricantes());
        reporte += "Reporte diario: " + fecha +
                "\nDetalle del turno de la tarde:" +
                "\nEfectivo: $" + reportesTurno.get(posReporteTurno+1).getVentasEfectivo() +
                "\nTarjeta: $" + reportesTurno.get(posReporteTurno+1).getVentasTarjeta()+
                "\nCrédito: $" + reportesTurno.get(posReporteTurno+1).getVentasCreditos() +
                "\nVenta lubricantes: $" + reportesTurno.get(posReporteTurno+1).getVentasLubricantes() +
                "\nVentas totales: $" + (reportesTurno.get(posReporteTurno+1).obtenerVentasTotales() + reportesTurno.get(posReporteTurno).getVentasLubricantes());
        reporte += "Reporte diario: " + fecha +
                "\nDetalle del turno de la noche:" +
                "\nEfectivo: $" + reportesTurno.get(posReporteTurno+1).getVentasEfectivo() +
                "\nTarjeta: $" + reportesTurno.get(posReporteTurno+1).getVentasTarjeta()+
                "\nCrédito: $" + reportesTurno.get(posReporteTurno+1).getVentasCreditos() +
                "\nVenta lubricantes: $" + reportesTurno.get(posReporteTurno+1).getVentasLubricantes() +
                "\nVentas totales: $" + (reportesTurno.get(posReporteTurno+1).obtenerVentasTotales() + reportesTurno.get(posReporteTurno).getVentasLubricantes()) +
                "\nObservaciones: " + cuadreTurnos(fecha, reportesTurno, turnos);
        generarArchivoReporteDiario(fecha, reporte);
    }
    public boolean generarArchivoReporteDiario(String fecha, String reporteDiario) {
        try {
            String nombreArchivo = "reporte_diario_"+ fecha +".txt";
            File archivo = new File("./reportes", nombreArchivo);
            if(archivo.createNewFile()) {
                System.out.println("Archivo creado exitosamente");
                FileWriter fw = new FileWriter(nombreArchivo);
                fw.write(reporteDiario);
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
