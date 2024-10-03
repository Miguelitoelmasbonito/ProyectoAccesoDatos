package org.example;

import java.io.*;

public class Ejersisioraro {
    public static void main(String[] args) throws IOException {

        String ruta = args[0];
        FileReader fr = new FileReader(ruta);
        BufferedReader br = new BufferedReader(fr);
        String linea;

        while ((linea = br.readLine()) != null) {
            try {
                FileWriter fw = new FileWriter("archivo.txt", true);  // 'true' para añadir texto sin sobrescribir
                BufferedWriter bw = new BufferedWriter(fw);
                bw.newLine();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }
}
