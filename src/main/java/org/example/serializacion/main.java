package org.example.serializacion;

import java.io.*;
import java.time.LocalDate;

public class main {
    public static void main(String[] args) {

        try (FileOutputStream fileOutput = new FileOutputStream("libros.dat");
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {

            Libro libro = new Libro("Las aventuras de Miguel","Miguelito","S5398539",33.99,8);
            Libro libro2 = new Libro("Las aventuras de sarita","Sarita","S515698555",45.99,9);
            Libro libro3= new Libro("Las aventuras de Michel","Michel","S53125539",44.99,10);
            Libro libro4 = new Libro("Las aventuras de Hector","Hector","S53535339",46.99,11);


            Biblioteca bibliotecanacional = new Biblioteca();

            bibliotecanacional.agregarLibros(libro);
            bibliotecanacional.agregarLibros(libro2);
            bibliotecanacional.agregarLibros(libro3);
            bibliotecanacional.agregarLibros(libro4);

            bibliotecanacional.mostrarLibros();
            bibliotecanacional.serializarLibros();
            bibliotecanacional.deserializarLibros(new File("libros.dat"));








    } catch (IOException e) {
            System.out.println("Error al almacenar mascotas");
        }
}
}
