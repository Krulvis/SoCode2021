package org.krulvis.socode.day02


fun puzzleOne(input: List<Pair<String, Int>>) {
    var horizontal = 0
    var depth = 0
    input.forEach { (d, a) ->
        when (d) {
            "forward" -> horizontal += a
            "up" -> depth -= a
            "down" -> depth += a
        }
    }
    println("Horizontal=$horizontal, Depth=$depth, multiplied=${horizontal * depth}")
}

fun puzzleTwo(input: List<Pair<String, Int>>) {
    var horizontal = 0
    var aim = 0
    var depth = 0
    input.forEach { (d, a) ->
        when (d) {
            "forward" -> {
                horizontal += a
                depth += a * aim
            }
            "up" -> aim -= a
            "down" -> aim += a
        }
    }
    println("Horizontal=$horizontal, depth=$depth, multiplied=${horizontal * depth}")
}

fun main() {
    val input = ClassLoader.getSystemResource("day2.txt")
        .readText().split("\n").filterNot { it.isEmpty() }
        .map {
            val instruction = it.split(" ")
            instruction[0] to instruction[1].toInt()
        }

    puzzleOne(input)
    puzzleTwo(input)
}


