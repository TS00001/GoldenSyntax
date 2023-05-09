class Shop {
    private val produkte = mutableListOf<Produkt>()

    fun produktHinzu(produkt: Produkt){
        produkte.add(produkt)
        println("✓ ${produkt.name} wurde dem Shop hinzugefügt.")
    }

    fun produkteAnzeigen(): List<Produkt>{
        return produkte.toList()
    }

    fun produktDeails(){
        println("Alle verfügbaren Produkte:")
        produkte.forEach{
            println("""
                 ● ${it.name} | Preis: ${it.preis}€
                   Bewertung: ${it.rezension}
                   -_-_-_-_-_-_-_-_-_-_-
                 """.trimIndent())
        }
    }
}