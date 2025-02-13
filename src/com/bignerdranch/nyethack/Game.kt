package com.bignerdranch.nyethack

import Room
import townSquared

const val MAX_EXPERIENCE: Int = 5000
fun main() {
    Game.play()
}

object Game{
    private val player = Player("Madrigal")
    private val currentRoom:Room=townSquared()

    init {
        println("Welcome Adventurer")
        player.castFireBall()
    }
    fun play(){
        while(true){
            //Play nyetHat
            println(currentRoom.description())
            println(currentRoom.load())
            //player sTATUS
            printPlayerStatus(player)
            print("> Enter your command: ")
            println("Last command: ${readLine()}")
        }
    }
    private fun printPlayerStatus(player: Player) {
        println("(Aura: ${player.auraColor()}) " +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }

}
