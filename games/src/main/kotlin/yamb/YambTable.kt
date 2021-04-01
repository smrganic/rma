package yamb

data class YambTable(val playerNumber: Int, val numberOfFields: Int) {
    private val playerResults = HashMap<String, HashMap<String, Int>>()

    init {

        // Consider implementing a builder but not today
        // All matchers should be uppercase

        val playerData = HashMap<String, Int>()
        playerData["PlayerNumber"] = playerNumber
        playerData["Total"] = -1

        playerResults["PlayerInfo"] = playerData
        playerResults["Downward"] = generateMap("Downward", numberOfFields)
        playerResults["Upward"] = generateMap("Upward", numberOfFields)
        playerResults["Free"] = generateMap("Free", numberOfFields)
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
        when (columnName) {
            "Downward" -> {
                map["Ones"] = -2
            }
            "Upward" -> {
                map["Yamb"] = -2
            }
            "Free" -> {
                for (item in map) {
                    map[item.key] = -2
                    map["Total"] = -1
                }
            }
        }
        return map
    }

    fun listAvailableOptions() {
        println("What table field do you want to populate?")
        println("Available options are: ")

        playerResults.forEach {
            if (it.key != "PlayerInfo") {
                println("For ${it.key}")
                it.value.forEach { (key, value) ->
                    if (value < 0 && value != -1) println(key)
                }
                println()
            }
        }
    }

    fun getScore(): Int = playerResults["PlayerInfo"]?.get("Total") ?: -1

    fun updateScore(keys: MutableList<String>, diceValues: List<String>): Boolean {
        var counter = 0
        if (keys.isEmpty()) return false
        val map: HashMap<String, Int> = playerResults[keys[0]] ?: return false
        when (keys[0]) {
            "Downward" -> {
                when (keys[1]) {
                    "Ones" -> {
                        diceValues.forEach { if (it == "1") counter++ }
                        map["Ones"] = counter
                        map["Twos"] = -2
                        return true
                    }
                    "Twos" -> {
                        diceValues.forEach { if (it == "2") counter++ }
                        map["Twos"] = counter * 2
                        map["Threes"] = -2
                        return true
                    }
                    "Threes" -> {
                        diceValues.forEach { if (it == "3") counter++ }
                        map["Threes"] = counter * 3
                        map["Fours"] = -2
                        return true
                    }
                    "Scale" -> {
                        when (diceValues.distinct().size) {
                            5 -> {
                                map["Scale"] = 35
                                return true
                            }
                            6 -> {
                                map["Scale"] = 45
                                return true
                            }
                        }
                    }
                    "Max" ->{
                        map["Max"] = diceValues.sumBy { it.toInt() }
                    }
                    "Min" ->{
                        map["Min"] = diceValues.sumBy { it.toInt() }
                    }
                }
            }
            "Upward" -> {
                return true
            }
            "Free" -> {
                return true
            }
            "Ann" -> {
                return true
            }
        }
        return false
    }
}