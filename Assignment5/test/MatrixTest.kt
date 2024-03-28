import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

/**
 * Unit Tests for matrix class and functions
 */
class MatrixTest {

    @Test
    fun plus(){
        val testMatrix1 = Matrix(arrayOf(
            arrayOf(2,2),
            arrayOf(2,2)))

        val testMatrix2 = Matrix(arrayOf(
            arrayOf(3,3),
            arrayOf(3,3)))

        val correctMatrix = Matrix(arrayOf(
            arrayOf(5,5),
            arrayOf(5,5)))
        assertEquals(correctMatrix.toString(), testMatrix1.plus(testMatrix2).toString())
    }

    @Test
    fun minus(){
        val testMatrix1 = Matrix(arrayOf(
            arrayOf(2,2),
            arrayOf(2,2)))

        val testMatrix2 = Matrix(arrayOf(
            arrayOf(3,3),
            arrayOf(3,3)))

        val correctMatrix = Matrix(arrayOf(
            arrayOf(-1,-1),
            arrayOf(-1,-1)))
        assertEquals(correctMatrix.toString(), testMatrix1.minus(testMatrix2).toString())
    }

    @Test
    fun multiply() {
        val testMatrix1 = Matrix(arrayOf(
            arrayOf(2,2),
            arrayOf(2,2)))

        val testMatrix2 = Matrix(arrayOf(
            arrayOf(3,3),
            arrayOf(3,3)))

        val correctMatrix = Matrix(arrayOf(
            arrayOf(12,12),
            arrayOf(12,12)))
        assertEquals(correctMatrix.toString(),testMatrix1.multiply(testMatrix2).toString())
    }

    @Test
    fun times() {
        val testMatrix1 = Matrix(arrayOf(
            arrayOf(2,2),
            arrayOf(2,2)))

        val testMatrix2 = Matrix(arrayOf(
            arrayOf(3,3),
            arrayOf(3,3)))

        val correctMatrix = Matrix(arrayOf(
            arrayOf(12,12),
            arrayOf(12,12)))
        assertEquals(correctMatrix.toString(),testMatrix1.times(testMatrix2).toString())
    }
}