package ficherosObjetos;

import java.io.*;

public class LeerPersonas {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File fichero = new File("FichPersonas.dat");
		ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));
		try {
			//otra opción antes que usar un cacht
			/*Persona persona;
			while ((persona = leerPersona(dataIS)) != null) {
				System.out.printf("Nombre: %s, edad: %d %n",persona.getNombre(), persona.getEdad());
			}/**/
			while (true) { // lectura del fichero
				Persona persona = (Persona) dataIS.readObject();
				System.out.printf("Nombre: %s, edad: %d %n", persona.getNombre(), persona.getEdad());
			}/**/
		} catch (EOFException eo) {
			System.out.println("FIN DE LECTURA.");
		} catch (StreamCorruptedException x) {
		}
		dataIS.close(); // cerrar stream de entrada
	}
	public static Persona leerPersona(ObjectInputStream dataIS)
			throws IOException, ClassNotFoundException {
		try {
			return (Persona) dataIS.readObject();
		} catch (EOFException e) {
			return null;
		}
	}
}