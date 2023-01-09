package ec.edu.epn;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LectorDatos lectorDatos = new LectorDatos();
        ArrayList<Turno> turnos = lectorDatos.obtenerLecturasPorTurno();
        ReporteTurno reporteTurno = new ReporteTurno("02/10/22", "1");
        // Ingreso de billetes
        System.out.println("---- Ingrese el número de billetes de cada denominación ---- ");
        System.out.println("Billetes de cien: ");
        int cien = Integer.parseInt(sc.nextLine());
        System.out.println("Billetes de cincuenta: ");
        int cincuenta = Integer.parseInt(sc.nextLine());
        System.out.println("Billetes de veinte: ");
        int veinte = Integer.parseInt(sc.nextLine());
        System.out.println("Billetes de diez: ");
        int diez = Integer.parseInt(sc.nextLine());
        System.out.println("Billetes de cinco: ");
        int cinco = Integer.parseInt(sc.nextLine());
        System.out.println("Billetes de uno: ");
        int uno = Integer.parseInt(sc.nextLine());
        // Ingreso de monedas
        reporteTurno.ingresoEfectivoBilletes(cien, cincuenta, veinte, diez, cinco, uno);
        System.out.println("---- Ingrese el número de monedas de cada denominación ---- ");
        System.out.println("Monedas de un dólar: ");
        int mUno = Integer.parseInt(sc.nextLine());
        System.out.println("Monedas de cincuenta centavos: ");
        int mCincuenta = Integer.parseInt(sc.nextLine());
        System.out.println("Monedas de veinticinco centavos: ");
        int mVeinticinco = Integer.parseInt(sc.nextLine());
        System.out.println("Monedas de diez centavos: ");
        int mDiez = Integer.parseInt(sc.nextLine());
        System.out.println("Monedas de cinco centavos: ");
        int mCinco = Integer.parseInt(sc.nextLine());
        System.out.println("Monedas de un centavo: ");
        int mUn = Integer.parseInt(sc.nextLine());
        reporteTurno.ingresoEfectivoMonedas(mUno, mCincuenta, mVeinticinco, mDiez, mCinco, mUn);
        reporteTurno.calcularEfectivo();
        // Registro de venta de lubricantes
        System.out.println("¿Existieron ventas de lubricantes? Si: 0 No: 1");
        String respuesta = sc.nextLine();
        if(respuesta.equals("0")) {
            System.out.println("¿Cuántos lubricantes se vendieron?");
            int numLubricantes = Integer.parseInt(sc.nextLine());
            reporteTurno.ingresarLubricantesVendidos(numLubricantes);
            reporteTurno.calcularVentasLubricantes();
        }
        // Registro de cobros o retiros de dinero
        System.out.println("¿Existieron cobros o retiros de dinero? No: 0 Cobro: 1 Retiro: 2");
        int pagoRetiro = Integer.parseInt(sc.nextLine());
        reporteTurno.registrarPagoRetiro(pagoRetiro);
        // Registro de ventas con tarjeta de crédito
        reporteTurno.obtenerPagosTarjeta();
        // Registro de ventas a crédito
        reporteTurno.obtenerPagosCredito();
        reporteTurno.sumarVentasCredito();
        // Total de ventas en turno
        reporteTurno.obtenerVentasTotales();
        ReporteDiario reporteDiario = new ReporteDiario();
    }
}