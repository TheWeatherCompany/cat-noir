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
        arrayOf("II", 2),
        arrayOf("III", 3),
        arrayOf("IV", 4),
        arrayOf("V", 5),
        arrayOf("VI", 6),
        arrayOf("VII", 7),
        arrayOf("VIII", 8),
        arrayOf("IX", 9)
    )

    /*

    CXX = 120
    XXX = 30
    XL = 40
    XC = 90
    XCVII = 97
    MCM = 1900
    MCMXCVII = 1997
    M    CM   XC  VII = 1997
    1000 900  90  7
    MI = 1001
    M    DCC LXX VI = 1776
    1000 700 70  6

    1000-3000 = M MM MMM -- - -- --- ---- -- (M--)
    100-900   = C CC CCC CD D DC DCC DCCC CM (MDC)
    10-90     = X XX XXX XL L LX LXX LXXX XC (CLX)
    1-9       = I II III IV V VI VII VIII IX (XVI)

    IVX no good
    IV = 4 no matter what
    CCC IV MMM = 3304 but bogus

     */
}