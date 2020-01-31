package com.example.pokerhands

class PokerHands {

    /**
     * @param playerA list of player A card values
     * @param playerB list of player B card values
     */
    fun getWinner(playerA: List<Int>, playerB: List<Int>): String {
        val sortedA = playerA.sortedDescending()
        val sortedB = playerB.sortedDescending()


        if(sortedA.max()!! == sortedB.max()!!) {

        }

        return if (sortedA.max()!! < sortedB.max()!!) {
            "Player B Wins"
        } else {
            "Player A Wins"
        }
    }
}