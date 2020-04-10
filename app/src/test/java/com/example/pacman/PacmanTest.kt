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
    @TestCaseName("width '{0}', height '{1}' should give {2}")
    fun `test my input`(
        boardWidth: Int,
        boardHeight: Int,
        expected: String
    ) {

        val pacman = Pacman(1, 1)
        val result = pacman.currentState()

        Assert.assertEquals(expected , result)
    }



    fun getInput() = arrayOf(
        arrayOf(1, 1, "."),// empty 1x1 grid matches expectation
        arrayOf(2, 1, "..") // empty 2x1 grid matches expectation

    )
}