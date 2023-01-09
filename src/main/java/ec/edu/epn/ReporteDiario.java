package ec.edu.epn;

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
                cuadre = "En el turno del "+ fecha + " en la " + obtenerTipoTurno(i) + " sobran: $" + Math.abs(diferencia);
            }else if(diferencia > 0){
                cuadre = "En el turno del "+ fecha + " en la " + obtenerTipoTurno(i) +  " faltan: $" + Math.abs(diferencia);
            }else{
                cuadre = "En el turno del "+ fecha  + " en la " + obtenerTipoTurno(i) + " no falta dinero.";
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
}
