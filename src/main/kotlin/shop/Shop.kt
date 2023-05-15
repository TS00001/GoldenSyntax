package shop
import loginOderRegistrieren
import produkte.Produkt
import produkte.elektronikprodukte.Smartphone
import produkte.elektronikprodukte.Waschmaschiene
import produkte.kleidung.Schuh
import sleep

open class Shop {
    private val produkte = mutableListOf<Produkt>()



    fun produktInWarenkorb(produkt: Produkt){
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
                is Waschmaschiene -> println("""
                    • ${it.name} (Waschmaschine)
                      Preis: ${it.preis} Euro Bewertung: ${it.rezension}
                        
                    """.trimIndent())
                is Smartphone -> println("""
                    • ${it.name} (Smartphone)
                      Preis: ${it.preis} Euro Bewertung: ${it.rezension}
                        
                    """.trimIndent())
                is Schuh -> println("""
                    • ${it.name} (Schuh)
                      Preis: ${it.preis} Euro Bewertung: ${it.rezension}
                        
                    """.trimIndent())
            }
        }
    }


}