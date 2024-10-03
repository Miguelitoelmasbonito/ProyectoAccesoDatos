package org.example;

import java.util.Scanner;

public class EjecuciondeunProceso {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
   String numero;
    String numero2;
    boolean comprobacion=true;

     do {
             System.out.println("Dime un numero");
             numero = sc.nextLine();

             System.out.println("Dime otro numero");
              numero2 = sc.nextLine();

              if (numero.matches("[0-9]+") && numero2.matches("[0-9]+")){
                  comprobacion=true;
              } else {
                  comprobacion=false;
                  System.out.println("No has introducido dos numeros");
              }
     }while(!comprobacion);

     int numeronew1= Integer.parseInt(numero);
     int numeronew2= Integer.parseInt(numero2);
     int suma=numeronew1+numeronew2;
        System.out.println("La suma total seria "+suma);






    }
}
