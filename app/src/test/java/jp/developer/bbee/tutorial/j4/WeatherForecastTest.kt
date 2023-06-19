package jp.developer.bbee.tutorial.j4

import org.assertj.core.api.Assertions.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith
import com.nhaarman.mockitokotlin2.*

/**
 * Use Mockito-Kotlin
 */
@RunWith(Enclosed::class)
class WeatherForecastTest {
    class スタブとして戻り値をテスト {
        lateinit var weatherForecast: WeatherForecast
        lateinit var satellite: Satellite

        @Before
        fun setUp() {
            satellite = mock(name = "MockSatellite") // SatelliteのMockを作成
            whenever(satellite.getWeather()) // MockのgetWeather()を呼び出すと
                .thenReturn("雨") // "雨"を返すように設定

            val recorder = WeatherRecorder()
            weatherForecast = WeatherForecast(satellite, recorder)
        }

        @Test
        fun 雨なら傘を持つ() {
            val actual = weatherForecast.shouldBringUmbrella()
            assertThat(actual).isTrue
        }
    }

    class モックとして入力をテスト {
        lateinit var weatherForecast: WeatherForecast
        lateinit var recorder: WeatherRecorder

        @Before
        fun setUp() {
            recorder = mock(name = "MockRecorder") // WeatherRecorderのMockを作成
            weatherForecast = WeatherForecast(Satellite(), recorder)
        }

        @Test
        fun メソッドが呼ばれたことを確認する() {
            weatherForecast.recordCurrentWeather()

            // recorder.record()が"1回"呼ばれたことを確認、any()は引数の値は問わないことを示す
            verify(recorder, times(1)).record(any())
        }
    }
}


/**
 *  Without mockito-kotlin
@RunWith(Enclosed::class)
class WeatherForecastTest {
    class 晴れ {
        lateinit var weatherForecast: WeatherForecast
        lateinit var satellite: SatelliteStub
        lateinit var recorder: MockWeatherRecorder
        @Before
        fun setUp() {
            satellite = SatelliteStub("晴れ")
            recorder = MockWeatherRecorder()
            weatherForecast = WeatherForecast(satellite, recorder)
        }

        @Test
        fun 晴れなら傘を持たない() {
            val actual = weatherForecast.shouldBringUmbrella()
            assertThat(actual).isFalse
        }

        @Test
        fun 晴れを記録する() {
            weatherForecast.recordCurrentWeather()
            assertThat(recorder.weather).isEqualTo("晴れ")
            assertThat(recorder.isCalled).isTrue
        }
    }

    class 曇り {
        lateinit var weatherForecast: WeatherForecast
        lateinit var satellite: SatelliteStub
        lateinit var recorder: MockWeatherRecorder
        @Before
        fun setUp() {
            satellite = SatelliteStub("曇り")
            recorder = MockWeatherRecorder()
            weatherForecast = WeatherForecast(satellite, recorder)
        }

        @Test
        fun 曇りなら傘を持たない() {
            val actual = weatherForecast.shouldBringUmbrella()
            assertThat(actual).isFalse
        }

        @Test
        fun 曇りを記録する() {
            weatherForecast.recordCurrentWeather()
            assertThat(recorder.weather).isEqualTo("曇り")
            assertThat(recorder.isCalled).isTrue
        }
    }

    class 雨 {
        lateinit var weatherForecast: WeatherForecast
        lateinit var satellite: SatelliteStub
        lateinit var recorder: MockWeatherRecorder
        @Before
        fun setUp() {
            satellite = SatelliteStub("雨")
            recorder = MockWeatherRecorder()
            weatherForecast = WeatherForecast(satellite, recorder)
        }

        @Test
        fun 雨なら傘を持つ() {
            val actual = weatherForecast.shouldBringUmbrella()
            assertThat(actual).isTrue
        }

        @Test
        fun 雨を記録する() {
            weatherForecast.recordCurrentWeather()
            assertThat(recorder.weather).isEqualTo("雨")
            assertThat(recorder.isCalled).isTrue
        }
    }
}
 */