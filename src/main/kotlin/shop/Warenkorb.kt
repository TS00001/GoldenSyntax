package shop

import produkte.Produkt

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


    fun warenkorbLeeren(){
        items.clear()
    }

    fun warenkorbSumme(): Double{
        return items.sumByDouble { it.preis }
    }

    fun bezahlen(sumWarenkorb: Double, guthaben: Double){
        var guthabenNachKauf = guthaben - (sumWarenkorb)
            if (guthabenNachKauf < 0){
                println("Fehler: Nicht genügend Guthaben auf dem Konto.")

            }else{
                println("""Vielen dank für Ihren Einkauf, 
                |Ihr guthaben beträgt nun $guthabenNachKauf€
                |""".trimMargin())
            }
        warenkorbLeeren()
    }
}