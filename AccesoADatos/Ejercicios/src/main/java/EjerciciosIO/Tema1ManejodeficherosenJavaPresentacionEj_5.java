package EjerciciosIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.IO.println;

public class Tema1ManejodeficherosenJavaPresentacionEj_5 {
    /*Parte A · Path
• Crea una ruta con Paths.get().
• Muestra getFileName(), getParent(), getRoot(),
getNameCount().
• Comprueba isAbsolute().
• Obtén la ruta absoluta.
• Prueba resolve().
*/
/*Parte B · Files
• Crea una carpeta datos.
• Crea dentro notas.txt.
• Comprueba existencia, permisos y tamaño.
• Escribe y lee contenido.
• Copia y después mueve/renombra la copia.*/


    public static void main (String [] args) throws IOException {
        parteA();
        parteB();

    }

    private static void parteB() throws IOException {
        Path p= Paths.get("Carpetota");
        Files.createDirectory(p);
        Path p2 = p.resolve("notas.txt");
        Files.createFile(p2);
        println(Files.isReadable(p2));
        println(Files.isExecutable(p2));
        println(Files.isWritable(p2));
        println(Files.isReadable(p2));
        println(Files.isRegularFile(p2));
        println(Files.exists(p2));
        println("Tamaño: "+Files.size(p2));

    }

    private static void parteA() throws IOException {
        Path p = Paths.get(".."+File.separator+"Ejercicios"+File.separator+"target"+ File.separator+"Ficheros");
        println("Nombre: "+p.getFileName());
        println("Padre: "+p.getParent());
        println("Root: "+p.getRoot());
        println("Name Count: "+p.getNameCount());
        println("Absoluto?: "+p.isAbsolute());
        println("Absoluta: "+p.toAbsolutePath());
        println("");
        println("Resuelto: "+p.resolve("Fichero.dat)"));
        Path p2 = p.resolve("Fichero.dat");
        println("Real path: "+p2.toRealPath());
        println("Nombre: "+p2.getFileName());
        println("Padre: "+p2.getParent());
        println("Root: "+p2.getRoot());
        println("Name Count: "+p2.getNameCount());
        println("");
        println("");
        println("");
    }
}
