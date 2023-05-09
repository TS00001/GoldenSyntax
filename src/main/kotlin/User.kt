import java.util.*
class User {
    var username: String = ""
    var email: String = ""
    var password: String = ""

    companion object {
        val users = mutableListOf<User>()
    }

    fun register() {
        val scanner = Scanner(System.`in`)

        print("Bitte geben Sie Ihren Benutzernamen ein: ")
        username = scanner.nextLine()

        print("Bitte geben Sie Ihre E-Mail-Adresse ein: ")
        email = scanner.nextLine()

        print("Bitte geben Sie Ihr Passwort ein: ")
        password = scanner.nextLine()

        if (users.any { it.email == email }) {
            println("✗ Die E-Mail-Adresse ist bereits registriert.")
            return
        }
        users.add(this)
        println("✓ Erfolgreich registriert.")
    }

    fun showUsers() {
        if (users.isNotEmpty()) {
            println("Liste aller registrierten Benutzer:")
            for (user in users) {
                println("👤 Benutzername: ${user.username}, E-Mail: ${user.email}")
            }
        } else {
            println("Es sind keine Benutzer registriert.")
        }

    }
}

