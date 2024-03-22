import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MatrixTest {
    private val testMatrix1 = Matrix(arrayOf(
        arrayOf(2,2),
        arrayOf(2,2)))

    private val testMatrix2 = Matrix(arrayOf(
        arrayOf(3,3),
        arrayOf(3,3)))

    private var correctMatrix = Matrix(arrayOf(
        arrayOf(1,1),
        arrayOf(1,1)))

    @Test
    fun plus(){
        assertEquals(correctMatrix.toString(), testMatrix1.plus(testMatrix2).toString())
    }

    @Test
    fun minus(){
        correctMatrix = Matrix(arrayOf(
            arrayOf(-1,-1),
            arrayOf(-1,-1)))
        assertEquals(correctMatrix.toString(), testMatrix1.minus(testMatrix2).toString())
    }

    @Test
    fun multiply() {
        correctMatrix = Matrix(arrayOf(
            arrayOf(0,0),
            arrayOf(0,0)))
        assertEquals(correctMatrix.toString(),testMatrix1.multiply(testMatrix2).toString())
    }

    @Test
    fun times() {
        correctMatrix = Matrix(arrayOf(
            arrayOf(12,12),
            arrayOf(12,12)))
        assertEquals(correctMatrix.toString(),testMatrix1.times(testMatrix2).toString())
    }
}