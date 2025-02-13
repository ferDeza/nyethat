package com.bignerdranch.nyethack
import Room
import townSquared
import Coordinate
import Direction
fun main() {
    Game.play()
}

object Game{
    private var state=true
    private class gameInput(arg:String?){
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, { "" })
        private fun commandNotFound() = "I'm not quite sure what you're trying to do!"
        fun processCommand()=when (command?.lowercase()) {
            "move"-> move(argument)
            "quit"->quit()
            "map"-> worldMap()
            "ring"-> ring()
         else->commandNotFound()
        }
    }
    private val player = Player("Madrigal")
    private var currentRoom:Room=townSquared()

    init {
        println("Welcome Adventurer")
        player.castFireBall()
    }
    fun play(){
        while(state){
            //Play nyetHat
            println(currentRoom.description())
            println(currentRoom.load())
            //player sTATUS
            printPlayerStatus(player)
            print("> Enter your command: ")
            println(gameInput(readLine()).processCommand())
            if(!state){
                println("Exit")
            }

        }
    }

    private fun quit(){
        println("Quit the application")
        state=false
    }
    private fun printPlayerStatus(player: Player) {
        println("(Aura: ${player.auraColor()}) " +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }
    private var worldMap = listOf(
        listOf(currentRoom, Room("Tavern"), Room("Back Room")),
        listOf(Room("Long Corridor"), Room("Generic Room")))

    private fun move(directionInput: String) =
        try {
            val direction = Direction.valueOf(directionInput.uppercase())
            val newPosition = direction.updateCoordinate(player.currentPosition)
            if (!newPosition.isInBounds) {
                throw IllegalStateException("$direction is out of bounds.")
            }

            val newRoom = worldMap[newPosition.y][newPosition.x]
            player.currentPosition = newPosition
            currentRoom = newRoom
            "OK, you move $direction to the ${newRoom.name}.\n${newRoom.load()}"
        } catch (e: Exception) {
            "Invalid direction: $directionInput."
        }
    private fun worldMap(){
        for(y in worldMap.indices){
            for(x in worldMap[y].indices){
                if(player.currentPosition.x == x && player.currentPosition.y == y){
                    print("O\t")
                }
                else{
                    print("X\t")
                }
            }
            println()
        }
    }
    private fun ring():String=
        if(currentRoom is townSquared){
            (currentRoom as townSquared).ringBell()
        }else{
            "isn't possible ring the bell here"
        }
}
