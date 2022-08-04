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

    override fun insertAfter(prevNode: DoublyLinkedNode?, data: T): DoublyLinkedNode? =
        prevNode?.let { prev ->
            DoublyLinkedNode(data).apply {
                next = prev.next
                this.prev = prev

                prev.next?.prev = this
                prev.next = this
            }
        }

    override fun removeAfter(prevNode: DoublyLinkedNode?): DoublyLinkedNode? =
        prevNode?.next?.let { current ->
            when {
                isEmpty() -> null
                head?.next == head -> {
                    head.also {
                        head = null
                    }
                }
                current == head -> {
                    head = current.next
                    head?.prev = prevNode
                    prevNode.next = head
                    current
                }
                else -> {
                    prevNode.next = current.next
                    current.next?.prev = prevNode
                    current
                }
            }
        }

    override fun removeAfter(position: Int): DoublyLinkedNode? {
        var prev = head
        for (i in 0 until position){
            if (prev?.next != head){
               prev = prev?.next
            }else{
                return null
            }
        }

        return when {
            head?.next == head -> {
                head?.also {
                    head = null
                }
            }
            prev?.next == head -> {
                head?.apply {
                    next?.prev = prev
                    prev?.next = next
                    head = next
                }
            }
            else -> {
                prev?.next?.apply {
                    this.prev?.next = next
                    this.next?.prev = prev
                }
            }
        }
    }


    override fun removeLast(): DoublyLinkedNode? =
        when{
            isEmpty() -> null
            head?.next == head -> head.also {
                head = null
            }
            else -> getLast(head)?.also {
                head?.prev = it.prev
                it.prev?.next = head
            }
        }

    override fun removeHead(): DoublyLinkedNode? =
        when {
            isEmpty() -> null
            head?.next == head -> head.also {
                head = null
            }
            else -> head?.also {
                if (it.next?.next == head){
                    head = it.next
                    head?.next = head
                    head?.prev = head

                }else{
                    it.next?.prev = it.prev
                    it.prev?.next = it.next
                }
            }
        }

    override fun removeByKey(node: DoublyLinkedNode?, key: T): DoublyLinkedNode? =
        when{
            isEmpty() -> null

            head?.data == key -> {
                head?.also {
                    if (it.next == head){
                        head = null
                    }else{
                        it.prev?.next = it.next
                        it.next?.prev = it.prev
                        head = it.next
                    }
                }
            }

            node?.data == key -> {
                node.also {
                    it.prev?.next = it.next
                    it.next?.prev = it.prev
                }
            }

            else -> removeByKey(node?.next, key)
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

    override fun toString(): String{
        return when {
            head == null -> "Empty List"
            head?.next == head -> return "${head?.data} ->"
            else -> {
                var node = head?.next
                var result = "${head?.data} -> "
                while (node != head){
                    result += "${node?.data} ${if (node?.next != null) "-> " else ""}"
                    node = node?.next
                }
                return result
            }
        }
    }
}