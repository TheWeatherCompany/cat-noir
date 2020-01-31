package com.example.pokerhands

class PokerHands {

    /**
     * @param playerA list of player A card values
     * @param playerB list of player B card values
     */
    fun getWinner(playerA: List<Int>, playerB: List<Int>): String {
        val sortedA = playerA.sortedDescending()
        val sortedB = playerB.sortedDescending()

        var i = 0
        while(i < sortedA.size && sortedA[i] == sortedB[i]) {
            i++
        }

        if(i == sortedA.size) {
            return "Tie"
        }

        return if (sortedA[i] < sortedB[i]) {
            "Player B Wins"
        } else {
            "Player A Wins"
        }
    }

    fun countDuplicates(item: Int, list: List<Int>): Int {
        return list.count { it == item } - 1
    }
}