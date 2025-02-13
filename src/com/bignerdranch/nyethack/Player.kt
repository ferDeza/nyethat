package com.bignerdranch.nyethack
import Coordinate
import java.io.File
class Player(_name:String, var healthPoints:Int=100,
             var isBlessed:Boolean,private val isImmortal:Boolean) {
    //atributes
    val hometown by lazy { selectHometown() }
    var name:String = _name
        get() = "${field.capitalize()} of $hometown"
        private set(value) {
            field = value.trim()
        }
    var currentPosition=Coordinate(0,0)


    init{
        require(healthPoints > 0, { "healthPoints must be greater than zero." })
        require(name.isNotBlank(), { "Player must have a name." })
    }
    constructor(name: String) : this(name,
        isBlessed = true,
        isImmortal = false){
        if (name.lowercase() == "kar") healthPoints = 40
    }

    //class functions
    fun auraColor(): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }
    private fun selectHometown(): String {
        return try {
            File("data/towns.txt")
                .readText()
                .split("\n").map{it.trim()
                }
                .shuffled()
                .first()  // Select a random town from the list
        } catch (e: Exception) {
            "Unknown" // Return "Unknown" if the file is not found or something goes wrong
        }
    }
fun formatHealthStatus() =
        when (healthPoints) {
            100 -> "is in excellent condition!"
            in 90..99 -> "has a few scratches."
            in 75..89 -> if (isBlessed) {
                "has some minor wounds, but is healing quite quickly!"
            } else {
                "has some minor wounds."
            }
            in 15..74 -> "looks pretty hurt."
            else -> "is in awful condition!"
        }


    fun castFireBall(numFireballs:Int=2){
        println("A glass of Fireball springs into existence. (x$numFireballs)")
    }
}
