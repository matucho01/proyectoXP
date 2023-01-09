package ec.edu.epn;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Pedido {
    private int galonesSuper;
    private int galonesExtra;
    private int galonesDiesel;
    private String fechaPedido;

    public Pedido(ArrayList<Integer> totalGalonesPedido, String fecha) {
        this.galonesSuper = totalGalonesPedido.get(0);
        this.galonesExtra = totalGalonesPedido.get(1);
        this.galonesDiesel = totalGalonesPedido.get(2);
        this.fechaPedido = fecha;
    }

    public String crearPedido() {
        String pedido = "";
        pedido = "El pedido es:" +
                "\nFecha: " + this.fechaPedido +
                "\nSuper: " + this.galonesSuper + "00" +
                "\nExtra: " + this.galonesExtra + "00" +
                "\nDiesel: " + this.galonesDiesel + "00" +
                "\nRevisado por: Gerente";
        return pedido;
    }
    public boolean generarArchivo() {
        try {
            String nombreArchivo = "pedido_"+this.fechaPedido+".txt";
            File archivo = new File("./pedidos", nombreArchivo);
            if(archivo.createNewFile()) {
                System.out.println("Archivo creado exitosamente");
                FileWriter fw = new FileWriter(nombreArchivo);
                String pedido = crearPedido();
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
