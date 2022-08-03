package dataStructure

import org.junit.Test
import kotlin.test.assertEquals

internal class DoublyCircularLinkedListTest {

    private val headPosition = 0

    @Test
    fun `assert push success`() {
        val doublyCircularLinkedList = DoublyCircularLinkedListImpl<Int>()

        val firstExpectedValue = 1
        val head = doublyCircularLinkedList.push(firstExpectedValue)
//      list = 1 ->

        assertEquals(firstExpectedValue, head.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(headPosition)?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(headPosition)?.next?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(headPosition)?.prev?.data)

        val secondExpectedValue = 2
        val head2 = doublyCircularLinkedList.push(secondExpectedValue)
//      list = 2 -> 1 ->

        assertEquals(secondExpectedValue, head2.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, 2)?.next?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, 2)?.prev?.data)

        assertEquals(secondExpectedValue, doublyCircularLinkedList.get(head, 1)?.next?.data)

        assertEquals(secondExpectedValue, doublyCircularLinkedList.get(head, 1)?.prev?.data)

        val thirdExpectedValue = 3
        val head3 = doublyCircularLinkedList.push(thirdExpectedValue)
//      list = 3 -> 2 -> 1 ->

        assertEquals(thirdExpectedValue, head3.data)

        assertEquals(secondExpectedValue, doublyCircularLinkedList.get(head3, 3)?.next?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head3, 3)?.prev?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head3, 2)?.next?.data)

        assertEquals(thirdExpectedValue, doublyCircularLinkedList.get(head3, 2)?.prev?.data)

        assertEquals(thirdExpectedValue, doublyCircularLinkedList.get(head3, 1)?.next?.data)
    }

    @Test
    fun `assert append success`(){
        val doublyCircularLinkedList = DoublyCircularLinkedListImpl<Int>()

        val firstExpectedValue = 1
        val head = doublyCircularLinkedList.append(firstExpectedValue)
//      list = 1 ->

        assertEquals(firstExpectedValue, head.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(headPosition)?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(headPosition)?.next?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(headPosition)?.prev?.data)

        val secondExpectedValue = 2
        assertEquals(secondExpectedValue, doublyCircularLinkedList.append(secondExpectedValue).data)
//      list = 1 -> 2 ->

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, secondExpectedValue)?.next?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, secondExpectedValue)?.prev?.data)

        assertEquals(secondExpectedValue, doublyCircularLinkedList.get(head, firstExpectedValue)?.next?.data)

        assertEquals(secondExpectedValue, doublyCircularLinkedList.get(head, firstExpectedValue)?.prev?.data)

        val thirdExpectedValue = 3
        assertEquals(thirdExpectedValue, doublyCircularLinkedList.append(thirdExpectedValue).data)
//      list = 1 -> 2 -> 3 ->

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, thirdExpectedValue)?.next?.data)

        assertEquals(secondExpectedValue, doublyCircularLinkedList.get(head, thirdExpectedValue)?.prev?.data)

        assertEquals(thirdExpectedValue, doublyCircularLinkedList.get(head, firstExpectedValue)?.prev?.data)

        assertEquals(thirdExpectedValue, doublyCircularLinkedList.get(head, secondExpectedValue)?.next?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, secondExpectedValue)?.prev?.data)
    }

    @Test
    fun `assert insertAfter success`() {
        val doublyCircularLinkedList = DoublyCircularLinkedListImpl<Int>()
        val firstExpectedValue = 1
        val head = doublyCircularLinkedList.push(firstExpectedValue)
//      list = 1 ->
        val secondExpectedValue = 2
        val secondNode = doublyCircularLinkedList.insertAfter(head, secondExpectedValue)
        assertEquals(secondExpectedValue, secondNode?.data)
//      list = 1 -> 2 ->

        assertEquals(secondExpectedValue, doublyCircularLinkedList.get(head, firstExpectedValue)?.next?.data)

        assertEquals(secondExpectedValue, doublyCircularLinkedList.get(head, firstExpectedValue)?.prev?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, secondExpectedValue)?.next?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, secondExpectedValue)?.prev?.data)

        val thirdExpectedValue = 3

        assertEquals(thirdExpectedValue, doublyCircularLinkedList.insertAfter(secondNode, thirdExpectedValue)?.data)
//      list = 1 -> 2 -> 3 ->

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, thirdExpectedValue)?.next?.data)

        assertEquals(secondExpectedValue, doublyCircularLinkedList.get(head, thirdExpectedValue)?.prev?.data)

        assertEquals(thirdExpectedValue, doublyCircularLinkedList.get(head, secondExpectedValue)?.next?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, secondExpectedValue)?.prev?.data)

        assertEquals(thirdExpectedValue, doublyCircularLinkedList.get(head, firstExpectedValue)?.prev?.data)
    }

    @Test
    fun get() {
    }

    @Test
    fun testGet() {
    }

    @Test
    fun removeAfter() {
    }

    @Test
    fun testRemoveAfter() {
    }

    @Test
    fun removeByKey() {
    }

    @Test
    fun removeByKeyRecursively() {
    }
}