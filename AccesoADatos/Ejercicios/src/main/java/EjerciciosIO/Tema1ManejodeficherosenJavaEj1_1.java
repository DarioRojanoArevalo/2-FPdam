package EjerciciosIO;

import java.io.*;

import static java.lang.IO.print;
import static java.lang.IO.println;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Tema1ManejodeficherosenJavaEj1_1 {
    static void main(String [] a) throws IOException {
        String ruta= null;
        if(a.length==1){
            ruta =a[0];
        }
        if(ruta == null||ruta.equals("")){
            ruta="DocumentoPrueba.txt";
        }
        File fichero=new File(ruta);
        if(fichero.exists()) {
            FileReader lector = new FileReader(fichero);
            int i;
            while ((i = lector.read()) != -1) {
               print((char) i);
            }
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            String linea= null;
            println("");
            while ((linea = br.readLine()) != null) {
                System.out.print("\n"+linea);
            }
        }else println("El fichero de la ruta "+ruta+" no existe\n\n");
        }
}
