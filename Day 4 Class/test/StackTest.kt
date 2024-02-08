import org.junit.jupiter.api.Assertions.*

class StackTest {

    @Test
    fun push(){
        val s = MyStack<String>()
        s.push(data: "hello")
        s.push(data:"world")
        assertEquals(s.peek(), "world")
        s.pop()
        assertEquals(s.peek(), "hello")
    }

}