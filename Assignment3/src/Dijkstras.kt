/**
 * Implementation of Dijkstra's Algorithm
 * @param graph the graph of vertices and edges to be searched
 * @param from the starting vertex of the search
 * @param to the ending vertex of the search
 * @return a list of the shortest path from and to the specified vertices
 */
fun <VertexType> dijkstras(graph: Graph<VertexType>, from: VertexType, to: VertexType): List<VertexType>? {

    val vertices = graph.getVertices()
    val prev: MutableMap<VertexType, VertexType> = mutableMapOf()
    val dist: MutableMap<VertexType, Double> = mutableMapOf()
    val queue = MinPriorityQueue<VertexType>()

    for (vertex in vertices) {
        dist[vertex] = Double.POSITIVE_INFINITY
        queue.addWithPriority(vertex, Double.MAX_VALUE)
    }

    dist[from] = 0.0
    queue.adjustPriority(from, 0.0)

    while (!queue.isEmpty()){
        val urgent = queue.next()

        if (urgent == null){
            break
        }
        else for (neighbor in graph.getEdges(urgent)){
            val vertex = neighbor.key
            val cost = neighbor.value
            //dist[urgent] will never be null as all elements in dist are initialized with infinity
            val alt: Double = dist[urgent]!! + cost

            if (alt < dist[vertex]!!){
                dist[vertex] = alt
                queue.adjustPriority(vertex, alt)
                prev[vertex] = urgent
            }
        }
    }

    //Reconstructing the resultant list from prev
    if (prev[to] == null){
        return null
    }

    val result = mutableListOf<VertexType>(to)
    var current = prev[to]

    while (current != from) {
        result.add(current!!)
        current = prev[current]
    }

    result.add(from)
    return result.reversed()
}