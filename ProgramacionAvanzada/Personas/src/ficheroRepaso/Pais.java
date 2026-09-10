package ficheroRepaso;

public class Pais {
	private String nombre;
	private int ganados, perdidos, empatados;
	public Pais(String nombre) {
		super();
		this.nombre = nombre;
		this.ganados = 0;
		this.perdidos = 0;
		this.empatados = 0;
	}
	public String getNombre() {
		return nombre;
	}
	public int getGanados() {
		return ganados;
	}
	public int getPerdidos() {
		return perdidos;
	}
	public int getEmpatados() {
		return empatados;
	}

	
	public void sumGanado() {
		this.ganados++;
	}
	public void sumPerdido() {
		this.perdidos++;
	}
	public void sumEmpatados() {
		this.ganados++;
	}
	
	
	public void mostrarClasificacion(String previo) {
		System.out.println(previo+"Pais: "+nombre+" Puntos: "+Puntuacion());
		System.out.println(previo+"Partidos Ganados:   "+ganados);
		System.out.println(previo+"Partidos Empatados: "+empatados);
		System.out.println(previo+"Partidos Perdidos:  "+perdidos);
		System.out.println();
	}
	private int Puntuacion() {
		return ((ganados*3)+perdidos);
	}
}
