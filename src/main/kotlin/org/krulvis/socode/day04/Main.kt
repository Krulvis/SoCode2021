package org.krulvis.socode.day04

fun main() {
    val input = ClassLoader.getSystemResource("day4.txt").readText().split("\n")

    val generated = input[0].split(",").map { it.toInt() }
    val rows = input.filter { it.length == 14 }.map { it.toCharArray() }.toTypedArray()
    val boards = mutableListOf<Board>()

    (0 until rows.size / 5).forEach {
        val index = it * 5
        val board = Board(rows.copyOfRange(index, index + 5))
        println(board)
        boards.add(board)
    }

    boards.secondChallenge(generated)

}

fun List<Board>.secondChallenge(generated: List<Int>) {
    var i = 5
    var remainingBoards = this.toList()
    while (i <= generated.size) {
        val subGenerated = generated.subList(0, i)
        println(subGenerated.joinToString())
        if (remainingBoards.size > 1) {
            remainingBoards = remainingBoards.filter { !it.won(subGenerated) }
            println("Remining boards = ${remainingBoards.size}")
        } else {
            val lastBoard = remainingBoards.first()
            if (lastBoard.won(subGenerated)) {
                println("BOARD WON WITH GENERATED NUMBERS=${subGenerated.joinToString()} ON LINE=${
                    lastBoard.allLines
                        .indexOfFirst { line ->
                            line.all { number -> number in subGenerated }
                        }
                }")
                println("Score of first board to win is=${lastBoard.score(subGenerated)}")
                break
            }
        }
        i++
    }
}

fun List<Board>.firstChallenge(generated: List<Int>) {
    var i = 5
    while (i <= generated.size) {
        val subList = generated.subList(0, i)
        println("Sublist=${subList.joinToString()}")
        val winningBoard = firstOrNull { it.won(subList) }
        if (winningBoard != null) {
            println("BOARD WON WITH GENERATED NUMBERS=${subList.joinToString()} ON LINE=${winningBoard.allLines.indexOfFirst { line -> line.all { number -> number in subList } }}: \n $winningBoard")
            println("Score of first board to win is=${winningBoard.score(subList)}")
            break
        }
        i++
    }
}