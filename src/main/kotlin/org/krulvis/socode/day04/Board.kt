package org.krulvis.socode.day04

import java.lang.StringBuilder

fun Array<CharArray>.toIntArray(): List<IntArray> {
    val length = get(0).size

    return map { chars ->
        val numbers = mutableListOf<Int>()
        var i = 0
        while (i < length) {
            numbers.add(chars.copyOfRange(i, i + 2).joinToString("").trim().toInt())
            i += 3
        }
        numbers.toIntArray()
    }
}

class Board(val input: List<IntArray>) {

    constructor(input: Array<CharArray>) : this(input.toIntArray())

    val allLines = input.toMutableList()

    init {
        val columns = input.indices.map { columnIndex ->
            input.map { it[columnIndex] }.toIntArray()
        }
        allLines.addAll(columns)
    }

    fun won(generated: List<Int>): Boolean {
        return allLines.any { line -> line.all { number -> number in generated } }
    }

    fun score(generated: List<Int>): Int {
        val unmarked = input.flatMap { it.toList() }.filterNot { it in generated }
        return unmarked.sum() * generated.last()
    }

    override fun toString(): String {
        val builder = StringBuilder()
        builder.append("BEGIN BOARD \n")
        input.forEach {
            builder.append(it.joinToString() + "\n")
        }
        builder.append("END BOARD \n")
        builder.append("BEGIN LINES \n")
        allLines.forEach { builder.append(it.joinToString() + "\n") }
        builder.append("BEGIN LINES \n")
        return builder.toString()
    }
}