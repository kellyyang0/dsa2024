import org.example.MinHeap

/**
 * This ``Graph`` that represents a directed graph
 * @param VertexType the representation of a vertex in the graph
 */
interface GraphInterface<VertexType> {
    /**
     * @return the vertices in the graph
     */
    fun getVertices(): Set<VertexType>

    /**
     * Add an edge to the graph
     * @param from the vertex the edge starts from
     * @param to the vertex the edge points to
     * @param cost the weight associated with the edge
     */
    fun addEdge(from: VertexType, to: VertexType, cost: Double)

    /**
     * @param from the vertex to find edges from
     * @return the edges from a vertex in the graph
     */
    fun getEdges(from: VertexType): Map<VertexType, Double>

    /**
     * Remove all edges and vertices from the graph
     */
    fun clear()
}

class Graph<VertexType>: GraphInterface<VertexType> {
    private var vertices: MutableSet<VertexType> = mutableSetOf()
    private var edges: MutableMap<VertexType, MutableMap<VertexType, Double>> = mutableMapOf()

    override fun getVertices(): Set<VertexType> {
        return vertices
    }

    override fun clear() {
        vertices = mutableSetOf()
        edges = mutableMapOf()
    }

    override fun getEdges(from: VertexType): Map<VertexType, Double> {

        var r = edges[from]?.toMap()
        if (r == null){
            r = mapOf()
        }
        return r
    }

    override fun addEdge(from: VertexType, to: VertexType, cost: Double) {
        val existingEdges = edges[from]
        if (existingEdges == null) {
            edges[from] = mutableMapOf(to to cost)
        }
        else {
            existingEdges[to] = cost
        }
    }

    fun addVertex(new: VertexType){
        vertices.add(new)
    }
}

/**
 * ``MinPriorityQueue`` maintains a priority queue where the lower
 *  the priority value, the sooner the element will be removed from
 *  the queue.
 *  @param T the representation of the items in the queue
 */
interface MinPriorityQueueInterface<T> {
    /**
     * @return true if the queue is empty, false otherwise
     */
    fun isEmpty(): Boolean

    /**
     * Add [elem] with at level [priority]
     */
    fun addWithPriority(elem: T, priority: Double)

    /**
     * Get the next (lowest priority) element.
     * @return the next element in terms of priority.  If empty, return null.
     */
    fun next(): T?

    /**
     * Adjust the priority of the given element
     * @param elem whose priority should change
     * @param newPriority the priority to use for the element
     *   the lower the priority the earlier the element int
     *   the order.
     */
    fun adjustPriority(elem: T, newPriority: Double)
}

class MinPriorityQueue<T>: MinPriorityQueueInterface<T> {

    private var heap = MinHeap<T>()

    override fun isEmpty(): Boolean {
        return heap.isEmpty()
    }

    override fun next(): T? {
        return heap.getMin()
    }

    override fun adjustPriority(elem: T, newPriority: Double) {
        heap.adjustHeapNumber(elem, newPriority)
    }

    override fun addWithPriority(elem: T, priority: Double) {
        heap.insert(elem, priority)
    }

}