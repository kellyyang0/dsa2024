import org.junit.jupiter.api.Assertions.*

class GraphTest {
    private val graph = Graph<String>()
    @org.junit.jupiter.api.BeforeEach
    fun setUp() {
        graph.clear()
    }

    @org.junit.jupiter.api.Test
    fun getVertices() {
        assertTrue(graph.getVertices().isEmpty())
        val vertices = setOf("Haven","Ascent","Bind")
        for (vertex in vertices) {
            graph.addVertex(vertex)
        }
        assertEquals(vertices, graph.getVertices())
    }

    @org.junit.jupiter.api.Test
    fun getEdges() {
        graph.addEdge("Haven", "Ascent", 2.0)
        graph.addEdge("Haven", "Bind", 7.0)
        graph.addEdge("Haven", "Sunset", 3.0)

        graph.addEdge("Ascent", "Bind", 4.0)
        graph.addEdge("Sunset", "Bind", 2.9)
        assertEquals(graph.getEdges("Haven"), mapOf(
            "Ascent" to 2.0,
            "Bind" to 7.0,
            "Sunset" to 3.0
        ))
    }

    @org.junit.jupiter.api.Test
    fun addEdge() {
        graph.addEdge("Haven", "Ascent", 2.0)
        graph.addEdge("Haven", "Bind", 7.0)
        graph.addEdge("Haven", "Sunset", 3.0)

        graph.addEdge("Ascent", "Bind", 4.0)
        graph.addEdge("Sunset", "Bind", 2.9)
        assertEquals(graph.getEdges("Haven"), mapOf(
            "Ascent" to 2.0,
            "Bind" to 7.0,
            "Sunset" to 3.0
        ))
    }
}