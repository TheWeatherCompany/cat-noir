package com.example.pokerhands

class PokerHands {

    /**
     * @param playerA list of player A card values
     * @param playerB list of player B card values
     */
    fun getWinner(playerA: List<Int>, playerB: List<Int>): String {
        val sortedA = playerA.sortedDescending()
        val sortedB = playerB.sortedDescending()

        return whoWinsPair(sortedA, sortedB) ?: whoWinsWhenBothHaveHighCard(sortedA, sortedB)
    }

    fun getPair(cards: List<Int>): Int {
        cards.forEach {
            val duplicates = countDuplicates(it, cards)

            if(duplicates == 1) {
                return it
            }
        }

        return 0
    }

    fun countDuplicates(item: Int, list: List<Int>): Int {
        return list.count { it == item } - 1
    }


    private fun whoWinsPair(sortedA: List<Int>, sortedB: List<Int>): String? {
        if (getPair(sortedA) > getPair(sortedB)) {
            return "Player A Wins"
        } else if (getPair(sortedA) < getPair(sortedB)) {
            return "Player B Wins"
        } else if (getPair(sortedA) < getPair(sortedB)) {
            return whoWinsWhenBothHaveHighCard(sortedA, sortedB)
        } else {
            return null
        }
    }

    private fun whoWinsWhenBothHaveHighCard(
        sortedA: List<Int>,
        sortedB: List<Int>
    ): String {
        var i = 0
        while (i < sortedA.size && sortedA[i] == sortedB[i]) {
            i++
        }

        if (i == sortedA.size) {
            return "Tie"
        }

        return if (sortedA[i] < sortedB[i]) {
            "Player B Wins"
        } else {
            "Player A Wins"
        }
    }

}