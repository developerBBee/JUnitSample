package jp.developer.bbee.tutorial.j4

import org.assertj.core.api.Assertions.*
import org.junit.Before

import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

@RunWith(Enclosed::class)
class CounterTest {
    /**
     * 初期状態
     */
    class 初期状態 {
        lateinit var sut: Counter
        @Before
        fun setUp() {
            sut = Counter()
        }

        @Test
        fun 初期状態からインクリメントしたら１が返る() {
            val actual = sut.increment()
            assertThat(actual).isEqualTo(1)
        }

        @Test
        fun 初期状態からデクリメントしたらマイナス１が返る() {
            val actual = sut.decrement()
            assertThat(actual).isEqualTo(-1)
        }
    }

    /**
     * インクリメント１回状態
     */
    class インクリメント１回状態 {
        lateinit var sut: Counter
        @Before
        fun setUp() {
            sut = Counter()
        }

        @Test
        fun インクリメントした状態からインクリメントしたら２が返る() {
            sut.increment()
            val actual = sut.increment()
            assertThat(actual).isEqualTo(2)
        }

        @Test
        fun インクリメントした状態からデクリメントしたら０が返る() {
            sut.increment()
            val actual = sut.decrement()
            assertThat(actual).isEqualTo(0)
        }
    }

    /**
     * インクリメント１００回状態
     */
    class インクリメント１００回状態 {
        lateinit var sut: Counter
        @Before
        fun setUp() {
            sut = Counter()
        }

        @Test
        fun インクリメントを１００回繰り返した後にインクリメントで１０１が返る() {
            for (i in 1..100) {
                sut.increment()
            }
            val actual = sut.increment()
            assertThat(actual).isEqualTo(101)
        }

        @Test
        fun インクリメントを１００回繰り返した後にデクリメントで９９が返る() {
            for (i in 1..100) {
                sut.increment()
            }
            val actual = sut.decrement()
            assertThat(actual).isEqualTo(99)
        }
    }
}