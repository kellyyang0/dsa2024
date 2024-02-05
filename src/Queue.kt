interface QueueInterface<T> {
    /**
     * Add [data] to the end of the queue.
     */
    fun enqueue(data: T)
    /**
     * Remove the element at the front of the queue.  If the queue is empty, it remains unchanged.
     * @return the value at the front of the queue or nil if none exists
     */
    fun dequeue(): T?
    /**
     * @return the value at the front of the queue or nil if none exists
     */
    fun peek(): T?
    /**
     * @return true if the queue is empty and false otherwise
     */
    fun isEmpty(): Boolean
}

class Queue<T>: QueueInterface<T>{

    private val list = DoublyList<T>()

    override fun enqueue(data: T) {
        list.pushBack(data)
    }

    override fun dequeue(): T? {
        return list.popFront()
    }

    override fun peek(): T? {
        return list.peekFront()
    }

    override fun isEmpty(): Boolean {
        return list.isEmpty()
    }


}