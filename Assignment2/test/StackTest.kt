import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class StackTest {

    @Test
    fun push() {
        val stack = Stack<String>()
        stack.push("purple")
        stack.push("blue")
        stack.push("green")

        assertEquals(stack.peek(),"green")
        assertEquals(stack.pop(),"green")
        assertEquals(stack.pop(),"blue")

    }

    @Test
    fun pop() {
        val stack = Stack<String>()
        stack.push("green")
        assertEquals(stack.pop(),"green")
    }

    @Test
    fun peek() {
        val stack = Stack<String>()
        stack.push("green")
        stack.push("yellow")
        assertEquals(stack.peek(),"yellow")
    }

    @Test
    fun isEmpty() {
        val stack = Stack<String>()
        assertTrue(stack.isEmpty())

        stack.push("green")
        assertFalse(stack.isEmpty())
    }
}