/*ACTIVIDAD 1.1
Realiza un programa Java que utilice el metodo listFiles() para mostrar la lista de
ficheros en un directorio cualquiera, o en el directorio actual. El directorio lo leemos por
teclado, si no existe mostramos un mensaje indicándolo. Asumimos directorio actual
cuando no introducimos nada por teclado.
Realiza un programa Java que muestre los ficheros de un directorio. El nombre del
directorio se pasará al programa desde los argumentos de main(). Si el directorio no
existe se debe mostrar un mensaje indicándolo. Si el nombre del directorio tiene
espacios en blanco lo encerramos entre comillas, por ejemplo "C:\Program Files"./**/
void main() {
   /* IO.println(String.format("Hello and welcome!"));
    for (int i = 1; i <= 5; i++) {
        IO.println("i = " + i);
    }*/
    try {
        identificarListar(".."+File.separator+"..");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
public static void identificarListar(String directorio) throws IOException {
    File carpeta= new File(directorio);
    if(carpeta.exists()) {
        System.out.println(carpeta.getCanonicalPath());
        listarcarpetasRecursivo(carpeta.getName(), "  ");
    }
}
public static void listarcarpetasRecursivo(String directorio, String identacion)  {
    File carpeta= new File(directorio);
    String [] in;
    if(carpeta.exists()&&carpeta.isDirectory()){
        for (String s : in = carpeta.list()) {
            File file = new File(directorio+File.separator+s);
            if(!file.exists())System.out.println("ERROR: se detectó la ruta "+directorio+" pero no existe");
            else {
                if (file.isFile()) System.out.println(identacion + "     |-" + s);
                else if (file.isDirectory()){
                    System.out.println(identacion + "  |->" + s);
                    listarcarpetasRecursivo(directorio+File.separator+s,identacion+"  |");
                }
                else System.out.println(identacion + "     |-" + s+ "   (WTF no es ni directorio ni archivo)");
            }
        }
        System.out.println(identacion.substring(0, identacion.length() - 1));
    }
}
/*
* |--|>
*    |--
*
* */






