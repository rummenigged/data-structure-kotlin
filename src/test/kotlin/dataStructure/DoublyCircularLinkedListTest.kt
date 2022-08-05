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

        assertEquals(null, doublyCircularLinkedList.insertAfter(null, thirdExpectedValue)?.data)

    }

    @Test
    fun `assert removeLast success`(){
        val doublyCircularLinkedList = DoublyCircularLinkedListImpl<Int>()

        assertEquals(null, doublyCircularLinkedList.removeLast())

        val firstExpectedValue = 1
        doublyCircularLinkedList.push(firstExpectedValue)
//      list = 1 ->

        assertEquals(firstExpectedValue, doublyCircularLinkedList.removeLast()?.data)

        assertEquals(null, doublyCircularLinkedList.removeLast())

        val secondExpectedValue = 2
        val head = doublyCircularLinkedList.push(firstExpectedValue)
        doublyCircularLinkedList.append(secondExpectedValue)
//      list = 1 -> 2 ->

        assertEquals(secondExpectedValue, doublyCircularLinkedList.removeLast()?.data)
//      list = 1 ->

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, firstExpectedValue)?.next?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, firstExpectedValue)?.prev?.data)

        val thirdExpectedValue = 3
        doublyCircularLinkedList.append(secondExpectedValue)
        doublyCircularLinkedList.append(thirdExpectedValue)
//      list = 1 -> 2 -> 3 ->

        assertEquals(thirdExpectedValue, doublyCircularLinkedList.removeLast()?.data)

//      list = 1 -> 2 ->

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, secondExpectedValue)?.next?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, secondExpectedValue)?.prev?.data)

        assertEquals(secondExpectedValue, doublyCircularLinkedList.get(head, firstExpectedValue)?.next?.data)

        assertEquals(secondExpectedValue, doublyCircularLinkedList.get(head, firstExpectedValue)?.prev?.data)

    }

    @Test
    fun `assert removeHead success`(){
        val doublyCircularLinkedList = DoublyCircularLinkedListImpl<Int>()

        assertEquals(null, doublyCircularLinkedList.removeHead())

        val firstExpectedValue = 1
        doublyCircularLinkedList.push(firstExpectedValue)
//      list = 1 ->

        assertEquals(firstExpectedValue, doublyCircularLinkedList.removeHead()?.data)
//      list = null

        assertEquals(null, doublyCircularLinkedList.removeHead())

        val secondExpectedValue = 2
        doublyCircularLinkedList.push(secondExpectedValue)
        val head = doublyCircularLinkedList.append(firstExpectedValue)
//      list = 2 -> 1 ->

        println(doublyCircularLinkedList.toString())

        assertEquals(secondExpectedValue, doublyCircularLinkedList.removeHead()?.data)
//      list = 1 ->

        println(doublyCircularLinkedList.toString())

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, firstExpectedValue)?.next?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, firstExpectedValue)?.prev?.data)

        val thirdExpectedValue = 3
        doublyCircularLinkedList.push(thirdExpectedValue)
        doublyCircularLinkedList.append(secondExpectedValue)
//      list = 3 -> 1 -> 2 ->

        assertEquals(thirdExpectedValue, doublyCircularLinkedList.removeHead()?.data)
//      list = 1 -> 2 ->

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, secondExpectedValue)?.next?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, secondExpectedValue)?.prev?.data)

        assertEquals(secondExpectedValue, doublyCircularLinkedList.get(head, firstExpectedValue)?.next?.data)

        assertEquals(secondExpectedValue, doublyCircularLinkedList.get(head, firstExpectedValue)?.prev?.data)
    }

    @Test
    fun `assert removeAfter success`() {
        val doublyCircularLinkedList = DoublyCircularLinkedListImpl<Int>()

        val firstExpectedValue = 1
        var head = doublyCircularLinkedList.push(firstExpectedValue)
//      list = 1 ->

        val secondExpectedValue = 2
        doublyCircularLinkedList.append(secondExpectedValue)
//      list = 1 -> 2 ->

        assertEquals(secondExpectedValue, doublyCircularLinkedList.removeAfter(head)?.data)
//      list = 1 ->

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(headPosition)?.next?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(headPosition)?.prev?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.removeAfter(head)?.data)
//      list = null

        assertEquals(null, doublyCircularLinkedList.removeAfter(head)?.data)

        val thirdExpectedValue = 3
        head = doublyCircularLinkedList.push(firstExpectedValue)
        val secondNode = doublyCircularLinkedList.append(secondExpectedValue)
        doublyCircularLinkedList.append(thirdExpectedValue)
//      list = 1 -> 2 -> 3 ->

        assertEquals(thirdExpectedValue, doublyCircularLinkedList.removeAfter(secondNode)?.data)
//      list = 1 -> 2 ->

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(headPosition + 1)?.next?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(headPosition + 1)?.prev?.data)

        assertEquals(secondExpectedValue, doublyCircularLinkedList.get(headPosition)?.next?.data)

        assertEquals(secondExpectedValue, doublyCircularLinkedList.get(headPosition)?.prev?.data)

        val forthExpectedValue = 4
        val thirdNode = doublyCircularLinkedList.append(thirdExpectedValue)
        doublyCircularLinkedList.append(forthExpectedValue)
//      list = 1 -> 2 -> 3 -> 4 ->

        assertEquals(forthExpectedValue, doublyCircularLinkedList.removeAfter(thirdNode)?.data)
//      list = 1 -> 2 -> 3 ->

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, thirdExpectedValue)?.next?.data)

        assertEquals(thirdExpectedValue, doublyCircularLinkedList.get(head, firstExpectedValue)?.prev?.data)
    }

    @Test
    fun `assert removeAfter by position success`() {
        val doublyCircularLinkedList = DoublyCircularLinkedListImpl<Int>()

        val firstExpectedValue = 1
        var head = doublyCircularLinkedList.push(firstExpectedValue)
//      list = 1 ->

        val secondExpectedValue = 2
        doublyCircularLinkedList.append(secondExpectedValue)
//      list = 1 -> 2 ->

        assertEquals(secondExpectedValue, doublyCircularLinkedList.removeAfter(headPosition)?.data)
//      list = 1 ->

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(headPosition)?.next?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(headPosition)?.prev?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.removeAfter(headPosition)?.data)
//      list = null

        assertEquals(null, doublyCircularLinkedList.removeAfter(headPosition)?.data)

        val thirdExpectedValue = 3
        head = doublyCircularLinkedList.push(firstExpectedValue)
        val secondNode = doublyCircularLinkedList.append(secondExpectedValue)
        doublyCircularLinkedList.append(thirdExpectedValue)
//      list = 1 -> 2 -> 3 ->

        assertEquals(thirdExpectedValue, doublyCircularLinkedList.removeAfter(headPosition + 1)?.data)
//      list = 1 -> 2 ->

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(headPosition + 1)?.next?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(headPosition + 1)?.prev?.data)

        assertEquals(secondExpectedValue, doublyCircularLinkedList.get(headPosition)?.next?.data)

        assertEquals(secondExpectedValue, doublyCircularLinkedList.get(headPosition)?.prev?.data)

        val forthExpectedValue = 4
        val thirdNode = doublyCircularLinkedList.append(thirdExpectedValue)
        doublyCircularLinkedList.append(forthExpectedValue)
//      list = 1 -> 2 -> 3 -> 4 ->

        assertEquals(forthExpectedValue, doublyCircularLinkedList.removeAfter(headPosition + 2)?.data)
//      list = 1 -> 2 -> 3 ->

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, thirdExpectedValue)?.next?.data)

        assertEquals(thirdExpectedValue, doublyCircularLinkedList.get(head, firstExpectedValue)?.prev?.data)
    }

    @Test
    fun removeByKey() {
        val doublyCircularLinkedList = DoublyCircularLinkedListImpl<Int>()

        val firstExpectedValue = 1
        var head = doublyCircularLinkedList.push(firstExpectedValue)
//      list = 1 ->

        assertEquals(firstExpectedValue, doublyCircularLinkedList.removeByKey(head, firstExpectedValue)?.data)
//      list = null

        assertEquals(null, doublyCircularLinkedList.removeByKey(head, firstExpectedValue))

        val secondExpectedValue = 2
        head = doublyCircularLinkedList.push(firstExpectedValue)
        doublyCircularLinkedList.append(secondExpectedValue)
//      list = 1 -> 2 ->

        assertEquals(secondExpectedValue, doublyCircularLinkedList.removeByKey(head, secondExpectedValue)?.data)
//      list = 1 ->

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(headPosition)?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, firstExpectedValue)?.next?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, firstExpectedValue)?.prev?.data)

        val thirdExpectedValue = 3
        doublyCircularLinkedList.append(secondExpectedValue)
        doublyCircularLinkedList.append(thirdExpectedValue)
//      list = 1 -> 2 -> 3 ->

        assertEquals(thirdExpectedValue, doublyCircularLinkedList.removeByKey(head, thirdExpectedValue)?.data)
//      list = 1 -> 2 ->

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, secondExpectedValue)?.next?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, secondExpectedValue)?.prev?.data)

        assertEquals(secondExpectedValue, doublyCircularLinkedList.get(head, firstExpectedValue)?.next?.data)

        assertEquals(secondExpectedValue, doublyCircularLinkedList.get(head, firstExpectedValue)?.prev?.data)

        val forthExpectedValue = 4
        doublyCircularLinkedList.append(thirdExpectedValue)
        doublyCircularLinkedList.append(forthExpectedValue)
//      list = 1 -> 2 -> 3 -> 4 ->

        assertEquals(secondExpectedValue, doublyCircularLinkedList.removeByKey(head, secondExpectedValue)?.data)
//      list = 1 -> 3 -> 4 ->

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, thirdExpectedValue)?.prev?.data)

        assertEquals(thirdExpectedValue, doublyCircularLinkedList.get(head, firstExpectedValue)?.next?.data)

        assertEquals(firstExpectedValue, doublyCircularLinkedList.get(head, forthExpectedValue)?.next?.data)

        assertEquals(forthExpectedValue, doublyCircularLinkedList.get(head, firstExpectedValue)?.prev?.data)
    }

    @Test
    fun `assert getLast success`() {
        val doublyCircularLinkedList = DoublyCircularLinkedListImpl<Int>()

        val firstExpectedValue = 1
        var head = doublyCircularLinkedList.push(firstExpectedValue)
//      list = 1 ->

        assertEquals(firstExpectedValue, doublyCircularLinkedList.getLast(head)?.data)

        val secondExpectedValue = 2
        doublyCircularLinkedList.append(secondExpectedValue)
//      list = 1 -> 2 ->

        val secondNode = doublyCircularLinkedList.getLast(head)
        assertEquals(secondExpectedValue, secondNode?.data)

        assertEquals(firstExpectedValue, secondNode?.next?.data)

        assertEquals(firstExpectedValue, secondNode?.prev?.data)
//      list = 1 ->


        val thirdExpectedValue = 3
        doublyCircularLinkedList.append(thirdExpectedValue)
//      list = 1 -> 2 -> 3 ->
        val thirdNode = doublyCircularLinkedList.get(head, thirdExpectedValue)

        assertEquals(thirdExpectedValue, thirdNode?.data)

        assertEquals(firstExpectedValue, thirdNode?.next?.data)

        assertEquals(secondExpectedValue, thirdNode?.prev?.data)
    }

    @Test
    fun `assert get by position success`() {
        val doublyCircularLinkedList = DoublyCircularLinkedListImpl<Int>()

        val firstExpectedValue = 1
        doublyCircularLinkedList.push(firstExpectedValue)
//      list = 1 ->

        val head = doublyCircularLinkedList.get(headPosition)
        assertEquals(firstExpectedValue, head?.data)

        assertEquals(firstExpectedValue, head?.next?.data)

        assertEquals(firstExpectedValue, head?.prev?.data)

        val secondExpectedValue = 2
        doublyCircularLinkedList.append(secondExpectedValue)
//      list = 1 -> 2 ->

        val secondNode = doublyCircularLinkedList.get(headPosition + 1)

        assertEquals(secondExpectedValue, secondNode?.data)

        assertEquals(firstExpectedValue, secondNode?.next?.data)

        assertEquals(firstExpectedValue, secondNode?.prev?.data)

        val thirdExpectedValue = 3
        doublyCircularLinkedList.append(thirdExpectedValue)

        val thirdNode = doublyCircularLinkedList.get(headPosition + 2)

        assertEquals(thirdExpectedValue, thirdNode?.data)

        assertEquals(firstExpectedValue, thirdNode?.next?.data)

        assertEquals(secondExpectedValue, thirdNode?.prev?.data)
    }

    @Test
    fun `assert get success`() {
        val doublyCircularLinkedList = DoublyCircularLinkedListImpl<Int>()

        val firstExpectedValue = 1
        val head = doublyCircularLinkedList.push(firstExpectedValue)
//      list = 1 ->
        val firstNode = doublyCircularLinkedList.get(head, firstExpectedValue)
        assertEquals(firstExpectedValue, firstNode?.data)

        assertEquals(firstExpectedValue, firstNode?.next?.data)

        assertEquals(firstExpectedValue, firstNode?.prev?.data)

        val secondExpectedValue = 2
        doublyCircularLinkedList.append(secondExpectedValue)
//      list = 1 -> 2 ->

        val secondNode = doublyCircularLinkedList.get(head, secondExpectedValue)

        assertEquals(secondExpectedValue, secondNode?.data)

        assertEquals(firstExpectedValue, secondNode?.next?.data)

        assertEquals(firstExpectedValue, secondNode?.prev?.data)

        val thirdExpectedValue = 3
        doublyCircularLinkedList.append(thirdExpectedValue)
//      list = 1 -> 2 -> 3 ->

        val thirdNode = doublyCircularLinkedList.get(head, thirdExpectedValue)

        assertEquals(thirdExpectedValue, thirdNode?.data)

        assertEquals(firstExpectedValue, thirdNode?.next?.data)

        assertEquals(secondExpectedValue, thirdNode?.prev?.data)
    }

    @Test
    fun `assert length success`(){
        val doublyCircularLinkedList = DoublyCircularLinkedListImpl<Int>()

        val firstExpectedValue = 1
        val head = doublyCircularLinkedList.push(firstExpectedValue)
//      list = 1 ->

        assertEquals(firstExpectedValue, doublyCircularLinkedList.length(head))

        val secondExpectedValue = 2
        doublyCircularLinkedList.append(secondExpectedValue)
//      list = 1 -> 2 ->

        assertEquals(secondExpectedValue, doublyCircularLinkedList.length(head))

        val thirdExpectedValue = 3
        doublyCircularLinkedList.append(thirdExpectedValue)
//      list = 1 -> 2 -> 3 ->

        assertEquals(thirdExpectedValue, doublyCircularLinkedList.length(head))
    }

    @Test
    fun `assert lengthTailRec success`(){
        val doublyCircularLinkedList = DoublyCircularLinkedListImpl<Int>()

        val firstExpectedValue = 1
        val head = doublyCircularLinkedList.push(firstExpectedValue)
//      list = 1 ->

        assertEquals(firstExpectedValue, doublyCircularLinkedList.lengthTailRec())

        val secondExpectedValue = 2
        doublyCircularLinkedList.append(secondExpectedValue)
//      list = 1 -> 2 ->

        assertEquals(secondExpectedValue, doublyCircularLinkedList.lengthTailRec())

        val thirdExpectedValue = 3
        doublyCircularLinkedList.append(thirdExpectedValue)
//      list = 1 -> 2 -> 3 ->

        assertEquals(thirdExpectedValue, doublyCircularLinkedList.lengthTailRec())
    }
}