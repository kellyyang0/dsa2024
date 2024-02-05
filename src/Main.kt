//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val stack = Stack<String>()

    stack.push("Winter")
    stack.push("Spring")
    stack.push("Summer")
    stack.push("Fall")

    reverseStack(stack)
}

/**
 * Reverses the order of a stack. The elements at the top go to the bottom.
 * @param orgStack the original stack to be reversed
 * @return the reversed stack object
 */
fun reverseStack(orgStack: Stack<String>): Stack<String> {
    val queue = Queue<String>()
    val reversedStack = Stack<String>()

    //Store elements of stack in a queue
    while (!orgStack.isEmpty()){
        val value = orgStack.pop()

        //Value will not be null due to isEmpty check
        queue.enqueue(value!!)
    }

    //Put values from queue into new stack
    while(!queue.isEmpty()) {
        val value = queue.dequeue()

        //Value will not be null due to isEmpty check
        reversedStack.push(value!!)
    }
    return reversedStack
}