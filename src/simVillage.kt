fun main() {
    val greetingFunction= {playerName:String,building:Int->
        println("adding someone houses : $building")
        val currentYear=2018
        "Welcome to simVillage($playerName) , ( copyright $currentYear)"
    }
    var signatureMissing="Missing signature"
    //signatureMissing=null
    runSimulation()
    val Missipi="missisipi".count{it=='s'}
    println(Missipi)
}
fun runSimulation() {
    val greetingFunction = configureGreetingFunction()
    println(greetingFunction("Guyal"))
    println(greetingFunction("Guyal"))
}

fun printConstructionCost(numBuildings: Int): String {
    val cost = 500
    return "The cost of $numBuildings houses is ${cost * numBuildings}"
}
//This is a configuration factory
fun configureGreetingFunction(): (String) -> String {
    val structureType = "hospitals"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2018
        numBuildings += 1
        println("Adding $numBuildings $structureType")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}