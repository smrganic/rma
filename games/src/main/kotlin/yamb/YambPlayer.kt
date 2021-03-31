package yamb

class YambPlayer(playerNumber: Int, numberOfFields: Int) {

    private var rollCounter: Int = 0
    private val playersResults = HashMap<String, Int>(numberOfFields)
    private lateinit var playerInput: String
    private var choices: MutableSet<String> = mutableSetOf()

    init {
        playersResults["Player Number"] = playerNumber
        playersResults["Total"] = 0
    }

    fun takeTurn(dice: List<Die>) {
        rollCounter = 0
        while(rollCounter < 3){
            dice.forEach { Die -> Die.roll() }
            printDice(dice)
            getInputs()
            rollCounter++
        }
    }

    private fun printDice(dice: List<Die>) {
        print("Your Roll is: ")
        dice.forEach { Die -> print(Die.state.toString() + " ") }
        println()
    }

    private fun getInputs() {
        println("Select the dice you wish to keep. (Comma separated).")
        playerInput = readLine() ?: ""
        if (playerInput != ""){
            choices.addAll(playerInput.split(",", " ").filter { it != "" })
            choices.forEach { println(it) }
        }
    }

    override fun toString(): String {
        return playersResults["Player Number"].toString() + "Score: " + playersResults["Total"].toString()
    }

    fun getScore(): Int {
        return playersResults["Total"] ?: -1
    }
}