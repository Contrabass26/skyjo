operator fun MutableList<Short>.minusAssign(deck: Iterable<Short?>) {
    deck.filterNotNull().forEach { remove(it) }
}

fun <T: Comparable<T>> Iterable<T>.indexedMax(): Pair<Int?, T?> {
    var maxIndex: Int? = null
    var max: T? = null
    forEachIndexed { i, value ->
        if (max == null || value > max!!) {
            max = value
            maxIndex = i
        }
    }
    return maxIndex to max
}