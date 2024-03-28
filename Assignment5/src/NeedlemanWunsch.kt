/**
 * Needleman-Wunsch algorithm for global alignment of sequences
 */
fun needlemanWunsch(sequence1: String, sequence2: String): Pair<String, String> {

    val gridRow: Int = sequence1.length + 1
    val gridCol: Int = sequence2.length + 1

    val grid = Matrix(gridRow, gridCol)

    //Scores, change for diff scoring systems
    val match = 1
    val indel = -1
    val mismatch = -1

    /**
     * Fills in the initial 2 rows and columns with first/top sequence going horizontally on the first row
     * and second/side sequence going vertically on the first column and the initial scores
     */
    grid[0,0] = 0

    for ((index, value) in (1..gridRow).zip(1..sequence1.length)){
        grid[0, index] = value * -1
    }

    for ((index, value) in (1..gridRow).zip(1..sequence1.length)){
        grid[index, 0] = value * -1
    }

    /**
     * Calculates the score of a specified index
     * @param row the row of the index
     * @param col the column of the index
     * @return a number representing the score of that index
     */
    fun calcScore(row: Int, col:Int): Int {
        var diagonal = grid[row-1, col-1]
        if (sequence1[col-1] == sequence2[row-1]) {
            diagonal += match
        }
        else {
            diagonal += mismatch
        }
        val top = grid[row-1, col] + indel
        val left = grid[row, col-1] + indel

        return maxOf(diagonal, left, top)
    }

    /**
     * Populates the remainder of the grid with scores
     */
    for (i in 1..<gridRow){
        for (j in 1..<gridCol){
            val score = calcScore(i,j)
            grid[i,j] = score
        }
    }

    /**
     * Traces back from the bottom right corner of the grid to the top left corner and
     * records movement to add gaps as necessary
     * @return a pair containing the aligned sequences
     */
    var posRow = gridRow - 1
    var posCol = gridCol - 1
    var posSeq1 = 0
    var posSeq2 = 0

    val alignedSeq1 = StringBuilder("")
    val alignedSeq2 = StringBuilder("")

    while (posRow != 0 || posCol != 0) {
        val goNext: Map<String, Int> = mapOf(
            "top" to grid[posRow - 1, posCol],
            "left" to grid[posRow, posCol - 1],
            "diagonal" to grid[posRow - 1, posCol - 1]
        )
        val max = goNext.maxBy { it.value }

        if (max.key == "top") {
            alignedSeq2.insert(0, "-")
            alignedSeq1.insert(0, sequence1[posSeq1])
            posRow -= 1
            posSeq1 += 1
        } else if (max.key == "left") {
            alignedSeq1.insert(0,"-")
            alignedSeq2.insert(0, sequence2[posSeq2])
            posCol -= 1
            posSeq2 += 1
        }
        else {
            alignedSeq1.insert(0, sequence1[posSeq1])
            alignedSeq2.insert(0, sequence2[posSeq2])
            posRow -= 1
            posCol -= 1
            posSeq1 += 1
            posSeq2 += 1
        }
    }
    return Pair(alignedSeq1.reverse().toString(), alignedSeq2.reverse().toString())
}