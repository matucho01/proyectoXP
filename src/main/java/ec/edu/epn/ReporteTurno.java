package ec.edu.epn;

import java.util.ArrayList;
import java.util.Arrays;

public class ReporteTurno {
    private double ventasEfectivo;
    private ArrayList<Integer> billetes;
    private ArrayList<Integer> monedas;
    public void ingresoEfectivoBilletes(int cien, int cincuenta, int veinte, int diez, int cinco, int uno) {
        this.billetes = new ArrayList<Integer>(Arrays.asList(cien,cincuenta,veinte,diez,cinco,uno));
    }

    public void ingresoEfectivoMonedas(int uno, int cincuenta, int veinticinco, int diez, int cinco, int centavo) {
        this.monedas = new ArrayList<Integer>(Arrays.asList(uno,cincuenta,veinticinco,diez,cinco,centavo));
    }

    public void calcularEfectivo(){
        double efectivoBilletes = billetes.get(0)*100 + billetes.get(1)*50 + billetes.get(2)*20 + billetes.get(3)*10 +
                                  billetes.get(4)*5 + billetes.get(5)*1;
        double efectivoMonedas = monedas.get(0)*1 + monedas.get(1)*0.5 + monedas.get(2)*0.25 + monedas.get(3)*0.1 +
                                 monedas.get(4)*0.05 + monedas.get(5)*0.01;
        this.ventasEfectivo = efectivoBilletes+efectivoMonedas;
    }

    public double getVentasEfectivo() {
        return ventasEfectivo;
    }

    public ArrayList<Integer> getBilletes() {
        return billetes;
    }

    public ArrayList<Integer> getMonedas() {
        return monedas;
    }
}
