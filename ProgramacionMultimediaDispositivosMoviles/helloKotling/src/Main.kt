//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    helloKotling();
    varTypes();
}

fun helloKotling() {
    println("Hello from KOTLING, thas ist like java but shorter?")
    println("the compilator translate to java machine and syso has chnaged by print but ln ist the same")
}
fun varTypes(){
    val a: Int=2;
    println("Int (2): "+a);
    val b = a.toByte(); println("Int(2) toByte: "+b);
    val b2: Byte = 1 // OK, literals are checked statically
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
}