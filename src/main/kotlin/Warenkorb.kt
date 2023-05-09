class Warenkorb {
    private val items = mutableListOf<Produkt>()

    fun produktHinzu(produkt: Produkt){
        items.add(produkt)
        println("● ${produkt.name} wurde zum Warenkorb hinzugefügt")
    }

    // TODO: Warenkorb wird nicht richtig angezeigt.
    fun warenkorbAnzeigen(): MutableMap<String, Double> {
        // neu map
        var printWarenkorb = mutableMapOf<String, Double>()
        // mit Schleife durch die liste
        for (produkt in items){
        // mit index auf die Produkte zugreifen
            printWarenkorb.set(produkt.name, produkt.preis)
        }
        // gebe neue Liste zurück
        return printWarenkorb
    }

    fun warenkorbSumme(): Double{
        return items.sumByDouble { it.preis }
    }
}