open class Room(val name:String){
    protected open val dangerLevel=5
    fun description()="Room : $name\n"+"Danger Level : $dangerLevel"
    open fun load()="Nothing much to see here...."
}
open class townSquared:Room("townSquared"){
    override val dangerLevel=super.dangerLevel-3
    private val bellSound="GWONG"
    final override fun load()="The villagers rally and cheer as you enter! ${ringBell()}"
    private fun ringBell()="The bell tower announces your arrival. $bellSound"
}
