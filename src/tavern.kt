import java.awt.MenuItem
import java.io.File
const val TAVERN_NAME = "Taernyl's Folly"
var playerGold = 10
var playerSilver = 10
var dragonCoin = 5.00
var costDragonCoin = 1.43
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val patronGold = mapOf("Eli" to 10.5, "Mordoc" to 8.0, "Sophie" to 5.5)
val charList = mutableListOf('A', 'B', 'C', 'D', 'E', 'F', 'G')
val intList = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
val uniquePatrons= mutableSetOf<String>()
fun main() {
    val menuList=File("data/tavern-menu-items.txt").readText().split('\n')

    //println(patronList)
    patronList.add(0,"fernando")
    //println(patronList)
    patronList.remove("Eli")
    //println(patronList)
    for (patron in patronList) {
        println("Good evening $patron")
    }
    formatMenu(menuList)
    //val menuData="shandy,Dragon's Breath,5.91"


    /*patronList.forEachIndexed{index,patron->
        println("Good evening $patron you're in ${index+1} line")
        placeHolder(patron,menuList.shuffled().first())
    }
    menuList.forEachIndexed{
        index,item->println("${index+1}: $item")
    }*/
    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons+=name
    }
    println(uniquePatrons)
    var orderCounter = 0
    while(orderCounter<=9){
        placeHolder(uniquePatrons.shuffled().first(),menuList.shuffled().first())
        orderCounter++
    }
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
fun performPurchase(type:String,price: Double,name:String) {
    displayBalance()
    var totalPurse=playerGold+(playerSilver/100.0)
    println("total purse : $totalPurse")
    println("Purchasing item for $price")
    val remainingBalance=totalPurse - price
    println("remaining balance : ${".2f".format(remainingBalance)}")
    var needDragonCoin=price/costDragonCoin
    if(dragonCoin>=needDragonCoin) {
        dragonCoin-=needDragonCoin
        println("Madrigal buys a $name ($type) for $price. remaining ${"%.4f".format(dragonCoin)}")
    }else{
        println("Madrigal don't have the sufficient money")
    }

    if(playerGold>=price){
        println("Madrigal buys a $name ($type) for $price.")
        totalPurse-=price
    }else{
        println("The money of Madrigal is enough, he only have $totalPurse")
    }

    val remainingGold=remainingBalance.toInt()
    val remainingSilver=(remainingBalance%1*10).toInt()
    playerGold =remainingGold
    playerSilver =remainingSilver
    displayBalance()
}
private fun displayBalance(){
    println("Player's purse balance: Gold $playerGold ,silver: $playerSilver")
}
private fun placeHolder(patronName:String,menuData:String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")
    val (type, name, price) = menuData.split(',')
    val message = "$patronName buys a $name ($type) for $price."
    //println(message)
    //performPurchase(type,price.toDouble(),name)
    //performPurchase(type,price.toDouble(),name)
    //performPurchase(type,price.toDouble(),name)
    val phrase=if(name=="Dragon's Breath"){
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    }else{
        "$patronName says: thanks for $name"
    }
    println(phrase)
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