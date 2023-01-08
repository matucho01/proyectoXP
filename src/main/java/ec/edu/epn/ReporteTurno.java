package ec.edu.epn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReporteTurno {
    private double ventasEfectivo;
    private double ventasTarjeta;
    private double ventasLubricantes;
    private int lubricantesVendidos;
    private double cobrosRetiros;
    private double ventasCreditoSuper;
    private double ventasCreditoExtra;
    private double ventasCreditoDiesel;
    private ArrayList<Integer> billetes;
    private ArrayList<Integer> monedas;
    private LectorDatos lectorDatos = new LectorDatos();
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

    public void obtenerPagosTarjeta(String fecha,String tipoTurno){
        ArrayList<ArrayList<String>> ventas = lectorDatos.obtenerVentasTarjeta();
        for (int i=0;i< ventas.size();i++){
            if (ventas.get(i).get(0).equals(fecha) && ventas.get(i).get(1).equals(tipoTurno)){
                this.ventasTarjeta = Double.parseDouble(ventas.get(i).get(2)) + Double.parseDouble(ventas.get(i).get(3));
            }
        }
    }

    public void ingresarLubricantesVendidos(int numLubricantes){
        this.lubricantesVendidos = numLubricantes;
    }

    public void calcularVentasLubricantes(){
        this.ventasLubricantes = this.lubricantesVendidos*3.5;
    }

    public void obtenerPagosCredito(String fecha,String tipoTurno){
        ArrayList<ArrayList<String>> ventas = lectorDatos.obtenerVentasCredito();
        for (int i=0;i< ventas.size();i++){
            if (ventas.get(i).get(0).equals(fecha) && ventas.get(i).get(1).equals(tipoTurno)){
                this.ventasCreditoSuper = Double.parseDouble(ventas.get(i).get(2));
                this.ventasCreditoExtra = Double.parseDouble(ventas.get(i).get(3));
                this.ventasCreditoDiesel = Double.parseDouble(ventas.get(i).get(4));
            }
        }
    }

    public void registrarPagoRetiro(int respuesta) {
        Scanner sc = new Scanner(System.in);
        if(respuesta == 0) {
            System.out.println("No se realizan cobros ni retiros");
        } else {
            if(respuesta == 1) {
                System.out.println("Ingrese el total del cobro registrado: ");
                double cobro = Double.parseDouble(sc.nextLine());
                registrarCobro(cobro);
            } else {
                System.out.println("Ingrese el total del retiro registrado: ");
                double retiro = Double.parseDouble(sc.nextLine());
                registrarRetiro(retiro);
            }
        }
    }

    public void registrarCobro(double monto) {
        this.cobrosRetiros += monto;
    }

    public void registrarRetiro(double monto) {
        this.cobrosRetiros -= monto;
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

    public double getVentasTarjeta() {
        return ventasTarjeta;
    }

    public double getVentasLubricantes() {
        return ventasLubricantes;
    }

    public int getLubricantesVendidos() {
        return lubricantesVendidos;
    }

    public double getCobrosRetiros() {
        return this.cobrosRetiros;
    }

    public double getVentasCreditoSuper() {
        return ventasCreditoSuper;
    }

    public double getVentasCreditoExtra() {
        return ventasCreditoExtra;
    }

    public double getVentasCreditoDiesel() {
        return ventasCreditoDiesel;
    }
}
