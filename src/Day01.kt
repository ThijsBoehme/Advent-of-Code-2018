fun main() {
    fun part1(input: List<Int>) = input.sum()

    fun part2(input: List<Int>): Int {
        val seen = mutableSetOf<Int>()
        var index = 0
        var currentFrequency = 0
        while (currentFrequency !in seen) {
            seen.add(currentFrequency)
            currentFrequency += input[index]
            index = (index + 1) % input.size
        }

        return currentFrequency
    }

    // Test if implementation meets criteria from the description, like:
    check(part1(listOf(+1, -2, +3, +1)) == 3)
    check(part1(listOf(+1, +1, +1)) == 3)
    check(part1(listOf(+1, +1, -2)) == 0)
    check(part1(listOf(-1, -2, -3)) == -6)

    check(part2(listOf(+1, -2, +3, +1)) == 2)
    check(part2(listOf(+1, -1)) == 0)
    check(part2(listOf(+3, +3, +4, -2, -4)) == 10)
    check(part2(listOf(-6, +3, +8, +5, -6)) == 5)
    check(part2(listOf(+7, +7, -2, -7, -4)) == 14)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01").map { it.toInt() }
    part1(input).println()
    part2(input).println()
}
