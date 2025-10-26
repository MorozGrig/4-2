fun encodeWordPattern(word: String): String {
    val charMap = mutableMapOf<Char, Int>()
    val pattern = StringBuilder()

    for (char in word) {
        if (!charMap.containsKey(char)) {
            charMap[char] = charMap.size
        }
        pattern.append(charMap[char])
    }

    return pattern.toString()
}

fun main() {
    val words = listOf("кот", "ток", "торт", "рот", "программа", "грамм", "алгоритм", "собака")
    for (word in words) {
        println("Кодировка для слова '$word': ${encodeWordPattern(word)}")
    }
}