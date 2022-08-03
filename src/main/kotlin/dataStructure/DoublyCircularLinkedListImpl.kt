package dataStructure

class DoublyCircularLinkedListImpl<T : Comparable<T>>: DoublyLinkedList<T>() {
    override fun push(data: T): DoublyLinkedNode =
        DoublyLinkedNode(data).apply {
            if (isEmpty()){
                next = this
                prev = this
                head = this
            }
            else{

                head?.prev?.next = this

                prev = head?.prev

                next = head

                head?.prev = this

                head = this
            }
        }

    override fun append(data: T): DoublyLinkedNode =
        DoublyLinkedNode(data).apply {
            if (isEmpty()){
                next = this
                prev = this
                head = this
            }else{
                getLast(head).also { last ->
                    next = head

                    prev = last

                    last?.next = this

                    head?.prev = this
                }
            }
        }

    override fun get(node: DoublyLinkedNode?, key: T): DoublyLinkedNode? =
        when{
            isEmpty() -> null
            node == null -> null
            node.data == key -> node
            else -> get(node.next, key)
        }

    override fun insertAfter(prevNode: DoublyLinkedNode?, data: T): DoublyLinkedNode? {
        TODO("Not yet implemented")
    }

    override fun removeAfter(prevNode: DoublyLinkedNode?): DoublyLinkedNode? {
        TODO("Not yet implemented")
    }

    override fun removeAfter(position: Int): DoublyLinkedNode? {
        TODO("Not yet implemented")
    }

    override fun removeLast(): DoublyLinkedNode? {
        TODO("Not yet implemented")
    }

    override fun removeHead(): DoublyLinkedNode? {
        TODO("Not yet implemented")
    }

    override fun removeByKey(node: DoublyLinkedNode?, key: T): DoublyLinkedNode? {
        TODO("Not yet implemented")
    }

    override fun getLast(node: DoublyLinkedNode?): DoublyLinkedNode? =
        when{
            node == null -> null
            node.next == head -> node
            else -> getLast(node.next)
        }

    override fun get(position: Int): DoublyLinkedNode? =
        if (isEmpty()) null
        else{
            var current = head
            for (i in 0 until position){
                current = if (current?.next != head){
                    current?.next
                }else{
                    null
                }
            }
            current
        }
}