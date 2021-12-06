package org.krulvis.socode.day06

fun main() {
    val lanterns = ClassLoader.getSystemResource("day6.txt").readText().split(",").map { it.toInt() }
    val days = 256
    optimized(lanterns, days)
}

fun optimized(lanterns: List<Int>, days: Int) {
    var lanterns = lanterns
    val dailyNewborn = LongArray(days)
    for (day in 0 until days) {
        lanterns = lanterns.map {
            val newVal = it - 1
            if (newVal < 0) {
                dailyNewborn[day] = dailyNewborn[day] + 1
                6
            } else {
                newVal
            }
        }.toMutableList()
        var newbornDay = day - 9
        while (newbornDay > 0) {
            dailyNewborn[day] = dailyNewborn[day] + dailyNewborn[newbornDay]
            newbornDay -= 7
        }
        println(
            "Day $day has ${dailyNewborn[day]} new lanternfish and ${
                lanterns.size + dailyNewborn.sum()
            } total"
        )
    }
}