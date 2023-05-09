fun main(){
    var iPhone14Pro = Smartphone("iPhone 14 Pro", 2000.0, "*****", randomBoolean())
    var iPhone10 = Smartphone("iPhone 10", 800.0, "***", randomBoolean())

    var mieleWaschmaschiene = Waschmaschiene("Miele 800", 899.90, "*****", randomBoolean(), randomBoolean())
    var siemansWaschmaschiene = Waschmaschiene("Siemens 3000", 499.00, "****", randomBoolean(), randomBoolean())
    var phillipsWaschmaschiene = Waschmaschiene("Phillips 600", 750.00, "**", randomBoolean(), randomBoolean())

    var nikeSchuh = Schuh("Nike Air Jordan", 120.00, "★★★★★", 40)


    nikeSchuh.printProdukt()
    val warenkorb = Warenkorb()
    partingLine()
    iPhone10.printProdukt()
    partingLine()
    iPhone14Pro.printProdukt()
    partingLine()
    mieleWaschmaschiene.printProdukt()
    partingLine()
    siemansWaschmaschiene.printProdukt()
    partingLine()
    phillipsWaschmaschiene.printProdukt()
    partingLine()
    println()
    println("WARENKORB")
    warenkorb.produktHinzu(iPhone10)
    garantie(iPhone10.preis, randomBoolean())
    partingLine()
    warenkorb.produktHinzu(iPhone14Pro)
    garantie(iPhone14Pro.preis, randomBoolean())
    partingLine()
    warenkorb.produktHinzu(mieleWaschmaschiene)
    garantie(mieleWaschmaschiene.preis, randomBoolean())

    partingLine()


    println(warenkorb.warenkorbAnzeigen())

    val summeWarenkorb = warenkorb.warenkorbSumme()
    println("Gesamtsumme: $summeWarenkorb")


    partingLine()

    println("SHOP")

    val testShop = Shop()

    testShop.produktHinzu(iPhone10)
    testShop.produktHinzu(iPhone14Pro)
    testShop.produktHinzu(mieleWaschmaschiene)
    testShop.produktHinzu(siemansWaschmaschiene)
    testShop.produktHinzu(phillipsWaschmaschiene)

    partingLine()
    testShop.produktDeails()

    val user1 = User()
    val user2 = User()

    user1.register()
    user2.register()


    user1.showUsers()
}