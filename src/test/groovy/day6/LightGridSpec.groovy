package day6

import spock.lang.Specification

import static common.Common.loadResource


class LightGridSpec extends Specification {

    def "Examples must pass"() {
        setup:
        def lg = new LightGrid(1000)
        def binaryLightStrategy = new BinaryLightStrategy()

        when:
        lg.processInstruction("turn on 0,0 through 999,999", binaryLightStrategy)

        then:
        lg.getNumberOfLightsOn() == 1000000

        when:
        lg.processInstruction("toggle 0,0 through 999,0", binaryLightStrategy)

        then:
        lg.getNumberOfLightsOn() == 999000

        when:
        lg.processInstruction("turn off 499,499 through 500,500", binaryLightStrategy)

        then:
        lg.getNumberOfLightsOn() == 998996
    }

    def "solve"() {
        setup:
        def instructions = loadResource("day6/input.txt").readLines()
        def binaryLightStrategy = new BinaryLightStrategy()
        def brightnessLightStrategy = new BrightnessLightStrategy()

        def lg = new LightGrid(1000)
        def lg2 = new LightGrid(1000)

        when:
        instructions.each {
            lg.processInstruction(it, binaryLightStrategy)
            lg2.processInstruction(it, brightnessLightStrategy)
        }

        then:
        lg.getNumberOfLightsOn() == 377891
        lg2.getTotalBrightness() == 14110788
    }



}