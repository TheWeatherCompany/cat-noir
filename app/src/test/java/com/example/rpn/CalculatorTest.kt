package com.example.rpn

import com.example.pokerhands.PokerHands
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import junitparams.naming.TestCaseName
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class CalculatorTest {

    @Test
    @Parameters(method = "getInput")
    @TestCaseName("equation '{0}' should equal {1}")
    fun `test my input`(
        equation: String,
        expected: Int
    ) {

        val calculator = Calculator()
        val result = calculator.calculate(equation)

        Assert.assertEquals(equation, expected, result)
    }

    fun getInput() = arrayOf(
        arrayOf(
            "1", 1
        ),
        arrayOf(
            "27", 27
        ),
        arrayOf(
            "5 3", 3
        ),
        arrayOf(
            "5 3 +", 8
        )
    )
}