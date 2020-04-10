package com.example.pacman

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import junitparams.naming.TestCaseName
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class PacmanGameTest {

    @Test
    @Parameters(method = "getEmptyBoardInput")
    @TestCaseName("width '{0}', height '{1}' should give {2}")
    fun `test my input`(
        boardWidth: Int,
        boardHeight: Int,
        expected: String
    ) {
        val pacman = PacmanGame(boardWidth, boardHeight)
        val result = pacman.currentState()

        Assert.assertEquals(expected , result)
    }

    fun getEmptyBoardInput() = arrayOf(
        arrayOf(1, 1, "v\n"),// empty 1x1 grid matches expectation
        arrayOf(2, 1, "v.\n"), // empty 2x1 grid matches expectation
        arrayOf(3, 5, "...\n...\n.v.\n...\n...\n") // empty 3x5 grid matches expectation
    )
}