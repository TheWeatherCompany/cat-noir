package com.example.rpn

import java.util.*

class Calculator {

    private val stack = Stack<Int>()

    fun calculate(equation: String): Int {
        val scanner = Scanner(equation)
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                val i = scanner.nextInt()
                stack.push(i)
            } else {
                val one = stack.pop()
                val two = stack.pop()
                when (scanner.next()) {
                    "+" -> stack.push(one + two)
                    "-" -> stack.push(two - one)
                    "/" -> stack.push(two / one)
                    else -> stack.push(one * two)
                }

            }
        }
        return stack.pop()
    }
}