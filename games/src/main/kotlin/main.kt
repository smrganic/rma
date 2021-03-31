import BlackJack.BlackJack
import yamb.Yamb
import kotlin.system.exitProcess

fun main() {
    
    var userSelection: String
    while (true) {

        println("Pick your game!")
        println("1 - Yamb")
        println("2 - Blackjack")
        println("3 - Exit program")
        
        userSelection = readLine() ?: ""

        when (userSelection) {
            "1" -> {
                // Should generate input for numberOfPlayers
                Yamb.runGame(2)
            }
            "2" -> {
                BlackJack.runGame()
            }
            "3" -> {
                exitProcess(3)
            }
            else -> {
                println("Enter a valid input")
            }
        }
    }
}