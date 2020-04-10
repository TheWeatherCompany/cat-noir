package com.example.pacman

class Pacman(width:Int,height:Int) {

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
}