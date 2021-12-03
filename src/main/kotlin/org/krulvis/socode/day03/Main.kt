package org.krulvis.socode.day03

import kotlin.math.pow
import kotlin.math.roundToInt

fun main() {
    val input = ClassLoader.getSystemResource("day3.txt")
        .readText().split("\n")
        .map { line -> line.toCharArray().map { char -> char.digitToInt() } }

    val gamma = mutableListOf<Int>()
    for (x in 0..11) {
        gamma.add(input.map { it[x].toDouble() }.average().roundToInt())
    }
    val epsilon = gamma.map { 1 - it }
    println("gamma=${gamma.joinToString("")}, epsilon=${epsilon.joinToString("")}")
    println("gamma=${gamma.binaryToDecimal()}, epsilon=${epsilon.binaryToDecimal()}")
    println("power consumption=${gamma.binaryToDecimal() * epsilon.binaryToDecimal()}")
    //End of part one

    var filtered = input.toList()
    for (x in 0..11) {
        val mostCommon = filtered.map { it[x].toDouble() }.average().roundToInt()
        filtered = filtered.filter { it[x] == mostCommon }
        if (filtered.size == 1)
            break
    }
    val oxygen = filtered.first()
    println("Oxygen generator rating=${oxygen}")

    filtered = input.toList()
    for (x in 0..11) {
        val leastCommon = 1 - filtered.map { it[x].toDouble() }.average().roundToInt()
        filtered = filtered.filter { it[x] == leastCommon }
        if (filtered.size == 1)
            break
    }
    val co2Scrubber = filtered.first()
    println("CO2 scrubber rating=${co2Scrubber}")
    println("Life support rating=${oxygen.binaryToDecimal() * co2Scrubber.binaryToDecimal()}")
}


fun List<Int>.binaryToDecimal(): Int {
    var decimal = 0.0
    reversed().forEachIndexed { i, b ->
        decimal += b * 2.0.pow(i.toDouble())
    }
    return decimal.toInt()
}