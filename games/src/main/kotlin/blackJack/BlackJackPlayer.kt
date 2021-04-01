package blackJack

import utils.InputParser


open class BlackJackPlayer(val playerNumber: Int, var accountBalance: Float) {

    protected val hand = mutableListOf<Int>()
    private lateinit var playerInput: String
    protected var playerHandSum = 0
    var blackJackAchieved = false


    open fun takeTurn() {
        blackJackAchieved = false
        hand.clear()
        hand.add(CardGenerator.getCard())
        hand.add(CardGenerator.getCard())
        while (playerHandSum <= 21) {

            println("Player $playerNumber turn!")
            printCards()
            printOptions()
            if (hand.sumBy { it } == 21) {
                blackJackAchieved = true
                break
            }
            playerInput = readLine() ?: ""
            when (InputParser.parseBlackJack(playerInput)) {
                1 -> hand.add(CardGenerator.getCard())
                else -> {
                    break
                }
            }

            if (hand.contains(11) && hand.sumBy { it } > 21) {
                hand.remove(11)
                hand.add(1)
            }

            playerHandSum = hand.sumBy { it }
        }
        println("Final player $playerNumber card sum is ${hand.sumBy { it }}.")
    }

    protected fun printOptions() {
        println("1 - Get another card.")
        println("2 - Stand")
    }

    protected fun printCards() {
        hand.forEach { print("$it ") }
        println()
    }

    fun getHand(): Int {
        return hand.sumBy { it }
    }
}