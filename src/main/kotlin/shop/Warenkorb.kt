package shop

import produkte.Produkt
import user

class Warenkorb {
    private val items = mutableListOf<Produkt>()

    fun produktHinzu(produkt: Produkt){
        items.add(produkt)
        println("✓ ${produkt.name} wurde zum Warenkorb hinzugefügt")
    }

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


    private fun warenkorbLeeren(){
        items.clear()
    }

    fun warenkorbSumme(): Double{
        return items.sumOf { it.preis }
    }

    fun bezahlen(sumWarenkorb: Double, guthaben: Double){
        var guthabenNachKauf = guthaben - (sumWarenkorb)

            if (guthabenNachKauf < 0){
                println("Fehler: Nicht genügend Guthaben auf dem Konto.")

            }else{
                user.guthaben = guthabenNachKauf
                println("""Vielen dank für Ihren Einkauf, 
                |Ihr guthaben beträgt nun $guthabenNachKauf€
                |""".trimMargin())
            }
        warenkorbLeeren()
    }
}