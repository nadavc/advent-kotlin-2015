package day6;

class BinaryLightStrategy : LightStrategy {
    override fun toggle(grid: Array<Array<Int>>, x: Int, y: Int) {
        grid[x][y] = when (grid[x][y]) {
            0 -> 1
            1 -> 0
            else -> throw IllegalStateException("Should only have 1s and 0s as state")
        }
    }

    override fun turnOff(grid: Array<Array<Int>>, x: Int, y: Int) {
        grid[x][y] = 0
    }

    override fun turnOn(grid: Array<Array<Int>>, x: Int, y: Int) {
        grid[x][y] = 1
    }
}
