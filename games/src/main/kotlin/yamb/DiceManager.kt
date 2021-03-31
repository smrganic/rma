package yamb

object DiceManager {
    private val dice = listOf(Die(), Die(), Die(), Die(), Die(), Die())

    fun printDiceValues() {
        println("Dice values are: ")
        dice.forEach { Die -> println("unlocked: ${Die.unlocked}\t-\tDie value: ${Die.value}") }
    }

    fun rollDice() = dice.forEach { Die -> if (Die.unlocked) Die.roll() }

    fun lockDice(parsedPlayerInput: MutableList<String>) {
        dice.forEach {
            if (parsedPlayerInput.contains(it.value.toString()) && it.unlocked) {
                it.unlocked = false
                parsedPlayerInput.remove(it.value.toString())
            }
        }
    }

    fun unlockDice(parsedPlayerInput: MutableList<String>) {
        dice.forEach {
            if (parsedPlayerInput.contains(it.value.toString()) && !it.unlocked) {
                it.unlocked = true
                parsedPlayerInput.remove(it.value.toString())
            }
        }
    }

    fun resetDice() {
        dice.forEach { Die -> Die.unlocked = true }
    }
}