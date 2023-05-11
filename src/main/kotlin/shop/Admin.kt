package shop

class Admin (
    private var username: String,
    private var password: String,){
    fun adminLogin(admin: Admin): Boolean {
        var versuche = 3
        while (versuche > 0) {
            print("Benutzername: ")
            val username = readln()
            print("Passwort: ")
            val password = readln()

            if (username == admin.username && password == admin.password) {
                println("Anmeldung erfolgreich.")
                return true
            } else {
                versuche--
                println("Ungültige Anmeldeinformationen. Versuche übrig: $versuche")
            }
        }
        println("Anmeldung fehlgeschlagen.")
        return false
    }


}
