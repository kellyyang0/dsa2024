import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import kotlin.random.Random

class SortsKtTest {
    var unsortedList = listOf<Int>()
    var sortedList = listOf<Int>()
    @BeforeEach
    fun setUp() {
        val toDoubles = (0..10).map { e -> e.toDouble() }
        // unsortedList = toDoubles.toList().shuffled()
        unsortedList = listOf(0, 1, 10, 100).shuffled()
        sortedList = unsortedList.sorted()
    }
    @Test
    fun radixSort() {
//         assertEquals(radixSort(unsortedList), sortedList)

        val allDigits = (0..10).toList().shuffled()

        assertEquals(allDigits.sorted(), radixSort(allDigits))
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

        val allDigits = (0..1000000).toList().shuffled()

        assertEquals(allDigits.sorted(), radixSort(allDigits))

    }
}