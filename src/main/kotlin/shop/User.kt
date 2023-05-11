package shop

import java.util.*
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

open class User(
    var username: String,
    var email: String,
    var password: String,
    var geburtsdatum: LocalDate,
    var guthaben: Double
) {


    companion object {
        val users = mutableListOf<User>()
    }

    fun aufladen() {
        println("Wieviel Euro möchten Sie aufladen?")
        var amount = readln().toDouble()
        guthaben += amount
        println("✓ Guthaben erfolgreich um $amount Euro aufgeladen. Neues Guthaben: $guthaben Euro")
    }

    fun register(): Boolean {
        var diff = 0
        print("Bitte geben Sie Ihren Benutzernamen ein: ")
        username = readln()
        print("Bitte geben Sie Ihre E-Mail-Adresse ein: ")
        email = readln()
        print("Bitte geben Sie Ihr Passwort ein: ")
        password = readln()
        print("Bitte geben Sie Ihr Geburtsdatum ein (Format: dd.MM.yyyy): ")
        val birthDateStr = readln()
        var splittedBirthday = birthDateStr.split('.')
        try {
            val today = LocalDate.now()
            val dayOfBirth =
                LocalDate.of(splittedBirthday[2].toInt(), splittedBirthday[1].toInt(), splittedBirthday[0].toInt())
            diff = Period.between(dayOfBirth, today).years
        } catch (e: Exception) {
            null
        }
        if (users.any { it.email == email }) {
            println("✗ Die E-Mail-Adresse ist bereits registriert.")
            return false
        }
        if (diff < 12) {
            println("✗ Sie müssen mindestens 12 Jahre alt sein, um sich zu registrieren.")
            return false
        }
        users.add(this)
        println("✓ Erfolgreich registriert.")
        return true
    }

    fun showUsers() {
        if (users.isNotEmpty()) {
            println("Liste aller registrierten Benutzer:")
            for (user in users) {
                println("👤 Benutzername: ${user.username}, E-Mail: ${user.email}, Guthaben:${user.guthaben}€")
            }
        } else {
            println("Es sind keine Benutzer registriert.")
        }

    }

    fun printUser() {
        println(
            """
            👤 USERPROFIL
            Username: ${this.username}
            E-Mail: ${this.email}
            Guthaben: ${this.guthaben}     
        """.trimIndent()
        )
    }

    fun login(): Boolean {
        var versuche = 0
        while (versuche < 3) {
            println("Bitte geben Sie ihren Benutzernamen ein:")
            val inputUsername = readln()

            println("Bitte geben Sie Ihr Passwort ein:")
            val inputPasswort = readln()

            if (inputUsername == username && inputPasswort == password) {
                println("""
                    Erfolgreich eingelogt.
                    
                    """.trimIndent())

                return true
            } else {
                versuche++
                println("Falsches Passwort oder Username, versuch es erneut.")
            }
        }
        println("maximum an versuchen erreicht, login fehlgeschlagen.")
        return false
    }
}

