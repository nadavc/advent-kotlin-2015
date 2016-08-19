package day5

import common.Common
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class NaughtyWordDetectorSpec extends Specification {

    def "check samples: #word nice should be #expected"(String word, boolean expected) {
        def niceDetector = new NiceWordDetector()

        when:
        def result = niceDetector.isNice(word)

        then:
        result == expected

        where:
        word               | expected
        'ugknbfddgicrmopn' | true
        'aaa'              | true
        'jchzalrnumimnmhp' | false
        'haegwjzuvuyypxyu' | false
        'dvszwmarrgswjxmb' | false
    }

    def "check samples 2: #word nice should be #expected"(word, expected) {
        def niceDetector = new NiceWordDetector()

        when:
        def result = niceDetector.isNice2(word)

        then:
        result == expected

        where:
        word               | expected
        'qjhvhtzxzqqjkmpb' | true
        'xxyxx'            | true
        'uurcxstgmygtbstg' | false
        'ieodomkazucvgmuy' | false
    }

    def "solve puzzle 1 and 2"() {
        setup:
        def lines = Common.classLoader.getResource('day5/input.txt').readLines()
        def niceDetector = new NiceWordDetector()

        when:
        def s = lines.count { niceDetector.isNice(it) }

        then:
        s == 258

        when:
        def s2 = lines.count { niceDetector.isNice2(it) }

        then:
        s2 == 53
    }

}
