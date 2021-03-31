package yamb

class YambPlayer(playerNumber: Int, numberOfFields: Int) {

    private var rollCounter: Int = 0
    private val playersResults = HashMap<String, Int>(numberOfFields)
    private lateinit var playerInput: String

    init {
        // Consider implementing a builder
        playersResults["Player Number"] = playerNumber
        playersResults["Total"] = 0
        playersResults["Poker"] = 0
        playersResults["Yamb"] = 0
        playersResults["Full House"] = 0
    }

    fun takeTurn() {
        DiceManager.resetDice()
        println("Player ${playersResults["Player Number"]} turn!")
        rollCounter = 0
        while (rollCounter < 3) {
            playRoll()
            rollCounter++
        }

    }

    private fun playRoll() {

        DiceManager.rollDice()
        DiceManager.printDiceValues()

        println("Roll counter: ${rollCounter + 1}")
        println("Select the dice you wish to lock. (Comma separated).")

        playerInput = readLine() ?: ""
        DiceManager.lockDice(InputParser.parse(playerInput))

        println("Select the dice you wish to unlock. (Comma separated).")
        playerInput = readLine() ?: ""
        DiceManager.unlockDice(InputParser.parse(playerInput))
    }

    override fun toString(): String {
        return playersResults["Player Number"].toString() + "Score: " + playersResults["Total"].toString()
    }

    fun getScore() = playersResults["Total"] ?: -1
}