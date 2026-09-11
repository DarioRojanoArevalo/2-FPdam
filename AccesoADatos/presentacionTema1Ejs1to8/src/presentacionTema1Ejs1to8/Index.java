package presentacionTema1Ejs1to8;

import java.io.File;
import java.io.IOException;

public class Index {
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
	public static void main(String[] args) {
		System.out.println("Hello World");// TODO Auto-generated method stub
		if(ej1("ejercicios")) System.out.println("creado el directorio");
		if(ej2_4("ejercicios", "ejercicio1"))System.out.println("creada el fichero");
		ej3();
		if(ej2_4("ejercicios", "ejercicio2"))System.out.println("creada el fichero");

	}
	public static boolean ej1(String directorio){
		File carpeta = new File(directorio);
        try {
            System.out.println("Se intentará crear un directorio en la ruta: "+carpeta.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(carpeta.exists()){
			if(carpeta.isDirectory()) {
			System.out.println("Ya existía el directorio");
			return false;
			}
			System.out.println("Ya existe un archivo de nombre "+directorio);
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
		System.out.println(fichero.length());
	}
	public static void ej5(String directorio){
		File carpeta = new File(directorio);
		String [] in = carpeta.list();
        try {
            System.out.println("Los directorios dentro de "+carpeta.getCanonicalPath()+" son:");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < in.length; i++) {
			System.out.println(in[i]);
		}
	}
}
