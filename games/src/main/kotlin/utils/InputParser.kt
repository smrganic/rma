package utils

object InputParser {
    private val parsedInput: MutableList<String> = mutableListOf()

    fun parseDice(playerInput: String): MutableList<String> {
        parsedInput.clear()
        parsedInput.addAll(playerInput.split(",", " ").filter { it != "" })
        return parsedInput
    }

    fun parseBlackJack(playerInput: String): Int {
        parsedInput.clear()
        parsedInput.addAll(playerInput.split(",", " ").filter { it != "" })
        if (parsedInput.isEmpty()) return -1
        return parsedInput.elementAt(0).toInt()
    }
}