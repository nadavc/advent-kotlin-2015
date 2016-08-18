package day4

import org.apache.commons.codec.digest.DigestUtils

class AdventMiner {

    fun findFirstMd5With5LeadingZeros(code: String, leadingZeros: Int = 5): Int {
        val s = StringBuilder(leadingZeros)
        repeat(leadingZeros) { s.append("0") }

        for (i in 1..5000000) {
            val digest = DigestUtils.md5Hex(code + i.toString())
            if (digest.startsWith(s))
                return i
        }
        return -1
    }

}