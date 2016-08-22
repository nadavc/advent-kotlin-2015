package day6

interface LightStrategy {
    fun turnOn(currValue: Int): Int
    fun turnOff(currValue: Int): Int
    fun toggle(currValue: Int): Int
}

class LightGrid(val size: Int) {

    val grid = Array(size, { Array(size, { 0 }) })
    val instRegex = "(turn on|turn off|toggle) (\\d+),(\\d+) through (\\d+),(\\d+)".toRegex()

    fun processInstruction(inst: String, strategy: LightStrategy) {
        val match = instRegex.matchEntire(inst) ?: throw RuntimeException("Invalid instruction: $inst")
        val action = match.groups.get(1)!!.value
        val (x1, y1, x2, y2) = match.groups.toList().subList(2, 6).map { it!!.value.toInt() }

        for (x in x1..x2) {
            for (y in y1..y2) {
                when (action) {
                    "turn on" -> grid[x][y] = strategy.turnOn(grid[x][y])
                    "turn off" -> grid[x][y] = strategy.turnOff(grid[x][y])
                    "toggle" -> grid[x][y] = strategy.toggle(grid[x][y])
                }
            }
        }
    }

    fun getNumberOfLightsOn() = grid.sumBy {
        it.count { it > 0 }
    }


    fun getTotalBrightness() = grid.sumBy {
        it.sum()
    }

}

