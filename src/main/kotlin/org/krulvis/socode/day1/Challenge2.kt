package org.krulvis.socode.day1

import java.io.FileReader


fun main() {
    val input = FileReader(
        ClassLoader.getSystemResource("day1.txt").file
    ).readText().split("\n").filter { it.isNotEmpty() }.map { it.toInt() }

    var larger = 0
    val windowed = input.windowed(3).map { it.sum() }
    windowed.forEachIndexed { i, r ->
        if (i > 0 && r > windowed[i - 1])
            larger++
    }
    println(larger)

}