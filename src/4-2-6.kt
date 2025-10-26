fun buildWordChains(words: List<String>): List<List<String>> {
    val chains = mutableListOf<List<String>>()

    fun backtrack(currentChain: MutableList<String>) {
        chains.add(currentChain.toList())
        val lastWord = currentChain.lastOrNull() ?: return

        for (word in words) {
            if (currentChain.contains(word)) continue
            if (lastWord.last() == word.first()) {
                currentChain.add(word)
                backtrack(currentChain)
                currentChain.removeAt(currentChain.size - 1)
            }
        }
    }

    for (word in words) {
        backtrack(mutableListOf(word))
    }

    return chains.distinct()
}

fun main() {
    val words = listOf("кот", "ток", "торт", "рот", "программа", "грамм", "алгоритм", "собака")
    println("Цепочки слов: ${buildWordChains(words)}")
}