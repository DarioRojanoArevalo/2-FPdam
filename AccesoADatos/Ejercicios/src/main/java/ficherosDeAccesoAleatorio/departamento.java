package ficherosDeAccesoAleatorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import static java.lang.IO.println;
/*Crear el fichero de departamentos de nombre AleatorioDepart.dat. Los campos de cada registro son: número de departamento(short), nombre (15
    caracteres) localidad (15 caracteres) y número de empleados (short). Los datos para llenar el fichero se toman de arrays que tendrás que crear. La posición
    de cada registro dependerá del número de departamento.
    Después realiza los siguientes metodos:
    CHECK• Metodo que reciba un número de departamento y devuelva true o false indicando si existe o no el registro.
    • Metodo que reciba un número de departamento y muestre los datos. Si no existe mostrar mensaje indicándolo.
    • Metodo que actualice el campo número de empleados, debe guardar el número de empleados del fichero AleatorioEmple.dat en ese departamento.
    • Metodo que reciba un número de departamento, un nombre y una localidad y modifique el nombre y la localidad de ese número de departamento. Si
    no existe mostrar mensaje indicándolo.
    • Metodo que reciba un número de departamento, un nombre y una localidad y lo inserte en el fichero, siempre y cuando no exista el número de
    departamento.
    • Metodo que reciba un número de departamento y lo elimine del fichero. El borrado consistirá en almacenar -1 en los campos numéricos y * en las
    cadenas.
    • Metodo que muestre todos los datos de todos los departamentos.
Puedes realizar los métodos en una clase o varias.
Probar todos los métodos y comprobar el correcto funcionamiento. Controlar las posibles situaciones de error que puedan ocurrir.*/

public class departamento {
    public static File fichero = new File("AleatorioDepart.dat");
    public static RandomAccessFile ficheroR;
    private static int bytesRegistro=(2*2)+((2*15)*2);


    Short numDepartamento, numEmpleados;
    String nombre, localidad;//15 caracteres

    public departamento(Short numDepartamento, Short numEmpleados, String nombre, String localidad) throws FileNotFoundException {
        this.localidad=localidad.substring(0,15);
        this.nombre = nombre.substring(0,15);
        this.numEmpleados=numEmpleados;
        this.ficheroR =new RandomAccessFile(fichero.getName(),"rw");
    }
    public departamento() throws FileNotFoundException {this.ficheroR =new RandomAccessFile(fichero.getName(),"rw");}
    public static void imprimirDepartamentoNDepart(int i){
        int numRegistro = numDepartToNumRegistro(i);
        if(numRegistro==-1){
            println("No se ha encontrado el departamento "+i);
            return;
        }
        try {
            ficheroR.seek(registroToBytes(numRegistro));
            println("Registro num "+i);
            println("Cod departamento "+ficheroR.readShort() );
            println("Nombre de departamento "+ficheroR.readUTF());
            println("Ubicación "+ficheroR.readUTF());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    public static boolean registrarNuevoDepartamento(Short numDepartamento, Short numEmpleados, String nombre, String localidad){
        try {
            nombre= String.format("%-" + 15 + "s", nombre);
            localidad= String.format("%-" + 15 + "s", localidad);
            println("Colocamos puntero en "+fichero.length());
            ficheroR.seek(fichero.length());
            println("Tamño del fichero es "+ fichero.length());
            println("Escribimos");
            ficheroR.writeShort(numDepartamento);

            println("*"+numDepartamento+"*");
            println("Tamño del fichero es "+ fichero.length());
            ficheroR.writeShort(numEmpleados);
            println("*"+numEmpleados+"*");
            println("Tamño del fichero es "+ fichero.length());
            ficheroR.writeUTF(nombre);
            println("*"+nombre+"*" +nombre.length());
            println("Tamño del fichero es "+ fichero.length());
            ficheroR.writeUTF(localidad);
            println("*"+localidad+"*" +localidad.length());println("Tamño del fichero es "+ fichero.length());
            println();
            println("El puntero finaliza en " + ficheroR.getFilePointer()+" y el tamño del fichero es "+ fichero.length());
            println();println();println();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void cerrarTodo() {
        try {
            ficheroR.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean registrarThisNuevoDepartamento(){
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
    }

    private static int registroToBytes(int numRegistro){
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

}