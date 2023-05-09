class Schuh(name: String, preis: Double, rezension: String, groesse: Int) : Kleidung(name, preis, rezension, groesse) {

    fun printProdukt() {
        println("""
            ${this.name}
            Preis: $preis €
            Bewertung: $rezension
        """.trimIndent())
    }
}