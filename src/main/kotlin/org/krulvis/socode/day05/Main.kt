package org.krulvis.socode.day05

import java.awt.Point
import kotlin.math.*

class Line(coordString: String) {

    val start = coordString.split(" -> ")[0].toCoords()

    val end = coordString.split(" -> ")[1].toCoords()

    fun String.toCoords(): Point {
        val coords = split(",")
        return Point(coords[0].toInt(), coords[1].toInt())
    }

    fun points(): List<Point> {
        val dx = if (start.x == end.x) 0 else if (start.x < end.x) 1 else -1
        val dy = if (start.y == end.y) 0 else if (start.y < end.y) 1 else -1
        val dist = max(abs(end.x - start.x), abs(end.y - start.y))
        println("dist=$dist, dx=$dx, dy=$dy")
        return (0..dist).map {
            Point(start.x + dx * it, start.y + dy * it)
        }
    }
}

fun main() {
    val input = ClassLoader.getSystemResource("day5.txt").readText().split("\n").map { Line(it) }
//        .filter { it.start.x == it.end.x || it.start.y == it.end.y } // uncomment for part one
    val points = mutableMapOf<Point, Int>()

    input.forEach {
        println("Getting points for line: [${it.start.x},${it.start.y} -> ${it.end.x},${it.end.y}]")
        val ps = it.points()
        ps.toSet().forEach { point ->
            points[point] = points.getOrDefault(point, 0) + 1
        }
    }
    println(points.filterValues { it >= 2 }.size)
}