import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

/**
 * Unit Tests for associative array class
 */
class AssociativeArrayTest {

    private var dict = AssociativeArray<String, Int>()

    @BeforeEach
    fun setup() {
        dict = AssociativeArray()
    }


    @org.junit.jupiter.api.Test
    fun set() {
        dict["Jett"] = 10
        dict["Clove"] = 25

        assertEquals(10, dict["Jett"])
        assertEquals(25, dict["Clove"])
    }

    @org.junit.jupiter.api.Test
    fun contains() {
        dict["Jett"] = 10
        dict["Clove"] = 25

        assertTrue(dict.contains("Jett"))
    }

    @org.junit.jupiter.api.Test
    fun get() {
        dict["Jett"] = 10
        dict["Clove"] = 25

        assertEquals(10, dict["Jett"])
        assertEquals(25, dict["Clove"])
    }

    @org.junit.jupiter.api.Test
    fun remove() {
        dict["Jett"] = 10
        dict["Clove"] = 25

        assertEquals(10, dict["Jett"])

        dict.remove("Jett")
        assertFalse(dict.contains("Jett"))
    }

    @org.junit.jupiter.api.Test
    fun numElements() {
        dict["Jett"] = 10
        dict["Clove"] = 25
        dict["Deadlock"] = 23
        dict["Astra"] = 16
        dict["Sova"] = 6

        assertEquals(5, dict.numElements())
    }

    @org.junit.jupiter.api.Test
    fun keyValuePairs() {
        dict["Jett"] = 10
        dict["Clove"] = 25

        assertEquals(mutableListOf(Pair("Jett", 10), Pair("Clove", 25)), dict.keyValuePairs())
    }
}