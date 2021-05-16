package ru.skillbranch.skillarticles.extensions

fun String?.indexesOf(
    substr: String,
    ignoreCase: Boolean = true
): List<Int> {
    val NO_RESULT = -1
    val result = mutableListOf<Int>()
    if (substr.isEmpty()) return result
    if (this.isNullOrEmpty()) return result
    var idx = 0
    while(idx != NO_RESULT) {
        idx = indexOf(substr, idx, ignoreCase)
        if (idx != NO_RESULT) {
            result.add(idx)
            idx = idx.inc()
        }
    }
    return result
}
