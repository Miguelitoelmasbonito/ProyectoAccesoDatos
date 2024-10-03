package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ListarContenidoTree {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            System.out.println("Uso: java ListarContenidoRecursivo <ruta_de_la_carpeta>");
            System.exit(1);
        }


        try {
            FileWriter fw = new FileWriter("salida.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            String linea;

            String rutaCarpeta = args[0];
            listarContenidoRecursivo(new File(rutaCarpeta), "", true, bw);

            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String archivoEntrada = "salida.txt";
        String archivoSalida = "archivo_salida.bin";
        String archivotexto = "archivotexto.txt";
        crearArchivoEjemplo(archivoEntrada,archivoSalida);
        binarioTexto(archivoSalida,archivotexto);
    }

    public static void listarContenidoRecursivo(File carpeta, String prefijo, boolean esUltimo, BufferedWriter bw) throws IOException {


        if (carpeta.isDirectory()) {
            //Carpeta Usuario
            // Muestra el nombre de la carpeta con el prefijo adecuado
            String linee = prefijo + (esUltimo ? "└── " : "├── ") + "Carpeta: " + carpeta.getName();
            System.out.println(linee);
            bw.write(linee + "\n");


            //Un array de objetos File con dos elementos: la carpeta etc y la carpeta home
            File[] archivos = carpeta.listFiles();


            if (archivos != null) {
                // Recorre los archivos y carpetas dentro de la carpeta actual
                for (int i = 0; i < archivos.length; i++) {
                    // Determina si es el último archivo para ajustar el prefijo de la siguiente línea
                    boolean esUltimoHijo = (i == archivos.length - 1);
                    listarContenidoRecursivo(archivos[i], prefijo + (esUltimo ? "    " : "│   "), esUltimoHijo, bw);
                }
            }
        } else if (carpeta.isFile()) {
            // Muestra el nombre del archivo con el prefijo adecuado
            String line = prefijo + (esUltimo ? "└── " : "├── ") + "Archivo: " + carpeta.getName();
            System.out.println(line);
            bw.write(line + "\n");
        }


    }

    public static void crearArchivoEjemplo(String archivoEntrada, String archivoSalida) throws FileNotFoundException {

        try(
                FileOutputStream fos = new FileOutputStream(archivoSalida);
                BufferedOutputStream bos= new BufferedOutputStream(fos);
                FileReader fis = new FileReader(archivoEntrada, StandardCharsets.UTF_8);
                BufferedReader bis =new BufferedReader(fis);
        ) {
            String linea;
            while ((linea = bis.readLine()) != null) {
              bos.write(linea.getBytes());
              bos.write(System.lineSeparator().getBytes());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void binarioTexto(String archivoBinario, String archivoTexto) {
        try (
                FileInputStream fis = new FileInputStream(archivoBinario);
                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                BufferedReader br = new BufferedReader(isr);

                FileWriter fw = new FileWriter(archivoTexto);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            String linea;
            while ((linea = br.readLine()) != null) {
                bw.write(linea);
               bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al convertir archivo binario a texto", e);
        }
    }




    }



