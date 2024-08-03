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

    fun shouldDrawBlind(): Boolean {
        assert(justDrawn == null)
        // Aiming for the lowest card
        val averageBlindValue = getPickupDeck().average()
        val visibleValue = visibleCards[0]
        return averageBlindValue < visibleValue
    }

    fun getSlotToPlay(): Short {
//        val cardToPlay = justDrawn ?: throw AssertionError("No card just drawn")
        // We want to put it in the slot with the highest average value
        val averageBlindValue = getPickupDeck().average()
        val currentValues = myCards.map { (it ?: averageBlindValue).toDouble() }
        return currentValues.indexedMax().first!!.toShort()
    }
}