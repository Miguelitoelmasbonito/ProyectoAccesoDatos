package org.example.serializacion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Libro> biblioteca = new ArrayList<>();


    public void agregarLibros(Libro libro) {
        biblioteca.add(libro);

    }


    public void mostrarLibros() {
        for (Libro a : biblioteca) {
            System.out.println("Libro:" + a);
        }


    }


    public void serializarLibros() {
        try (FileOutputStream fileOutput = new FileOutputStream("libros.dat");
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {
            for (Libro libro : biblioteca) {
                objectOutput.writeObject(libro);
            }
            System.out.println("Los libros han sido serializados");
        } catch (IOException e) {
            System.out.println("Los libros no han podido serializarse");
            throw new RuntimeException(e);
        }
    }

    public void deserializarLibros(File file) {
        try (FileInputStream fileInput = new FileInputStream(file);
             ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {

            while (true) {
                try {
                    Libro libro = (Libro) objectInput.readObject();
                    System.out.println(libro);

                } catch (EOFException e) {
                    System.err.println("Alcanzado el final del archivo");
                    break; // Se alcanzó el final del archivo
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer el archivo libros.dat: " + e.getMessage());
        }
    }
}