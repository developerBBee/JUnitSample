package jp.developer.bbee.tutorial.j4

class WeatherForecast(
    val satellite: Satellite,
    val recorder: WeatherRecorder
) {
    fun shouldBringUmbrella(): Boolean {
        val weather = satellite.getWeather()
        return when(weather) {
            "雨" -> true
            else -> false
        }
    }

    fun recordCurrentWeather() {
        val weather = satellite.getWeather()
        recorder.record(weather)
    }
}