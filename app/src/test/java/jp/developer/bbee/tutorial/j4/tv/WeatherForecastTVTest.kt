package jp.developer.bbee.tutorial.j4.tv

import org.assertj.core.api.Assertions.*
import com.nhaarman.mockitokotlin2.*
import org.junit.Before
import org.junit.Test

class WeatherForecastTVTest {
    lateinit var satellite: Satellite
    lateinit var closet: Closet
    lateinit var sut: WeatherForecastTV

    @Before
    fun setUp() {
        satellite = mock(name = "MockSatellite")
        closet = mock(name = "MockCloset")
        sut = WeatherForecastTV(satellite, closet)
    }

    @Test
    fun 低温の服は厚着() {
        whenever(satellite.getTemperature()).thenReturn(9.9) // 9.9(10度未満)を返す設定
        sut = WeatherForecastTV(satellite, closet)

        val actual = sut.getSuitableCloth()
        assertThat(actual).isEqualTo("厚着")

        verify(closet, times(1)).pickUpCloth(any())
    }

    @Test
    fun 適温の服は羽織もの下限() {
        whenever(satellite.getTemperature()).thenReturn(10.0) // 10.0を返す設定
        sut = WeatherForecastTV(satellite, closet)

        val actual = sut.getSuitableCloth()
        assertThat(actual).isEqualTo("羽織もの")

        verify(closet, times(1)).pickUpCloth(any())
    }

    @Test
    fun 適温の服は羽織もの上限() {
        whenever(satellite.getTemperature()).thenReturn(25.0) // 25.0を返す設定
        sut = WeatherForecastTV(satellite, closet)

        val actual = sut.getSuitableCloth()
        assertThat(actual).isEqualTo("羽織もの")

        verify(closet, times(1)).pickUpCloth(any())
    }

    @Test
    fun 高温の服は半袖() {
        whenever(satellite.getTemperature()).thenReturn(25.1) // 25.1(25度を超える)を返す設定
        sut = WeatherForecastTV(satellite, closet)

        val actual = sut.getSuitableCloth()
        assertThat(actual).isEqualTo("半袖")

        verify(closet, times(1)).pickUpCloth(any())
    }

    @Test
    fun クローゼットのピックアップ呼び出し確認() {
        whenever(satellite.getTemperature()).thenReturn(25.1)
        sut = WeatherForecastTV(satellite, closet)
        sut.getSuitableCloth()
        verify(closet, times(1)).pickUpCloth(any())
    }
}