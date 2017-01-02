package day7

import day6.BinaryLightStrategy
import day6.BrightnessLightStrategy
import day6.LightGrid
import spock.lang.Specification

import static common.Common.loadResource


class BitwiseOperatorSpec extends Specification {

    def 'example should pass'() {
        setup:
        def instructions = """\
                123 -> x
                456 -> y
                x AND y -> d
                x OR y -> e
                x LSHIFT 2 -> f
                y RSHIFT 2 -> g
                NOT x -> h
                NOT y -> i""".stripIndent().readLines()
        def bwOp = new BitwiseOperator(instructions)

        when:
        def results = bwOp.process()

        then:
        results == [
                d: 72,
                e: 507,
                f: 492,
                g: 114,
                h: 65412,
                i: 65079,
                x: 123,
                y: 456,
        ]
    }

    def 'solve'() {
        setup:
        def instructions = loadResource("day7/input.txt").readLines()
        def operator = new BitwiseOperator(instructions)

        when:
        def result = operator.process()

        then:
        result['a'] == 0
    }


}