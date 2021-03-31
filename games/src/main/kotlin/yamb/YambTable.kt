package yamb

class YambTable(playerNumber: Int, numberOfFields: Int){
    private val playerResults = HashMap<String, HashMap<String, Int>>()
    init {
        // Consider implementing a builder but not today
        val playerData = HashMap<String, Int>();
        playerData["PlayerNumber"] = playerNumber
        playerData["Total"] = -1

        playerResults["PlayerInfo"] = playerData
        playerResults["Downward"] = generateMap("Downward", numberOfFields)
        playerResults["Upward"] = generateMap("Upward", numberOfFields)
        playerResults["FreeDirection"] = generateMap("FreeDirection", numberOfFields)
        playerResults["Ann"] = generateMap("Ann", numberOfFields)
    }
    private fun generateMap(columnName: String, numberOfFields: Int): HashMap<String, Int> {
        val map = HashMap<String, Int>(numberOfFields)
        map["Ones"] = -1
        map["Twos"] = -1
        map["Threes"] = -1
        map["Fours"] = -1
        map["Fives"] = -1
        map["Sixes"] = -1
        map["Max"] = -1
        map["Min"] = -1
        map["ThreeOfAKind"] = -1
        map["Scale"] = -1
        map["FullHouse"] = -1
        map["Poker"] = -1
        map["Yamb"] = -1
        map["Total"] = -1
        return map
    }

    fun getPlayerNumber(): Int = playerResults["PlayerInfo"]?.get("PlayerNumber") ?: -1
    fun listAvailableOptions() {
        TODO("Not yet implemented")
    }

    fun getScore(): Int = playerResults["PlayerInfo"]?.get("Total") ?: -1
    fun updateScore(keys: MutableList<String>, diceValues: List<String>): Boolean {
        TODO("Not Implemented")
    }
}