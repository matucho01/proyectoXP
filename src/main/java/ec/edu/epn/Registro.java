package ec.edu.epn;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Registro {
    private ArrayList consumoSuper = new ArrayList();
    private ArrayList consumoExtra = new ArrayList();
    private ArrayList consumoDiesel = new ArrayList();
    private int numDias = 3;
    DecimalFormat formato = new DecimalFormat("#.#");

    public Registro() {
    }

    public void totalizarConsumosSemanales(String fecha, ArrayList<Turno> turnos) {
        ArrayList<Integer> elementosFecha = this.tokenizarFecha(fecha);
        this.consumoSuper.clear();
        this.consumoExtra.clear();
        this.consumoDiesel.clear();
        Calendar c = Calendar.getInstance();
        new SimpleDateFormat("dd-MM-yy");
        int posFecha = this.posFecha(fecha, turnos);

        for(int i = 1; i < 4; ++i) {
            c.set((Integer)elementosFecha.get(2), (Integer)elementosFecha.get(1), (Integer)elementosFecha.get(0));
            c.add(5, -7 * i);
            float auxSemanaSuper = 0.0F;
            float auxSemanaExtra = 0.0F;
            float auxSemanaDiesel = 0.0F;
            int posTurno = posFecha - 7 * i * 3;

            for(int j = 0; j < this.numDias; ++j) {
                Calendar aux = (Calendar)c.clone();
                aux.add(5, j);

                for(int k = 0; k < 3; ++k) {
                    ++posTurno;
                    ArrayList listaAux = ((Turno)turnos.get(posTurno)).calcularVentasEnGalonesPorProducto();
                    auxSemanaSuper += Float.parseFloat(listaAux.get(0).toString());
                    auxSemanaExtra += Float.parseFloat(listaAux.get(1).toString());
                    auxSemanaDiesel += Float.parseFloat(listaAux.get(2).toString());
                }
            }

            auxSemanaSuper = this.formatearGalones(auxSemanaSuper);
            auxSemanaExtra = this.formatearGalones(auxSemanaExtra);
            auxSemanaDiesel = this.formatearGalones(auxSemanaDiesel);
            this.consumoSuper.add(auxSemanaSuper);
            this.consumoExtra.add(auxSemanaExtra);
            this.consumoDiesel.add(auxSemanaDiesel);
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

    public ArrayList<Float> proyectarVentas(String fecha, ArrayList<Turno> turnos, float galonesSuper, float galonesExtra, float galonesDiesel) {
        float total = 0.0F;
        float estimadorSuper = 0.0F;
        float estimadorExtra = 0.0F;
        float estimadorDiesel = 0.0F;

        ArrayList pedido = new ArrayList<Float>();

        while(total <= 10) {
            total = 0.0F;
            pedido.clear();
            pedido.add(estimadorSuper);
            pedido.add(estimadorExtra);
            pedido.add(estimadorDiesel);
            this.totalizarConsumosSemanales(fecha, turnos);
            estimadorSuper = (float)Math.round((Float)this.obtenerMayor().get(0) - this.formatearGalones(galonesSuper));
            estimadorExtra = (float)Math.round((Float)this.obtenerMayor().get(1) - this.formatearGalones(galonesExtra));
            estimadorDiesel = (float)Math.round((Float)this.obtenerMayor().get(2) - this.formatearGalones(galonesDiesel));
            if (estimadorSuper < 0.0F) {
                estimadorSuper = 0.0F;
            }

            total = estimadorSuper + estimadorExtra + estimadorDiesel;
        }

        return pedido;
    }

    private ArrayList<Integer> tokenizarFecha(String fecha) {
        List tokens = new ArrayList();
        StringTokenizer tkzr = new StringTokenizer(fecha, "-");

        while(tkzr.hasMoreElements()) {
            tokens.add(tkzr.nextToken());
        }

        ArrayList elementosFecha = new ArrayList();
        elementosFecha.add(Integer.parseInt(tokens.get(0).toString()));
        elementosFecha.add(Integer.parseInt(tokens.get(1).toString()) - 1);
        elementosFecha.add(Integer.parseInt(tokens.get(2).toString()));
        return elementosFecha;
    }

    private float formatearGalones(float galones) {
        float galonesNormalizados = galones / 1000.0F;
        return Float.parseFloat(this.formato.format((double)galonesNormalizados));
    }

    public ArrayList<Float> obtenerMayor() {
        ArrayList<Float> mayorDemanda = new ArrayList();
        mayorDemanda.add((Float)((Comparable)Collections.max(this.consumoSuper)));
        mayorDemanda.add((Float)((Comparable)Collections.max(this.consumoExtra)));
        mayorDemanda.add((Float)((Comparable)Collections.max(this.consumoDiesel)));
        this.mostrarMayores(mayorDemanda);
        return mayorDemanda;
    }

    private void mostrarMayores(ArrayList mayorDemanda) {
        System.out.println("La demanda más alta de super es: " + mayorDemanda.get(0));
        System.out.println("La demanda más alta de extra es: " + mayorDemanda.get(1));
        System.out.println("La demanda más alta de diesel es: " + mayorDemanda.get(2));
    }

    public ArrayList getConsumoSuper() {
        return this.consumoSuper;
    }

    public ArrayList getConsumoExtra() {
        return this.consumoExtra;
    }

    public ArrayList getConsumoDiesel() {
        return this.consumoDiesel;
    }

    public int getNumDias() {
        return this.numDias;
    }
}
