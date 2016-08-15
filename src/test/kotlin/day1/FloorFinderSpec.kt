package day1

import io.kotlintest.specs.StringSpec
import loadResource

class FloorFinderSpec : StringSpec() {

    init {
        val ff = FloorFinder()

        "FloorFinder should pass sample inputs" {
            ff.findFloor("(())") shouldBe 0
            ff.findFloor("()()") shouldBe 0

            ff.findFloor("(((") shouldBe 3
            ff.findFloor("(()(()(") shouldBe 3

            ff.findFloor("))(((((") shouldBe 3

            ff.findFloor("())") shouldBe -1
            ff.findFloor("))(") shouldBe -1

            ff.findFloor(")))") shouldBe -3
            ff.findFloor(")())())") shouldBe -3
        }

        "Find first position where basement is entered" {
            ff.findFirstEncounter(")", -1) shouldBe 1
            ff.findFirstEncounter("()())", -1) shouldBe 5
        }

        "Return -1 for when floor is never entered" {
            ff.findFirstEncounter("(((", -1) shouldBe -1
        }

        "Solve advent of code 1" {
            val instructions = loadResource("day1/input.txt")

            ff.findFloor(instructions) shouldBe 280
            ff.findFirstEncounter(instructions, -1) shouldBe 1797
        }
    }
}