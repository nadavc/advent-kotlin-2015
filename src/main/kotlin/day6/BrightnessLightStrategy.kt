package day6;

class BrightnessLightStrategy : LightStrategy {
    override fun turnOn(currValue: Int) = currValue + 1
    override fun turnOff(currValue: Int) = Math.max(0, currValue - 1)
    override fun toggle(currValue: Int) = currValue + 2
}