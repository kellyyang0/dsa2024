import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class SortsKtTest {
    var unsortedList = listOf<Double>()
    val sortedList = listOf(0.0, 1.0, 2.0, 3.0, 4.0, 5.0)
    @BeforeEach
    fun setUp() {
        val toDoubles = (0..5).map { e -> e.toDouble() }
        unsortedList = toDoubles.toList().shuffled()
    }
    @Test
    fun radixSort() {
        assertEquals(radixSort(unsortedList), sortedList)
    }

    @Test
    fun mergeSort() {
        assertEquals(mergeSort(unsortedList), sortedList)
    }

    @Test
    fun selectionSort() {
        assertEquals(selectionSort(unsortedList), sortedList)
    }

    @Test
    fun heapSort() {
        assertEquals(heapSort(unsortedList), sortedList)
    }
}