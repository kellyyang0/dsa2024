/**
 * Graph class to represent the web implemented as an adjacency matrix
 * @param size the number of nodes in the graph
 */
class Graph(val size: Int) {
    private var adjacencyMatrix = Array(size) { DoubleArray(size) }

    /**
     * Adds a new node to the graph with no edges
     */
    fun addNode() {
        adjacencyMatrix = Array(size+1) {DoubleArray(size+1)}
    }

    /**
     * Adds a new edge to the graph
     * @param from the node from
     * @param to the node being directed towards
     */
    fun addEdge(from: Int, to: Int) {
        adjacencyMatrix[from][to] = 1.0
    }

    /**
     * @param page the page to check
     * @return true if the node has no outgoing links, false otherwise
     */
    fun dangling(page: Int): Boolean {
        return getOutgoingLinks(page).isEmpty()
    }

    /**
     * @param page the page to check outgoing links
     * @return a list with all the nodes this page points to
     */
    fun getOutgoingLinks(page: Int): List<Int> {
        val node = adjacencyMatrix[page]
        val outgoing = mutableListOf<Int>()

        for (i in node.indices) {
            if (node[i] > 0) {
                outgoing.add(i)
            }
        }
        return outgoing
    }
}

/**
 * PageRank algorithm that ranks pages on a web based on the distribution of links pointing towards it
 * @param web the graph representing the web of pages
 * @param iterations the number of iterations to run the algorithm
 * @param damping the damping factor
 * @return an array of the rank for all pages
 */
fun pageRank(web: Graph, iterations: Int = 5, damping: Double = 0.85): DoubleArray {
    val size = web.size
    val ranks = DoubleArray(size) { 1.0 / size } // all ranks equal to start

    for (i in 0..<iterations) {
        val newRanks = DoubleArray(size) { (1 - damping) / size }
        for (node in 0..<size) {
            if (web.dangling(node)) {
                for (otherNode in 0..<size) {
                    newRanks[otherNode] += damping * ranks[node] / size
                }
            } else {
                val outgoingPages = web.getOutgoingLinks(node)
                for (edge in outgoingPages) {
                    newRanks[edge] += damping * ranks[node] / outgoingPages.size
                }
            }
        }

        for (num in ranks.indices) {
            ranks[num] = newRanks[num]
        }
    }

    return ranks
}

