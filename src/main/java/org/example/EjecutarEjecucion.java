package org.example;

import java.io.*;
import java.util.Scanner;

public class EjecutarEjecucion {

    public static void main(String[] args) throws IOException {

        File directorio = new File("./src/main/java/org/example");
        ProcessBuilder pb = new ProcessBuilder("java", "EjecuciondeunProceso.java");
        pb.directory(directorio);


        // Se ejecuta el proceso
        Process p = pb.start();

        OutputStream os = p.getOutputStream();
        InputStream is = p.getInputStream();


        // Enviar el primer número
        Scanner sc =new Scanner(System.in);
        os.write((sc.nextInt()+"\n").getBytes());
        os.flush();
        os.write((sc.nextInt()+"\n").getBytes());
        os.flush();

        int i;
        while ((i = is.read())!=-1){
            System.out.print((char)i);
        }








    }
}
