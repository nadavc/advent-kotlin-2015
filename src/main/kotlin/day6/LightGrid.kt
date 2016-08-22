package day6

interface LightStrategy {
    fun turnOn(grid: Array<Array<Int>>, x: Int, y: Int)
    fun turnOff(grid: Array<Array<Int>>, x: Int, y: Int)
    fun toggle(grid: Array<Array<Int>>, x: Int, y: Int)
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
                    "turn on" -> strategy.turnOn(grid, x, y)
                    "turn off" -> strategy.turnOff(grid, x, y)
                    "toggle" -> strategy.toggle(grid, x, y)
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

