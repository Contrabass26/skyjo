class GameState(val justDrawn: Short?, val visibleCards: List<Short>, val myCards: List<Short?>, vararg oppCards: List<Short?>) {

    val oppCards = oppCards.toList()

    private fun getFullDeck() = sequence {
        var value: Short = -2
        while (value <= 12) {
            for (i in 1..10) yield(value)
            value++
        }
    }.toMutableList()

    fun getPickupDeck(): List<Short> {
        val deck = getFullDeck()
        deck -= myCards.toSet()
        oppCards.forEach { deck -= it.toSet() }
        return deck
    }
}