import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import javax.xml.stream.XMLInputFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.IO.println;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Element raiz = new Element("productos");
    // Crear el documento
    static Document document = new Document(raiz);
    // Guardar en un archivo
    static XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());

  static void main() throws IOException {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println(String.format("Hello and welcome!"));
      escribirXMLEjemplo();
      mostrarElementoSubelementos(raiz,"");
      raiz.addContent(new Element("SmartWacht"));
      actualizar();

    }


    public static void mostrarElementoSubelementos (Element elemento,String identacion){
        String identationPlus ="  ";
        println(identacion+identationPlus + elemento.getName());
        println(identacion+identationPlus+identationPlus+"TEXTO:"+elemento.getText().trim());
        List atributos =elemento.getAttributes();
        println(identacion+identationPlus+identationPlus+identationPlus+"ATRIBUTOS:");
        for(int i =0;i<atributos.size();i++){
          println(identacion+identationPlus+identationPlus+identationPlus+atributos.get(i).toString());
        }
        List elementosHijos = elemento.getChildren();
        println(identacion+identationPlus+identationPlus+"Sub-Elementos:");
        for(int i =0;i<elementosHijos.size();i++){
          mostrarElementoSubelementos((Element)elementosHijos.get(i),identacion+identationPlus);
        }
  }

    private static void escribirXMLEjemplo(){
      ArrayList<Element> productos = new ArrayList<Element>();
      productos.add(new Element("Portattil"));
      productos.get(0).setAttribute("id","HP1");
      productos.get(0).setAttribute("precio","10000");
      productos.get(0).setText("Portatil alta gama con capacidad de procesamiento para arruinar tu economía");
      productos.get(0).addContent(new Element("Incluye"));
      productos.get(0).getChild("Incluye").addContent(new Element("Cargador"));
      productos.get(0).getChild("Incluye").addContent(new Element("Lapiz_Táctil"));
      productos.get(0).getChild("Incluye").addContent(new Element("Ratón_Ultimate_Edition"));
      productos.add(new Element("Reloj"));
      productos.add(new Element("Tablet"));
      for (int i =0; i<productos.size();i++) {
        raiz.addContent(productos.get(i));
      }
      System.out.println("Fichero XML creado.");
    }

    private static void eliminarElemento(Element padre, String nombre){
    }
    private static void actualizar(){
      try {
        xmlOutputter.output(document,new FileWriter("Productos.xml"));
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
}

