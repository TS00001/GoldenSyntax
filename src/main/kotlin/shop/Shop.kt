package shop

import produkte.Produkt
import produkte.elektronikprodukte.Smartphone
import produkte.elektronikprodukte.Waschmaschiene
import produkte.kleidung.Schuh

open class Shop {
    private val produkte = mutableListOf<Produkt>()

    fun produktHinzu(produkt: Produkt){
        produkte.add(produkt)
        println("✓ ${produkt.name} wurde dem Warenkorb hinzugefügt.")
    }

    fun produkteAnzeigen(): List<Produkt>{
        return produkte.toList()
    }
    //Zeigt ein produkt an.
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

    // Zeigt alle Produkte an
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