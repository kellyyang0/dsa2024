class DoublyList<T> {

    private var head: Node<T>?=null
    private var tail: Node<T>?=null

    internal class Node<T>(val data: T, var previous: Node<T>? = null, var next: Node<T>? = null)

    /**
     * Adds the element [data] to the front of the linked list.
     */
    fun pushFront(data: T){
        val newNode = Node<T>(data)
        newNode.next = head
        head?.previous = newNode
        head = newNode
        if(tail == null)
            tail = head
    }

    /**
     * Adds the element [data] to the back of the linked list.
     */
    fun pushBack(data: T){
        val newNode = Node<T>(data)
        newNode.previous = tail
        tail?.next = newNode
        tail = newNode
        if (head == null) {
            head = tail
        }
    }

    /**
     * Removes an element from the front of the list. If the list is empty, it is unchanged.
     * @return the value at the front of the list or nil if none exists
     */
    fun popFront(): T?{
        val data = head?.data
        head = head?.next
        if (head == tail){
            tail = null
        }
        return data
    }

    /**
     * Removes an element from the back of the list. If the list is empty, it is unchanged.
     * @return the value at the back of the list or nil if none exists
     */
    fun popBack(): T?{
        val data = tail?.data
        tail = tail?.previous
        if (head == tail){
            head = null
        }
        return data
    }

    /**
     * @return the value at the front of the list or nil if none exists
     */
    fun peekFront(): T?{
        return head?.data
    }

    /**
     * @return the value at the back of the list or nil if none exists
     */
    fun peekBack(): T?{
        return tail?.data
    }

    /**
     * @return true if the list is empty and false otherwise
     */
    fun isEmpty(): Boolean{
        return head == null
    }
}