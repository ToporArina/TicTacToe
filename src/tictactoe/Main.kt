package tictactoe

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
    // write your code here
}