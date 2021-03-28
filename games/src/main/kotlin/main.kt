import BlackJack.BlackJack
import Yamb.Yamb
import kotlin.system.exitProcess

fun main() {
    
    var userSelection: String?
    while (true) {

        println("Pick your game!")
        println("1 - Yamb")
        println("2 - Blackjack")
        println("3 - Exit program")
        
        userSelection = readLine()

        when (userSelection) {
            "1" -> {
                Yamb.runGame()
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