class Smartphone(name: String, preis: Double, rezension: String, garantie: Boolean) : Elektronikprodukt(name, preis, rezension,
    garantie){

    fun printProdukt() {
        println("""
            ${this.name}
            Preis: $preis €
            Bewertung: $rezension
        """.trimIndent())
    }

    override fun garantie(preis: Double, garantie: Boolean){
        if (garantie){
            var garantiePreis = preis * 5/100
            var preisInklGarantie = preis * 1.05
            println("""
            Die garantie für das Produkt Kostet $garantiePreis€
            Das Produkt inklusive Garantie Kostet $preisInklGarantie€
            """.trimIndent())
        }else{
            println("""
            Sie haben sich dafür entschieden keine Garantie zu buchen.
            Das Produkt wurde zu Ihrem Warenkorb hinzugefügt $preis€
            """.trimIndent())
        }
    }
}