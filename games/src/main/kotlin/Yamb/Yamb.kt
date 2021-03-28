package Yamb

object Yamb {
    private var playerOneTurn: Boolean = true
    private var rollCounter: Int = 0
    private var choices: MutableSet<String> = mutableSetOf()
    private lateinit var userInput: String
    private val dice = listOf<Die>(Die(), Die(), Die(), Die(), Die(), Die())
    fun runGame() {
        while(rollCounter < 3 && playerOneTurn){
            takeTurn()
            printDice()
            getInputs()
        }
    }

    private fun takeTurn() {
        dice.forEach { Die -> Die.roll() }
        rollCounter++;
    }

    private fun printDice() {
        print("Your Roll is: ")
        dice.forEach { Die -> print(Die.state.toString() + " ") }
        println()
    }

    private fun getInputs() {
        println("Select the dice you wish to keep. (Comma separated).")
        userInput = readLine() ?: ""
        if (userInput != ""){
            choices.addAll(userInput.split(",", " ").filter { it -> it != "" })
            choices?.forEach { it -> println(it) }
        }

    }
}
