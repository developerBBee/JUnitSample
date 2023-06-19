package jp.developer.bbee.tutorial

class Calculator{
    fun multiply(x: Int, y:Int): Int {
        return x * y
    }

    fun divide(x: Int, y:Int): Double {
        if (y == 0) throw IllegalArgumentException("0で割ることはできません")
        return x / y.toDouble()
    }
}