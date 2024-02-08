import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class QueueTest {

    @Test
    fun enqueue() {
        val queue = Queue<String>()
        queue.enqueue("1")
        queue.enqueue("2")
        queue.enqueue("3")

        assertEquals(queue.peek(),"1")
    }

    @Test
    fun dequeue() {
        val queue = Queue<String>()
        queue.enqueue("1")
        queue.enqueue("2")
        queue.enqueue("3")
        queue.dequeue()

        assertEquals(queue.peek(),"2")


    }

    @Test
    fun peek() {
        val queue = Queue<String>()
        queue.enqueue("1")
        queue.enqueue("2")
        assertEquals(queue.peek(),"1")

    }

    @Test
    fun isEmpty() {
        val queue = Queue<String>()
        assertTrue(queue.isEmpty())
        queue.enqueue("1")
        assertFalse(queue.isEmpty())
    }
}