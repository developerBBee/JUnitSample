package jp.developer.bbee.tutorial.j4.tv

class WeatherForecastTV(
    private val satellite: Satellite,
    private val closet: Closet,
) {
    fun getSuitableCloth(): String {
        val temperature = satellite.getTemperature()
        val cloth = when {
            temperature > 25.0 -> "半袖"
            temperature >= 10.0 -> "羽織もの"
            else -> "厚着"
        }
        closet.pickUpCloth(cloth)
        return cloth
    }
}