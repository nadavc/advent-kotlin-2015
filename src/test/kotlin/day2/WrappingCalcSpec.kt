package day2

import io.kotlintest.specs.StringSpec
import loadResource

class WrappingCalcSpec : StringSpec() {
    init {
        val calc = WrappingCalc()

        "it should calculate samples correctly" {
            calc.wrappingPaperArea("2x3x4") shouldBe 58
            calc.wrappingPaperArea("1x1x10") shouldBe 43

            calc.ribbonLength("2x3x4") shouldBe 34
            calc.ribbonLength("1x1x10") shouldBe 14
        }



        "solve advent of code day 2" {
            val listOfMeasurements = loadResource("day2/input.txt").lines()
            listOfMeasurements.sumBy { calc.wrappingPaperArea(it) } shouldBe 1606483

        }

    }
}