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
        System.out.println("tamaño turnos: " + turnos.size());
        ArrayList<ReporteTurno> reportesTurno = new ArrayList<>();
        for (int i=0;i<3;i++) {
            ReporteTurno reporteTurno = new ReporteTurno("24-10-22", ""+i);
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
            if (respuesta.equals("0")) {
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
            reportesTurno.add(reporteTurno);
        }

        //Reporte diario
        ReporteDiario reporteDiario = new ReporteDiario();
        reporteDiario.cuadreTurnos("24-10-22",reportesTurno,turnos);
        reporteDiario.crearReporteDiario("24-10-22",reportesTurno,turnos);
        //Inventario
        Inventario inventario = new Inventario();
        System.out.println("---- Ingrese la medición del nivel de los tanques ----");
        System.out.println("Nivel del tanque de Super: ");
        float nivelSuper = Float.parseFloat(sc.nextLine());
        System.out.println("Nivel del tanque de Extra: ");
        float nivelExtra = Float.parseFloat(sc.nextLine());
        System.out.println("Nivel del tanque de Diesel: ");
        float nivelDiesel = Float.parseFloat(sc.nextLine());
        inventario.ingresarNivelTanques(nivelSuper,nivelExtra,nivelDiesel);
        System.out.println("¿Existieron descargas de combustible? No:0 Si:1");
        String respuesta = sc.nextLine();
        if (respuesta.equals(1)){
            System.out.println("Descarga de combustible Super: ");
            int descargaSuper = Integer.parseInt(sc.nextLine());
            System.out.println("Descarga de combustible Extra: ");
            int descargaExtra = Integer.parseInt(sc.nextLine());
            System.out.println("Descarga de combustible Diesel: ");
            int descargaDiesel = Integer.parseInt(sc.nextLine());
            inventario.registrarDescarga(descargaSuper,descargaExtra,descargaDiesel);
        }

        //Registro para el pedido
        Registro registro = new Registro();
        ArrayList<Float> totalGalonesPedido = registro.proyectarVentas("24-10-22",turnos
                ,inventario.getGalonesSuper(), inventario.getGalonesExtra(), inventario.getGalonesDiesel());

        //Generacion del Pedido
        Pedido pedido = new Pedido(totalGalonesPedido,"24-10-22");
        pedido.generarArchivo();

        //Visualizar archivos
        GestorPedido gestorPedido = new GestorPedido();
        System.out.println("---- Pedidos ----");
        gestorPedido.listarPedidos();
        System.out.println("Ingrese el nombre del archivo a visualizar: ");
        respuesta = sc.nextLine();
        gestorPedido.mostrarPedido(respuesta);

        GestorReporte gestorReporte =  new GestorReporte();
        System.out.println("---- Reportes ----");
        gestorReporte.listarReportes();
        System.out.println("Ingrese el nombre del archivo a visualizar: ");
        respuesta = sc.nextLine();
        gestorReporte.mostrarReporte(respuesta);
        System.out.println("hola");
    }
}