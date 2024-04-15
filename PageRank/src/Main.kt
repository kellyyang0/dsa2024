fun main() {
    val web = Graph(6)
    web.addEdge(0,1)
    web.addEdge(0,2)
    web.addEdge(1,0)
    web.addEdge(1,2)
    web.addEdge(2,0)
    web.addEdge(2,3)
    web.addEdge(2,4)
    web.addEdge(4,0)
    web.addEdge(4,5)

    val ranks = pageRank(web)

    println("PageRank of nodes:")
    for (i in ranks.indices) {
        println("Page $i: ${ranks[i]}")
    }
}