package jp.developer.bbee.tutorial.j4.tv

import kotlin.random.Random

open class Satellite {
    open fun getTemperature(): Double {
        return Random.nextDouble(-10.0, 40.0) // implementation example
    }
}