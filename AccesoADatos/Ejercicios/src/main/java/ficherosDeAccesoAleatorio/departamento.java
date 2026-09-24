package ficherosDeAccesoAleatorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import static java.lang.IO.println;
public class departamento {
    public static File fichero = new File("AleatorioDepart.dat");
    public static RandomAccessFile ficheroR;
    //los strings ocupan 17 porque usamos readUTF y writeUTF
    public static int bytesRegistro=(2*2)+((2*15)*2);


    public Short numDepartamento, numEmpleados;
    public String nombre, localidad;//15 caracteres
    public departamento() throws FileNotFoundException {this.ficheroR =new RandomAccessFile(fichero.getName(),"rw");}
    /*CONSTRUCTOR*/public departamento(Short numDepartamento, Short numEmpleados, String nombre, String localidad) throws FileNotFoundException {
        this.localidad=localidad.substring(0,15);
        this.nombre = nombre.substring(0,15);
        this.numEmpleados=numEmpleados;
        this.ficheroR =new RandomAccessFile(fichero.getName(),"rw");
    }
    /*Crear el fichero de departamentos de nombre AleatorioDepart.dat. Los campos de cada registro son: número de departamento(short), nombre (15
        caracteres) localidad (15 caracteres) y número de empleados (short). Los datos para llenar el fichero se toman de arrays que tendrás que crear. La posición
        de cada registro dependerá del número de departamento.
        Después realiza los siguientes metodos:
        CHECKk Metodo que reciba un número de departamento y devuelva true o false indicando si existe o no el registro.
        CHECK! Metodo que reciba un número de departamento y muestre los datos. Si no existe mostrar mensaje indicándolo.
        CHECK!Metodo que actualice el campo número de empleados, debe guardar el número de empleados del fichero AleatorioEmple.dat en ese departamento.
        CHECK! Metodo que reciba un número de departamento, un nombre y una localidad y modifique el nombre y la localidad de ese número de departamento. Si
        no existe mostrar mensaje indicándolo.
        CHECK! Metodo que reciba un número de departamento, un nombre y una localidad y lo inserte en el fichero, siempre y cuando no exista el número de
        departamento.
        CHECK! Metodo que reciba un número de departamento y lo elimine del fichero. El borrado consistirá en almacenar -1 en los campos numéricos y * en las
        cadenas.
        • Metodo que muestre todos los datos de todos los departamentos.
    Puedes realizar los métodos en una clase o varias.
    Probar todos los métodos y comprobar el correcto funcionamiento. Controlar las posibles situaciones de error que puedan ocurrir.*/




    public static void imprimirDepartamenFromNDepart(int i){
        int numRegistro = numDepartToNumRegistro(i);
        if(numRegistro==-1){
            println("No se ha encontrado el departamento "+i);
            println();println();println();
            return;
        }
            imprimirDepartamenFromByte(numRegistroToBytes(numRegistro));
    }
    public static void imprimirDepartamenFromByte(int i){
        if(1<0)println("No se ha podido imprimir el departamento");
        else {
            try {
                ficheroR.seek(i);
                println("Registro num " + bytePositionToNumRegistro());
                println("Cod departamento " + ficheroR.readShort());
                println("Numero empleados " + ficheroR.readShort());
                println("Nombre de departamento " + leerChars((int)ficheroR.getFilePointer(),15));
                println("Ubicación " + leerChars((int)ficheroR.getFilePointer(),15));
                println();
                println();
                println();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void imprimirDepartamenFromNRegistro(int i){
        int puntero= numRegistroToBytes(i);
        imprimirDepartamenFromByte(puntero);
    }
    public static void imprimirAll(){
        try {
            ficheroR.seek(0);
            for (int i = 0;i<fichero.length();i+=bytesRegistro){
                println("Registro num " + bytePositionToNumRegistro());
                println("Cod departamento " + ficheroR.readShort());
                println("Numero empleados " + ficheroR.readShort());
                println("Nombre de departamento " + leerChars((int)ficheroR.getFilePointer(),15));
                println("Ubicación " + leerChars((int)ficheroR.getFilePointer(),15));
                println();
                println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String leerChars(int puntero, int cantidad){
        String response="";
        try {
            ficheroR.seek(puntero);
            for(int i =0; i<cantidad;i++){
                response+=ficheroR.readChar();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response.substring(0,15).trim();
    }

    public static Boolean exist(short numDepartamento){
            for (int i =0;i<fichero.length();i+=bytesRegistro){
                try {
                    ficheroR.seek(i);
                    if(numDepartamento==ficheroR.readShort())return true;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        return false;
    }

    public static boolean registrarNuevoDepartamento(Short numDepartamento, Short numEmpleados, String nombre, String localidad) {
        if (!exist(numDepartamento)) {
            try {
                nombre = String.format("%-" + 15 + "s", nombre);
                localidad = String.format("%-" + 15 + "s", localidad);
                ficheroR.seek(fichero.length());
                ficheroR.writeShort(numDepartamento);
                ficheroR.writeShort(numEmpleados);
                ficheroR.writeChars(nombre.substring(0, 15));
                ficheroR.writeChars(localidad.substring(0, 15));
                return true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
    public static void deleteFromNumDepart(int numDepartamento){
        try {
            int num = numDepartToNumRegistro(numDepartamento);
            if(num==-1){
                println("No se ha encontrado el departamento "+numDepartamento);
                println();println();println();
                return;
            }
            num = numRegistroToBytes(num);
            ficheroR.seek(num);
            ficheroR.writeShort(-1);
            ficheroR.writeShort(-1);
            ficheroR.writeChars("***************".substring(0,15));
            ficheroR.writeChars("***************".substring(0,15));
            println();
            return;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void setnumEmpleadosFromNDepart(int numDepart,int numeEmple){
        int numRegistro = numDepartToNumRegistro(numDepart);
        if(numRegistro==-1){
            println("No se ha encontrado el departamento "+numDepart);
            println();println();println();
            return;
        }
        try {
            int punteroNumEmple= numRegistroToBytes(numRegistro);
            ficheroR.seek(punteroNumEmple);
            println("Numero empleados Original "+ficheroR.readShort());
            ficheroR.seek(punteroNumEmple);
            ficheroR.writeShort(numeEmple);
            ficheroR.seek(punteroNumEmple);
            println("Numero empleados Actualizado "+ficheroR.readShort());
            println();println();println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void setDepart(Short numDepartamento, Short numEmpleados, String nombre, String localidad){
        try {
            int num = numDepartToNumRegistro(numDepartamento);
            if(num==-1){
                println("No se ha encontrado el departamento "+numDepartamento);
                println();println();println();
                return;
            }
            num = numRegistroToBytes(num);
            nombre= String.format("%-" + 15 + "s", nombre);
            localidad= String.format("%-" + 15 + "s", localidad);
            imprimirDepartamenFromByte(num);
            ficheroR.seek(num);
            ficheroR.writeShort(numDepartamento);
            ficheroR.writeShort(numEmpleados);
            ficheroR.writeChars(nombre.substring(0,15));
            ficheroR.writeChars(localidad.substring(0,15));
            println();
            imprimirDepartamenFromByte(num);
            return;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /* public boolean registrarThisNuevoDepartamento(){
        try {
            ficheroR.seek(fichero.length());

            ficheroR.writeShort(this.numDepartamento);
            ficheroR.writeShort(this.numEmpleados);
            ficheroR.writeUTF(this.nombre);
            ficheroR.writeUTF(this.localidad);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/

    public static void cerrarTodo() {
        try {
            ficheroR.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static int numRegistroToBytes(int numRegistro){
        return (bytesRegistro* (numRegistro-1));
    }
    public static int numDepartToNumRegistro (int NumDepart){
        for (int i =0;i<fichero.length();i+=bytesRegistro){
            try {
                ficheroR.seek(i);
                int numeroFich =ficheroR.readShort();
                if(NumDepart==numeroFich){
                    int filePointer=(int)ficheroR.getFilePointer();
                    return (filePointer/bytesRegistro)+1;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return -1;
    }
    public static int bytePositionToNumRegistro(){
        try {
            return (int)ficheroR.getFilePointer()/bytesRegistro;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}