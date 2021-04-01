package blackJack

import kotlin.random.Random

object CardGenerator {
    fun getCard(): Int {
        return Random.nextInt(1, 12)
    }
}