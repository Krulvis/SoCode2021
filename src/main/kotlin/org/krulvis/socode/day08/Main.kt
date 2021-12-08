package org.krulvis.socode.day08


fun main() {
    val input =
        ClassLoader.getSystemResource("day8.txt").readText().split("\n").map { it.replace(Char(13).toString(), "") }

    val lines = input.map { it.split(" | ")[0].split(" ") to it.split(" | ")[1].split(" ") }

    println("${lines.size} total lines")
    val identifiables = intArrayOf(2, 3, 4, 7)
    println("part 1: ${lines.sumOf { (_, line) -> line.count { it.length in identifiables } }}")

    println(
        "Part 2: ${
            lines.sumOf { (input, output) ->
                val mapping = mapValues(input)
                output.joinToString(separator = "") {
                    "${mapping.indexOf(it.toCharArray().sorted())}"
                }.toInt()
            }
        }"
    )
}

fun mapValues(line: List<String>): List<List<Char>> {
    val mapping = List(10) { "".toList() }.toMutableList()

    line.map { it.toCharArray().sorted() }.sortedBy { it.size }.forEach {
        when (it.size) {
            2 -> mapping[1] = it
            3 -> mapping[7] = it
            4 -> mapping[4] = it
            5 -> {
                if (it.intersect(mapping[1].toSet()).size == 2) {
                    mapping[3] = it
                } else if (it.toList().intersect(mapping[4].toSet()).size == 3) {
                    mapping[5] = it
                } else {
                    mapping[2] = it
                }
            }
            6 -> {
                if (it.toList().intersect(mapping[1].toSet()).size == 1) {
                    mapping[6] = it
                } else if (it.toList().intersect(mapping[4].toSet()).size == 4) {
                    mapping[9] = it
                } else {
                    mapping[0] = it
                }
            }
            7 -> mapping[8] = it
        }
    }

    return mapping

}