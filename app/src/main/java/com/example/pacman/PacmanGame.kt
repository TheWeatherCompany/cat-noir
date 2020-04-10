package com.example.pacman

class PacmanGame(width: Int, height: Int) {

    private var board = arrayOf<Array<Char>>()
    private val pacman = MovingThing(width/2, height/2, 1, arrayOf('>', 'v', '<', '^'))

    init {
        for (i in 0 until height) {
            var array = arrayOf<Char>()
            for (j in 0 until width) {
                array += '.'
            }
            board += array
        }
    }

    fun currentState(): String {
        val output = StringBuffer()
        for (row in board.withIndex()) {
            for (cell in row.value.withIndex()) {
                output.append(calculateCharacter(cell, row))
            }
            output.append("\n")
        }
        return output.toString()
    }

    private fun calculateCharacter(
        cell: IndexedValue<Char>,
        row: IndexedValue<Array<Char>>
    ) =
        if (cell.index == pacman.x && row.index == pacman.y) pacman.directions[pacman.direction] else cell.value

    data class MovingThing(val x: Int, val y: Int, val direction: Int, val directions: Array<Char>)
}
