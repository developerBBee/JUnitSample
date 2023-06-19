package jp.developer.bbee.tutorial.j4.circle

import kotlin.math.PI

class Circle(var p: Double = PI) {
    fun area(r: Int): Double {
        return r * r * p
    }
}