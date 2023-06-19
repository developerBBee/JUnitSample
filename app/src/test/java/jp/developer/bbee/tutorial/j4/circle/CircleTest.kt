package jp.developer.bbee.tutorial.j4.circle

import jp.developer.bbee.tutorial.j4.circle.Circle
import org.junit.Assert.*
import org.assertj.core.api.Assertions.*

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CircleTest {
    @Test
    fun constructor() {
        assertThat(Circle().p).isEqualTo(Math.PI)
        assertThat(Circle(3.14).p).isEqualTo(3.14)
        assertThat(Circle(-2.5).p).isEqualTo(-2.5)
    }

    @Test
    fun area() {
        val circle = Circle()
        assertThat(circle.area(10)).isEqualTo(314.1592653589793, offset(0.000000000000001))
        val circle5 = Circle(5.0)
        assertThat(circle5.area(2)).isEqualTo(20.0, offset(0.000000000000001))
    }
}