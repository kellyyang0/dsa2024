fun main() {

    //Graph representing the costs associated with time to travel different parts of the map Haven from the game Valorant
    val haven = Graph<String>()

    //Add different parts of map as vertices
    haven.addVertex("A Site")
    haven.addVertex("B Site")
    haven.addVertex("C Site")
    haven.addVertex("Garage")
    haven.addVertex("C Long")
    haven.addVertex("Grass")
    haven.addVertex("A Short")
    haven.addVertex("A Long")
    haven.addVertex("C Spawn")
    haven.addVertex("CT Spawn")

    //Add possible connections between parts as edges
    haven.addEdge("C Spawn","A Long", 4.0)
    haven.addEdge("C Spawn","A Short", 3.0)
    haven.addEdge("C Spawn","Grass", 1.0)
    haven.addEdge("C Spawn","C Long", 2.0)
    haven.addEdge("A Long","A Site", 1.0)
    haven.addEdge("A Short","A Site", 3.0)
    haven.addEdge("A Site","CT Spawn", 2.0)
    haven.addEdge("Grass","B Site", 3.0)
    haven.addEdge("B Site","A Site", 2.0)
    haven.addEdge("B Site","C Site", 3.0)
    haven.addEdge("Grass","Garage", 2.0)
    haven.addEdge("Garage","C Site", 2.0)
    haven.addEdge("C Long","C Site", 4.0)
    haven.addEdge("C Site","CT Spawn", 3.0)

    //Run dijkstras
    println(dijkstras(haven, "C Spawn", "CT Spawn"))

}