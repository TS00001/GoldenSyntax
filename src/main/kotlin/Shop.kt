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

    fun displayAllProducts(products: List<Produkt>) {
        println("Gesamtes Sortiment:")
        products.forEach {
            when (it) {
                is Waschmaschiene -> println("- ${it.name} Bewertung: ${it.rezension} Preis: (${it.preis} Euro)")
                is Smartphone -> println("- ${it.name} Bewertung: ${it.rezension} Preis: (${it.preis} Euro)")
                is Schuh -> println("- ${it.name} Bewertung: ${it.rezension} Preis: (${it.preis} Euro)")
            }
        }
    }


}