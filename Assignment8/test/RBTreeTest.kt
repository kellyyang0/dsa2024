import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import javax.print.attribute.standard.QueuedJobCount

class RBTreeTest {

    @Test
    fun insert() {
        val tester = RBTree()
        tester.insert(5)

        assertTrue(tester.exactLookup(5))
        assertTrue(checkInvariants(tester))
    }

    @Test
    fun insertFixup() {

        //case 1: new node is root
        val tester1 = RBTree()
        tester1.insert(5)
        assertEquals(black, tester1.root!!.color)
        assertTrue(checkInvariants(tester1))


        //case 2: new node's uncle is red
        val tester2 = RBTree()
        tester2.insert(1)
        tester2.insert(2)
        tester2.insert(5)
        tester2.insert(6) //Uncle
        tester2.insert(7)
        tester2.insert(8)

        tester2.insert(0) //new node

        assertEquals(2, tester2.root!!.value) //check root is as expected
        assertEquals(red, tester2.root!!.rightChild!!.color) //check uncle is red
        assertTrue(checkInvariants(tester2))

        //case 3: new node's uncle is black and forms triangle with parent and grandparent
        val tester3 = RBTree()
        tester3.insert(4)
        tester3.insert(6)
        tester3.insert(7) //Uncle
        tester3.insert(8)

        tester3.insert(5) //new node

        assertEquals(6, tester3.root!!.value) //check root is as expected
        assertEquals(black, tester3.root!!.rightChild!!.color) //check uncle is black
        assertTrue(checkInvariants(tester3))

        //case 4: new node's uncle is black and forms line with parent and grandparent
        val tester4 = RBTree()
        tester4.insert(4)
        tester4.insert(6)
        tester4.insert(7) //Uncle
        tester4.insert(8)

        tester4.insert(3) //new node

        assertEquals(6, tester4.root!!.value) //check root is as expected
        assertEquals(black, tester4.root!!.rightChild!!.color) //check uncle is black
        assertTrue(checkInvariants(tester4))



    }

    //Check root node is black
    fun checkProperty2(tree: RBTree): Boolean {
        if (tree.root?.color != black) { //Property 2
            return false
        }
        return true
    }

    //Check that children of a red node are black
    fun checkProperty3(tree: RBTree): Boolean {
        fun valid(node: RBTree.Node?): Boolean {
            if (node == null) {
                return true
            }

            val children = listOf(node.leftChild, node.rightChild)
            val childrenColor = children.map {it?.color}

            if (node.color == red && childrenColor.contains(red)) {
                return false
            }

            return valid(node.leftChild) && valid(node.rightChild)
        }

        return valid(tree.root)
    }

    //Check that number of black nodes from root to all leafs are the same
    fun checkProperty4(tree: RBTree): Boolean {
        val list: MutableList<Int> = mutableListOf()

        fun countBlack(node: RBTree.Node?, count: Int) {

            var score = 0

            if (node == null) {
                list.add(count + 1)
                return
            }

            if (node.color == black) {
                score = 1
            }

            countBlack(node.leftChild, count + score)
            countBlack(node.rightChild, count + score)
        }

        countBlack(tree.root, 0)

        if (list.isNotEmpty()) {
            for (item in list) {
                if (list[0] != item) {
                    return false
                }
            }
        }
        return true
    }

    /**
     * Single function for checking all the invariants
     * @param tree the red-black tree to check
     * @return true if the tree does not violate any invariant, false otherwise
     */
    fun checkInvariants(tree: RBTree): Boolean {
        return checkProperty2(tree) && checkProperty3(tree) && checkProperty4(tree)
    }

}