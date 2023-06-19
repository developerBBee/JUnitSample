package jp.developer.bbee.tutorial

import org.assertj.core.api.Assertions.INTEGER
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.atIndex
import org.junit.jupiter.api.Test

internal class SampleAssertionTest {
    @Test
    fun sample() {
        assertThat("KOTLIN")
            .`as`("KOTLINの文字列チェック")
            .isEqualTo("KOTLIN")
            .isEqualToIgnoringCase("kotlin")
            .isNotEqualTo("KOLTIN")
            .startsWith("KO")
            .endsWith("IN")
            .contains("TL")
            .isInstanceOf(String::class.java)
    }

    @Test
    fun numberTestSample() {
        assertThat(3.1415)
            .isNotZero()
            .isNotNegative()
            .isLessThan(4.0)
            .isGreaterThanOrEqualTo(3.0)
            .isBetween(3.0, 3.2)
    }

    @Test
    fun arrayTestSample() {
        val sut = arrayOf("Kotlin", "Java", "Scala")
        assertThat(sut)
            .hasSize(3)
            .contains("Kotlin")
            .containsOnly("Scala", "Java", "Kotlin")
            .containsExactly("Kotlin", "Java", "Scala")
            .doesNotContain("Groovy")
    }

    @Test
    fun practiceProblem3() {
        val sut = arrayOf(3,1,4) // 3 elements
        assertThat(sut)
            .hasSize(3)
            .doesNotContain(0,2,5,6,7,8,9)
                // 1つ目の要素を確認する
            .contains(3, atIndex(0))
                // 2つ目の要素を確認する
        assertThat(sut.toList())
            .element(1, INTEGER)
            .isPositive
        assertThat(sut.toList())
            .element(2, INTEGER)
            .isLessThanOrEqualTo(4)
    }
}
