package ec.edu.epn;

import java.util.ArrayList;
import java.util.Arrays;

public class Combustible {
    private double precioSuper, precioExtra, precioDiesel;
    private LectorDatos lectorDatos = new LectorDatos();

    public Combustible() {
        ArrayList<Double> precios = lectorDatos.obtenerPreciosActualizados();
        this.precioSuper = precios.get(0);
        this.precioExtra = precios.get(1);
        this.precioDiesel = precios.get(2);
    }

    public double getPrecioSuper() {
        return precioSuper;
    }

    public double getPrecioExtra() {
        return precioExtra;
    }

    public double getPrecioDiesel() {
        return precioDiesel;
    }

    public void setPrecioSuper(double precioSuper) {
        this.precioSuper = precioSuper;
    }

    public void setPrecioExtra(double precioExtra) {
        this.precioExtra = precioExtra;
    }

    public void setPrecioDiesel(double precioDiesel) {
        this.precioDiesel = precioDiesel;
    }

    @Override
    public String toString() {
        return "Precios oficiales: " +
                "\nSuper: " + precioSuper +
                "\nExtra:" + precioExtra +
                "\nDiesel:" + precioDiesel;
    }
}
