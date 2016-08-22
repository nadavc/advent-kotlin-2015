package day6;

class BinaryLightStrategy : LightStrategy {
    override fun toggle(currValue: Int) = when (currValue) {
        0 -> 1
        1 -> 0
        else -> throw IllegalStateException("Should only have 1s and 0s as state")
    }
    override fun turnOff(currValue: Int): Int = 0
    override fun turnOn(currValue: Int) = 1
}
