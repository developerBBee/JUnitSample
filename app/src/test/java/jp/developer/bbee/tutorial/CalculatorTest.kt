package jp.developer.bbee.tutorial

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.IllegalArgumentException

@Suppress("NonAsciiCharacters")
internal class CalculatorTest {
    lateinit var sut: Calculator

    @BeforeEach
    fun setUp() {
        println("テスト開始")
        sut = Calculator() // sut: System Under Test (テスト対象オブジェクト)
    }

    @Test
    fun multiplyで掛け算結果取得をテストする() {
        val actual = sut.multiply(2, 3)
        val expected = 6
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun divideで割り算で整数の結果取得をテストする() {
        val actual = sut.divide(6, 3)
        val expected = 2.0
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun divideで割り算で少数の結果取得をテストする() {
        val actual = sut.divide(3, 2)
        val expected = 1.5
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun divideで0で割ろうとした時の例外発生をテストする() {
        val error = assertThrows<IllegalArgumentException> {
            sut.divide(3, 0)
        }
        assertThat(error.message).isEqualTo("0で割ることはできません")
    }

    @AfterEach
    fun tearDown() {
        val callStack = Thread.currentThread().stackTrace
        callStack.forEach(::println)
    }
}