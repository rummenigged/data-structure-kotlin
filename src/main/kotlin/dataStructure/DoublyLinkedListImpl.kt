package dataStructure

class DoublyLinkedListImpl<T: Comparable<T>>: DoublyLinkedList<T>() {

    override fun push(data: T): DoublyLinkedNode =
        DoublyLinkedNode(data).apply {
            if (head == null) head = this
            else{
                next = head
                head?.prev = this
                head = this
            }
        }

    override fun insertAfter(prevNode: DoublyLinkedNode?, data: T): DoublyLinkedNode? =
        prevNode?.let { node ->
            DoublyLinkedNode(data).apply{
                next = node.next
                prev = prevNode
                prevNode.next = this
                next?.prev = this
            }
        }

    override fun append(data: T): DoublyLinkedNode =
        DoublyLinkedNode(data).apply{
            if (head == null) head = this
            else{
                getLast(head)?.also { last ->
                    last.next = this
                    prev = last
                }
            }
        }


    override fun removeHead(): DoublyLinkedNode? =
        head.let {
            if (head == null) null
            else{
               val aux = head
               head = head?.next
               head?.prev = null
               aux?.next = null
               aux
            }
        }

    override fun removeLast(): DoublyLinkedNode? =
        when {
            isEmpty() -> null
            head?.next == null -> {
                head?.also {
                    head =  null
                }
            }
            else -> {
                getLast(head)?.also { last ->
                    last.prev?.next = null
                    last.prev = null
                }
            }
        }

    override fun removeAfter(prevNode: DoublyLinkedNode?): DoublyLinkedNode? =
        if (isEmpty()) null
        else{
            val node = prevNode?.next
            prevNode?.next = node?.next
            node?.next?.prev = prevNode
            node?.next = null
            node
        }

    override fun removeAfter(position: Int): DoublyLinkedNode? =
        if (isEmpty()) null
        else{
            var node = head
            for (i in 0 until position){
                if (node?.next != null){
                    node = node.next
                }
            }
            val temp = node?.next
            node?.next = node?.next?.next
            node?.next?.prev = node
            temp?.next = null
            temp
        }

    fun removeByKey2(key: T): DoublyLinkedNode?{
        if (isEmpty()) return null
        var temp = head
        var prev: DoublyLinkedNode? = null

        if (temp != null && temp.data == key){
            return head?.also {
                head = it.next
                head?.prev = null
            }
        }

        while (temp != null && temp.data != key){
            prev = temp
            temp = temp.next
        }

        if (temp != null){
            prev?.next = temp.next
            temp.next?.prev = prev
        }

        return temp
    }

    override fun removeByKey(node: DoublyLinkedNode?, key: T): DoublyLinkedNode?{
        return when {
            isEmpty() -> null

            node?.data == key -> {
                if (node == head){
                    head?.also {
                        head = it.next
                        it.next?.prev = null
                    }
                }else{
                    node.apply {
                        next?.prev = prev
                        prev?.next = next

                        next = null
                        prev = null
                    }
                }
            }
            node?.next == null -> null
            else -> removeByKey(node.next, key)
        }
    }

    override fun get(node: DoublyLinkedNode?, key: T): DoublyLinkedNode? =
        when{
            isEmpty() || node == null -> null
            node.data == key -> node
            else -> get(node.next, key)
        }

    override fun get(position: Int): DoublyLinkedNode? =
        if (isEmpty() || position < 0) null
        else{
            var current = head
            for (i in 0 until position ){
                current = if (current?.next != null){
                    current.next
                }else{
                    null
                }
            }
            current
        }

    override fun getLast(node: DoublyLinkedNode?): DoublyLinkedNode? =
        when{
            node == null -> null
            node.next == null -> node
            else -> getLast(node.next)
        }
}