package com.example.pacman

class Pacman(width:Int,height:Int) {

    private val board : Array<Array<Char>> = arrayOf(height, { arrayOf(width, {'.'}) })


    fun currentState():String{
        var output = StringBuffer()
        for (row in board) {
            for (cell in row) {
                output.append(cell)
            }
        }
        return output.toString()
    }
}