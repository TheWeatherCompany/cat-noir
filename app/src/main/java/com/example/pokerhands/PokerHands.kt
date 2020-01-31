package com.example.pokerhands

class PokerHands {

    /**
     * @param playerA list of player A card values
     * @param playerB list of player B card values
     */
    fun getWinner(playerA: List<Int>, playerB: List<Int>): String {
        val sortedA = playerA.sortedDescending()
        val sortedB = playerB.sortedDescending()

        return whoWins2Pair(sortedA, sortedB) ?: whoWinsPair(sortedA, sortedB) ?: whoWinsHighCard(sortedA, sortedB)
    }

    private fun whoWins2Pair(sortedA: List<Int>, sortedB: List<Int>): String? {

        if (getPair(sortedA) != 0 && get2Pair(sortedA) != 0) {
            return "Player A Wins"
        } else {
            return ""
        }
    }

    private fun getPair(cards: List<Int>): Int {
        cards.forEach {
            val duplicates = countDuplicates(it, cards)

            if(duplicates == 1) {
                return it
            }
        }

        return 0
    }

    private fun get2Pair(cards: List<Int>): Int {
        val firstPair = getPair(cards)
        return getPair(cards.filter { it == firstPair })
    }

    private fun countDuplicates(item: Int, list: List<Int>): Int {
        return list.count { it == item } - 1
    }

    private fun whoWinsPair(sortedA: List<Int>, sortedB: List<Int>): String? {
        val pairA = getPair(sortedA)
        val pairB = getPair(sortedB)
        return if (pairA > pairB) {
            "Player A Wins"
        } else if (pairA < pairB) {
            "Player B Wins"
        } else if (pairA > 0 && pairB > 0 && pairA == pairB) {
            whoWinsHighCard(sortedA, sortedB)
        } else {
            null
        }
    }

    private fun whoWinsHighCard(
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