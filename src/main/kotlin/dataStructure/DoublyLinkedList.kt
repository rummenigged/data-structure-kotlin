package dataStructure

abstract class DoublyLinkedList<T: Comparable<T>>: LinkedList<T, DoublyLinkedList<T>.DoublyLinkedNode>() {

    inner class DoublyLinkedNode(
        override val data: T,
    ): Node<DoublyLinkedNode>(data){
        override var next: DoublyLinkedNode? = null
        var prev: DoublyLinkedNode? = null
    }

    override fun toString(): String{
        return when {
            head == null -> "Empty List"
            head?.next == null -> return "${head?.data} ->"
            else -> {
                var node = head
                var result = ""
                while (node != null){
                    result += "${node.data} ${if (node.next != null) "-> " else ""}"
                    node = node.next
                }
                return result
            }
        }
    }
}