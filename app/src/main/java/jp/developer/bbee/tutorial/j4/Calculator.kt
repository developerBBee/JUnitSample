package jp.developer.bbee.tutorial.j4

class Calculator(val rate: Int) {
    fun multiply(x: Int, y: Int): Int {
        return rate * x * y
    }

    fun divide(x: Int, y: Int): Double {
        if (y == 0) throw IllegalArgumentException("0で割ることはできません")
        return rate * x / y.toDouble()
    }
}