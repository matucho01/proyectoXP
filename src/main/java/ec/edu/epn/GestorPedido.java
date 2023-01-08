package ec.edu.epn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GestorPedido {

    private String[] archivos;
    public void listarPedidos() {
        File dir = new File("/pedidos");
        this.archivos = dir.list();
        if (archivos == null)
            System.out.println("No hay archivos en el directorio especificado");
        else {
            for (int i=0; i<archivos.length; i++)
                System.out.println(archivos[i]);
        }
    }

    public void mostrarPedido(String nombreArchivo) {
        for(int i=0; i<this.archivos.length; i++) {
            if(nombreArchivo.equals(archivos[i])) {
                try {
                    File f = new File(nombreArchivo);
                    Scanner myReader = new Scanner(f);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Existió un error al intentar leer el archivo");
                    e.printStackTrace();
                }
            }
        }
    }
}
