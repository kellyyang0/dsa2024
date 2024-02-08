import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class DoublyListTest {

    @Test
    fun pushFront() {
        val list = DoublyList<String>()
        list.pushFront("a")
        list.pushFront("b")
        list.pushFront("c")

        assertEquals(list.peekFront(), "c")
        assertEquals(list.peekBack(),"a")
    }

    @Test
    fun pushBack() {
        val list = DoublyList<String>()
        list.pushBack("a")
        list.pushBack("b")
        list.pushBack("c")

        assertEquals(list.peekFront(), "a")
        assertEquals(list.peekBack(),"c")
    }

    @Test
    fun popFront() {
        val list = DoublyList<String>()
        list.pushFront("yippie")
        assertEquals(list.popFront(),"yippie")
    }

    @Test
    fun popBack() {
        val list = DoublyList<String>()
        list.pushFront("yippie")
        assertEquals(list.popBack(),"yippie")
    }

    @Test
    fun peekFront() {
        val list = DoublyList<String>()
        list.pushFront("a")
        list.pushFront("b")
        assertEquals(list.peekFront(),"b")
    }

    @Test
    fun peekBack() {
        val list = DoublyList<String>()
        list.pushFront("a")
        list.pushFront("b")
        assertEquals(list.peekBack(),"a")
    }


    @Test
    fun isEmpty() {
        val list = DoublyList<String>()
        list.pushFront("a")
        assertFalse(list.isEmpty())

        list.popFront()
        assertTrue(list.isEmpty())
    }
}