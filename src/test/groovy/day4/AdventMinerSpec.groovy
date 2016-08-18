package day4

import spock.lang.Specification
import spock.lang.Unroll


@Unroll
class AdventMinerSpec extends Specification {

    AdventMiner miner = new AdventMiner()

    def 'code #code should return #expected'(code, zeros, expected) {
        when:
        def result = miner.findFirstMd5With5LeadingZeros(code, zeros)

        then:
        result == expected

        where:
        code       | zeros | expected
        'abcdef'   | 5     | 609043
        'pqrstuv'  | 5     | 1048970
        'ckczppom' | 5     | 117946
        'ckczppom' | 6     | 3938038
    }

}