import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

/**
 * Unit test for Needleman-Wunsch Algorithm
 */
class NeedlemanWunschKtTest {

    @Test
    fun needlemanWunsch() {
        val sequence1 = "GCATGCG"
        val sequence2 = "GATTACA"

        assertEquals(Pair("GCATG-CG", "G-ATTACA"), needlemanWunsch(sequence1, sequence2))

    }
}