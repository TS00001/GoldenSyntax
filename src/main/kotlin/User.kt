import java.util.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
class User {
    var username: String = ""
    var email: String = ""
    var password: String = ""
    var geburtsdatum: LocalDate? = null
    var guthaben:  Double = 0.0

    companion object {
        val users = mutableListOf<User>()
    }

    fun aufladen(amount: Double) {
        guthaben += amount
        println("✓ Guthaben erfolgreich um $amount Euro aufgeladen. Neues Guthaben: $guthaben Euro")
    }

    fun register(guthaben: Double = 0.0) {
        val scanner = Scanner(System.`in`)

        print("Bitte geben Sie Ihren Benutzernamen ein: ")
        username = scanner.nextLine()

        print("Bitte geben Sie Ihre E-Mail-Adresse ein: ")
        email = scanner.nextLine()

        print("Bitte geben Sie Ihr Passwort ein: ")
        password = scanner.nextLine()

        print("Bitte geben Sie Ihr Geburtsdatum ein (Format: dd.MM.yyyy): ")
        val birthDateStr = scanner.nextLine()
        geburtsdatum = try {
            LocalDate.parse(birthDateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"))
        } catch (e: Exception) {
            null
        }

        if (users.any { it.email == email }) {
            println("✗ Die E-Mail-Adresse ist bereits registriert.")
            return
        }
        if (geburtsdatum == null || LocalDate.now().minusYears(13).isBefore(geburtsdatum)) {
            println("✗ Sie müssen mindestens 13 Jahre alt sein, um sich zu registrieren.")
            return
        }


        users.add(this)
        println("✓ Erfolgreich registriert.")
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


}

