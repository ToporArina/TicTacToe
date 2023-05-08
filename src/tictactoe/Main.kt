package tictactoe

import java.lang.Math.abs
import java.util.Scanner
import kotlin.system.exitProcess

var field = ""
var gamer = 'X'

fun main() {
    field = "         "

    printField()
    while (true) {
        try {
            checkCell()
            status()
        } catch (e: Exception) {
            println("You should enter numbers!")
        }
    }
}

fun status() {
    val s1 = "${field[0]}${field[1]}${field[2]}"
    val s2 = "${field[3]}${field[4]}${field[5]}"
    val s3 = "${field[6]}${field[7]}${field[8]}"
    val s4 = "${field[0]}${field[3]}${field[6]}"
    val s5 = "${field[1]}${field[4]}${field[7]}"
    val s6 = "${field[2]}${field[5]}${field[8]}"
    val s7 = "${field[0]}${field[4]}${field[8]}"
    val s8 = "${field[2]}${field[4]}${field[6]}"
    val listWinLines = mutableListOf(s1, s2, s3, s4, s5, s6, s7, s8)

    var winLines = 0 // количество выиграшных комбинаций
    var winner: Char = ' '
    for (i in listWinLines.indices) {
        if (isWinLine(listWinLines[i])) {
            winner = listWinLines[i].first()
            winLines++
        }
    }

    val diff = kotlin.math.abs(field.count { it == 'X' } - field.count { it == 'O' }) //разница между X и O

    if (winLines == 0 && (field.count { it == 'X' } + field.count { it == 'O' }) == 9) {
        println("Draw")
        exitProcess(0)
    } else if (winLines > 1 || diff > 1) {
        println("Impossible")
    } else if (winner == 'X') {
        println("X wins")
        exitProcess(0)
    } else if (winner == 'O') {
        println("O wins")
        exitProcess(0)
    }
}

fun isWinLine(s1: String): Boolean {
    return s1 == "OOO" || s1 == "XXX"
}

fun printField() {
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
}

fun checkCell() {
    val sc = Scanner(System.`in`)
    val a = sc.nextInt()
    val b = sc.nextInt()
    if (a !in 1..3 || b !in 1..3) {
        println("Coordinates should be from 1 to 3!")
        checkCell()
    } else if (field[(a - 1) * 3 + b - 1] == 'X' || field[(a - 1) * 3 + b - 1] == 'O') {
        println("The cell is occupied! Choose another one!")
        checkCell()
    } else {
        val temp = field.toMutableList()
        temp[(a - 1) * 3 + b - 1] = gamer
        field = temp.joinToString("")
        printField()
        gamer = if (gamer == 'X') 'O' else 'X'
    }
}