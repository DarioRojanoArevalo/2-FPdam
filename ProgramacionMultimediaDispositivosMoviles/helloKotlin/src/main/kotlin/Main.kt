import java.io.File
import java.util.Date

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    helloKotling();
    //varTypes();
    //condicionales();
    bucles();


    //Los rangos y progresiones me parecen una shit mu gorda
    /*val rango: IntRange = (1 .. 2)
    val progresion: IntProgression=(9 downTo 1 step 2)
    val varName: CharProgression = ('a'..'z' step 3)
    val vari: OpenEndRange<String> = "Anton" ..< "Zacarias";*/
}

fun helloKotling() {
    println("Hello from KOTLING, thas ist like java but shorter?")
    println("the compilator translate to java machine and syso has chnaged by print but ln ist the same")
}
fun varTypes(){
    val a: Int=2;
    println("Int (2): "+a);
    val b = a.toByte(); println("Int(2) toByte: "+b);
    val b2: Byte = 0 // OK, literals are checked statically
    println("Byte (1): "+b2)

    val i1: Int = b2.toInt(); println("Byte (1) to int: "+i1)

    val i2: String = b2.toString(); println("Byte (1) to String: "+i2)

    val i3: Double = b2.toDouble(); println("Byte (1) to Double "+i3)
    /********************************************************************************
     *
     *      Existen varios prefijos y sufijos que le indican al compilador que un
     *      número esta expresado en una formato u otro o que debe almacenarse en
     *      un tipo concreto de variable. Estos son:
     *      0x (prefijo) indica que se trata de un numero hexadecimal
     *      0b (prefijo) indica que se trata de un numero binario
     *      L (sufijo) indica que es un numeor de tipo Long.
     *      No termino de entender la utilidad de esto puesto que aquí los harcodean.
     *
     ********************************************************************************/
    val oneMillion = 1_000_000; println("Million: "+oneMillion)
    val socialSecurityNumber = 999_99_9999L; println("Social Security Number "+socialSecurityNumber)
    val bytes = 0b11010010_01101001_10010100_10010010; println("bytes: "+bytes)
    val string1: String= "Hello_Kotling";
    val string2= "Hello_Kotling";
    println(""); println("Parece que podemos escribir nueros hexadecimales si lo indicamos conmenzando con 0x");
    val hex: Long= 0xFF_EC_DE_5E; println("Hexbyte tipado: "+ hex);
    val hexBytes = 0xFF_EC_DE_5E; println("hexBytes autotipado: "+hexBytes)
    println("")

    val CharComillaSimple: Char ='A'; println(CharComillaSimple);
    val stringdollar="hemos ganado $oneMillion \\ \$oneMillion"; println(stringdollar);
    val stringSuma = "Two Milions ${oneMillion*2}"; println(stringSuma)

    var money: Int=65;
    val price: Int=50;
    var suficiente: Boolean=true;
    println("Tienes $money, Cuesta $price")
    suficiente= money>=price;
    if(suficiente) {
        println("Lo has comprado por $price y te queda ${money - price}")
        money-=price;
    }
    else println("No tienes suficiente, te faltan ${price-money}")
    println("Tienes $money, Cuesta $price")
    var sucesion:  IntRange= 1..100;

    println(sucesion)
    if(money in sucesion) println("Tienes dinero entre $sucesion")

    when(money){
        0 -> println("Sin dinero");
        in 0..30 -> println("Tienes dinero");

    }
    var fishFoodTreats: Int? =null;
    println(fishFoodTreats);
    fishFoodTreats = fishFoodTreats?.dec() ?: 0
    println(fishFoodTreats)
    fishFoodTreats = fishFoodTreats!!.dec()
    println(fishFoodTreats)
    println("El códio se detiene si el valor es nulo y en caso de que no quieras poner el ? no te deja ya que el valor es nullable")
    println("")
    println("")

    val listaFija: List<Any> = listOf(1,2,3,4,5,"seis","siete",true, false, File(""),true);
    val listaFijaints: List<Int> = listOf(1,2,3,4,5);
    println(listaFija)
    println(listaFija[6])
    println("Tamño de la lista fija "+listaFija.size)
    println("")

    val listaCambiante: Array<Any> = arrayOf(1, 2, 3, 4, 5 , true, false)
    val listaCambianteints: Array<Int> = arrayOf(1, 2, 3, 4, 5 /*, "seis"*/)
    //las listas se pueden imprimir directamente, los arrays no
    println(listaCambianteints);
    //al poner una any hay que catear esto también era así en java, interesante
    listaCambiante[4]=listaCambiante[4].toString()+"Cambiado"
    println(listaCambianteints[4])
    println("Tamaño de la lista cambiante ${listaCambiante.size} ")
    println("")

    val listaDinamica: MutableList<Any> = mutableListOf(1, 2, 3, 4, "seis")
    val listaDinamicaints: MutableList<Int> = mutableListOf(1,2,3,4);
    println(listaDinamica)
    listaDinamica[4] =listaDinamica[4].toString() + "cambiado"
    println(listaDinamica[4])
    println("Tamaño original lista dinamica ${listaDinamica.size}")
    listaDinamica.add("one more element")
    println("Tamaño actualizado lista dinamica ${listaDinamica.size}")
    println("")
    //MI conclusión el array se ha vuelto lo más inutil y lo mejor ahora son los mutable List


}
fun bucles(){
    var nums =listOf(1,2,3)
    var cadenas = arrayOf("Uno","dos","tres")
    var gg = mutableListOf("1","2","3","4","5","6","7","8","9");
    var bb = (2..10 step 2);
    println("");
    println("El for para recorrer un aray se hace con el nombre de la variable que será el valor del array e in.array EJ: for(i in nums) ")
    for(i in nums){
        print(i)
    }
    println("");
    println("Para acceder a los indices se usa el elemento .indices");
    for(i in nums.indices){
        print(i)
    }
    println()
    println("Para que devuelva tanto el valor como el índice se usa usamos la función WithIndex ej for((indice,valor) in nums.withIndex()) ")
    for((i,e) in nums.withIndex()){
        print("$e$i ")
    }
    println("")
    println("Es igual para todos los tipos de array, listas y progresiones")
    for((i,e) in cadenas.withIndex()){
        print("$e$i ")
    }
    println("")
    for((i,e) in gg.withIndex()){
        print("$e$i ")
    }
    println("")
    for((i,e) in bb.withIndex()){
        print("$e$i ")
    }
println()
    println("Los while y do While son iguales a java")
    var bubbles = 0

    while (bubbles < 5) {
        bubbles++
        print("$bubbles bubbles in the water  " )
    }
    println()
    while (true) {
        bubbles++
        print("$bubbles bubbles in the water  " )
        if(bubbles>=7) break
    }
    println()
    do {
        print("$bubbles bubbles in the water  " )
        bubbles--
    } while (bubbles > 3)
 println("")
    println("\n Además del While contamos con repeat una estructura que enbucla un numero determinado de veces EJ:repeat(2) ")
    repeat(2) {
        println("A fish is swimming")
    }
}
fun condicionales(){
    println("Tanto if, else if y else se escriben y usan como en java : ")
    if(false)print("IF ");
    else if(false)print("ELSE IF ");
    else print("ELSE ");
    println("");
    {
        var temp =1;
        when(temp){
            (1) ->{print("En cambio swicht ha sido sustituido por when. ")}
            in (1..10) ->{print("Podemos hacer que se ejecuten varias opciones con Rangos")};
            in arrayOf(1,18,13) -> {print("Así como listas y arrays")}
        }
    }
    when {
        (true)->{println("También se puede poner una when de opciones sin varibale comparativa fija")}
        (true||false)->{println("Del mismo modo podemos encadenar opciones usando ||"); println("")}
    }

}