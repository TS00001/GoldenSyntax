import java.util.*
import kotlin.concurrent.thread

//Diese Funktion berechnet den Preis der garantie (5% vom produktpreis)
fun garantie(preis: Double, garantie: Boolean) {
    if (garantie) {
        var garantiePreis = preis * 5 / 100
        var preisInklGarantie = preis * 1.05
        println(
            """
            Die garantie für das Produkt Kostet $garantiePreis€
            Das Produkt inklusive Garantie Kostet $preisInklGarantie€
            """.trimIndent()
        )
    } else {
        println(
            """
            Sie haben sich dafür entschieden keine Garantie zu buchen.
            Das Produkt wurde zu Ihrem Wahrenkorb hinzugefügt $preis€
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