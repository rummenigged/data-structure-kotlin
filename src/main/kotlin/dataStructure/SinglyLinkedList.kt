package dataStructure

abstract class SinglyLinkedList<T: Comparable<T>>: LinkedList<T, SinglyLinkedList<T>.SinglyLinkedNode>() {

    inner class SinglyLinkedNode(
        override val data: T,
    ): Node<SinglyLinkedNode>(data) {
        override var next: SinglyLinkedNode? = null
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