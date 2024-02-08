class Graph<VertexType> {
    private var vertices: MutableSet<VertexType> = mutableSetOf()
    private var edges: MutableMap<VertexType, MutableSet<VertexType>> = mutableMapOf()

    /**
     * Add the vertex [v] to the graph
     * @param v the vertex to add
     * @return true if the vertex is successfully added, false if the vertex
     *   was already in the graph
     */
    fun addVertex(v: VertexType): Boolean {
        if (vertices.contains(v)) {
            return false
        }
        vertices.add(v)
        return true
    }

    /**
     * Add an edge between vertex [from] connecting to vertex [to]
     * @param from the vertex for the edge to originate from
     * @param to the vertex to connect the edge to
     * @return true if the edge is successfully added and false if the edge
     *     can't be added or already exists
     */
    fun addEdge(from: VertexType, to: VertexType): Boolean {
        if (!vertices.contains(from) || !vertices.contains(to)) {
            return false
        }
        edges[from]?.also { currentAdjacent ->
            if (currentAdjacent.contains(to)) {
                return false
            }
            currentAdjacent.add(to)
        } ?: run {
            edges[from] = mutableSetOf(to)
        }
        return true
    }

    /**
     * Clear all vertices and edges
     */
    fun clear() {
        vertices = mutableSetOf()
        edges = mutableMapOf()
    }

    /**
     * Breadth first search approach to traversing a graph
     * @param from the vertex to start the search from
     * @param to the target vertex to be searched for
     * @return true if there is a path from the root to the target vertex
     */
    fun breadthFirst(from: VertexType, to: VertexType): Boolean{
        var priorityList = Queue<VertexType>() //queue
        var toVisit: MutableSet<VertexType> = mutableSetOf()

        priorityList.enqueue(from)
        toVisit.add(from)

        while(!priorityList.isEmpty()){
            val n = priorityList.dequeue() //pop

            if (n == to){
                return true
            }

            edges[n]?.forEach { edge ->
                if (!toVisit.contains(edge)){
                    toVisit.add(edge)
                    priorityList.enqueue(edge)
                }
            }
        }
        return false
    }


    /**
     * depth first search approach to traversing a graph
     * @param from the vertex to start the search from
     * @param to the target vertex to be searched for
     * @return true if there is a path from the root to the target vertex
     */
    fun depthFirst(from: VertexType, to: VertexType): Boolean{
        var priorityList = Stack<VertexType>() //stack
        var toVisit: MutableSet<VertexType> = mutableSetOf()

        priorityList.push(from)
        toVisit.add(from)

        while(!priorityList.isEmpty()){
            val n = priorityList.pop()

            if (n == to){
                return true
            }

            edges[n]?.forEach { edge ->
                if (!toVisit.contains(edge)){
                    toVisit.add(edge)
                    priorityList.push(edge)
                }
            }
        }
        return false
    }

}

