package dataStructure

import kotlin.test.Test
import kotlin.test.assertEquals

internal class CircularLinkedListTest {

    private val headPosition = 0

    @Test
    fun `assert push success`() {
        val circularLinkedList = CircularLinkedList<Int>()

        val headValueExpected = 2

        assertEquals(headValueExpected, circularLinkedList.push(headValueExpected).data)

        assertEquals(headValueExpected, circularLinkedList.get(headPosition)?.data)

        assertEquals(headValueExpected, circularLinkedList.get(headPosition)?.next?.data)

        val newHeadValueExpected = 3
        circularLinkedList.push(newHeadValueExpected)

        assertEquals(newHeadValueExpected, circularLinkedList.get(headPosition)?.data)

        assertEquals(headValueExpected, circularLinkedList.get(headPosition)?.next?.data)

        assertEquals(newHeadValueExpected, circularLinkedList.get(headPosition)?.next?.next?.data)
    }

    @Test
    fun `assert insertAfter success`() {
        val circularLinkedList = CircularLinkedList<Int>()
        val firstNode = circularLinkedList.push(1)
        val firstExpectedValue = 2


        assertEquals(firstExpectedValue, circularLinkedList.insertAfter(firstNode, firstExpectedValue)?.data)

        assertEquals(firstExpectedValue, circularLinkedList.get(headPosition + 1)?.data)

        assertEquals(firstNode.data, circularLinkedList.get(headPosition + 1)?.next?.data)

        assertEquals(firstExpectedValue, circularLinkedList.get(headPosition)?.next?.data)

        val secondExpectedValue = 3
        circularLinkedList.insertAfter(firstNode, secondExpectedValue)

        assertEquals(secondExpectedValue, circularLinkedList.get(headPosition + 1)?.data)

        assertEquals(firstExpectedValue, circularLinkedList.get(headPosition + 1)?.next?.data)

        assertEquals(secondExpectedValue, circularLinkedList.get(headPosition)?.next?.data)
    }

    @Test
    fun `assert append success`() {
        val circularLinkedList = CircularLinkedList<Int>()

        val firstExpectedValue = 1
        val node = circularLinkedList.append(firstExpectedValue)

        assertEquals(firstExpectedValue, circularLinkedList.getLast(node)?.data)

        assertEquals(firstExpectedValue, circularLinkedList.get(headPosition)?.data)

        assertEquals(firstExpectedValue, circularLinkedList.get(headPosition)?.next?.data)

        val secondExpectedValue = 2
        circularLinkedList.append(secondExpectedValue)

        assertEquals(secondExpectedValue, circularLinkedList.getLast(node)?.data)

        assertEquals(circularLinkedList.get(headPosition)?.data, circularLinkedList.getLast(node)?.next?.data)

        assertEquals(secondExpectedValue, circularLinkedList.get(headPosition)?.next?.data)

        val thirdExpectedValue = 3
        circularLinkedList.append(thirdExpectedValue)

        assertEquals(thirdExpectedValue, circularLinkedList.getLast(node)?.data)

        assertEquals(circularLinkedList.get(headPosition)?.data, circularLinkedList.getLast(node)?.next?.data)

        assertEquals(secondExpectedValue, circularLinkedList.get(headPosition)?.next?.data)
    }

    @Test
    fun `assert removeHead success`() {
        val circularLinkedList = CircularLinkedList<Int>()

        assertEquals(null, circularLinkedList.removeHead()?.data)

        val firstExpectedValue = 1
        circularLinkedList.push(firstExpectedValue)

        assertEquals(firstExpectedValue, circularLinkedList.removeHead()?.data)

        assertEquals(null, circularLinkedList.removeHead()?.data)

        val secondExpectedValue = 3
        circularLinkedList.push(firstExpectedValue)
        circularLinkedList.push(secondExpectedValue)

        assertEquals(secondExpectedValue, circularLinkedList.removeHead()?.data)

        assertEquals(firstExpectedValue, circularLinkedList.get(headPosition)?.data)

        assertEquals(firstExpectedValue, circularLinkedList.get(headPosition)?.next?.data)

        val thirdExpectedValue = 2
        val forthExpectedValue = 4
        val fifthExpectedValue = 5
        val node = circularLinkedList.push(thirdExpectedValue)
        circularLinkedList.push(forthExpectedValue)
        circularLinkedList.push(fifthExpectedValue)

        assertEquals(fifthExpectedValue, circularLinkedList.removeHead()?.data)

        assertEquals(forthExpectedValue, circularLinkedList.get(headPosition)?.data)

        assertEquals(forthExpectedValue, circularLinkedList.getLast(node)?.next?.data)
    }

    @Test
    fun `assert removeLast success`() {
        val circularLinkedList = CircularLinkedList<Int>()

        assertEquals(null, circularLinkedList.removeLast()?.data)
//      list = null

        val firstExpectedValue = 1
        circularLinkedList.push(firstExpectedValue)
//      list = 1 ->

        assertEquals(firstExpectedValue, circularLinkedList.removeLast()?.data)
//      list = null

        assertEquals(null, circularLinkedList.removeLast()?.data)

        val secondExpectedValue = 3
        circularLinkedList.push(secondExpectedValue)
        val head = circularLinkedList.push(firstExpectedValue)
//      list = 1 -> 3 ->

        assertEquals(secondExpectedValue, circularLinkedList.removeLast()?.data)
//      list = 1 ->
        assertEquals(firstExpectedValue, circularLinkedList.getLast(head)?.data)

        assertEquals(firstExpectedValue, circularLinkedList.getLast(head)?.next?.data)

        val thirdExpectedValue = 2
        val forthExpectedValue = 4
        val fifthExpectedValue = 5
        circularLinkedList.push(thirdExpectedValue)
        circularLinkedList.push(forthExpectedValue)
        val newHead = circularLinkedList.push(fifthExpectedValue)
//      list = 5 -> 4 -> 2 -> 1 ->
        assertEquals(firstExpectedValue, circularLinkedList.removeLast()?.data)

        assertEquals(thirdExpectedValue, circularLinkedList.getLast(newHead)?.data)

        assertEquals(fifthExpectedValue, circularLinkedList.getLast(newHead)?.next?.data)
    }

    @Test
    fun `assert removeAfter success`() {
        val circularLinkedList = CircularLinkedList<Int>()

        assertEquals(null, circularLinkedList.removeAfter(null)?.data)

        val firstExpectedValue = 1
        val head = circularLinkedList.push(firstExpectedValue)

        assertEquals(firstExpectedValue, circularLinkedList.removeAfter(head)?.data)

        assertEquals(null, circularLinkedList.removeAfter(head)?.data)

//      list = null
        val secondExpectedValue = 3
        circularLinkedList.push(secondExpectedValue)
        val head2 = circularLinkedList.push(firstExpectedValue)
//      list = 1 -> 3

        assertEquals(secondExpectedValue, circularLinkedList.removeAfter(head2)?.data)

        assertEquals(head2.data, circularLinkedList.get(headPosition)?.next?.data)

        assertEquals(head2.data, circularLinkedList.getLast(head2)?.next?.data)

//      list = 1 ->
        val thirdExpectedValue = 4
        val secondNode = circularLinkedList.append(thirdExpectedValue)
//      list = 1 -> 4 ->

        assertEquals(head2.data, circularLinkedList.removeAfter(secondNode)?.data)

        assertEquals(thirdExpectedValue, circularLinkedList.get(headPosition)?.data)

        assertEquals(thirdExpectedValue, circularLinkedList.getLast(secondNode)?.next?.data)

//      list = 4 ->
        val fifthExpectedValue = 6
        val forthExpectedValue = 5
        val sixthExpectedValue = 2
        circularLinkedList.push(sixthExpectedValue)
        val forthNode = circularLinkedList.push(forthExpectedValue)
        circularLinkedList.push(fifthExpectedValue)
//      list = 6 -> 5 -> 2 -> 4 ->

        assertEquals(sixthExpectedValue, circularLinkedList.removeAfter(forthNode)?.data)
//      list = 6 -> 5 -> 4 ->

        assertEquals(thirdExpectedValue, circularLinkedList.removeAfter(forthNode)?.data)
//      list = 6 -> 5 ->

        assertEquals(forthExpectedValue, circularLinkedList.getLast(forthNode)?.data)

        assertEquals(fifthExpectedValue, circularLinkedList.getLast(forthNode)?.next?.data)
    }

    @Test
    fun `assert RemoveAfter position success`() {
        val circularLinkedList = CircularLinkedList<Int>()

        assertEquals(null, circularLinkedList.removeAfter(headPosition)?.data)

        val firstExpectedValue = 1
        circularLinkedList.push(firstExpectedValue)

        assertEquals(firstExpectedValue, circularLinkedList.removeAfter(headPosition)?.data)

        assertEquals(null, circularLinkedList.removeAfter(headPosition)?.data)

//      list = null
        val secondExpectedValue = 3
        circularLinkedList.push(secondExpectedValue)
        val head = circularLinkedList.push(firstExpectedValue)
//      list = 1 -> 3

        assertEquals(secondExpectedValue, circularLinkedList.removeAfter(headPosition)?.data)
//      list = 1 ->

        assertEquals(firstExpectedValue, circularLinkedList.get(headPosition)?.next?.data)

        assertEquals(firstExpectedValue, circularLinkedList.getLast(head)?.next?.data)

        //      list = 1 ->
        val thirdExpectedValue = 4
        val node = circularLinkedList.append(thirdExpectedValue)
//      list = 1 -> 4 ->

        assertEquals(firstExpectedValue, circularLinkedList.removeAfter(1)?.data)

        assertEquals(thirdExpectedValue, circularLinkedList.get(headPosition)?.data)

        assertEquals(thirdExpectedValue, circularLinkedList.getLast(node)?.next?.data)

        val fifthExpectedValue = 6
        val forthExpectedValue = 5
        val sixthExpectedValue = 2
        circularLinkedList.push(sixthExpectedValue)
        circularLinkedList.push(forthExpectedValue)
        val head2 = circularLinkedList.push(fifthExpectedValue)
//      list = 6 -> 5 -> 2 -> 4 ->

        assertEquals(sixthExpectedValue, circularLinkedList.removeAfter(1)?.data)
//      list = 6 -> 5 -> 4 ->

        assertEquals(thirdExpectedValue, circularLinkedList.removeAfter(1)?.data)
//      list = 6 -> 5 ->

        assertEquals(forthExpectedValue, circularLinkedList.getLast(head2)?.data)

        assertEquals(fifthExpectedValue, circularLinkedList.getLast(head2)?.next?.data)
    }

    @Test
    fun `assert removeByKey success`() {
        val circularLinkedList = CircularLinkedList<Int>()

        assertEquals(null, circularLinkedList.removeByKey2(1)?.data)

        val firstExpectedValue = 1
        circularLinkedList.push(firstExpectedValue)

        assertEquals(firstExpectedValue, circularLinkedList.removeByKey2(firstExpectedValue)?.data)

        assertEquals(null, circularLinkedList.removeByKey2(1)?.data)
//      list = null

        val secondExpectedValue = 3
        circularLinkedList.push(secondExpectedValue)
        val head = circularLinkedList.push(firstExpectedValue)
//      list = 1 -> 3

        assertEquals(secondExpectedValue, circularLinkedList.removeByKey2(3)?.data)
//      list = 1 ->

        assertEquals(firstExpectedValue, circularLinkedList.get(headPosition)?.next?.data)
//
        assertEquals(firstExpectedValue, circularLinkedList.getLast(head)?.next?.data)

        val thirdExpectedValue = 4
        val node = circularLinkedList.append(thirdExpectedValue)
//      list = 1 -> 4 ->

        assertEquals(firstExpectedValue, circularLinkedList.removeByKey2(1)?.data)

//      list = 4 ->
        assertEquals(thirdExpectedValue, circularLinkedList.get(headPosition)?.data)
//
        assertEquals(thirdExpectedValue, circularLinkedList.getLast(node)?.next?.data)

        val fifthExpectedValue = 6
        val forthExpectedValue = 5
        val sixthExpectedValue = 2
        circularLinkedList.push(sixthExpectedValue)
        circularLinkedList.push(forthExpectedValue)
        val head2 = circularLinkedList.push(fifthExpectedValue)
//      list = 6 -> 5 -> 2 -> 4 ->

        assertEquals(sixthExpectedValue, circularLinkedList.removeByKey2(2)?.data)
//      list = 6 -> 5 -> 4 ->

        assertEquals(thirdExpectedValue, circularLinkedList.removeByKey2(4)?.data)
//      list = 6 -> 5 ->

        assertEquals(forthExpectedValue, circularLinkedList.getLast(head2)?.data)

        assertEquals(fifthExpectedValue, circularLinkedList.getLast(head2)?.next?.data)

        assertEquals(null, circularLinkedList.removeByKey2(7)?.data)
    }

    @Test
    fun `assert removeByKeyRecursively success`() {
        val circularLinkedList = CircularLinkedList<Int>()

        val firstExpectedValue = 1
        val head = circularLinkedList.push(firstExpectedValue)

        assertEquals(firstExpectedValue, circularLinkedList.removeByKey(head, 1)?.data)

        assertEquals(null, circularLinkedList.removeByKey(head, 1)?.data)
//      list = null

        val secondExpectedValue = 3
        circularLinkedList.push(secondExpectedValue)
        val head2 = circularLinkedList.push(firstExpectedValue)
//      list = 1 -> 3

        assertEquals(secondExpectedValue, circularLinkedList.removeByKey(head2, 3)?.data)
//      list = 1 ->

        assertEquals(firstExpectedValue, circularLinkedList.get(headPosition)?.next?.data)

        assertEquals(firstExpectedValue, circularLinkedList.getLast(head2)?.next?.data)

        val thirdExpectedValue = 4
        val node = circularLinkedList.append(thirdExpectedValue)
//      list = 1 -> 4 ->

        assertEquals(firstExpectedValue, circularLinkedList.removeByKey(head2, 1)?.data)

//      list = 4 ->
        assertEquals(thirdExpectedValue, circularLinkedList.get(headPosition)?.data)

        assertEquals(thirdExpectedValue, circularLinkedList.getLast(node)?.next?.data)

        val fifthExpectedValue = 6
        val forthExpectedValue = 5
        val sixthExpectedValue = 2
        circularLinkedList.push(sixthExpectedValue)
        circularLinkedList.push(forthExpectedValue)
        val head3 = circularLinkedList.push(fifthExpectedValue)
//      list = 6 -> 5 -> 2 -> 4 ->

        assertEquals(sixthExpectedValue, circularLinkedList.removeByKey(head3, 2)?.data)
//      list = 6 -> 5 -> 4 ->

        assertEquals(thirdExpectedValue, circularLinkedList.removeByKey(head3, 4)?.data)
//      list = 6 -> 5 ->

        assertEquals(forthExpectedValue, circularLinkedList.getLast(head3)?.data)

        assertEquals(fifthExpectedValue, circularLinkedList.getLast(head3)?.next?.data)
    }

    @Test
    fun `assert get success`() {
        val circularLinkedList = CircularLinkedList<Int>()

        val firstExpectedValue = 1
        val head = circularLinkedList.push(firstExpectedValue)

        assertEquals(firstExpectedValue, circularLinkedList.get(head, firstExpectedValue)?.data)

        circularLinkedList.removeHead()
//      list = null
        val secondExpectedValue = 2
        circularLinkedList.push(secondExpectedValue)
        val head2 = circularLinkedList.push(firstExpectedValue)
//      list = 1 -> 2 ->
        assertEquals(secondExpectedValue, circularLinkedList.get(head2, 2)?.data)

        val fifthExpectedValue = 5
        val forthExpectedValue = 4
        val thirdExpectedValue = 3
        circularLinkedList.push(thirdExpectedValue)
        circularLinkedList.push(forthExpectedValue)
        val head3 = circularLinkedList.push(fifthExpectedValue)
//      list = 5 -> 4 -> 3 -> 1 -> 2 ->

        assertEquals(fifthExpectedValue, circularLinkedList.get(head3, 5)?.data)

        assertEquals(secondExpectedValue, circularLinkedList.get(head3, 2)?.data)

        assertEquals(forthExpectedValue, circularLinkedList.get(head3, 4)?.data)

        assertEquals(thirdExpectedValue, circularLinkedList.get(head3, 3)?.data)
    }

    @Test
    fun `assert get by position success`() {
        val circularLinkedList = CircularLinkedList<Int>()

        val firstExpectedValue = 1
        circularLinkedList.push(firstExpectedValue)

        assertEquals(firstExpectedValue, circularLinkedList.get(headPosition)?.data)

        circularLinkedList.removeHead()
//      list = null
        val secondExpectedValue = 2
        circularLinkedList.push(secondExpectedValue)
        circularLinkedList.push(firstExpectedValue)
//      list = 1 -> 2 ->
        assertEquals(secondExpectedValue, circularLinkedList.get(1)?.data)

        val fifthExpectedValue = 5
        val forthExpectedValue = 4
        val thirdExpectedValue = 3
        circularLinkedList.push(thirdExpectedValue)
        circularLinkedList.push(forthExpectedValue)
        circularLinkedList.push(fifthExpectedValue)
//      list = 5 -> 4 -> 3 -> 1 -> 2 ->

        assertEquals(fifthExpectedValue, circularLinkedList.get(headPosition)?.data)

        assertEquals(secondExpectedValue, circularLinkedList.get(4)?.data)

        assertEquals(forthExpectedValue, circularLinkedList.get(1)?.data)

        assertEquals(thirdExpectedValue, circularLinkedList.get(2)?.data)

        assertEquals(null, circularLinkedList.get(5)?.data)
    }
}