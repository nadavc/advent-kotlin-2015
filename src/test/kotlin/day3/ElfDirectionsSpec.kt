package day3

import io.kotlintest.specs.StringSpec
import loadResource

class ElfDirectionsSpec : StringSpec() {
    init {
        val ed = ElfDirections()

        "samples should work" {
            ed.recordVisitations(">").size shouldBe 2
            ed.recordVisitations("^>v<").size shouldBe 4
            ed.recordVisitations("^v^v^v^v^v").size shouldBe 2
        }

        "samples for second puzzle should work" {
            ed.recordVisitationsWithRobot("^v").size shouldBe 3
            ed.recordVisitationsWithRobot("^>v<").size shouldBe 3
            ed.recordVisitationsWithRobot("^v^v^v^v^v").size shouldBe 11
        }

        "solve puzzle" {
            val input = loadResource("day3/input.txt")
            ed.recordVisitations(input).size shouldBe 2081
            ed.recordVisitationsWithRobot(input).size shouldBe 2341
        }
    }
}