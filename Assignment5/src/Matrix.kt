/**
 * Matrix class capable of storing matrices, creating matrices of size n, sets/gets for specific indices
 */
class Matrix(private val row: Int, private val col: Int){
    private var matrix = Array(row) {Array(col) {0} }

    constructor(matrix: Array<Array<Int>>) : this(matrix.size, matrix[0].size) {
        this.matrix = matrix
    }

    operator fun get(i: Int, j: Int): Int{
        return matrix[i][j]
    }

    operator fun set(i: Int, j: Int, value: Int){
        matrix[i][j] = value
    }

    private fun getRowLength(): Int {
        return matrix.size
    }

    private fun getColLength(): Int {
        return matrix[0].size
    }

    /**
     * Adds [this] matrix with the [other] matrix
     * The two matrices must be of the same dimensions
     * @returns a matrix with values added
     */
    operator fun plus(other: Matrix): Matrix {
        val aRows = this.getRowLength()
        val bCols = other.getColLength()

        if (aRows != bCols){
            throw IllegalArgumentException("mismatched sizes")
        }

        val resultMatrix = Matrix(aRows, bCols)

        for (i in 0..<aRows){
            for (j in 0..<bCols){
                resultMatrix[i, j] = this[i, j] + other[i,j]
            }
        }
        return resultMatrix
    }

    /**
     * Subtracts [this] matrix with the [other] matrix
     * The two matrices must be of the same dimensions
     * @returns a matrix with values subtracted
     */
    operator fun minus(other: Matrix): Matrix {
        val aRows = this.getRowLength()
        val bCols = other.getColLength()

        if (aRows != bCols){
            throw IllegalArgumentException("mismatched sizes")
        }

        val resultMatrix = Matrix(aRows, bCols)

        for (i in 0..<aRows){
            for (j in 0..<bCols){
                resultMatrix[i,j] = this[i,j] - other[i,j]
            }
        }
        return resultMatrix
    }

    /**
     * Multiply [this] matrix by [other].
     * You can implement this either using block-based matrix multiplication or
     * traditional matrix multiplication (the kind you learn about in math
     * classes!)
     * @return [this]*[other] if the dimensions are compatible and null otherwise
     */
    fun multiply(other: Matrix):Matrix? {

        val aRows = this.getRowLength()
        val aCols = this.getColLength()
        val bCols = other.getColLength()

        if (aRows != bCols){
            return null
        }

        val resultMatrix = Matrix(aRows, bCols)

        for (i in 0..<aRows){
            for (j in 0..<bCols){
                var sum = 0
                for (k in 0..<aCols){
                    sum += this[i, k] * other[k, j]
                    resultMatrix[i, j] = sum
                }
            }
        }
        return resultMatrix
    }

    override fun toString(): String{
        val resultString = StringBuilder()
        for (i in 0..<row){
            for (j in 0..<col) {
                resultString.append(matrix[i][j])
                resultString.append(" ")
            }
            resultString.append("\n")
        }
        return resultString.toString()
    }

    /**
     * Multiply [this] matrix by [other] using Strassen's algorithm
     * Function is named times so that it can be an operator
     * Note: returns null if dimensions of matrices are not the same
     * @return [this]*[other] if the dimensions are compatible and null otherwise
     */
    operator fun times(other: Matrix): Matrix {
        val aRows = this.getRowLength()
        val aCols = this.getColLength()
        val bRows = other.getRowLength()
        val bCols = other.getColLength()

        if (aRows != aCols || bRows != bCols || aRows != bCols){
            throw IllegalArgumentException("mismatched size")
        }

        val resultMatrix = Matrix(aRows,aRows)
        val half = aRows/2

        if (aRows == 1) {
            val num = this[0,0] * other[0,0]
            resultMatrix[0,0] = num
            return resultMatrix
        }

        val a11 = Matrix(half, half)
        val a12 = Matrix(half, half)
        val a21 = Matrix(half, half)
        val a22 = Matrix(half, half)

        val b11 = Matrix(half, half)
        val b12 = Matrix(half, half)
        val b21 = Matrix(half, half)
        val b22 = Matrix(half, half)

        for (i in 0..<half){
            for (j in 0..<half){
                a11[i,j] = this[i,j]
                a12[i,j] = this[i+half,j]
                a21[i,j] = this[i,j+half]
                a22[i,j] = this[i+half,j+half]

                b11[i,j] = other[i,j]
                b12[i,j] = other[i+half,j]
                b21[i,j] = other[i,j+half]
                b22[i,j] = other[i+half,j+half]
            }
        }

        val m1 = (a11 + a22) * (b11 + b22)
        val m2 = (a21 + a22) * b11
        val m3 = a11 * (b12 - b22)
        val m4 = a22 * (b21 - b11)
        val m5 = (a11 + a12) * b22
        val m6 = (a21 - a11) * (b11 + b12)
        val m7 = (a12 - a22) * (b21 +b22)

        val c11 = m1 + m4 - m5 + m7
        val c12 = m3 + m5
        val c21 = m2 + m4
        val c22 = m1 - m2 + m3 + m6

        return c11.hStack(c12).vStack(c21.hStack(c22))
    }

    /**
     * Helper function that stacks [this] matrix with another matrix to the right
     * @returns
     */
    private fun hStack(with: Matrix): Matrix {
        val resultValues = Array(matrix.size){ emptyArray<Int>()}

        for (i in matrix.indices) {
            resultValues[i] = matrix[i] + with.matrix[i]
        }

        return Matrix(resultValues)
    }

    private fun vStack(with: Matrix): Matrix {
        if (matrix.size != with.matrix.size) {
            throw IllegalArgumentException("mismatched sizes")
        }

        val resultValues = matrix + with.matrix

        return Matrix(resultValues)
    }

}