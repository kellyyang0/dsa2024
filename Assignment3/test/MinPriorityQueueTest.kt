import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class MinPriorityQueueTest {
    private var queue = MinPriorityQueue<String>()

    @BeforeEach
    fun setUp() {
        queue = MinPriorityQueue()
    }

    @Test
    fun isEmpty() {
        assertTrue(queue.isEmpty())
        queue.addWithPriority("Sunset", 0.0)
        assertFalse(queue.isEmpty())
    }

    @Test
    operator fun next() {
        queue.addWithPriority("Sunset", 0.0)
        queue.addWithPriority("Icebox", 1.0)
        queue.addWithPriority("Breeze", 3.0)

        assertEquals("Sunset", queue.next())
    }

    @Test
    fun adjustPriority() {
        queue.addWithPriority("Sunset", 1.0)
        queue.addWithPriority("Icebox", 2.0)
        queue.addWithPriority("Breeze", 3.0)

        queue.adjustPriority("Breeze", 0.0)

        assertEquals("Breeze", queue.next())
    }

    @Test
    fun addWithPriority() {
        queue.addWithPriority("Sunset", 0.0)
        queue.addWithPriority("Icebox", 1.0)
        queue.addWithPriority("Breeze", 3.0)

        assertEquals("Sunset", queue.next())
        assertEquals("Icebox", queue.next())
        assertEquals("Breeze", queue.next())
    }
}