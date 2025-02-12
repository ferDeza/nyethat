package com.bignerdranch.nyethack

const val MAX_EXPERIENCE: Int = 5000
fun main() {

    val player = Player()
    //player.name="stragon"
    println(player.name+" The brave")
    player.castFireBall()
    val auraColor = player.auraColor()
    printPlayerStatus(player)
    player.auraColor()
    val karma = (Math.pow(Math.random(), (110 - player.healthPoints) / 100.0) * 20 ).toInt()
    val karmaAura=when(karma){
        in 0..5 ->"RED"
        in  5..10 ->"ORANGE"
        in 10..15->"PURPLE"
        in 15..20 ->"GREEN"
        else -> {"not color now"}
    }
    println("$karma and its color is  $karmaAura")

}

private fun printPlayerStatus(player: Player)
 {
    println(
        "(Aura: ${player.auraColor()})" +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
    )
    println("${player.name} ${player.formatHealthStatus()}")
}

