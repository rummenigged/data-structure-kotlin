package dataStructure
class CircularLinkedList<T: Comparable<T>>: SinglyLinkedList<T>() {

    override fun push(data: T): SinglyLinkedNode =
        SinglyLinkedNode(data).apply {
            if (head == null) {
                head = this
                head?.next = head
            }
            else{
                var lastNode = head
                while (lastNode?.next != head){
                    lastNode = lastNode?.next
                }

                lastNode?.next = this

                this.next = head

                head = this
            }
        }

    override fun insertAfter(prevNode: SinglyLinkedNode?, data: T): SinglyLinkedNode? =
        prevNode?.let { prev ->
            SinglyLinkedNode(data).apply{
                next = prev.next
                prev.next = this

                if (prev.next == head){
                    head = this
                }
            }
        }


    override fun append(data: T): SinglyLinkedNode =
        SinglyLinkedNode(data).apply{
            if (head == null){
                head = this
                head?.next = head
            }
            else{
                var last = head
                while (last?.next != head){
                    last = last?.next
                }

                last?.next = this

                this.next = head
            }
        }


    override fun removeHead(): SinglyLinkedNode? =
        head?.let {
            when (head?.next) {
                head -> {
                    val aux = head
                    head = null
                    aux
                }
                else -> {
                    var lastNode = head
                    while (lastNode?.next != it){
                        lastNode = lastNode?.next
                    }

                    val aux = it
                    head = it.next
                    lastNode.next = head
                    aux.next = null
                    aux
                }
            }
        }

    override fun removeLast(): SinglyLinkedNode? =
        when {
            isEmpty() -> null
            head?.next == head -> {
                val aux = head
                head = null
                aux
            }
            else -> {

                var current = head
                var prev: SinglyLinkedNode? = null
                while (current?.next != head){
                    prev = current
                    current = current?.next
                }

                prev?.next = current?.next
                current?.next = null
                current
            }
        }

    override fun removeAfter(prevNode: SinglyLinkedNode?): SinglyLinkedNode? =
        when {
            isEmpty() -> null
            head?.next == head -> {
                val aux = head
                head = null
                aux
            }
            else -> {
                val node = prevNode?.next
                prevNode?.next = node?.next

                if (node == head){
                    head = node?.next
                }

                node?.next = null
                node
            }
        }

    override fun removeAfter(position: Int): SinglyLinkedNode? =
        if (isEmpty()) null
        else if (head?.next == head){
          val temp = head
          head = null
          temp
        } else{
            var current = head
            for (i in 0 until position){
                if (current?.next != head){
                    current = current?.next
                }
            }

            if (current?.next == head){
                val aux = head
                head = head?.next
                current?.next = head
                aux?.next = null
                aux
            }else{
                val temp = current?.next
                current?.next = temp?.next
                temp?.next = null
                temp
            }

        }

    fun removeByKey2(key: T): SinglyLinkedNode? =
        when{
            isEmpty() ->  null
            head?.data == key -> {
                if (head?.next == head){
                    head?.also {
                        head = null
                    }
                }else{
                    var lastNode = head
                    while (lastNode?.next != head){
                        lastNode = lastNode?.next
                    }

                    val removedNode = head
                    head = head?.next
                    lastNode?.next = head
                    removedNode?.next = null
                    removedNode
                }
            }

            else -> {
                var current = head
                var prev: SinglyLinkedNode? = null

                while (current?.next != head && current?.data != key){
                    prev = current
                    current = current?.next
                }

                if (current?.data != key) current = null
                else {
                    prev?.next = current.next
                    current.next = null
                }

                current
            }

        }

    override fun removeByKey(node: SinglyLinkedNode?, key: T): SinglyLinkedNode?{
        return if (isEmpty() || node?.next == null) null
        else if (head?.next == head){
            val temp = head
            head = null
            temp
        }
        else if (node == head && node.data == key){
            var lastNode = head
            while (lastNode?.next != head){
                lastNode = lastNode?.next
            }
            val aux = head
            head = head?.next
            lastNode?.next = head
            aux
        } else if (node.next?.data == key){
            val aux = node.next
            node.next = node.next?.next
            aux
        }else removeByKey(node.next, key)
    }

    override fun get(node: SinglyLinkedNode?, key: T): SinglyLinkedNode? =
        when{
            node == null -> null
            node.data == key -> node
            else -> get(node.next, key)
        }

    override fun get(position: Int): SinglyLinkedNode? =
        when {
            isEmpty() -> null
            else -> {
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

    override fun getLast(node: SinglyLinkedNode?): SinglyLinkedNode? =
        when {
            isEmpty() -> null
            node == null -> node
            node.next == head -> node
            else -> {
                getLast(node.next)
            }
        }

    override fun toString(): String {
        return when {
            head == null -> "Empty List"
            head?.next == head -> "${head?.data} -> "
            else -> {
                var result = "${head?.data} -> "
                var node = head?.next
                while (node != head){
                    result += "${node?.data} -> "
                    node = node?.next
                }
                result
            }
        }
    }
}

