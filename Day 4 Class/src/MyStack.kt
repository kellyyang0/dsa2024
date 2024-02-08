interface Stack<T>{
    fun isEmpty(): Boolean
    fun push(data:T)
    fun peek():T
    fun pop():T
}

/**
 * An implementation of a LIFO structure called Stack
 * @param T type of data stored in the stack
 * @property top references the top element in the tack
 *
 */

class MyStack<T>:Stack<T> {
    var top: StackNode<T>? = null

    /**
     * Push [data] onto the Stack
     * @param data the new value to put onto the stack
     */
    override fun push(data:T){
        val n = StackNode(data, top)
        top = n
    }

    /**
     * Pop the top element off the stack
     * @return the top element if it is not empty, else return null
     */
    override fun pop(): T? {
        val tmp = peek()
        top = top?.next
        return tmp
    }

    /**
     * @return the top element if it's not empty, else return null
     */
    override fun peek(): T? {
        return top?.data
    }

    /**
     * @return true if the stack is empty, else return false
     */
    override fun isEmpty(): Boolean{
        return top == null
    }
}

/**
 * @param T the type of data to store
 * @property data the string data associated with the node
 * @property next reference to the next node
 */
class StackNode<T>(val data: T, var next: StackNode<T>?){

}