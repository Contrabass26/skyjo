

fun main() {
    val myCards: List<Short?> = listOf(10, null, null, null, null, null, null, null, null, null, null, null)
    val opp1Cards: List<Short?> = listOf(null, null, null, null, null, null, null, null, null, null, null, null)
    val opp2Cards: List<Short?> = listOf(null, null, null, null, null, null, null, null, null, null, null, null)
    val state = GameState(-2, listOf(1), myCards, opp1Cards, opp2Cards)
//    println(state.shouldDrawBlind())
    println(state.getSlotToPlay())
}