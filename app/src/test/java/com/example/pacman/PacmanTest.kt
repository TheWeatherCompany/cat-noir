package com.example.pacman

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import junitparams.naming.TestCaseName
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class PacmanTest {

    @Test
    @Parameters(method = "getInput")
    @TestCaseName("equation '{0}' should equal {1}")
    fun `test my input`(
        boardWidth: Int,
        boardHeight: Int,
        expected: String
    ) {

        val pacman = Pacman(1, 1)
        val result = pacman.currentState()

        Assert.assertEquals(boardConfig, expected, result)
    }



    fun getInput() = arrayOf(
        arrayOf(".", 1, 1), // empty 1x1 grid matches expectation
        arrayOf("27", 27),
        arrayOf("5 3", 3),
        arrayOf("5 3 +", 8),
        arrayOf("5 3 3 + +", 11),
        arrayOf("5 3 3 + + 7 *", 77),
        arrayOf("5 3 - ", 2),
        arrayOf("9 3 / ", 3),
        arrayOf("9 -1 / ", -9),
        arrayOf("5 5 - ", 0),
        arrayOf("1 8 a = ", 1),
        arrayOf("a", 8),
        arrayOf("1 5 8 + a = a", 13),
        arrayOf("1 5 8 + b = a b +", 26),
        arrayOf("a c = c", 13),
        arrayOf("1 a = a", 1),
        arrayOf("-1 a = a", -1),
        arrayOf("1 a + a = a", 0)
    )
}