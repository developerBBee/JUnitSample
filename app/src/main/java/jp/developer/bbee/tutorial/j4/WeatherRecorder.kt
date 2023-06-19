package jp.developer.bbee.tutorial.j4

// Make the class "open" so that mockito-kotlin can mock it.
open class WeatherRecorder {
    open fun record(weather: String) {
        // record weather
    }
}

/* Mock class (Comment-out if using mockito-kotlin)
class MockWeatherRecorder: WeatherRecorder() {
    var weather: String = ""
    var isCalled: Boolean = false

    override fun record(weather: String) {
        this.weather = weather
        this.isCalled = true
    }
}
 */