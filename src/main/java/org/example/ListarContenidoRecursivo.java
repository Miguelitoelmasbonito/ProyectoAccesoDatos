package org.example;

import java.io.File;

public class ListarContenidoRecursivo {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Uso: java ListarContenidoRecursivo <ruta_de_la_carpeta>");
            System.exit(1);
        }

        String rutaCarpeta = args[0];
        listarContenidoRecursivo(new File(rutaCarpeta),0);
    }

    public static void listarContenidoRecursivo(File carpeta, int contador) {
        String espacio = "____".repeat(contador*2);
        if (carpeta.isDirectory()) {


            System.out.println("|_"+espacio+" Carpeta: " + carpeta.getAbsolutePath());

            File[] archivos = carpeta.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    listarContenidoRecursivo(archivo,contador+1);
                }
            }
        } else if (carpeta.isFile()) {
            System.out.println(" "+espacio+"_____Archivo: " + carpeta.getAbsolutePath());

        }
    }
}