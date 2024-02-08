//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import kotlin.time.measureTime

fun main() {
    val arraySizes = listOf(100, 1000, 10000, 100000, 1000000, 10000000, 100000000)
    println("numberOfElements totalTime timePerElement")
    for (arraySize in arraySizes) {
        val myList = MyMutableIntList()
        val timeTaken = measureTime {
            for (i in 0..<arraySize) {
                myList.add(i)
            }
        }
        println("$arraySize $timeTaken ${timeTaken/arraySize}")
    }
}