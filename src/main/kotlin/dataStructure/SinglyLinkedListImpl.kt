package dataStructure

open class SinglyLinkedListImpl<T: Comparable<T>>: SinglyLinkedList<T>() {

    override fun push(data: T): SinglyLinkedNode =
        SinglyLinkedNode(data).apply {
            if (head == null) head = this
            else{
                next = head

                head = this
            }
        }

    override fun insertAfter(prevNode: SinglyLinkedNode?, data: T): SinglyLinkedNode? =
        prevNode?.let { node ->
            SinglyLinkedNode(data).apply{
                next = node.next
                prevNode.next = this
            }
        }

    override fun append(data: T): SinglyLinkedNode =
        SinglyLinkedNode(data).apply{
            if (head == null) head = this
            else{
                var last = head
                while (last?.next != null){
                    last = last.next
                }
                last?.next = this
            }
        }


    override fun removeHead(): SinglyLinkedNode? =
        head?.let {
           val aux = head
           head = head?.next
           aux?.next = null
           aux
        }

    override fun removeLast(): SinglyLinkedNode? =
        when {
            isEmpty() -> null
            head?.next == null -> {
                val temp = head
                head = null
                temp
            }
            else -> {
                var current = head
                var prev: SinglyLinkedNode? = null
                while (current?.next != null){
                    prev = current
                    current = current.next
                }
                prev?.next = null
                current
            }
        }

    override fun removeAfter(prevNode: SinglyLinkedNode?): SinglyLinkedNode? =
        if (isEmpty()) null
        else{
            val node = prevNode?.next
            prevNode?.next = node?.next
            node?.next = null
            node
        }

    override fun removeAfter(position: Int): SinglyLinkedNode? =
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
            temp?.next = null
            temp
        }

    open fun removeByKey2(key: T): SinglyLinkedNode? =
        when {
            isEmpty() -> null

            (head?.data == key) -> {
                head?.apply {
                    head = next
                }
            }

            else -> {
                var temp = head
                var prev: SinglyLinkedNode? = null

                while (temp != null && temp.data != key) {
                    prev = temp
                    temp = temp.next
                }

                if (temp != null) prev?.next = temp.next

                temp
            }
        }

    override fun removeByKey(node: SinglyLinkedNode?, key: T): SinglyLinkedNode? =
        when {
            isEmpty() -> null
            node == null -> null
            head?.data == key -> {
                head?.also {
                    head = it.next
                }
            }
            node.next?.data == key -> {
                node.next?.also { nodeToBeRemoved ->
                    node.next = nodeToBeRemoved.next
                }
            }
            else -> removeByKey(node.next, key)
        }


    override fun get(node: SinglyLinkedNode?, key: T): SinglyLinkedNode? =
        when{
            node == null -> null
            node.data == key -> node
            else -> get(node.next, key)
        }

    override fun getLast(node: SinglyLinkedNode?): SinglyLinkedNode? =
        when {
            isEmpty() -> null
            node?.next == null -> node
            else -> {
                getLast(node.next)
            }
        }

    override fun get(position: Int): SinglyLinkedNode? =
        if (isEmpty() || position < 0) null
        else {
            var current = head
            for (i in 0 until position){
                current = if (current?.next != null){
                    current.next
                }else{
                    null
                }
            }
            current
        }

    override fun length(node: SinglyLinkedNode?): Int =
        if (node == null) 0
        else 1 + length(node.next)

    override fun lengthTailRec(node: SinglyLinkedNode?, count: Int): Int =
        if (node == null) count
        else lengthTailRec(node.next, count + 1)

}