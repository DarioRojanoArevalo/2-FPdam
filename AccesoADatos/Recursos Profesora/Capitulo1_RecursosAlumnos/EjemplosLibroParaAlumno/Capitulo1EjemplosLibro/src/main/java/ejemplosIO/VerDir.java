package ejemplosIO;
import java.io.File;

public class VerDir {
	public static void main(String[] args) {
   // String dir = "."; //directorio actual
    String dir = "." + File.separator + "src";
    File f = new File(dir);
    String[] archivos = f.list();

    System.out.printf("Ficheros en el directorio actual: %d %n", archivos.length);

    for (int i = 0; i < archivos.length; i++) {
	File f2 = new File(f, archivos[i]);

    //System.out.printf("",var,var,var,var) permite indicar mediante % variables que se han de inseratar:
    //%s indica el string que se ponga después de la cadena
    //%b indica el booleano que se encuentra después de la cadena
    //%n indica un salto de linea se cual sea el dispositivo
	System.out.printf("Nombre: %s, es fichero?: %b, es directorio?: %b %n", archivos[i], f2.isFile(),f2.isDirectory());
    }
  }
}
