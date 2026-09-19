package EjerciciosIO;

import java.io.*;

import static java.lang.IO.println;

public class DataStream {
    static void main() {
        BytetoHardData();
        BytetoByte();
    }
    public static void BytetoHardData(){
        File fichero = new File("Fichero.dat");
        try {
            DataOutputStream datOut=new DataOutputStream(new FileOutputStream(fichero));
            datOut.writeInt(12399);
            datOut.writeUTF("La loca del pueblo");
            datOut.writeUTF("El loco de la puebla");
            datOut.writeByte(15);
            datOut.close();

            println("Leyendo con DataInput los datos escritos con Data output");
            DataInputStream datIn= new DataInputStream(new FileInputStream(fichero));
            System.out.println(datIn.readInt());
            System.out.println(datIn.readUTF());
            System.out.println(datIn.readUTF());
            System.out.println(datIn.readByte());
            datIn.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void BytetoByte (){
        File fichero = new File("Fichero.bit");
        try {
            FileWriter fwrite = new FileWriter(fichero,true);
            fwrite.write(23);
            fwrite.write("Laloca ");
            fwrite.write("Elloco");
            fwrite.close();
            FileInputStream inStream = new FileInputStream(fichero);
            int recuperado;
            println("Leyendo con FileInput (byte a byte) los datos introducidos con FileOutput");
            while((recuperado=inStream.read())!=-1){
                System.out.println(recuperado);
            }
            inStream.close();
            println("Leyendo con FileReader los datos introducidos con FileWriter parece que File Writer no borra las cosas como si hace DataOutputStream, no la entiendo bién parece que va con strings para numeros y lo demás malo");
            FileReader reader= new FileReader(fichero);
            println(reader.readAllLines());
            //println(reader.toString());
            inStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}