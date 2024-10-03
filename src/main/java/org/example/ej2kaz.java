package org.example;

import java.io.*;
import java.util.Scanner;

public class ej2kaz {
    public static void main(String[] args) {

        try{

            Scanner sc=new Scanner(System.in);
            FileReader fr= new FileReader("entrada.txt");
            FileWriter fw= new FileWriter("salida.txt");

            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw= new BufferedWriter(fw);

            // Bucle para leer y escribir
            String linea;

            while (!(linea = sc.nextLine()).equals("codigosecreto233")) {
                System.out.println(linea);
                bw.write(linea+" ");
                bw.newLine();

            }
            /*
            while(sc.hasNextLine()) {
                linea = sc.nextLine();
                bw.write(linea);
                bw.newLine();
            }

            */
            // String linea= br.readLine();
            // while (linea != null) {
            // y al  linea=br.newLine();

            br.close();
            bw.close();







        }catch (IOException e){

            e.printStackTrace();
        }
    }
}
