import produkte.elektronikprodukte.Smartphone
import produkte.elektronikprodukte.Waschmaschiene
import produkte.kleidung.Schuh
import shop.Shop

fun main(){
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
    goldenSyntax.produktInWarenkorb(mieleWaschmaschiene)
    goldenSyntax.produktInWarenkorb(siemansWaschmaschiene)
    goldenSyntax.produktInWarenkorb(phillipsWaschmaschiene)
    goldenSyntax.produktInWarenkorb(iPhoneX)
    goldenSyntax.produktInWarenkorb(iPhone10)
    goldenSyntax.produktInWarenkorb(iPhone14Pro)
    goldenSyntax.produktInWarenkorb(iPhone14ProMax)

}