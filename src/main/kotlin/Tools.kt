import produkte.elektronikprodukte.Smartphone
import produkte.elektronikprodukte.Waschmaschiene
import produkte.kleidung.Schuh
import java.lang.Exception
import java.lang.IndexOutOfBoundsException
import java.lang.NumberFormatException
import java.util.*

//WILLKOMEN
    //startet die app
fun welcome(){
    println("Herzlich willkommen bei Golden Syntax")
    sleep(1000)
    println("Bevor Sie bei uns einkaufen können müssen Sie sich Registrieren oder einloggen.")
    sleep(1000)
    loginOderRegistrieren()
    sleep(500)
}

//Gibt einen random Boolean zurück
fun randomBoolean(): Boolean {
    val random = Random()
    return random.nextBoolean()
}

//MENÜS
    //Landingpage Menü
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
                loggedIn = user.userLogin()
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

    //Hauptmenü
fun hauptmenue() {
    var auswahl: Int
    do {
        println("HAUPTMENÜ")
        println("Bitte wähle 1-10 und bestätige mit enter:")
        println("1. Profil anzeigen")
        println("2. Guthaben aufladen")
        println("3. Sortiment anzeigen")
        println("4. Produkte nach Preis sortieren")
        println("5. Produkte alphabetisch sortieren")
        println("6. Produkte nach Klasse filtern")
        println("7. Produkte kaufen")
        println("8. Warenkorb anzeigen")
        println("9. Bezahlen")
        println("10. Logout")
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
            10 -> println("Sie sind jetzt ausgeloggt...")
            else -> println("Ungültige Eingabe, bitte wählen Sie erneut.")
        }
    } while (auswahl != 10)
}


//SORTIERFUNKTIONEN
    //sortiert nach Alphabet
fun sortiertNachNamen(){
    println("↓ ALLE PRODUKTE ALPHABETISCH SORTIERT:")
    val sortiertNachNamen = alleProdukte.sortedBy { it.name }
    sortiertNachNamen.forEach{
        println("""
            • ${it.name} 
              ${it.preis}€ Bewertung: ${it.rezension}
                
            """.trimIndent())
    }
}
    //Sortiert nach Preis
fun sortiertNachPreis(){
    println("↓ ALLE PRODUKTE SORTIERT NACH DEM PREIS:")
    val sortiertNachPreis = alleProdukte.sortedBy { it.preis }
    sortiertNachPreis.forEach{
        println("""
            • ${it.name} 
              ${it.preis}€ Bewertung: ${it.rezension}
                
            """.trimIndent())

    }
}


//FILTERFUNKTIONEN
    //zeigt alle Waschmaschinen
fun filterWaschmaschine(){
    val waschmaschinen = alleProdukte.filterIsInstance<Waschmaschiene>()
    println("WASCHMASCHINEN:")
    waschmaschinen.forEach {
        println("""
            |• ${it.name}: ${it.preis}€
            |  Bewertung: ${it.rezension}
            |""".trimMargin())
    }

}
    //Zeigt alle Smartphones
fun filterSmartphones(){
    val smartphone = alleProdukte.filterIsInstance<Smartphone>()
    println("SMARTPHONES:")
    smartphone.forEach {
        println("""
            |• ${it.name}: ${it.preis}€
            |  Bewertung: ${it.rezension}
            |""".trimMargin())
    }

}

    //Zeigt alle Schuhe
fun filterSchuhe(){
    val schuh = alleProdukte.filterIsInstance<Schuh>()
    println("SCHUHE:")
    schuh.forEach {
        println("""
            |• ${it.name}: ${it.preis}€
            |  Bewertung: ${it.rezension}
            |""".trimMargin())
    }

}


    //Diese Funktion zeigt mir eine Liste mit allen Produkten an, die zum kauf zur verfügung stehen an.
fun produktKaufen(){
    var erfolg: Boolean = false
    while (!erfolg) {
        println("WÄHLEN SIE EINES UNSERER PRODUKTE:")
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
    println()
}

    //Diese Funktion berechnet den Preis der garantie (5% vom produktpreis)
    //Leider konnte ich diese funktion noch nicht richtig in meine Main einbauen.
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


    //Trenner
fun partingLine() {
    println("-_-_-_-_-_-_-_-_-_-_-")
}

    //Sleep mit parameter bei der ich die dauer in Millisekunden eingeben kann
fun sleep(i: Long) {
    Thread.sleep(i)
}