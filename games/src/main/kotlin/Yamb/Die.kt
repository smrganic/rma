package Yamb

import kotlin.random.Random

class Die(var state: Int = 1) {
    fun roll(): Int {
        state = Random.nextInt(1, 6)
        return state
    }
}