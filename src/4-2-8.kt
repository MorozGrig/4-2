fun findMaxOverlap(words: List<String>): Triple<String, String, Pair<Int, String>> {
    var maxCount = 0
    var bestPair: Pair<String, String>? = null
    var commonLettersResult = ""

    for (i in words.indices) {
        for (j in words.indices) {
            if (i != j) {
                val commonLetters = findCommonLetters(words[i], words[j])
                if (commonLetters.first > maxCount) {
                    maxCount = commonLetters.first
                    bestPair = Pair(words[i], words[j])
                    commonLettersResult = commonLetters.second
                }
            }
        }
    }

    return Triple(bestPair?.first ?: "", bestPair?.second ?: "", Pair(maxCount, commonLettersResult))
}

fun findCommonLetters(word1: String, word2: String): Pair<Int, String> {
    val letterCount = mutableMapOf<Char, Int>()

    for (char in word1) {
        letterCount[char] = letterCount.getOrDefault(char, 0) + 1
    }

    val commonLetters = StringBuilder()
    var totalCount = 0

    for (char in word2) {
        if (letterCount.containsKey(char) && letterCount[char]!! > 0) {
            commonLetters.append(char)
            totalCount++
            letterCount[char] = letterCount[char]!! - 1
        }
    }

    return Pair(totalCount, commonLetters.toString())
}

fun main() {
    val words = listOf("кот", "ток", "торт", "рот", "программа", "грамм", "алгоритм", "собака")
    val maxOverlap = findMaxOverlap(words)
    println(
        "Максимальное пересечение букв: ${maxOverlap.first} и ${maxOverlap.second} → " +
                "Общие буквы: '${maxOverlap.third.second}', Количество: ${maxOverlap.third.first}"
    )
}