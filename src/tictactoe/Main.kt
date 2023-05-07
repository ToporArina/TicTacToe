package tictactoe

import java.lang.Math.abs

var field = ""
fun main() {
    field = readln()
    println("---------")
    for (i in 0 until 3) {
        print("| ")
        for (y in 0 until 3) {
            print(field[i * 3 + y] + " ")
        }
        print("|")
        println()
    }
    println("---------")
    val s1 = "${field[0]}${field[1]}${field[2]}"
    val s2 = "${field[3]}${field[4]}${field[5]}"
    val s3 = "${field[6]}${field[7]}${field[8]}"
    val s4 = "${field[0]}${field[3]}${field[6]}"
    val s5 = "${field[1]}${field[4]}${field[7]}"
    val s6 = "${field[2]}${field[5]}${field[8]}"
    val s7 = "${field[0]}${field[4]}${field[8]}"
    val s8 = "${field[2]}${field[4]}${field[6]}"
    val listWinLines = mutableListOf<String>(s1, s2, s3, s4, s5, s6, s7, s8)

    var winLines = 0 // количество выиграшных комбинаций
    var winner: Char = ' '
    for (i in listWinLines.indices) {
        if (isWinLine(listWinLines[i])) {
            winner = listWinLines[i].first()
            winLines++
        }
    }

    var diff = abs(field.count { it == 'X' } - field.count { it == 'O' }) //разница между X и O

    if (winLines == 0 && (field.count { it == 'X' } + field.count { it == 'O' }) == 9) {
        println("Draw")
    } else if (winLines > 1 || diff > 1) {
        println("Impossible")
    } else if (winner == 'X') {
        println("X wins")
    } else if (winner == 'O') {
        println("O wins")
    } else {
        println("Game not finished")
    }
}

fun isWinLine(s1: String): Boolean {
    return s1 == "OOO" || s1 == "XXX"
}