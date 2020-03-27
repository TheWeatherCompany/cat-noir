package com.example.rpn

import java.util.*
import kotlin.collections.HashMap

class Calculator {

    private val stack = Stack<Any>()

    private val variables = HashMap<String, Int>()

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
                    "*" -> stack.push(one * two)
                    else -> TODO("bleh")
            }
        }
        return stack.pop()
    }

        fun getValue(input: Any): Int {
            when(input) {
                is Int -> return input
                is String -> return variables.get(input) as Int
            }
        }
    }
}