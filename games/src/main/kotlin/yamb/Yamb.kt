package yamb

object Yamb {


    private var loopCounter: Int = 0
    private const val numberOfFields: Int = 4 * 12

    private val players = mutableListOf<YambPlayer>()

    fun runGame(numberOfPlayers: Int) {

        generatePlayers(numberOfPlayers)

        while (loopCounter <= numberOfFields * numberOfPlayers) {
            for (player in players) {
                player.takeTurn()
            }
            loopCounter++
        }

        declareWinner()
    }

    private fun generatePlayers(numberOfPlayers: Int) {
        for (playerNumber in 1..numberOfPlayers) {
            players.add(YambPlayer(playerNumber, numberOfFields))
        }
    }

    private fun declareWinner() {
        var maxHighScore = 0
        var currentPlayerScore: Int
        var winnerIndex = 0
        for (player in players) {
            currentPlayerScore = player.getScore()
            if (maxHighScore < currentPlayerScore) {
                maxHighScore = currentPlayerScore
                winnerIndex = players.indexOf(player)
            }
        }
        println("The winner is: " + players[winnerIndex].toString())
    }
}
