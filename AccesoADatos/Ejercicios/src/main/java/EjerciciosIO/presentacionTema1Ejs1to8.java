package org.example;

import java.io.File;
import java.io.IOException;

import static java.lang.System.*;

public class presentacionTema1Ejs1to8 {
/*
1. Crea un directorio llamado ”ejercicios”
2. Crea un fichero llamado ejercicio1, dentro del directorio ejercicios
3. Muestra por pantalla la longitud del fichero con nombre “ejercicio1”
4. Crea un fichero llamado ejercicio2 , dentro del directorio ejercicios
5. Muestra todos los ficheros del directorio ejercicios
6. Elimina el fichero llamado ejercicio1
7. Muestra todos los ficheros del directorio ejercicios
8. Elimina nuevamente el fichero llamado fichero1.
• ¿Has podido? YES!YES!YES!YES!
*/
	private static void main(String[] args) {
		if(ej1("ejercicios")) out.println("creado el directorio");
		if(ej2_4("ejercicios", "ejercicio1")) out.println("creada el fichero");
		ej3();
		if(ej2_4("ejercicios", "ejercicio2")) out.println("creada el fichero");
		ej5_7("ejercicios");
		ej6_8("ejercicios","ejercicio1");
		ej5_7("ejercicios");
		ej6_8("ejercicios","ejercicio1");
	}
	public static boolean ej1(String directorio){
		File carpeta = new File(directorio);
        try {
            out.println("Se intentará crear un directorio en la ruta: "+carpeta.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(carpeta.exists()){
			if(carpeta.isDirectory()) {
			out.println("Ya existía el directorio");
			return false;
			}
			out.println("Ya existe un archivo de nombre "+directorio);
			return false;
		}
		return carpeta.mkdir();
	}
	public static boolean ej2_4(String directorio, String carpeta){
		File fichero = new File(directorio+File.separator+carpeta);
        try {
            return fichero.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
	public static void ej3(){
		File fichero = new File("ejercicios"+ File.separator+"ejercicio1");
        try {
            out.println("Tamaño del fichero de la ruta "+fichero.getCanonicalPath()+":"+fichero.length());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
	public static void ej5_7(String directorio){
		File carpeta = new File(directorio);
		if(carpeta.isDirectory()){
			String [] in = carpeta.list();
			try {
				out.println("Los directorios dentro de "+carpeta.getCanonicalPath()+" son:");
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			for (int i = 0; i < in.length; i++) {
				out.println(in[i]);
			}
		}else out.println("No se ha podido mostrar la información de los directorios porque la ruta no corresponde a una carpeta");
	}
	private static void ej6_8(String ejercicios, String ejercicio1) {
		File fichero = new File(ejercicios+File.separator+ejercicio1);
		if(fichero.exists()&&fichero.isFile()) out.println("Borrado el fichero? :"+fichero.delete());
	}
}
