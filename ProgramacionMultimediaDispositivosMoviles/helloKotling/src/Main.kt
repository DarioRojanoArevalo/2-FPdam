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
    println(a);
    val b = a.toByte();
    println(b);
    val b2: Byte = 1 // OK, literals are checked statically
    println(b2)

    val i1: Int = b2.toInt();


    val i2: String = b2.toString();

    val i3: Double = b2.toDouble();
}