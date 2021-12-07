package org.krulvis.socode.day07

import java.util.Collections.max
import java.util.Collections.min
import kotlin.math.abs

fun main() {
    val input = ClassLoader.getSystemResource("day7.txt").readText().split(",").map { it.toInt() }
    println("Least effort part 1 is: ${leastEffort(input)}")
    println("Least effort part 2 is: ${leastEffort(input, true)}")
}

fun leastEffort(input: List<Int>, sum: Boolean = false): Int {
    return (min(input) until max(input)).map { x ->
        input.sumOf { crab -> if (sum) (1..abs(crab - x)).sum() else abs(crab - x) }
    }.minByOrNull { it }!!
}