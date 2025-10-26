fun findPalindromePairs(words: List<String>): List<Pair<String, String>> {
    val palindromePairs = mutableListOf<Pair<String, String>>()
    for (i in words.indices) {
        for (j in words.indices) {
            if (i != j) {
                val combined = words[i] + words[j]
                if (combined == combined.reversed()) {
                    palindromePairs.add(Pair(words[i], words[j]))
                }
            }
        }
    }
    return palindromePairs
}

fun main() {
    val words = listOf("кот", "ток", "торт", "рот", "программа", "грамм", "алгоритм", "собака")
    println("Палиндромные пары: ${findPalindromePairs(words)}")
}