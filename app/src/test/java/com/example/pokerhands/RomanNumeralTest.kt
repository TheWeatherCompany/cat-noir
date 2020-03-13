package com.example.pokerhands

import junit.framework.Assert.assertEquals
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import junitparams.naming.TestCaseName
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(JUnitParamsRunner::class)
class RomanNumeralTest {

    @Test
    @Parameters(method = "getInput")
    @TestCaseName("test {0} should return {1}")
    fun `test my input`(input: String, output: Int) {
        assertEquals(RomanNumeral().convert(input), output)
    }

    fun getInput() = arrayOf(
        arrayOf("I", 1),
        arrayOf("II", 2)  
    )
}