package blackJack

import kotlin.random.Random

class CardGenerator {
    fun getCard(): Int {
        return Random.nextInt(1, 11)
    }
}