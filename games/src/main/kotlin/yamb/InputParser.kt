package yamb

object InputParser {
    private val parsedInput: MutableList<String> = mutableListOf()

    fun parse(playerInput: String): MutableList<String> {
        parsedInput.clear()
        parsedInput.addAll(playerInput.split(",", " ").filter { it != "" })
        return parsedInput
    }

}