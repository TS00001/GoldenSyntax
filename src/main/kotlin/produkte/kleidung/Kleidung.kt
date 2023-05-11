package produkte.kleidung

import produkte.Produkt

open class Kleidung(name: String, preis: Double, rezension: String, groesse: Int) : Produkt(name, preis, rezension) {

    open fun groesseWaehlen(): Int? {
        val groesse = listOf(36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46)
        println("Bitte wählen Sie Ihre Schuhgröße: ")
        groesse.forEachIndexed { index, size -> println("${index+1}. $size") }
        val input = readLine()
        return input?.toIntOrNull()?.takeIf { it in 1..groesse.size }
            ?.let { groesse[it-1] }
    }


}