package org.krulvis.socode.day01

import java.io.FileReader


fun main() {
    val input = FileReader(
        ClassLoader.getSystemResource("day1.txt").file
    ).readText().split("\n").filter { it.isNotEmpty() }.map { it.toInt() }

    var larger = 0
    input.forEachIndexed { i, r ->
        if (i > 0 && r > input[i - 1])
            larger++
    }
    println(larger)
}