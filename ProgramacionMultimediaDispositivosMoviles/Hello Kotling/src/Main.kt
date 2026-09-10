//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    /*val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, " + name + "!")

    for (i in 1..5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        println("i = $i")
    }*/
    helloKotling();
    varTypes();
}

fun helloKotling() {
    println("Hello from KOTLING, thas ist like java but shorter?")
    print("the compilator translate to java machine and syso has chnaged by print but ln ist the same")
}
fun varTypes(){
    val a: Int=2;
    print(a);
    val b = a.toByte();
    print(b);
    val b2: Byte = 1 // OK, literals are checked statically
    println(b2)

    val i1: Int = b2.toInt();


    val i2: String = b2.toString();

    val i3: Double = b2.toDouble();
}