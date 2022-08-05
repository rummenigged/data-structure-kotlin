package dataStructure

abstract class LinkedList<T: Comparable<T>, N: LinkedList<T, N>.Node<N>> {
    protected var head: N? = null

    abstract inner class Node<R: Node<R>>(
        open val data: T,
    ){
        open var next: R? = null

        override fun toString(): String {
            return "{$data}"
        }
    }

    abstract fun push(data: T): N

    abstract fun append(data: T): N

    abstract fun get(node: N? = head, key: T): N?

    abstract fun insertAfter(prevNode: N?, data: T): N?

    abstract fun removeAfter(prevNode: N?): N?

    abstract fun removeAfter(position: Int): N?

    abstract fun removeLast(): N?

    abstract fun removeHead(): N?

    abstract fun removeByKey(node: N? = head, key: T): N?

    abstract fun get(position: Int): N?

    abstract fun getLast(node: N?): N?

    fun middle(node: N? = head): N? =
        get(lengthTailRec(node) / 2)

    abstract fun length(node: N? = head): Int

    abstract fun lengthTailRec(node: N? = head, count: Int = 1): Int

    protected fun isEmpty(): Boolean = head == null
}