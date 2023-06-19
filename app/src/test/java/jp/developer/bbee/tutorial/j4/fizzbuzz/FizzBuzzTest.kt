package jp.developer.bbee.tutorial.j4.fizzbuzz

import jp.developer.bbee.tutorial.j4.fizzbuzz.FizzBuzz
import org.junit.Assert.*
import org.junit.Before
import org.assertj.core.api.Assertions.*

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class FizzBuzzTest {
    lateinit var fizzBuzz: FizzBuzz
    @Before
    fun setUp() {
        fizzBuzz = FizzBuzz()
    }

    @Test
    fun fbCheck_Others() {
        val others = arrayOf(-4, -2, -1, 1, 2, 4, 7, 8, 11, 13, 14, 16, 17) // 3, 5の倍数ではない
        assertThat(others).allMatch { fizzBuzz.fbCheck(it) == it.toString() } // 数値を文字列に変換
    }
    @Test
    fun fbCheck_Threes() {
        val threes = arrayOf(-6, -3, 3, 6, 9, 12, 18, 21, 24, 27) // 3の倍数, 5の倍数ではない
        assertThat(threes).allMatch { fizzBuzz.fbCheck(it) == "Fizz" } // Fizz
    }
    @Test
    fun fbCheck_Fives() {
        val fives = arrayOf(-10, -5, 5, 10, 20, 25) // 5の倍数, 3の倍数ではない
        assertThat(fives).allMatch { fizzBuzz.fbCheck(it) == "Buzz" } // Buzz
    }
    @Test
    fun fbCheck_Fifteens() {
        val fifteens = arrayOf(-30, -15, 0, 15, 30, 45) // 15の倍数
        assertThat(fifteens).allMatch { fizzBuzz.fbCheck(it) == "FizzBuzz" } // FizzBuzz
    }
}