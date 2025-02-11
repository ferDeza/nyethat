import java.awt.Color
const val MAX_EXPERIENCE: Int = 5000
fun main() {
    val name = "Madrigal"
    var healthPoints = 40
    val isBlessed=false
    val isInmortal=true
    //in is for range in 10..100 give a range in the value <= and <=
    //when is like switch case for example
    // when(variable){
    // 100->"is value"
    //or in 100..200 inside of the when conditional
    // is possible asignement a variable a when or if and the next condition
    //.......... an other I using -> arrow for the asigment
    //else-> "condition"
    // in 10..100 -> if(condition){
    // }
    // }
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)
    val auraColor = formatAuraColor(isBlessed, healthPoints, isInmortal)
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)
    castFireball()
    1 in 1..3
    (1..3).toList()
    1 in 3 downTo 1
    1 in 1 until 3
    3 in 1 until 3
    2 in 1..3
    2 !in 1..3
    'x' in 'a'..'z'
    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20 ).toInt()
    val karmaAura=when(karma){
        in 0..5 ->"RED"
        in  5..10 ->"ORANGE"
        in 10..15->"PURPLE"
        in 15..20 ->"GREEN"
        else -> {"not color now"}
    }
    println("$karma and its color is  $karmaAura")

}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println(
        "(Aura: $auraColor) " +
                "(Blessed: ${if (isBlessed) "YES" else "NO"})"
    )
    println("$name $healthStatus")
}

private fun formatAuraColor(isBlessed: Boolean, healthPoints: Int, isInmortal: Boolean):String {
    val auraVisible = isBlessed && healthPoints in 50..100 || isInmortal
    val auraColor = if (auraVisible) "Green" else "None"
    return auraColor
}
private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }

        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }

private  fun castFireball (numFireballs:Int=2)=
    println("A glass of Fireball springs into existence. x$numFireballs Fireballs")
