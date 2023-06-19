package jp.developer.bbee.tutorial.j4.suite

import jp.developer.bbee.tutorial.j4.circle.CircleTest
import jp.developer.bbee.tutorial.j4.fizzbuzz.FizzBuzzTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    CircleTest::class,
    FizzBuzzTest::class,
)
class AllTest {
}