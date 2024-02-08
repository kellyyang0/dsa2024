import org.junit.jupiter.api.Assertions.*

class MyMutableIntListTest{
    @Test
    fun add(element:Int){
        val tester = MyMutableIntList()
        tester.add(10)
        assertEquals(tester.size(), 1)
    }
}