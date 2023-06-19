package jp.developer.bbee.tutorial.j4

import kotlin.random.Random

// Make the class "open" so that mockito-kotlin can mock it.
open class Satellite {
    open fun getWeather(): String {
        return when (Random.nextInt(10)) {
            0 -> "晴れ"
            1 -> "曇り"
            else -> "雨"
        }
    }
}

/* Stub class (Comment-out if using mockito-kotlin)
class SatelliteStub(private val weather: String): Satellite() {
    override fun getWeather(): String {
        return weather
    }
}
 */