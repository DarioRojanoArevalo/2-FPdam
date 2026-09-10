package ficheroRepaso;

import java.util.ArrayList;
import java.util.Arrays;
/*Ejercicio, dada una lista de números ordenados en este caso de impares entre 1 y 17. Haz un algoritmo que te indique si el número que le pides se encuentra e nel Array*/


public class BúsquedaBinaria {
	static ArrayList<Integer> impares = new ArrayList<Integer>(Arrays.asList(1, 3 ,5,7,9,11,13,15,17/**/));

	public static void main(String[] args) {
		for (int i = 1; i < impares.size()*2+2; i=i+2) {
			System.out.println("Encontrado el "+i+"?: "+buscarImpar(impares, i));
		}
	}
	public static boolean buscarImpar(ArrayList<Integer> lista, int numeroBuscado){
		if (lista==null)return false;
		int posicionMinima=0;
		int posicionMaxima=lista.size();
		int posicion, contador;
		contador=0;
		if (posicionMaxima<=0)return false;
		while (true) {
			contador++;
			posicion = posicioMediaRango(posicionMinima, posicionMaxima);
			if(numeroBuscado==lista.get(posicion)) {
				System.out.print("Numero intentos: "+contador+". ");
				return true;
			}
			if(posicionMaxima-posicionMinima<=1)return false;
			if(numeroBuscado<lista.get(posicion))posicionMaxima=posicion;
			else posicionMinima = posicion;
		}
	}
	public static int posicioMediaRango(int bajo, int alto){
		return ((alto-bajo)/2)+bajo;
	}
}

