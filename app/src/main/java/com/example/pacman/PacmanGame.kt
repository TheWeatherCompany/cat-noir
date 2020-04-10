package com.example.pacman

class PacmanGame(width:Int, height:Int) {

    private var board = arrayOf<Array<Char>>()

    init {
        for (i in 0 until height) {
            var array = arrayOf<Char>()
            for (j in 0 until width) {
                array += '.'
            }
            board += array
        }
    }

    fun currentState():String{
        val output = StringBuffer()
        for (row in board) {
            for (cell in row) {
                output.append(cell)
            }
            output.append("\n")
        }
        return output.toString()
    }

    data class MovingThing(val x : Int, val y : Int, val direction : Int, val directions : Array<Char>)
}
