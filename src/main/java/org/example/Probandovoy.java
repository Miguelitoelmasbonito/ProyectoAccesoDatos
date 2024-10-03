package org.example;

import java.io.File;

public class Probandovoy {
    public static void main(String[] args) {

        if(args.length !=1 ) {
            System.out.println("Error ");
            System.exit(0);
        }

        String rutacarpeta= args[0];

    }


    public static void ListarContenidoRecursivo(File archivo, String prefijo,boolean esUltimo) {

        if (archivo.isDirectory()) {

            System.out.println(prefijo + (esUltimo ? "└──" : "├── ")+ "Carpeta" + archivo.getName());
            File[] documentos= archivo.listFiles();

            if (documentos != null) {

            }


        }

    }





}
