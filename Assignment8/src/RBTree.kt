import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.math.max
import kotlin.math.pow

const val black = true
const val red = false

/**
 * Class for a red-black tree, which self-balances and follows the four invariants
 * Reference: https://github.com/msambol/dsa/blob/master/trees/red_black_tree.py
 */
class RBTree {

    /**
     * Class for the node of a red-black tree
     * @param value the int representing the value of the node
     * @param parent the parent node
     * @param color the color of the node, either red or black
     * @param leftChild the left child node (value less than this node)
     * @param rightChild the right child node (value greater than this node)
     */
    class Node(
        val value: Int?,
        var parent: Node? = null,
        var color: Boolean = red,
        var leftChild: Node? = null,
        var rightChild: Node? = null) {

        /**
         * Equals function to evaluate two nodes against each other
         * @return true if the two nodes are equal, false if two nodes are not equal
         */
        override fun equals(other: Any?): Boolean {

            if (other is Node) {
                return this.value == other.value &&
                        this.color == other.color &&
                        this.leftChild == other.leftChild &&
                        this.rightChild == other.rightChild
            }

            return false
        }
    }


    var root: Node? = null //root node of the tree

    /**
     * Function for inserting a new node into the tree
     * @param new the number to be added
     */
    fun insert(new: Int){

        val z = Node(new, color = red)
        var temp: Node? = null
        var currentNode: Node? = root

        while (currentNode?.value != null) {
            temp = currentNode
            if (new < currentNode.value!!) {
                currentNode = currentNode.leftChild ?: break
            }
            else { //new > currentNode.value
                currentNode = currentNode.rightChild ?: break
            }
        }

        z.parent = temp
        if (temp == null) {
            root = z
        }
        else if (new < temp.value!!) {
            temp.leftChild = z
        }
        else { //new > temp.value
            temp.rightChild = z
        }

        insertFixup(z)
    }

    /**
     * Function for fixing invariants caused by inserting a new node
     * @param newNode the new node to be added
     */
    private fun insertFixup(newNode: Node) {

        var z = newNode

        if (z != root) { //no parent if z is the root
            while ((z.parent?.color) == red) {

                val zParent = z.parent
                val zGParent = zParent?.parent

                if (zParent == zGParent?.leftChild) { //when z's parent is a left child
                    val zUncle = zGParent?.rightChild
                    if (zUncle?.color == red){ //case 2
                        zParent.color = black
                        zUncle.color = black
                        zGParent.color = red
                        z = zGParent //problem goes up the tree
                    }
                    else {
                        if (z == zParent!!.rightChild) { //case 3
                            z = zParent
                            leftRotate(z)
                        }
                        zParent.color = black //case 4
                        zGParent?.color = red
                        if (zGParent != null) {
                            rightRotate(zGParent)
                        }
                    }
                }
                else { //when z's parent is a right child
                    val zUncle = zGParent?.leftChild
                    if (zUncle?.color == red) { //case 2
                        zParent.color = black
                        zUncle.color = black
                        zGParent.color = red
                        z = zGParent
                    }
                    else {
                        if (z == zParent?.leftChild) { //case 3
                            z = zParent
                            rightRotate(z)
                        }
                        zParent?.color = black //case 4
                        zGParent?.color = red
                        if (zGParent != null) {
                            leftRotate(zGParent)
                        }
                    }
                }
            }
        }
        root?.color = black // case 1
    }

    /**
     * Right-rotation of the tree
     * @param x the node to rotate from
     */
    private fun rightRotate(x: Node) {
        val y = x.leftChild
        x.leftChild = y!!.rightChild

        if (y.rightChild != null){
            y.rightChild!!.parent = x
        }

        y.parent = x.parent

        if (x.parent == null) {
            root = y
        }
        else if (x == x.parent!!.rightChild) {
            x.parent!!.rightChild = y
        }
        else {
            x.parent!!.leftChild = y
        }

        y.rightChild = x
        x.parent = y
    }

    /**
     * Left-rotation of the tree
     * @param x the node to rotate from
     */
    private fun leftRotate(x: Node) {
        val y = x.rightChild
        x.rightChild = y!!.leftChild

        if (y.leftChild != null){
            y.leftChild!!.parent = x
        }

        y.parent = x.parent

        if (x.parent == null) {
            root = y
        }
        else if (x == x.parent!!.leftChild) {
            x.parent!!.leftChild = y
        }
        else {
            x.parent!!.rightChild = y
        }

        y.leftChild = x
        x.parent = y
    }

    /**
     * Exact lookup function to search if a value is in the tree or not
     * @param num the number to look for in the tree
     * @return true if the value is in the tree, false if not
     */
    fun exactLookup(num: Int): Boolean {
        var currentNode = root

        while (num != currentNode?.value) {
            if (currentNode?.value != null) {
                if (num > currentNode.value!!) {
                    currentNode = currentNode.leftChild!! //if there is no child, will exit loop next run
                }
                else {
                    currentNode = currentNode.rightChild!!
                }
            }
            else {
                return false
            }
        }
        return true
    }

    /**
     * Object with functionality to print the red-black tree with color
     */
    object BTreePrinter { // copied this from https://stackoverflow.com/a/4973083/12021982
        private lateinit var output: PrintStream
        fun printTree(tree: RBTree): String {
            val root = tree.root
            val maxLevel = maxLevel(root)
            val stream = ByteArrayOutputStream()
            output = PrintStream(stream)

            printNodeInternal(listOf(root), 1, maxLevel)
            return stream.toString()
        }

        private fun printNodeInternal(nodes: List<Node?>, level: Int, maxLevel: Int): String {
            if (nodes.isEmpty() || isAllElementsNull(nodes)) return ""

            val floor = maxLevel - level
            val endLines = 2.0.pow((max((floor - 1).toDouble(), 0.0))).toInt()
            val firstSpaces = 2.0.pow(floor.toDouble()).toInt() - 1
            val betweenSpaces = 2.0.pow((floor + 1).toDouble()).toInt() - 1

            printWhitespaces(firstSpaces)

            val newNodes: MutableList<Node?> = ArrayList()
            for (node in nodes) {
                if (node != null) {
                    // Everything after this is in red
                    val colorRed = "\u001b[31m"

                    // Resets previous color codes
                    val reset = "\u001b[0m"

                    output.print(if (node.color == red) "$colorRed${node.value}$reset" else "${node.value}")
                    newNodes.add(node.leftChild)
                    newNodes.add(node.rightChild)
                } else {
                    newNodes.add(null)
                    newNodes.add(null)
                    output.print(" ")
                }

                printWhitespaces(betweenSpaces)
            }
            output.println("")

            for (i in 1..endLines) {
                for (j in nodes.indices) {
                    printWhitespaces(firstSpaces - i)
                    if (nodes[j] == null) {
                        printWhitespaces(endLines + endLines + i + 1)
                        continue
                    }

                    if (nodes[j]?.leftChild != null) output.print("/")
                    else printWhitespaces(1)

                    printWhitespaces(i + i - 1)

                    if (nodes[j]?.rightChild != null) output.print("\\")
                    else printWhitespaces(1)

                    printWhitespaces(endLines + endLines - i)
                }

                output.println("")
            }

            printNodeInternal(newNodes, level + 1, maxLevel)

            return output.toString()
        }

        private fun printWhitespaces(count: Int) {
            for (i in 0..<count) output.print(" ")
        }

        private fun maxLevel(node: Node?): Int {
            if (node == null) return 0

            return (max(
                maxLevel(node.leftChild).toDouble(),
                maxLevel(node.rightChild).toDouble()
            ) + 1).toInt()
        }

        private fun isAllElementsNull(list: List<Node?>): Boolean {
            for (`object` in list) {
                if (`object` != null) return false
            }

            return true
        }
    }
    override fun toString(): String {
        return BTreePrinter.printTree(this)
    }
}