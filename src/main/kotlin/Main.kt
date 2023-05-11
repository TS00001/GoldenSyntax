import produkte.elektronikprodukte.Smartphone
import produkte.elektronikprodukte.Waschmaschiene
import produkte.kleidung.Schuh
import shop.Shop
import shop.User
import shop.Warenkorb
import java.lang.Exception
import java.lang.IndexOutOfBoundsException
import java.lang.NumberFormatException
import java.time.LocalDate

// WASCHMASCHIENEN
var mieleWaschmaschiene = Waschmaschiene("Miele 800", 899.90, "★★★★★", randomBoolean(), randomBoolean())
var siemansWaschmaschiene = Waschmaschiene("Siemens 3000", 499.00, "★★★★", randomBoolean(), randomBoolean())


// SMARTPHONES
var iPhone14Pro = Smartphone("iPhone 14 Pro", 1200.0, "★★★★★", randomBoolean())
var iPhone14ProMax = Smartphone("iPhone 14 Pro Max", 1450.0, "★★★★★", randomBoolean())
var iPhone10 = Smartphone("iPhone 10", 800.0, "★★★", randomBoolean())


// SCHUHE
var nikeAirJordanOne = Schuh("Nike Air Jordan One", 220.00, "★★★★★", 40)
var nikeRun = Schuh("Nike Run", 160.00, "★★★★", 40)

var warenkorb = Warenkorb()
val goldenSyntax = Shop()
val alleProdukte = listOf(
    mieleWaschmaschiene,
    siemansWaschmaschiene,
    iPhone10,
    iPhone14Pro,
    iPhone14ProMax,
    nikeRun,
    nikeAirJordanOne)
var user = User("Tom", "info@tom.de", "123", LocalDate.of(1986,3,10), 1000.0)
fun main(){
    welcome()
}








