package ficherosDeAccesoAleatorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import static java.lang.IO.println;

public class Tema1ManejodeficherosenJavaEj_1_5 {
    /*Crear el fichero de departamentos de nombre AleatorioDepart.dat. Los campos de cada registro son: número de departamento(short), nombre (15
        caracteres) localidad (15 caracteres) y número de empleados (short). Los datos para llenar el fichero se toman de arrays que tendrás que crear. La posición
        de cada registro dependerá del número de departamento.
        Después realiza los siguientes metodos:
        • Metodo que reciba un número de departamento y devuelva true o false indicando si existe o no el registro.
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
    public static void main(String argumentos[]) throws FileNotFoundException {
        if (!departamento.fichero.exists()) {
            try {
                departamento.fichero.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            try {
                departamento.fichero.delete();
                departamento.fichero.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //Los metodos de registro están mal casi seguro porque al leer el shor del puntero 64 devuelve un numero 13423 mientras debería estar escrito 2
        departamento d = new departamento();
        departamento.registrarNuevoDepartamento((short) 1,(short) 23,"RecursosHumanos","Sesena");
        departamento.registrarNuevoDepartamento((short) 2,(short) 325,"Transportes","Madrid");
        departamento.registrarNuevoDepartamento((short) 4,(short) 54,"Publicidad","Barcelona");

        for(int i =1;i<5;i++){
            println("Existe el departamento de código: "+i+" ="+departamento.exist((short)i));
            departamento.imprimirDepartamenFromNDepart(i);
        }
        departamento.setnumEmpleadosFromNDepart(2,50);

        departamento.setDepart((short) 1, (short) 34,"Laturracadelavacapacreroiueriuoierutoieuoitoera","Sara");
        departamento.setDepart((short) 15, (short) 34,"Laturracadelavacapacreroiueriuoierutoieuoitoera","Sara");
        departamento.deleteRegistro(1);
        departamento.imprimirDepartamenFromNRegistro(1);
        departamento.cerrarTodo();
       // departamento.fichero.delete();
    }
}
