package ec.edu.epn;

import java.util.ArrayList;
import java.util.Arrays;

public class Turno {
    private String fecha;
    private double lecturaInicialSuper, lecturaInicialExtra, lecturaInicialDiesel;

    private double lecturaFinalSuper, lecturaFinalExtra, lecturaFinalDiesel;

    private int tipoTurno; // 0, 1, 2 -> mañana, tarde, noche

    public Turno(String fecha, double lecturaInicialSuper, double lecturaInicialExtra, double lecturaInicialDiesel, double lecturaFinalSuper, double lecturaFinalExtra, double lecturaFinalDiesel, int tipoTurno) {
        this.fecha = fecha;
        this.lecturaInicialSuper = lecturaInicialSuper;
        this.lecturaInicialExtra = lecturaInicialExtra;
        this.lecturaInicialDiesel = lecturaInicialDiesel;
        this.lecturaFinalSuper = lecturaFinalSuper;
        this.lecturaFinalExtra = lecturaFinalExtra;
        this.lecturaFinalDiesel = lecturaFinalDiesel;
        this.tipoTurno = tipoTurno;
    }
    public ArrayList<Double> calcularVentasEnGalonesPorProducto() {
        return new ArrayList<>(Arrays.asList((lecturaFinalSuper-lecturaInicialSuper), (lecturaFinalExtra-lecturaInicialExtra),
                (lecturaFinalDiesel-lecturaInicialDiesel)));
    }

    public ArrayList<Double> calcularVentasEnDolares() {
        Combustible combustible = new Combustible();
        ArrayList<java.lang.Double> ventasGalones = calcularVentasEnGalonesPorProducto();
        ArrayList<java.lang.Double> precios = new ArrayList<>(Arrays.asList(combustible.getPrecioSuper(), combustible.getPrecioExtra(), combustible.getPrecioDiesel()));
        ArrayList<java.lang.Double> total = new ArrayList<>();
        for(int i=0; i<precios.size(); i++) {
            total.add(ventasGalones.get(i)*precios.get(i));
        }
        return total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getLecturaInicialSuper() {
        return lecturaInicialSuper;
    }

    public void setLecturaInicialSuper(double lecturaInicialSuper) {
        this.lecturaInicialSuper = lecturaInicialSuper;
    }

    public double getLecturaInicialExtra() {
        return lecturaInicialExtra;
    }

    public void setLecturaInicialExtra(double lecturaInicialExtra) {
        this.lecturaInicialExtra = lecturaInicialExtra;
    }

    public double getLecturaInicialDiesel() {
        return lecturaInicialDiesel;
    }

    public void setLecturaInicialDiesel(double lecturaInicialDiesel) {
        this.lecturaInicialDiesel = lecturaInicialDiesel;
    }

    public double getLecturaFinalSuper() {
        return lecturaFinalSuper;
    }

    public void setLecturaFinalSuper(double lecturaFinalSuper) {
        this.lecturaFinalSuper = lecturaFinalSuper;
    }

    public double getLecturaFinalExtra() {
        return lecturaFinalExtra;
    }

    public void setLecturaFinalExtra(double lecturaFinalExtra) {
        this.lecturaFinalExtra = lecturaFinalExtra;
    }

    public double getLecturaFinalDiesel() {
        return lecturaFinalDiesel;
    }

    public void setLecturaFinalDiesel(double lecturaFinalDiesel) {
        this.lecturaFinalDiesel = lecturaFinalDiesel;
    }

    public int getTipoTurno() {
        return tipoTurno;
    }

    public void setTipoTurno(int tipoTurno) {
        this.tipoTurno = tipoTurno;
    }

    public double calcularConsumo(double lecInicial, double lecFinal) {
        return lecFinal - lecInicial;
    }

    @Override
    public String toString() {
        return "Turno:" +
                "fecha: " + fecha + '\'' +
                ", lecturaInicialSuper: " + lecturaInicialSuper +
                ", lecturaInicialExtra: " + lecturaInicialExtra +
                ", lecturaInicialDiesel: " + lecturaInicialDiesel +
                ", lecturaFinalSuper: " + lecturaFinalSuper +
                ", lecturaFinalExtra: " + lecturaFinalExtra +
                ", lecturaFinalDiesel: " + lecturaFinalDiesel +
                ", turno: " + tipoTurno;
    }
}
