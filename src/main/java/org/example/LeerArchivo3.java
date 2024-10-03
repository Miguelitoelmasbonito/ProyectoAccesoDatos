package org.example;

import java.io.*;

public class LeerArchivo3 {
    public static void main(String[] args) {
        try {

            if (args.length != 1) {
                System.out.println("Uso: java ListarContenidoRecursivo <ruta_de_la_carpeta>");
                System.exit(1);
            }

            String ruta = args[0];
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
