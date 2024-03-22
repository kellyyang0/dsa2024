import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MatrixTest {
    private val testMatrix1 = Matrix(arrayOf(
        arrayOf(0,0,0),
        arrayOf(0,0,0),
        arrayOf(0,0,0)))

    private val testMatrix2 = Matrix(arrayOf(
        arrayOf(1,1,1),
        arrayOf(1,1,1),
        arrayOf(1,1,1)))

    private var correctMatrix = Matrix(arrayOf(
        arrayOf(1,1,1),
        arrayOf(1,1,1),
        arrayOf(1,1,1)))


    @Test
    fun plus(){
        assertEquals(correctMatrix, testMatrix1 + testMatrix2)
    }

    @Test
    fun minus(){
        correctMatrix = Matrix(arrayOf(
            arrayOf(-1,-1,-1),
            arrayOf(-1,-1,-1),
            arrayOf(-1,-1,-1)))
        assertEquals(correctMatrix,testMatrix1 - testMatrix2)
    }

    @Test
    fun multiply() {
        correctMatrix = Matrix(arrayOf(
            arrayOf(-1,-1,-1),
            arrayOf(-1,-1,-1),
            arrayOf(-1,-1,-1)))
        assertEquals(correctMatrix,testMatrix1.multiply(testMatrix2))
    }

    @Test
    fun times() {
        correctMatrix = Matrix(arrayOf(
            arrayOf(-1,-1,-1),
            arrayOf(-1,-1,-1),
            arrayOf(-1,-1,-1)))
        assertEquals(correctMatrix,testMatrix1.times(testMatrix2))
    }
}