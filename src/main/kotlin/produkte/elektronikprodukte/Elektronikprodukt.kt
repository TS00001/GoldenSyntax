package produkte.elektronikprodukte

import produkte.Produkt

open class Elektronikprodukt(name: String, preis: Double, rezension: String, garantie: Boolean) : Produkt(name, preis, rezension) {


    open fun garantie(preis: Double, garantie: Boolean){
        if (garantie){
            var garantiePreis = preis * 5/100
            var preisInklGarantie = preis * 1.05
            println("""
            Die garantie für das produkte.Produkt Kostet $garantiePreis€
            Das produkte.Produkt inklusive Garantie Kostet $preisInklGarantie€
            """.trimIndent())
        }else{
            println("""
            Sie haben sich dafür entschieden keine Garantie zu buchen.
            Das produkte.Produkt wurde zu Ihrem Wahrenkorb hinzugefügt $preis€
            """.trimIndent())
        }
    }




}