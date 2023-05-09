open class Produkt(
    val name: String,
    val preis: Double,
    val rezension: String){


    open fun printProdukt(name: String, preis: Double, rezension: String){
        println("""
            ${this.name}
            Preis: ${this.preis} €
            Bewertung: ${this.rezension}
        """.trimIndent())

    }


}