package shop

import produkte.Produkt

class Warenkorb {
    private val items = mutableListOf<Produkt>()

    fun produktHinzu(produkt: Produkt){
        items.add(produkt)
        println("● ${produkt.name} wurde zum Warenkorb hinzugefügt")
    }

    // TODO: shop.Warenkorb wird nicht richtig angezeigt.
    fun warenkorbAnzeigen() {
        var summe = 0.0
        for (produkt in items){
            summe += produkt.preis
        }

        val format = "| %-21s | %5.2f |%n"

        println("+-----------------------+-------+")
        println("| Produktname           | Preis |")
        println("+-----------------------+-------+")
        for (produkt in items) {
            println(String.format(format, produkt.name, produkt.preis))
        }
        println("+-----------------------+-------+")
        println(String.format(format, "Summe", summe))
        println("+-----------------------+-------+")
    }




    fun warenkorbSumme(): Double{
        return items.sumByDouble { it.preis }
    }
}