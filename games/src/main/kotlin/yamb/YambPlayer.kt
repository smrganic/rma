package yamb

class YambPlayer(playerNumber: Int, numberOfFields: Int) {

    private var rollCounter: Int = 0
    private val table = YambTable(playerNumber, numberOfFields)

    private lateinit var playerInput: String

    fun takeTurn() {
        DiceManager.resetDice()
        println("Player ${table.getPlayerNumber()} turn!")
        rollCounter = 0
        while (rollCounter < 3) {
            playRoll()
            rollCounter++
        }
        updateScore()
    }

    private fun updateScore() {
        DiceManager.printDiceValues()

        println("What table field do you want to populate?")
        var flag = true
        lateinit var keys: MutableList<String>
        while (flag) {
            println("Available options are: ")
            table.listAvailableOptions()

            playerInput = readLine() ?: ""
            keys = InputParser.parseTable(playerInput)
            if(table.updateScore(keys, DiceManager.getDiceValues()))
                flag = false
        }
    }

    private fun playRoll() {

        DiceManager.rollDice()
        if (rollCounter == 2) return
        DiceManager.printDiceValues()

        println("Roll counter: ${rollCounter + 1}")
        println("Select the dice you wish to lock. (Comma separated).")

        playerInput = readLine() ?: ""
        DiceManager.lockDice(InputParser.parseDiceValues(playerInput))

        println("Select the dice you wish to unlock. (Comma separated).")
        playerInput = readLine() ?: ""
        DiceManager.unlockDice(InputParser.parseDiceValues(playerInput))
    }

    override fun toString(): String {
        return "${table.getPlayerNumber()}" +
                "Score: " +
                "${table.getScore()}"
    }

    fun getScore() = table.getScore()
}