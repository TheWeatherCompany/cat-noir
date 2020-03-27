package com.example.rpn

import java.util.*
import kotlin.collections.HashMap

class Calculator {

    companion object {
        val variables = HashMap<String, Int>()
    }

    private val stack = Stack<Any>()

    fun calculate(equation: String): Int {
        val scanner = Scanner(equation)
        while (scanner.hasNext()) {
            when {
                scanner.hasNextInt() -> {
                    stack.push(scanner.nextInt())
                }
                scanner.hasNext("[+-/*=]") -> {
                    val one: Any = stack.pop()
                    val two: Any = stack.pop()
                    when (scanner.next()) {
                        "+" -> stack.push(getValue(two) + getValue(one))
                        "-" -> stack.push(getValue(two) - getValue(one))
                        "/" -> stack.push(getValue(two) / getValue(one))
                        "*" -> stack.push(getValue(two) * getValue(one))
                        "=" -> variables[one as String] = two as Int
                    }
                }
                else -> {
                    stack.push(scanner.next()) // variable name
                }
            }
        }
        return getValue(stack.pop())
    }

    fun getValue(input: Any): Int {
        return when (input) {
            is Int -> input
            is String -> variables[input] as Int
            else -> throw IllegalArgumentException()
        }
    }
}