package blackJack

object BlackJack {
    private val players = mutableListOf<BlackJackPlayer>()

    // This should be adjusted so it doesn't generate infinite funds
    private val dealer = BlackJackPlayer(0, Float.POSITIVE_INFINITY)

    fun runGame(numberOfPlayers: Int) {
        generatePlayers(numberOfPlayers)
        for (player: BlackJackPlayer in players) {
            player.takeTurn()
            dealer.takeTurn()
        }
        declareWinner()
    }

    private fun generatePlayers(numberOfPlayers: Int) {
        for (i in 1..numberOfPlayers) {
            players.add(BlackJackPlayer(i, 10_000f))
        }
    }

    private fun declareWinner() {
        var playerHandValue = 0
        val dealerHandValue = dealer.getHand()
        players.forEach {
            playerHandValue = it.getHand()
            when {
                playerHandValue > 21 -> println("Player: ${it.playerNumber} lost.")
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
