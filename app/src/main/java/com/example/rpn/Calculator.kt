package com.example.rpn

import java.util.*

class Calculator {

    private val stack = Stack<Int>()

    fun calculate(equation: String): Int {
        val scanner: Scanner()

        val i = scanner.nextInt()
        stack.push(i)
        return stack.pop()
    }
}