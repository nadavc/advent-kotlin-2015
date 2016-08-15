package day4

import spock.lang.Specification
import spock.lang.Unroll


@Unroll
class AdventMinerSpec extends Specification {

    AdventMiner miner = new AdventMiner()

    def 'code #code should return #expected'(code, expected) {
        when:
        def result = miner.findFirstMd5With5LeadingZeros(code)

        then:
        result == expected

        where:
        code      | expected
        'abcdef'  | 609043
        'pqrstuv' | 1048970
    }

}