package jp.developer.bbee.tutorial.j4

import org.assertj.core.api.Assertions.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith
import org.junit.Test

@RunWith(Enclosed::class)
class CalculatorTest {
    class 初期値１ {
        private lateinit var sut: Calculator

        @Before
        fun setUp() {
            sut = Calculator(1)
        }

        @Test
        fun 初期値１掛け算テスト１かける１() {
            val actual = sut.multiply(1, 1)
            assertThat(actual).isEqualTo(1)
        }

        @Test
        fun 初期値１掛け算テスト１かける２() {
            val actual = sut.multiply(1, 2)
            assertThat(actual).isEqualTo(2)
        }
    }
    class 初期値２ {
        private lateinit var sut: Calculator

        @Before
        fun setUp() {
            sut = Calculator(2)
        }

        @Test
        fun 初期値２掛け算テスト１かける１() {
            val actual = sut.multiply(1, 1)
            assertThat(actual).isEqualTo(2)
        }

        @Test
        fun 初期値２掛け算テスト１かける２() {
            val actual = sut.multiply(1, 2)
            assertThat(actual).isEqualTo(4)
        }
    }
}