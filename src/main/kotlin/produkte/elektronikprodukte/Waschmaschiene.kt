package produkte.elektronikprodukte

open class Waschmaschiene(name: String, preis: Double, rezension: String, garantie: Boolean, var install: Boolean) : Elektronikprodukt(name, preis, rezension,
    garantie){



    override fun garantieverlaengerung(preis: Double, garantie: Boolean) {
        super.garantieverlaengerung(preis, garantie)
    }
    fun printProdukt() {
        println("""
            ${this.name}
            Preis: $preis €
            Bewertung: $rezension
        """.trimIndent())
    }

    open fun setupWaschmaschiene(preis: Double, setup: Boolean){
        if (setup){
            var setupPreis = 50
            var preisInklSetup = preis + 50
            println("""
            Die Installation für Ihre produkte.elektronikprodukte.Waschmaschiene Kostet $setupPreis€
            Die produkte.elektronikprodukte.Waschmaschiene Inkl. Installation Kostet $preisInklSetup€
            """.trimIndent())
        }else{
            println("""
            Wir liefern Ihre produkte.elektronikprodukte.Waschmaschiene innerhalb 3 Werktagen.
            """.trimIndent())
        }
    }
}

