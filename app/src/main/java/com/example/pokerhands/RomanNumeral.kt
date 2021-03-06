package com.example.pokerhands

/*
For each character
 examine this character
 examine the next character (if any if their is next character)
 if the next is higher, subtract this
 else add this
 */
class RomanNumeral {

    private val vals = mapOf(
        "I" to 1,
        "V" to 5,
        "X" to 10,
        "L" to 50,
        "C" to 100,
        "D" to 500,
        "M" to 1000
    )

    fun convert(numeral: String): Int {
        var holdValue = 0

        numeral.forEachIndexed() { index, ch ->

            val thisValue = vals.get(ch.toString())!!
            if (index + 1 < numeral.length) {
                // peek at the next char
                val next = numeral[index + 1]

                val nextValue = vals.get(next.toString())!!

                if (thisValue < nextValue) {
                    holdValue-=thisValue
                }
                else{
                    holdValue+=thisValue
                }
            }
            else{
                holdValue+=thisValue
            }

        }

        return holdValue
    }
}

/*
Roman Numerals
Difficulty - Easy.

Problem Description
The Romans were a clever bunch. They conquered most of Europe and ruled it for hundreds of years.
They invented concrete and straight roads and even bikinis [1]. One thing they never discovered
though was the number zero. This made writing and dating extensive histories of their exploits
slightly more challenging, but the system of numbers they came up with is still in use today.
For example the BBC uses Roman numerals to date their programmes.

The Romans wrote numbers using letters : I, V, X, L, C, D, M. (notice these letters have lots of
straight lines and are hence easy to hack into stone tablets)

Part I
The Kata says you should write a function to convert from Roman numerals to numbers: eg
    Symbol       Value
    I            1
    V            5
    X            10
    L            50
    C            100
    D            500
    M            1000

A small-value symbol before a large-value symbol is subtracted from the large-value symbol
I, X, C and M can be repeated 3 times
I can be subtracted from V and X only
X can be subtracted from L and C only
C can be subtracted from D and M only
V, L and D can never be subtracted
Only one small-value symbol may be subtracted from a large-value symbol
 */