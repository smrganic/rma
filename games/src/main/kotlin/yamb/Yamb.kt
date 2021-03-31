package yamb

object Yamb {




    private val diceToRoll = listOf(Die(), Die(), Die(), Die(), Die(), Die())

    private var loopCounter: Int = 0
    private const val numberOfFields: Int = 4 * 12

    private val players = mutableListOf<YambPlayer>()

    fun runGame(numberOfPlayers: Int) {

        generatePlayers(numberOfPlayers)

        while(loopCounter <= numberOfFields * numberOfPlayers){
            for(player in players) {
                player.takeTurn(diceToRoll)
            }
            loopCounter++
        }

        calculateWinner()
    }

    private fun generatePlayers(numberOfPlayers: Int) {
        for (playerNumber in 1..numberOfPlayers) {
            players.add(YambPlayer(playerNumber, numberOfFields))
        }
    }

    private fun calculateWinner() {
        TODO("Not yet implemented")
    }


}
