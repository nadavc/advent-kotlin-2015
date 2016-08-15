package day3

import java.util.*

class ElfDirections {

    data class Coordinate(val x: Int, val y: Int)

    fun recordVisitations(path: String): HashSet<Coordinate> {
        val set = HashSet<Coordinate>()
        set.add(Coordinate(0, 0))

        var currX = 0
        var currY = 0
        path.forEach {
            when (it) {
                '^' -> currY++
                '>' -> currX++
                '<' -> currX--
                'v' -> currY--
                else -> throw RuntimeException("Invalid input: $it")
            }
            set.add(Coordinate(currX, currY))
        }

        return set
    }

    fun recordVisitationsWithRobot(path: String): HashSet<Coordinate> {
        val first = path.filterIndexed { i, c -> i % 2 != 0 }
        val second = path.filterIndexed { i, c -> i % 2 == 0 }

        val firstSet = recordVisitations(first)
        val secondSet = recordVisitations(second)
        secondSet.addAll(firstSet)

        return secondSet
    }

}