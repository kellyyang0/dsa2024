//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val s = MyStack<String>()
    s.push("hello")
    println(s.isEmpty())
    println(s.pop())
    println(s.pop())
    println(s.isEmpty())
}