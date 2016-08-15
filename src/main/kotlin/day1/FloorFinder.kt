package day1

class FloorFinder {

    val accFunc = { count: Int, c: Char ->
        when (c) {
            '(' -> count + 1
            ')' -> count - 1
            else -> throw RuntimeException("Invalid character found: $c")
        }
    }

    fun findFloor(input: String): Int {
        return input.fold(0, accFunc)
    }

    fun findFirstEncounter(input: String, requiredFloor: Int): Int {
        var currentFloor = 0
        input.forEachIndexed { i, c ->
            currentFloor = accFunc(currentFloor, c)
            if (currentFloor == requiredFloor)
                return i + 1
        }
        return -1
    }

}