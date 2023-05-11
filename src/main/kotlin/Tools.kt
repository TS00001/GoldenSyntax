import produkte.elektronikprodukte.Smartphone
import produkte.elektronikprodukte.Waschmaschiene
import produkte.kleidung.Schuh
import java.lang.Exception
import java.lang.IndexOutOfBoundsException
import java.lang.NumberFormatException
import java.util.*

//Diese Funktion berechnet den Preis der garantie (5% vom produktpreis)
fun garantie(preis: Double, garantie: Boolean) {
    if (garantie) {
        var garantiePreis = preis * 5 / 100
        var preisInklGarantie = preis * 1.05
        println(
            """
            Die garantie für das produkte.Produkt Kostet $garantiePreis€
            Das produkte.Produkt inklusive Garantie Kostet $preisInklGarantie€
            """.trimIndent()
        )
    } else {
        println(
            """
            Sie haben sich dafür entschieden keine Garantie zu buchen.
            Das produkte.Produkt wurde zu Ihrem Wahrenkorb hinzugefügt $preis€
            """.trimIndent()
        )
    }
}

fun randomBoolean(): Boolean {
    val random = Random()
    return random.nextBoolean()
}

fun partingLine() {
    println("-_-_-_-_-_-_-_-_-_-_-")
}

fun sleep(i: Long) {
    Thread.sleep(i)
}
fun welcome(){
    println("Herzlich willkommen bei Golden Syntax")
    sleep(1000)
    println("Bevor Sie bei uns einkaufen können müssen Sie sich Registrieren oder einloggen.")
    sleep(1000)
    loginOderRegistrieren()
    sleep(500)
}




//MENÜS
fun hauptmenue() {
    var auswahl: Int
    do {
        println("Was möchten Sie tun?")
        partingLine()
        println("1. Profil anzeigen")
        println("2. Guthaben aufladen")
        println("3. Sortiment anzeigen")
        println("4. Produkte nach Preis sortieren")
        println("5. Produkte alphabetisch sortieren")
        println("6. Produkte nach Klasse filtern")
        println("7. Produkte kaufen")
        println("8. Warenkorb anzeigen")
        println("9. Bezahlen")
        println("10. Programm beenden")
        print("Auswahl: ")
        try {
            auswahl = readln().toInt()
        } catch (ex: Exception) {
            auswahl = 0
        }
        when (auswahl) {
            1 -> user.printUser()
            2 -> user.aufladen()
            3 -> goldenSyntax.displayAllProducts(alleProdukte)
            4 -> sortiertNachPreis()
            5 -> sortiertNachNamen()
            6 -> {
                filterSchuhe()
                filterSmartphones()
                filterWaschmaschine()
            }
            7 -> produktKaufen()
            8 -> warenkorb.warenkorbAnzeigen()
            9 -> warenkorb.bezahlen(warenkorb.warenkorbSumme(), user.guthaben)
            10 -> println("Programm wird beendet...")
            else -> println("Ungültige Eingabe, bitte wählen Sie erneut.")
        }
    } while (auswahl != 10)
}
fun loginOderRegistrieren() {
    var auswahl: Int
    var loggedIn = false
    do {
        println("1. Login")
        println("2. Registrieren")
        println("3. Programm beenden")
        print("Auswahl: ")
        try {
            auswahl = readln().toInt()
        } catch (ex: Exception) {
            auswahl = 0
        }
        when (auswahl) {
            1 ->{
                loggedIn = user.login()
                if (loggedIn == true){
                    auswahl = 3
                }
            }
            2 -> user.register()
            3 -> println("Programm wird beendet...")
            else -> println("Ungültige Eingabe, bitte wählen Sie erneut.")
        }
    } while (auswahl != 3)
    if (loggedIn == true){
        hauptmenue()
    }
}

fun loginOderRegistrieren1() {
    var auswahl: Int
    var loggedIn = false
    do {
        println("1. Login")
        println("2. Registrieren")
        println("3. Programm beenden")
        print("Auswahl: ")
        try {
            auswahl = readln().toInt()
        } catch (ex: Exception) {
            auswahl = 0
        }
        when (auswahl) {
            1 ->{
                loggedIn = user.login()
                if (loggedIn == true){
                    auswahl = 3
                }
            }
            2 -> user.register()
            3 -> println("Programm wird beendet...")
            else -> println("Ungültige Eingabe, bitte wählen Sie erneut.")
        }
    } while (auswahl != 3)
    if (loggedIn == true){
        hauptmenue()
    }
}


//SORTIERFUNKTIONEN
fun sortiertNachNamen(){
    println("Alle Produkte sortiert nach Namen:")
    val sortiertNachNamen = alleProdukte.sortedBy { it.name }
    sortiertNachNamen.forEach{
        println("- ${it.name}: ${it.preis}€")
    }
}
fun sortiertNachPreis(){
    println("Alle Produkte sortiert nach Preis:")
    val sortiertNachPreis = alleProdukte.sortedBy { it.preis }
    sortiertNachPreis.forEach{
        println("- ${it.name}: ${it.preis}€")
    }
}

//FILTERFUNKTIONEN
fun filterWaschmaschine(){
    val waschmaschinen = alleProdukte.filterIsInstance<Waschmaschiene>()
    println("WASCHMASCHINEN:")
    waschmaschinen.forEach {
        println("""
            |- ${it.name}: ${it.preis}€
            |  Bewertung: ${it.rezension}
            |""".trimMargin())
    }

}
fun filterSmartphones(){
    val smartphone = alleProdukte.filterIsInstance<Smartphone>()
    println("SMARTPHONES:")
    smartphone.forEach {
        println("""
            |- ${it.name}: ${it.preis}€
            |  Bewertung: ${it.rezension}
            |""".trimMargin())
    }

}
fun filterSchuhe(){
    val schuh = alleProdukte.filterIsInstance<Schuh>()
    println("SCHUHE:")
    schuh.forEach {
        println("""
            |- ${it.name}: ${it.preis}€
            |  Bewertung: ${it.rezension}
            |""".trimMargin())
    }

}

fun produktKaufen(){
    var erfolg: Boolean = false
    while (!erfolg) {
        println("Wählen Sie eines unserer Produkte:")
        for (i in alleProdukte.indices){
            println("Wählen Sie [$i] für ${alleProdukte[i]}")
        }
        try {
            var eingabe: String = readln()
            var index: Int = eingabe.toInt()
            val gewaehltesProdukt = alleProdukte[index]
            warenkorb.produktHinzu(gewaehltesProdukt)
            erfolg = true
        }catch (ex: Exception){
            if (ex is NumberFormatException){
                println("Sie müssen eine Zahl eingeben.")
            }else if (ex is IndexOutOfBoundsException){
                println("Die eingegebene Zahl mus zwischen 0 und ${alleProdukte.size-1} liegen.")
            }
        }
    }
    println("Möchten Sie weiter einkaufen?")
}