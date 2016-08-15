package day2

class WrappingCalc {
    fun wrappingPaperArea(item: String): Int {
        val (small, medium, large) = item.split('x').map { it.toInt() }.sorted()
        return (2 * small * medium) + (2 * medium * large) + (2 * large * small) + small * medium
    }

    fun ribbonLength(item: String): Int {
        val (small, medium, large) = item.split('x').map { it.toInt() }.sorted()
        return (2 * small) + (2 * medium) + small * medium * large
    }
}