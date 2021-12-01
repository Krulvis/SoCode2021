package org.krulvis.socode.day01

import java.io.FileReader

fun partOne(input: List<Int>): Int {
    var larger = 0
    input.forEachIndexed { i, r ->
        if (i > 0 && r > input[i - 1])
            larger++
    }
    return larger
}

fun partTwo(input: List<Int>): Int {
    var larger = 0
    val windowed = input.windowed(3).map { it.sum() }
    windowed.forEachIndexed { i, r ->
        if (i > 0 && r > windowed[i - 1])
            larger++
    }
    return larger
}

fun main() {
    val input = ClassLoader.getSystemResource("day1.txt")
        .readText()
        .split("\n")
        .filter { it.isNotEmpty() }
        .map { it.toInt() }

    println("Answer to part one: ${partOne(input)}")
    println("Answer to part two: ${partTwo(input)}")
}