package yamb

import utils.InputParser

class YambPlayer(playerNumber: Int, numberOfFields: Int) {

    private var rollCounter: Int = 0
    private val table = YambTable(playerNumber, numberOfFields)

    private lateinit var playerInput: String

    fun takeTurn() {
        DiceManager.resetDice()
        println("Player ${table.playerNumber} turn!")
        rollCounter = 0
        while (rollCounter < 3) {
            playRoll()
            rollCounter++
        }
        updateScore()
    }

    private fun updateScore() {
        var flag = true
        while (flag) {
            table.listAvailableOptions()
            playerInput = readLine() ?: ""
            val keys = InputParser.parseDice(playerInput)
            if (table.updateScore(keys, DiceManager.getDiceValues()))
                flag = false
        }
    }

    private fun playRoll() {

        DiceManager.rollDice()
        DiceManager.printDiceValues()
        if (rollCounter == 2) return

        println("Roll counter: ${rollCounter + 1}")
        println("Select the dice you wish to lock. (Comma separated).")

        playerInput = readLine() ?: ""
        DiceManager.lockDice(InputParser.parseDice(playerInput))

        println("Select the dice you wish to unlock. (Comma separated).")
        playerInput = readLine() ?: ""
        DiceManager.unlockDice(InputParser.parseDice(playerInput))
    }

    override fun toString(): String {
        return "${table.playerNumber}" +
                "Score: " +
                "${table.getScore()}"
    }

    fun getScore() = table.getScore()
}