package jp.developer.bbee.tutorial.j4.fizzbuzz

class FizzBuzz {
    fun fbCheck(n: Int): String {
        return when {
            n % 15 == 0 -> "FizzBuzz"
            n % 3 == 0 -> "Fizz"
            n % 5 == 0 -> "Buzz"
            else -> n.toString()
        }
    }
}