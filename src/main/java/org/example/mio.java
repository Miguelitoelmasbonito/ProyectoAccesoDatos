package org.example;

import java.io.*;

public class mio {
    public static void main(String[] args) {

        try{

            FileReader fr= new FileReader("entrada.txt");
            FileWriter fw= new FileWriter("salida.txt");

            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw= new BufferedWriter(fw);

            // Bucle para leer y escribir
            String linea;
            char c;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                bw.write(linea);
                bw.newLine();
            }

            // String linea= br.readLine();
            // while (linea != null) { todo lo anterior
            // y al  linea=br.newLine();

            br.close();
            bw.close();







        }catch (IOException e){

            e.printStackTrace();
        }
    }
}
