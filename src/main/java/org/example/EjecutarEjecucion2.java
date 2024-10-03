package org.example;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class EjecutarEjecucion2 {
    public static void main(String[] args) throws IOException {


        File directorio = new File("./src/main/java/org/example");
        ProcessBuilder pb = new ProcessBuilder("java", "EjecuciondeunProceso2.java");
        pb.directory(directorio);


        Process p = pb.start();
        OutputStream os = p.getOutputStream();
        InputStream is = p.getInputStream();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Introduce una cadena");
             os.write((sc.nextLine() + "\n").getBytes());
             os.flush();
            try{
                Thread.sleep(1000);
            } catch (Exception e){
                e.printStackTrace();
            }

        }while(p.isAlive());





















    }
}
