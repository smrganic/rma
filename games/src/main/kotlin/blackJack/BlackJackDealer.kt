package blackJack

// This should be adjusted so it doesn't generate infinite funds
object BlackJackDealer : BlackJackPlayer(0, Float.POSITIVE_INFINITY) {
    override fun takeTurn() {
        hand.clear()
        hand.add(CardGenerator.getCard())
        hand.add(CardGenerator.getCard())

        while (hand.sumBy { it } < 17) {
            println("Dealer turn!")
            printCards()
            printOptions()
            hand.add(CardGenerator.getCard())
            printCards()
            playerHandSum = hand.sumBy { it }
            if(hand.contains(11) && playerHandSum > 21){
                hand.remove(11)
                hand.add(1)
                playerHandSum = hand.sumBy { it }
            }
        }
    }
}