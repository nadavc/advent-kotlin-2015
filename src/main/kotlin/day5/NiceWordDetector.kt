package day5

class NiceWordDetector {

    // Rules
    // * Contains at least 3 vowels (aeiou)
    // * Contains at least 1 letter that appears twice in a row
    // * Does not contain the strings 'ab', 'cd', 'pq' or 'xy'
    val vowels = listOf('a', 'e', 'i', 'o', 'u')
    val forbidden = listOf("ab", "cd", "pq", "xy")

    fun isNice(word: String): Boolean {
        val numberOfVowels = word.count { vowels.contains(it) }
        var letterAppearsTwice = false
        for (i in 1..word.length-1) {
            if (word[i-1] == word[i]) {
                letterAppearsTwice = true
                break
            }
        }
        val containsForbidden = forbidden.any { word.contains(it) }

        return numberOfVowels >= 3 && letterAppearsTwice && !containsForbidden
    }

    val firstRule = Regex(".*?([a-z][a-z]).*?(\\1).*?")
    val secondRule = Regex(".*?([a-z])[a-z](\\1).*?")

    fun isNice2(word: String): Boolean {
        return firstRule.matches(word) && secondRule.matches(word)
    }
}