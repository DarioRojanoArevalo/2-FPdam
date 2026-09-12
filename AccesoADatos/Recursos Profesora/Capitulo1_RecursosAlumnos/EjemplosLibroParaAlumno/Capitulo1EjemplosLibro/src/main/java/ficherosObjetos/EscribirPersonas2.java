package ficherosObjetos;

import java.io.*;
import java.util.ArrayList;
//Le pedí a chat una solución que permitiese añadir personas al .dat sin reescribirlo entero.

// Es decir si es una lista podemos simplemente añadir una elemento al final no? pero en ambas
// soluciones reescribimos por completo el fichero, lo que me parece inecesario en algunos casos.
public class EscribirPersonas2 {
    public static void main(String[] args) {
        File fichero = new File("FichPersonas2.dat");
        ArrayList<Persona> listaPersonas = new ArrayList<>();

        // 1. SI EL ARCHIVO YA EXISTE, LEEMOS LO QUE TIENE
        if (fichero.exists() && fichero.length() > 0) {
            try (ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero))) {
                // Leemos la lista completa que ya estaba guardada
                listaPersonas = (ArrayList<Persona>) dataIS.readObject();
                System.out.println("Cargados " + listaPersonas.size() + " registros previos.");
            } catch (Exception e) {
                System.out.println("Error al leer el archivo previo: " + e.getMessage());
            }
        }

        // 2. AÑADIMOS LOS NUEVOS DATOS A LA LISTA
        String nombres[] = { "Ana", "Luis Miguel", "Alicia", "Pedro",
                "Manuel", "Andrés", "Julio", "Antonio",
                "María Jesús" };
        int edades[] = { 14, 15, 13, 15, 16, 12, 16, 14, 13 };

        System.out.println("AÑADIENDO NUEVOS DATOS...");
        for (int i = 0; i < edades.length; i++) {
            listaPersonas.add(new Persona(nombres[i], edades[i]));
            System.out.println("Registro preparado en memoria...");
        }

        // 3. GUARDAMOS LA LISTA COMPLETA ACTUALIZADA (Sobrescribiendo el archivo con el objeto ArrayList completo)
        // Usamos try-with-resources para que se cierre el flujo automáticamente
        try  {
            ObjectOutputStream dataOS = new ObjectOutputStream(new FileOutputStream(fichero));
            dataOS.writeObject(listaPersonas); // Se escribe UN SOLO OBJETO (la lista completa)
            System.out.println("¡Archivo guardado con éxito! Total personas: " + listaPersonas.size());
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}
