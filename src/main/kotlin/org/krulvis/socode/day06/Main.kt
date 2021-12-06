package org.krulvis.socode.day06

fun main() {
    var lanterns = ClassLoader.getSystemResource("day6.txt").readText().split(",").map { it.toInt() }
    val days = 256
    optimized(lanterns, days)
}

fun optimized(lanterns: List<Int>, days: Int) {
    var lanterns = lanterns
    val dailyNewborn = mutableMapOf<Int, Long>()
    for (day in 1..days) {
        lanterns = lanterns.map {
            val newVal = it - 1
            if (newVal < 0) {
                dailyNewborn[day] = dailyNewborn.getOrDefault(day, 0) + 1
                6
            } else {
                newVal
            }
        }.toMutableList()
        var newbornDay = day - 9
        while (newbornDay > 0) {
            dailyNewborn[day] = dailyNewborn.getOrDefault(day, 0) + dailyNewborn.getOrDefault(newbornDay, 0)
            newbornDay -= 7
        }
        println(
            "Day $day has ${dailyNewborn[day]} new lanternfish and ${
                lanterns.size + dailyNewborn.values.sum()
            } total"
        )
    }
}