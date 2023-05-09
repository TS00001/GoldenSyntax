// WASCHMASCHIENEN
var mieleWaschmaschiene = Waschmaschiene("Miele 800", 899.90, "★★★★★", randomBoolean(), randomBoolean())
var siemansWaschmaschiene = Waschmaschiene("Siemens 3000", 499.00, "★★★★", randomBoolean(), randomBoolean())
var phillipsWaschmaschiene = Waschmaschiene("Phillips 600", 750.00, "★★", randomBoolean(), randomBoolean())

// SMARTPHONES
var iPhone14Pro = Smartphone("iPhone 14 Pro", 1200.0, "★★★★★", randomBoolean())
var iPhone14ProMax = Smartphone("iPhone 14 Pro Max", 1450.0, "★★★★★", randomBoolean())
var iPhone10 = Smartphone("iPhone 10", 800.0, "★★★", randomBoolean())
var iPhoneX = Smartphone("iPhone X", 700.0, "★★★", randomBoolean())

// SCHUHE
var nikeAirJordanOne = Schuh("Nike Air Jordan One", 220.00, "★★★★★", 40)
var nikeRun = Schuh("Nike Run", 160.00, "★★★★", 40)
var nikeFree = Schuh("Nike Free", 140.00, "★★★", 40)

val goldenSyntax = Shop()
val alleProdukte = listOf(
    mieleWaschmaschiene,
    siemansWaschmaschiene,
    phillipsWaschmaschiene,
    iPhone10,
    iPhoneX,
    iPhone14Pro,
    iPhone14ProMax,
    nikeFree,
    nikeRun,
    nikeAirJordanOne)
fun main(){

    // WILLKOMEN
    welcome()
    //USER REGISTRIERUNG
    // TODO: try catch für falscheingabe einbauen
    val antwort = readln().uppercase()
    val user1 = User()
    if (antwort.equals("JA", ignoreCase = true)) {
        user1.register()
    } else if (antwort.equals("NEIN", ignoreCase = true)) {
        println("Registrierung abgebrochen.")
    } else {
        println("Falsche Eingabe. Bitte antworten Sie mit Ja oder Nein.")
    }
    //GUTHABEN AUFLADEN
    user1.aufladen()


    //ALLE PRODUKTE ANZEIGEN
    goldenSyntax.displayAllProducts(alleProdukte)

    println("Produkte nach Preis absteigend oder Alphabetisch sortiert anzeigen?")
    sortiertNachPreis()
    partingLine()
    filterWaschmaschine()
    partingLine()
    filterSmartphones()
    partingLine()
    filterSchuhe()
}

// TODO: FUNKTIONEN
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



