package ficheroRepaso;
	import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Index {
	
	private static final String ruta ="C:\\Users\\DAM\\Desktop\\resultadosMundial.txt";
	
	private static int locales, visitantes;
	private static ArrayList<Pais> paises = new ArrayList<Pais>();
	
	private static File txt;
	private static Scanner sc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		txt = new File(ruta);
		try {
			sc= new Scanner(txt);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!txt.canRead())  System.out.println("No se encuentra el fichero en la ruta: "+ ruta);
		else {
			System.out.println("Ej 1:");
			ejercicioOne();
			System.out.println("");
			System.out.println("Ej 2");
			ejercicioTwo();
			}
		sc.close();
	try {
		FileWriter fw= new FileWriter(txt);
		FileReader fr= new FileReader(txt);
		
		
		fr.close();
		fw.close();
		File[] txts = txt.listFiles();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	private static void ejercicioTwo() {
		try {
			sc = new Scanner(txt);
			while(sc.hasNext()) {
				String localName=sc.next();
				String puntuaciones=sc.next();
				String[] puntos= puntuaciones.split("-");
				String visitName=sc.next();
				
				Pais paisLocal=paisCreado(localName);
				Pais paisVisitante=paisCreado(visitName);
				int puntosLocal = Integer.parseInt(puntos[0]);
				int puntosVisitante = Integer.parseInt(puntos[1]);
				
				if(puntosLocal<puntosVisitante) {
					paisVisitante.sumGanado();
					paisLocal.sumPerdido();
				}else if(puntosLocal>puntosVisitante) {
					paisVisitante.sumPerdido();
					paisLocal.sumGanado();
				}else {
					paisVisitante.sumEmpatados();
					paisLocal.sumEmpatados();
				}
			}
			for (int i = 0; i < paises.size(); i++) {
				paises.get(i).mostrarClasificacion("");
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		public  static Pais paisCreado(String name) {
		if (!paisRegistrado(name)) {
			Pais pais = new Pais(name);
			paises.add(pais);
			return pais;
		}
		for (int i = 0; i < paises.size(); i++) {
			if(paises.get(i).getNombre().equals(name)) return paises.get(i);
		}
		return null;
	}
		public static boolean paisRegistrado(String name) {
		for (int i = 0; i < paises.size(); i++) {
			if(paises.get(i).getNombre().equals(name)) return true;
		}
		return false;
	}
	
	
	

 	private  static void ejercicioOne() {	
		while(sc.hasNext()) {
			String local = sc.next();
			sc.next();
			String visitante = sc.next();
			if(local.equals("España")) locales++;
			if(visitante.equals("España")) visitantes++;
		}
	System.out.println("España ha jugado "+locales+" partidos como local y "+ visitantes + " partidos cómo visitantes");
	}

}
