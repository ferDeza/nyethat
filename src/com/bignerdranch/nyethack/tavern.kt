package com.bignerdranch.nyethack
import com.bignerdranch.nyethack.extensions.random as randomizer
import com.bignerdranch.nyethack.extensions.toDragonSpeak
import java.io.File
const val TAVERN_NAME = "Taernyl's Folly"
var dragonCoin = 5.00
var costDragonCoin = 1.43
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val patronGold = mutableMapOf<String,Double>()
val uniquePatrons= mutableSetOf<String>()




fun main() {
    val menuList=File("data/tavern-menu-items.txt").readText().split('\n')
    patronList.remove("Eli")
    for (patron in patronList) {
        println("Good evening $patron")
    }
    uniquePatrons.forEach{
        patronGold[it]=6.0
    }
    formatMenu(menuList)
    (0..9).forEach {
        val first = patronList.randomizer()
        val last = lastName.randomizer()
        val name = "$first $last"
        uniquePatrons +=name
        uniquePatrons.distinct()
    }
    println(uniquePatrons)
    var orderCounter = 0
    while(orderCounter<=9){
        placeHolder(uniquePatrons.randomizer(),menuList.randomizer())
        orderCounter++
    }
    //println(patronGold)
    displayPatronBalance()
}

fun formatMenu(menuList:List<String>){
    var menuItems=mutableListOf<Triple<String,String,Double>>()
    menuList.forEach{items->
        val lines=items.split(',')
        if(lines.size==3){
            val type=lines[0].trim()
            val name=lines[1].trim()
            val price=lines[2].trim().toDouble()
            menuItems.add(Triple(type,name,price))
        }
        }
    println("**** $TAVERN_NAME *****")
    val maxLen=menuItems.maxOf { it.second.length }

    menuItems.forEach{
            (type,name,price)->
        val formatName = name.split(" ").joinToString(" ") { it.capitalize() }
        val priceFormat=String.format("%.2f", price)
        println("\t\t~[$type]~")
        println("${formatName.padEnd(maxLen )} ......... $priceFormat")

    }


}

fun performPurchase(price: Double,patronName: String) {
    val totalPurse = patronGold.getOrDefault(patronName, 0.0)
    patronGold[patronName]=totalPurse-price
}
private fun placeHolder(patronName:String,menuData:String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")
    val (type, name, price) = menuData.split(',')
    val message = "$patronName buys a $name ($type) for $price."
    performPurchase(price.toDouble(),patronName)
    val phrase=if(name=="Dragon's Breath"){
        "$patronName exclaims: ${("Ah, delicious $name!").toDragonSpeak()}"
    }else{
        "$patronName says: thanks for $name"
    }
    println(phrase)
}
private fun displayPatronBalance(){
    patronGold.forEach{ patron, balance->
         println("$patron, balance : ${"%.2f".format(balance)}")
        }
    }
private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiouAEIOU]")) {
        when (it.value) {
            "a","A" -> "4"
            "e","E" -> "3"
            "i","I" -> "1"
            "o","O" -> "0"
            "u","U" -> "|_|"
            else -> it.value
        }
    }