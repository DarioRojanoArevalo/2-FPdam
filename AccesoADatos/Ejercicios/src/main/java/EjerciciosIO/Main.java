package org.example;

import java.io.*;

public class Main {
    static void main() {
        BytetoHardData();
    }
    public static void BytetoHardData(){
        File fichero = new File("Fichero.dat");
        try {
            DataOutputStream datOut=new DataOutputStream(new FileOutputStream(fichero)) ;
            datOut.writeInt(12399);
            datOut.writeUTF("La loca del pueblo");
            datOut.writeUTF("El loco de la puebla");
            datOut.close();

            DataInputStream datIn= new DataInputStream(new FileInputStream(fichero));
            System.out.println(datIn.readInt());
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
            FileOutputStream outStream = new FileOutputStream(fichero);
            outStream.write(12);
            outStream.write(15);
            // outStream.write("La loca".getBytes());
            outStream.close();
            FileWriter fwrite = new FileWriter(fichero,true);
            fwrite.write("Laloca");
            fwrite.close();
            FileInputStream inStream = new FileInputStream(fichero);
            int recuperado;
            while((recuperado=inStream.read())!=-1){
                System.out.println(recuperado);
            }
            inStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}