import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MainKtTest {

    @Test
    fun reverseStack() {
        val stack = Stack<String>()

        stack.push("Winter")
        stack.push("Spring")
        stack.push("Summer")
        stack.push("Fall")

        val newStack = reverseStack(stack)

        assertEquals(newStack.pop(),"Winter")
        assertEquals(newStack.pop(),"Spring")
        assertEquals(newStack.pop(),"Summer")
        assertEquals(newStack.pop(),"Fall")
    }
}