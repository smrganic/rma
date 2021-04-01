package yamb

import kotlin.random.Random

class Die(var value: Int = 1) {
    var unlocked = true

    fun roll(): Int {
        // Until is exclusive
        value = Random.nextInt(1, 7)
        return value
    }
}