package org.example;

import java.util.Scanner;

public class EjecuciondeunProceso2 {
    public static void main(String[] args) {
        String cadena="";

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Introduce cadenas, pon * cuando quieras parar");
             cadena = sc.nextLine();


        }while (!cadena.equals("*"));
    }

}
