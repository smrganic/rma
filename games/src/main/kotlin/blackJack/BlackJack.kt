package blackJack

object BlackJack {
    private val players = mutableListOf<BlackJackPlayer>()

    fun runGame(numberOfPlayers: Int) {
        players.clear()
        generatePlayers(numberOfPlayers)
        // Could implement fund subtraction and betting mechanics but not today
        for (player: BlackJackPlayer in players) {
            player.takeTurn()
        }
        BlackJackDealer.takeTurn()
        declareWinner()
    }

    private fun generatePlayers(numberOfPlayers: Int) {
        for (i in 1..numberOfPlayers) {
            players.add(BlackJackPlayer(i, 10_000f))
        }
    }

    private fun declareWinner() {
        var playerHandValue = 0
        val dealerHandValue = BlackJackDealer.getHand()
        println("Dealer Hand is: $dealerHandValue.")
        players.forEach {
            playerHandValue = it.getHand()
            when {
                playerHandValue > 21 -> println("Player: ${it.playerNumber} lost.")
                it.blackJackAchieved -> println("Player: ${it.playerNumber} won.")
                playerHandValue == 21 && dealerHandValue == 21 -> println("Player: ${it.playerNumber} lost.")
                playerHandValue in (dealerHandValue + 1)..21 -> {
                    println("Player: ${it.playerNumber} won.")
                }
                else -> {
                    println("Player: ${it.playerNumber} lost.")
                }
            }
        }
    }
}
