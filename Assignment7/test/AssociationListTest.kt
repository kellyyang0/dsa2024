import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

/**
 * Unit tests for the association list class
 */
class AssociationListTest {

    private var testList = AssociationList<String, Int>()

    @BeforeEach
    fun setup() {
        testList = AssociationList()
    }

    @Test
    fun get() {
        testList["Jett"] = 10
        testList["Clove"] = 25

        //Check correct value is returned for each key
        assertEquals(10, testList["Jett"])
        assertEquals(25, testList["Clove"])
    }

    @Test
    fun set() {
        testList["Jett"] = 10
        testList["Clove"] = 25

        assertEquals(10, testList["Jett"])
        assertEquals(25, testList["Clove"])
    }

    @Test
    fun isEmpty() {
        //Check that empty list does return true
        assertTrue(testList.isEmpty())

        //Check that list with new item added returns false
        testList["Jett"] = 10
        assertFalse(testList.isEmpty())
    }

    @Test
    fun size() {
        testList["Jett"] = 10
        testList["Clove"] = 25

        assertEquals(2, testList.size())

        //Check if size correctly increases
        testList["Deadlock"] = 23
        testList["Astra"] = 16
        testList["Sova"] = 6

        assertEquals(5, testList.size())
    }

    @Test
    fun remove() {
        testList["Jett"] = 10
        testList["Clove"] = 25

        assertEquals(10, testList["Jett"])

        //Check if item is correctly removed, list will not have the key after
        testList.remove("Jett")

        assertFalse(testList.contains("Jett"))

    }

    @Test
    operator fun iterator() {
        testList["Jett"] = 10
        testList["Clove"] = 25
        testList["Deadlock"] = 23
        testList["Astra"] = 16
        testList["Sova"] = 6

        //Check that iterator works through all items
        for (item in testList) {
            assertTrue(testList.contains(item.first))
        }
    }

    @Test
    fun contains() {
        testList["Jett"] = 10
        assertTrue(testList.contains("Jett"))
    }
}