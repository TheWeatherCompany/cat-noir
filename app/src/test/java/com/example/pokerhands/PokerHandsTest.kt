package com.example.pokerhands

import junit.framework.Assert.assertEquals
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import junitparams.naming.TestCaseName
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(JUnitParamsRunner::class)
class PokerHandsTest {

    @Test
    @Parameters(method = "getInput")
    @TestCaseName("test {0} with A={2} and B={3} should return {1}")
    fun `test my input`(
        message: String,
        expected: String,
        playerAValues: List<Int>,
        playerBValues: List<Int>
    ) {

        val pokerHands = PokerHands()
        val actualResult = pokerHands.getWinner(playerAValues, playerBValues)

        assertEquals(message, expected, actualResult)
    }

    fun getInput() = arrayOf(

        arrayOf(
            "High card with player A",
            "Player A Wins",
            listOf(2, 3, 4, 5, 13),
            listOf(7, 8, 9, 10, 12)
        ),
        arrayOf(
            "High card with player B",
            "Player B Wins",
            listOf(2, 3, 4, 5, 7),
            listOf(7, 8, 9, 10, 12)
        ),

        arrayOf(
            "Highest second card with player A",
            "Player A Wins",
            listOf(2, 3, 4, 11, 13),
            listOf(7, 8, 9, 10, 13)
        ),
        arrayOf(
            "Highest second card with player B",
            "Player B Wins",
            listOf(2, 3, 4, 10, 13),
            listOf(7, 8, 9, 11, 13)
        ),
        arrayOf(
            "Both players have the same hand",
            "Tie",
            listOf(2, 3, 4, 5, 8),
            listOf(2, 3, 4, 5, 8)
        ),
        arrayOf(
            "Player A has a pair",
            "Player A Wins",
            listOf(2, 2, 4, 5, 8),
            listOf(2, 3, 4, 5, 8)
        ),
        arrayOf(
            "Player B has a pair",
            "Player B Wins",
            listOf(2, 3, 4, 5, 8),
            listOf(2, 2, 4, 5, 8)
        ),
        arrayOf(
            "Player B has a higher pair than A",
            "Player B Wins",
            listOf(2, 2, 4, 5, 10),
            listOf(2, 4, 4, 5, 8)
        ),
        arrayOf(
            "Player A has a higher pair than B",
            "Player A Wins",
            listOf(2, 3, 4, 10, 10),
            listOf(2, 4, 4, 5, 8)
        ),
        arrayOf(
            "Player A and B have a tied pair",
            "Player A Wins",
            listOf(2, 2, 4, 5, 10),
            listOf(2, 2, 4, 5, 8)
        ),
        arrayOf(
            "Player A and B have a tied pair",
            "Player B Wins",
            listOf(2, 3, 4, 10, 10),
            listOf(2, 3, 5, 10, 10)
        ),
        arrayOf(
            "Player A and B have a tied pair and their cards are tied",
            "Tie",
            listOf(2, 3, 4, 10, 10),
            listOf(2, 3, 4, 10, 10)
        ),
        arrayOf(
            "Player A has 2 pairs",
            "Player A Wins",
            listOf(2, 2, 4, 10, 10),
            listOf(2, 3, 4, 10, 10)
        )
    )
}