package ficherosObjetos;

import java.io.*;
import java.util.ArrayList;

public class LeerPersonas2 {

    public static void main(String[] args) {

        File fichero = new File("FichPersonas2.dat");

        try (ObjectInputStream dataIS =
new ObjectInputStream(new FileInputStream(fichero))) {

            // Leemos el único objeto que hay en el fichero
            ArrayList<Persona> listaPersonas =(ArrayList<Persona>) dataIS.readObject();

            // Recorremos la lista
            for (Persona persona : listaPersonas) {
                System.out.printf("Nombre: %s, edad: %d%n",
                        persona.getNombre(),
                        persona.getEdad());
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}