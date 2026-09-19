package EjerciciosIO;

import java.io.*;
import java.util.ArrayList;

public class ObjectsStream {
    static void main() throws IOException, ClassNotFoundException {
        ArrayList<Producto> productos= new ArrayList<Producto>();
        productos.add(new Producto(1,9.2,"Sartén"));
        productos.add(new Producto(2,1.2,"Mesa"));
        productos.add(new Producto(3,3.2,"Mesa"));
        productos.add(new Producto(5,2.9,"Libreta"));
        productos.add(new Producto(4,2.2,"Chimichanga"));

        File productosFile = new File("Productos.dat");
        if(!productosFile.exists()) productosFile.createNewFile();

        ObjectOutputStream objectOutFile = new ObjectOutputStream(new FileOutputStream(productosFile));
        objectOutFile.writeObject(productos);
        objectOutFile.close();
        ObjectInputStream objectInStream = new ObjectInputStream (new FileInputStream(new File("Productos.dat")));
        ArrayList<Producto> productos2= (ArrayList<Producto>) objectInStream.readObject();
        System.out.println("Falló el equals");
        System.out.println("");
        System.out.println("Original");
        mostrarArrayProducto(productos);
        System.out.println("");
        System.out.println("Leido");
        mostrarArrayProducto(productos2);
    }
    public static void opcionLentayconFallos() throws IOException {
        ArrayList<Producto> productos= new ArrayList<Producto>();
        productos.add(new Producto(1,9.2,"Sartén"));
        productos.add(new Producto(2,1.2,"Mesa"));
        productos.add(new Producto(3,3.2,"Mesa"));
        productos.add(new Producto(5,2.9,"Libreta"));
        productos.add(new Producto(4,2.2,"Chimichanga"));

        guardarProductos(productos);
        ArrayList<Producto> productos2 = recuperarProductos();

        if(productos.equals(productos2)) System.out.println("exito!!");
        else{
            System.out.println("Falló el equals");
            System.out.println("");
            System.out.println("Original");
            mostrarArrayProducto(productos);
            System.out.println("");
            System.out.println("Leido");
            mostrarArrayProducto(productos2);
        }
    }
    public static void guardarProductos(ArrayList<Producto> productos) throws IOException{
        File productosFile = new File("Productos.dat");
        if(!productosFile.exists()) productosFile.createNewFile();

        ObjectOutputStream objectOutFile = new ObjectOutputStream(new FileOutputStream(productosFile));


        for(int i =0 ;i<productos.size();i++){
            objectOutFile.writeObject(productos.get(i));
        }

    }
    public static ArrayList<Producto> recuperarProductos() {
        ArrayList<Producto> a = new ArrayList<Producto>();
        try{
        ObjectInputStream objectInStream = new ObjectInputStream (new FileInputStream(new File("Productos.dat")));


            while (true) {
                a.add((Producto) objectInStream.readObject());
            }
        }catch (EOFException i){
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
    public static void mostrarArrayProducto (ArrayList<Producto> p ){
        for(int i = 0;i<p.size();i++){
            System.out.println(p.get(i).toString());
        }
    }
}
