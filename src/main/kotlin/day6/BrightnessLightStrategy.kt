package day6;

class BrightnessLightStrategy : LightStrategy {
    override fun turnOn(grid: Array<Array<Int>>, x: Int, y: Int) {
        grid[x][y]++
    }

    override fun turnOff(grid: Array<Array<Int>>, x: Int, y: Int) {
        if (grid[x][y] > 0) {
            grid[x][y]--
        }
    }

    override fun toggle(grid: Array<Array<Int>>, x: Int, y: Int) {
        grid[x][y] += 2
    }
}