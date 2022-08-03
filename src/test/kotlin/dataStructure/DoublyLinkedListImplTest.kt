package dataStructure

import org.junit.Test
import kotlin.test.assertEquals

internal class DoublyLinkedListImplTest {

    private val headPosition = 0

    @Test
    fun `assert push success`() {
        val doublyLinkedList = DoublyLinkedListImpl<Int>()

        val firstExpectedValue = 1

        val head = doublyLinkedList.push(firstExpectedValue)

        assertEquals(firstExpectedValue, head.data)
//      list = 1 ->

        assertEquals(firstExpectedValue, doublyLinkedList.get(headPosition)?.data)

        assertEquals(null, doublyLinkedList.get(headPosition)?.next?.data)

        assertEquals(null, doublyLinkedList.get(headPosition)?.prev?.data)

        val secondExpectedValue = 2
        val head2 = doublyLinkedList.push(secondExpectedValue)
//      list = 2 -> 1 ->

        assertEquals(secondExpectedValue, head2.data)

        assertEquals(secondExpectedValue, doublyLinkedList.get(headPosition)?.data)

        assertEquals(firstExpectedValue, doublyLinkedList.get(headPosition)?.next?.data)

        assertEquals(secondExpectedValue, doublyLinkedList.get(head2, 1)?.prev?.data)

        assertEquals(null, doublyLinkedList.get(head2, 2)?.prev)

        val thirdExpectedValue = 3

        val head3 = doublyLinkedList.push(thirdExpectedValue)
//      list = 3 -> 2 -> 1 ->

        assertEquals(thirdExpectedValue, head3.data)

        assertEquals(thirdExpectedValue, doublyLinkedList.get(headPosition)?.data)

        assertEquals(secondExpectedValue, doublyLinkedList.get(headPosition)?.next?.data)

        assertEquals(thirdExpectedValue, doublyLinkedList.get(head3, 2)?.prev?.data)

        assertEquals(null, doublyLinkedList.get(head3, 3)?.prev)
    }

    @Test
    fun `assert insertAfter success`() {
        val doublyLinkedList = DoublyLinkedListImpl<Int>()

        val firstExpectedValue = 1

        assertEquals(null, doublyLinkedList.insertAfter(null, firstExpectedValue)?.data)

        val head = doublyLinkedList.push(firstExpectedValue)
//      list = 1 ->

        val secondExpectedValue = 2
        val secondNode = doublyLinkedList.insertAfter(head, secondExpectedValue)
//      list = 1 -> 2

        assertEquals(secondExpectedValue, secondNode?.data)

        assertEquals(secondExpectedValue, doublyLinkedList.get(headPosition)?.next?.data)

        assertEquals(firstExpectedValue, doublyLinkedList.get(head, 2)?.prev?.data)

        assertEquals(null, doublyLinkedList.get(head, 2)?.next)

        val thirdExpectedValue = 3

        assertEquals(thirdExpectedValue, doublyLinkedList.insertAfter(secondNode, thirdExpectedValue)?.data)
//      list = 1 -> 2 -> 3

        assertEquals(thirdExpectedValue, doublyLinkedList.get(head, 2)?.next?.data)

        assertEquals(secondExpectedValue, doublyLinkedList.get(head, 3)?.prev?.data)

        assertEquals(null, doublyLinkedList.get(head, 3)?.next?.data)

        val forthExpectedValue = 4

        assertEquals(forthExpectedValue, doublyLinkedList.insertAfter(secondNode, forthExpectedValue)?.data)
//      list = 1 -> 2 -> 4 -> 3

        assertEquals(thirdExpectedValue, doublyLinkedList.get(head, 4)?.next?.data)

        assertEquals(secondExpectedValue, doublyLinkedList.get(head, 4)?.prev?.data)
    }

    @Test
    fun `assert append success`() {
        val doublyLinkedList = DoublyLinkedListImpl<Int>()

        val firstExpectedValue = 1
        val head = doublyLinkedList.append(firstExpectedValue)
        assertEquals(firstExpectedValue, head.data)
//      list = 1

        assertEquals(firstExpectedValue, doublyLinkedList.get(headPosition)?.data)

        val secondExpectedValue = 2
        assertEquals(secondExpectedValue, doublyLinkedList.append(secondExpectedValue).data)
//      list = 1 -> 2

        assertEquals(secondExpectedValue, doublyLinkedList.get(head, 1)?.next?.data)

        assertEquals(firstExpectedValue, doublyLinkedList.get(head, 2)?.prev?.data)

        assertEquals(null, doublyLinkedList.get(head, 1)?.prev?.data)

        val thirdExpectedValue = 3
        assertEquals(thirdExpectedValue, doublyLinkedList.append(thirdExpectedValue).data)
//      list = 1 -> 2 -> 3

        assertEquals(thirdExpectedValue, doublyLinkedList.get(head, 2)?.next?.data)

        assertEquals(secondExpectedValue, doublyLinkedList.get(head, 3)?.prev?.data)

        assertEquals(null, doublyLinkedList.get(head, 3)?.next)

    }

    @Test
    fun `assert removeHead success`() {
        val doublyLinkedList = DoublyLinkedListImpl<Int>()

        assertEquals(null, doublyLinkedList.removeHead())
        val firstExpectedValue = 1
        doublyLinkedList.append(firstExpectedValue)
//      list = 1 ->
        assertEquals(firstExpectedValue, doublyLinkedList.removeHead()?.data)

        assertEquals(null, doublyLinkedList.removeHead())

        val secondExpectedValue = 2
        doublyLinkedList.push(firstExpectedValue)
        doublyLinkedList.append(secondExpectedValue)
//      list = 1 -> 2

        assertEquals(firstExpectedValue, doublyLinkedList.removeHead()?.data)
//      list = 2

        assertEquals(secondExpectedValue, doublyLinkedList.get(headPosition)?.data)

        assertEquals(null, doublyLinkedList.get(headPosition)?.prev)

        val thirdExpectedValue = 3
        doublyLinkedList.append(firstExpectedValue)
        doublyLinkedList.push(thirdExpectedValue)
//      list = 3 -> 2 -> 1

        assertEquals(thirdExpectedValue, doublyLinkedList.removeHead()?.data)
//      list = 2 -> 1

        assertEquals(secondExpectedValue, doublyLinkedList.get(headPosition)?.data)

        assertEquals(null, doublyLinkedList.get(headPosition)?.prev)
    }

    @Test
    fun removeLast() {
        val doublyLinkedList = DoublyLinkedListImpl<Int>()

        assertEquals(null, doublyLinkedList.removeLast())

        val firstExpectedValue = 1
        doublyLinkedList.append(firstExpectedValue)
//      list = 1 ->

        assertEquals(firstExpectedValue, doublyLinkedList.removeLast()?.data)
//      list = null

        assertEquals(null, doublyLinkedList.removeLast())

        val secondExpectedValue = 2
        doublyLinkedList.push(firstExpectedValue)
        doublyLinkedList.append(secondExpectedValue)
//      list = 1 -> 2 ->

        assertEquals(secondExpectedValue, doublyLinkedList.removeLast()?.data)
//      list = 1 ->

        assertEquals(null, doublyLinkedList.get(headPosition)?.next?.data)

        assertEquals(firstExpectedValue, doublyLinkedList.removeLast()?.data)
//      list = null

        assertEquals(null, doublyLinkedList.removeLast()?.data)

        val thirdExpectedValue = 3
        doublyLinkedList.append(secondExpectedValue)
        doublyLinkedList.append(thirdExpectedValue)
//      list = 1 -> 2 -> 3 ->

        assertEquals(thirdExpectedValue, doublyLinkedList.removeLast()?.data)
//      list = 1 -> 2 ->

        assertEquals(null, doublyLinkedList.get(1)?.next)
    }

    @Test
    fun `assert removeAfter success`() {
        val doublyLinkedList = DoublyLinkedListImpl<Int>()

        assertEquals(null, doublyLinkedList.removeAfter(null))

        val firstExpectedValue = 1
        val head = doublyLinkedList.push(firstExpectedValue)
//      list = 1 ->

        assertEquals(null, doublyLinkedList.removeAfter(head))

        assertEquals(firstExpectedValue, doublyLinkedList.get(headPosition)?.data)

        val secondExpectedValue = 2
        doublyLinkedList.append(secondExpectedValue)
//      list = 1 -> 2 ->

        assertEquals(secondExpectedValue, doublyLinkedList.removeAfter(head)?.data)
//      list = 1 ->

        assertEquals(null, doublyLinkedList.get(headPosition)?.next)

        val thirdExpectedValue = 3
        val secondNode = doublyLinkedList.append(secondExpectedValue)
        doublyLinkedList.append(thirdExpectedValue)
//      list = 1 -> 2 -> 3 ->

        assertEquals(thirdExpectedValue, doublyLinkedList.removeAfter(secondNode)?.data)
//      list = 1 -> 2 ->

        assertEquals(null, doublyLinkedList.get(head, secondExpectedValue)?.next)

        val forthExpectedValue = 4
        doublyLinkedList.append(thirdExpectedValue)
        doublyLinkedList.append(forthExpectedValue)
//      list = 1 -> 2 -> 3 -> 4 ->

        assertEquals(thirdExpectedValue, doublyLinkedList.removeAfter(secondNode)?.data)
//      list = 1 -> 2 -> 4 ->

        assertEquals(forthExpectedValue, doublyLinkedList.get(head, secondExpectedValue)?.next?.data)

        assertEquals(secondExpectedValue, doublyLinkedList.get(head, forthExpectedValue)?.prev?.data)
    }

    @Test
    fun testRemoveAfter() {
        val doublyLinkedList = DoublyLinkedListImpl<Int>()

        assertEquals(null, doublyLinkedList.removeAfter(headPosition))

        val firstExpectedValue = 1
        val head = doublyLinkedList.push(firstExpectedValue)
//      list = 1 ->

        assertEquals(null, doublyLinkedList.removeAfter(headPosition))

        assertEquals(firstExpectedValue, doublyLinkedList.get(headPosition)?.data)

        val secondExpectedValue = 2
        doublyLinkedList.append(secondExpectedValue)
//      list = 1 -> 2 ->

        assertEquals(secondExpectedValue, doublyLinkedList.removeAfter(headPosition)?.data)
//      list = 1 ->

        assertEquals(null, doublyLinkedList.get(headPosition)?.next)

        val thirdExpectedValue = 3
        doublyLinkedList.append(secondExpectedValue)
        doublyLinkedList.append(thirdExpectedValue)
//      list = 1 -> 2 -> 3 ->

        assertEquals(thirdExpectedValue, doublyLinkedList.removeAfter(1)?.data)
//      list = 1 -> 2 ->

        assertEquals(null, doublyLinkedList.get(head, secondExpectedValue)?.next)

        val forthExpectedValue = 4
        doublyLinkedList.append(thirdExpectedValue)
        doublyLinkedList.append(forthExpectedValue)
//      list = 1 -> 2 -> 3 -> 4 ->

        assertEquals(thirdExpectedValue, doublyLinkedList.removeAfter(1)?.data)
//      list = 1 -> 2 -> 4 ->

        assertEquals(forthExpectedValue, doublyLinkedList.get(head, secondExpectedValue)?.next?.data)

        assertEquals(secondExpectedValue, doublyLinkedList.get(head, forthExpectedValue)?.prev?.data)
    }

    @Test
    fun removeByKey() {
        val doublyLinkedList = DoublyLinkedListImpl<Int>()

        val firstExpectedValue = 1
        assertEquals(null, doublyLinkedList.removeByKey2(firstExpectedValue))

        doublyLinkedList.push(firstExpectedValue)
//      list = 1 ->

        assertEquals(null, doublyLinkedList.removeByKey2(20)?.data)

        assertEquals(firstExpectedValue, doublyLinkedList.removeByKey2(firstExpectedValue)?.data)

        assertEquals(null, doublyLinkedList.removeByKey2(firstExpectedValue))

        val secondExpectedValue = 2
        doublyLinkedList.push(firstExpectedValue)
        doublyLinkedList.append(secondExpectedValue)
//      list = 1 -> 2 ->

        assertEquals(secondExpectedValue, doublyLinkedList.removeByKey2(secondExpectedValue)?.data)
//      list = 1 ->

        assertEquals(null, doublyLinkedList.get(headPosition)?.next)

        val thirdExpectedValue = 3
        doublyLinkedList.append(secondExpectedValue)
        doublyLinkedList.append(thirdExpectedValue)
//      list = 1 -> 2 -> 3 ->

        assertEquals(thirdExpectedValue, doublyLinkedList.removeByKey2(thirdExpectedValue)?.data)
//      list = 1 -> 2 ->

        assertEquals(null, doublyLinkedList.get(1)?.next?.data)

        assertEquals(firstExpectedValue, doublyLinkedList.removeByKey2(firstExpectedValue)?.data)
//      list = 2 ->

        assertEquals(secondExpectedValue, doublyLinkedList.get(headPosition)?.data)

        assertEquals(null, doublyLinkedList.get(headPosition)?.prev?.data)

        val forthExpectedValue = 4
        doublyLinkedList.push(firstExpectedValue)
        doublyLinkedList.append(thirdExpectedValue)
        doublyLinkedList.append(forthExpectedValue)
//      list = 1 -> 2 -> 3 -> 4 ->

        assertEquals(thirdExpectedValue, doublyLinkedList.removeByKey2(thirdExpectedValue)?.data)
//      list = 1 -> 2 -> 4 ->

        assertEquals(forthExpectedValue, doublyLinkedList.get(1)?.next?.data)

        assertEquals(secondExpectedValue, doublyLinkedList.get(2)?.prev?.data)
    }

    @Test
    fun removeByKeyRecursively() {
        val doublyLinkedList = DoublyLinkedListImpl<Int>()

        val firstExpectedValue = 1
        assertEquals(null, doublyLinkedList.removeByKey(key = firstExpectedValue))

        doublyLinkedList.push(firstExpectedValue)
//      list = 1 ->

        assertEquals(null, doublyLinkedList.removeByKey(key = 20)?.data)

        assertEquals(firstExpectedValue, doublyLinkedList.removeByKey(key = firstExpectedValue)?.data)
//      list = null

        assertEquals(null, doublyLinkedList.removeByKey(key = firstExpectedValue))

        val secondExpectedValue = 2
        doublyLinkedList.push(firstExpectedValue)
        doublyLinkedList.append(secondExpectedValue)
//      list = 1 -> 2 ->

        assertEquals(secondExpectedValue, doublyLinkedList.removeByKey(key = secondExpectedValue)?.data)
//      list = 1 ->

        assertEquals(null, doublyLinkedList.get(headPosition)?.next)

        val thirdExpectedValue = 3
        doublyLinkedList.append(secondExpectedValue)
        doublyLinkedList.append(thirdExpectedValue)
//      list = 1 -> 2 -> 3 ->

        assertEquals(thirdExpectedValue, doublyLinkedList.removeByKey(key = thirdExpectedValue)?.data)
//      list = 1 -> 2 ->

        assertEquals(null, doublyLinkedList.get(1)?.next?.data)

        assertEquals(firstExpectedValue, doublyLinkedList.removeByKey(key = firstExpectedValue)?.data)
//      list = 2 ->

        assertEquals(secondExpectedValue, doublyLinkedList.get(headPosition)?.data)

        assertEquals(null, doublyLinkedList.get(headPosition)?.prev?.data)

        val forthExpectedValue = 4
        doublyLinkedList.push(firstExpectedValue)
        doublyLinkedList.append(thirdExpectedValue)
        doublyLinkedList.append(forthExpectedValue)
//      list = 1 -> 2 -> 3 -> 4 ->

        assertEquals(thirdExpectedValue, doublyLinkedList.removeByKey(key = thirdExpectedValue)?.data)
//      list = 1 -> 2 -> 4 ->

        assertEquals(forthExpectedValue, doublyLinkedList.get(1)?.next?.data)

        assertEquals(secondExpectedValue, doublyLinkedList.get(2)?.prev?.data)
    }

    @Test
    fun `assert get success`() {
        val doublyLinkedList = DoublyLinkedListImpl<Int>()

        val firstExpectedValue = 1

        assertEquals(null, doublyLinkedList.get(null, firstExpectedValue)?.data)

        val head = doublyLinkedList.push(firstExpectedValue)
//      list = 1 ->
        assertEquals(firstExpectedValue, doublyLinkedList.get(head, firstExpectedValue)?.data)

        doublyLinkedList.removeHead()

        assertEquals(null, doublyLinkedList.get(head, firstExpectedValue)?.data)
        val secondExpectedValue = 2
        val head2 = doublyLinkedList.push(secondExpectedValue)
        doublyLinkedList.append(firstExpectedValue)
//      list = 2 -> 1 ->

        assertEquals(secondExpectedValue, doublyLinkedList.get(head2, secondExpectedValue)?.data)

        assertEquals(firstExpectedValue, doublyLinkedList.get(head2, firstExpectedValue)?.data)

        assertEquals(firstExpectedValue, doublyLinkedList.get(head2, secondExpectedValue)?.next?.data)

        assertEquals(secondExpectedValue, doublyLinkedList.get(head2, firstExpectedValue)?.prev?.data)
        val thirdExpectedValue = 3
        doublyLinkedList.append(thirdExpectedValue)
//      list = 2 -> 1 -> 3 ->

        assertEquals(thirdExpectedValue, doublyLinkedList.get(head2, thirdExpectedValue)?.data)

        assertEquals(null, doublyLinkedList.get(head2, 4)?.data)
    }

    @Test
    fun `assert get by position success`(){
        val doublyLinkedList = DoublyLinkedListImpl<Int>()

        assertEquals(null, doublyLinkedList.get(headPosition))
//      list = null

        val firstExpectedValue = 1
        doublyLinkedList.push(firstExpectedValue)
//      list = 1 ->

        assertEquals(firstExpectedValue, doublyLinkedList.get(headPosition)?.data)

        doublyLinkedList.removeHead()
//      list = null

        assertEquals(null, doublyLinkedList.get(headPosition))

        val secondExpectedValue = 2
        doublyLinkedList.push(firstExpectedValue)
        doublyLinkedList.append(secondExpectedValue)
//      list = 1 -> 2 ->

        assertEquals(secondExpectedValue, doublyLinkedList.get(1)?.data)

        assertEquals(secondExpectedValue, doublyLinkedList.get(headPosition)?.next?.data)

        assertEquals(firstExpectedValue, doublyLinkedList.get(1)?.prev?.data)

        val thirdExpectedValue = 3
        doublyLinkedList.append(thirdExpectedValue)
//      list = 1 -> 2 -> 3 ->

        assertEquals(thirdExpectedValue, doublyLinkedList.get(2)?.data)

        assertEquals(thirdExpectedValue, doublyLinkedList.get(1)?.next?.data)

        assertEquals(secondExpectedValue, doublyLinkedList.get(2)?.prev?.data)

    }
}