package org.example;


import java.io.*;

public class PasarTextoBinarioTextoV1 {

    public static void main(String[] args) {
        // Nombres de los ficheros
        String archivoTexto = "entrada.txt";
        String archivoBinario = "archivo.bin";
        String archivoSalidaTexto = "salida.txt";

        // Convertir texto a binario
        textoABinario(archivoTexto, archivoBinario);

        // Convertir binario a texto
        binarioATexto(archivoBinario, archivoSalidaTexto);
    }

    // Método para convertir un archivo de texto a un archivo binario
    public static void textoABinario(String archivoTexto, String archivoBinario) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoTexto));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(archivoBinario))) {

            String linea;
            while ((linea = reader.readLine()) != null) {
                // Convertimos la línea a bytes
                byte[] bytes = linea.getBytes();

                // Guardamos la longitud de la línea en 4 bytes (equivalente a un int)
                bos.write(intToBytes(bytes.length));

                // Escribimos los bytes de la línea en el archivo binario
                bos.write(bytes);
            }

        } catch (IOException e) {
            System.err.println("Error leyendo/escribiendo archivos: " + e.getMessage());
        }
    }

    // Método para leer desde el archivo binario y escribirlo en un archivo de texto
    public static void binarioATexto(String archivoBinario, String archivoTextoSalida) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(archivoBinario));
             BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTextoSalida))) {

            byte[] intBytes = new byte[4]; // Buffer para leer el tamaño de la línea (4 bytes)

            while (bis.read(intBytes) != -1) {
                // Convertimos los 4 bytes a un entero (tamaño de la línea)
                int longitud = bytesToInt(intBytes);

                // Creamos un array de bytes para almacenar la línea
                byte[] lineaBytes = new byte[longitud];

                // Leemos los bytes de la línea
                bis.read(lineaBytes);

                // Convertimos los bytes a String y lo escribimos en el archivo de salida
                String linea = new String(lineaBytes);
                writer.write(linea);
                writer.newLine(); // Añadimos una nueva línea
            }

        } catch (IOException e) {
            System.err.println("Error leyendo/escribiendo archivos: " + e.getMessage());
        }
    }

    // Método para convertir un entero a un array de 4 bytes
    private static byte[] intToBytes(int value) {
        return new byte[] {
                (byte)(value >> 24),
                (byte)(value >> 16),
                (byte)(value >> 8),
                (byte)value
        };
    }

    // Método para convertir un array de 4 bytes a un entero
    private static int bytesToInt(byte[] bytes) {
        return ((bytes[0] & 0xFF) << 24) |
                ((bytes[1] & 0xFF) << 16) |
                ((bytes[2] & 0xFF) << 8) |
                (bytes[3] & 0xFF);
    }
}
