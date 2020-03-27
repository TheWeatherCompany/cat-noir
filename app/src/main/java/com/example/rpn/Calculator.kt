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
                val one: Any = stack.pop()
                val two: Any = stack.pop()
                when (scanner.next()) {
                    "+" -> stack.push(getValue(one) + getValue(two))
                    "-" -> stack.push(getValue(one) - getValue(two))
                    "/" -> stack.push(getValue(one) / getValue(two))
                    "*" -> stack.push(getValue(one) * getValue(two))
                    else -> {
                        if (two.equals("=")) {
                            variables.put(one as String, getValue(stack.pop()))
                        }
//                        variables.put(two as String, one)
                    }
                }
            }
        }
        return stack.pop() as Int
    }

    fun getValue(input: Any): Int {
        return when (input) {
            is Int -> input
            is String -> variables[input] as Int
            else -> throw IllegalArgumentException()
        }
    }
}