package yamb

import kotlin.random.Random

class Die(var value: Int = 1) {
    var unlocked = true

    fun roll(): Int {
        value = Random.nextInt(1, 6)
        return value
    }
}