package dataStructure

import org.junit.Test
import kotlin.test.assertEquals

internal class SinglyLinkedListTest {

    private val headPosition = 0

    @Test
    fun `assert push success`() {
        val singlyLinkedList = SinglyLinkedListImpl<Int>()

        val firstExpectedValue = 1

        assertEquals(firstExpectedValue, singlyLinkedList.push(firstExpectedValue).data)

        assertEquals(firstExpectedValue, singlyLinkedList.get(headPosition)?.data)

        assertEquals(null, singlyLinkedList.get(headPosition)?.next?.data)

        val secondExpectedValue = 2
        assertEquals(secondExpectedValue, singlyLinkedList.push(secondExpectedValue).data)

        assertEquals(secondExpectedValue, singlyLinkedList.get(headPosition)?.data)

        assertEquals(firstExpectedValue, singlyLinkedList.get(headPosition)?.next?.data)

        val thirdExpectedValue = 3
        singlyLinkedList.push(thirdExpectedValue)

        assertEquals(thirdExpectedValue, singlyLinkedList.get(headPosition)?.data)

        assertEquals(secondExpectedValue, singlyLinkedList.get(headPosition)?.next?.data)
    }

    @Test
    fun `assert insertAfter success`() {
        val singlyLinkedList = SinglyLinkedListImpl<Int>()

        val firstExpectedValue = 1

        assertEquals(null, singlyLinkedList.insertAfter(null, firstExpectedValue)?.data)

        val head = singlyLinkedList.push(firstExpectedValue)
//      list = 1 ->
        val secondExpectedValue = 2
        val secondNode = singlyLinkedList.insertAfter(head, secondExpectedValue)
        assertEquals(secondExpectedValue, secondNode?.data)
//      list = 1 -> 2

        assertEquals(secondExpectedValue, singlyLinkedList.get(headPosition + 1)?.data)

        assertEquals(secondExpectedValue, singlyLinkedList.get(headPosition)?.next?.data)

        assertEquals(null, singlyLinkedList.get(headPosition + 1)?.next?.data)

        val thirdExpectedValue = 3

        assertEquals(thirdExpectedValue, singlyLinkedList.insertAfter(secondNode, thirdExpectedValue)?.data)
//      list = 1 -> 2 -> 3

        assertEquals(thirdExpectedValue, singlyLinkedList.get(headPosition + 1)?.next?.data)

        val fortyExpectedValue = 4

        assertEquals(fortyExpectedValue, singlyLinkedList.insertAfter(secondNode, fortyExpectedValue)?.data)
//      list = 1 -> 2 -> 4 -> 3

        assertEquals(fortyExpectedValue, singlyLinkedList.get(headPosition + 1)?.next?.data)

        assertEquals(thirdExpectedValue, singlyLinkedList.get(2)?.next?.data)
    }

    @Test
    fun `assert append success`() {
        val singlyLinkedList = SinglyLinkedListImpl<Int>()

        val firstExpectedValue = 1
        val head = singlyLinkedList.append(firstExpectedValue)
        assertEquals(firstExpectedValue, head.data)
//      list = 1

        assertEquals(firstExpectedValue, singlyLinkedList.get(headPosition)?.data)

        assertEquals(firstExpectedValue, singlyLinkedList.getLast(head)?.data)

        val secondExpectedValue = 2

        assertEquals(secondExpectedValue, singlyLinkedList.append(secondExpectedValue).data)
//      list = 1 -> 2

        assertEquals(secondExpectedValue, singlyLinkedList.get(headPosition)?.next?.data)

        assertEquals(secondExpectedValue, singlyLinkedList.getLast(head)?.data)

        val thirdExpectedValue = 3

        assertEquals(thirdExpectedValue, singlyLinkedList.append(thirdExpectedValue).data)
//      list = 1 -> 2 -> 3

        assertEquals(thirdExpectedValue, singlyLinkedList.get(1)?.next?.data)

        assertEquals(thirdExpectedValue, singlyLinkedList.getLast(head)?.data)
    }

    @Test
    fun `assert removeHead success`() {
        val singlyLinkedList = SinglyLinkedListImpl<Int>()

        assertEquals(null, singlyLinkedList.removeHead()?.data)

        val firstExpectedValue = 1

        singlyLinkedList.push(firstExpectedValue)
//      list = 1 ->


        assertEquals(firstExpectedValue, singlyLinkedList.removeHead()?.data)
//      list = null

        assertEquals(null, singlyLinkedList.removeHead()?.data)
//      list = null

        val secondExpectedValue = 2
        singlyLinkedList.push(firstExpectedValue)
        singlyLinkedList.push(secondExpectedValue)
//      list = 2 -> 1 ->

        assertEquals(secondExpectedValue, singlyLinkedList.removeHead()?.data)

//      list = 1 ->
        assertEquals(firstExpectedValue, singlyLinkedList.get(headPosition)?.data)

        val thirdExpectedValue = 3
        singlyLinkedList.append(secondExpectedValue)
        singlyLinkedList.append(thirdExpectedValue)
//      list = 1 -> 2 -> 3 ->

        assertEquals(firstExpectedValue, singlyLinkedList.removeHead()?.data)

//      list = 2 -> 3 ->
        assertEquals(thirdExpectedValue, singlyLinkedList.get(headPosition)?.next?.data)
    }

    @Test
    fun `assert removeLast success`() {
        val singlyLinkedList = SinglyLinkedListImpl<Int>()

        assertEquals(null, singlyLinkedList.removeLast()?.data)

        val firstExpectedValue = 1

        singlyLinkedList.push(firstExpectedValue)
//      list = 1 ->

        assertEquals(firstExpectedValue, singlyLinkedList.removeLast()?.data)

        assertEquals(null, singlyLinkedList.removeLast()?.data)

        val secondExpectedValue = 2
        val head = singlyLinkedList.push(firstExpectedValue)
        singlyLinkedList.append(secondExpectedValue)
//      list = 1 -> 2 ->

        assertEquals(secondExpectedValue, singlyLinkedList.removeLast()?.data)

        assertEquals(null, singlyLinkedList.get(headPosition)?.next?.data)

        assertEquals(firstExpectedValue, singlyLinkedList.getLast(head)?.data)

        val thirdExpectedValue = 3
        singlyLinkedList.append(secondExpectedValue)
        singlyLinkedList.append(thirdExpectedValue)
//      list = 1 -> 2 -> 3 ->

        assertEquals(thirdExpectedValue, singlyLinkedList.removeLast()?.data)
//      list = 1 -> 2 ->

        assertEquals(null, singlyLinkedList.get(1)?.next?.data)

        assertEquals(secondExpectedValue, singlyLinkedList.getLast(head)?.data)
    }

    @Test
    fun `assert removeAfter success`() {
        val singlyLinkedList = SinglyLinkedListImpl<Int>()

        assertEquals(null, singlyLinkedList.removeAfter(null)?.data)

        val firstExpectedValue = 1

        val head = singlyLinkedList.push(firstExpectedValue)
//      list = 1 ->

        assertEquals(null, singlyLinkedList.removeAfter(head)?.data)

        val secondValueExpected = 2
        singlyLinkedList.append(secondValueExpected)
//      list = 1 -> 2 ->

        assertEquals(secondValueExpected, singlyLinkedList.removeAfter(head)?.data)

        assertEquals(null, singlyLinkedList.get(headPosition)?.next?.data)

        val thirdValueExpected = 3
        val secondNode = singlyLinkedList.append(secondValueExpected)
        val thirdNode = singlyLinkedList.append(thirdValueExpected)
//      list = 1 -> 2 -> 3 ->

        assertEquals(thirdValueExpected, singlyLinkedList.removeAfter(secondNode)?.data)

        assertEquals(null, singlyLinkedList.removeAfter(thirdNode)?.data)

        assertEquals(null, singlyLinkedList.get(1)?.next?.data)
    }

    @Test
    fun `assert RemoveAfter position success`() {
        val singlyLinkedList = SinglyLinkedListImpl<Int>()

        assertEquals(null, singlyLinkedList.removeAfter(0)?.data)

        val firstExpectedValue = 1
        singlyLinkedList.push(firstExpectedValue)
//      list = 1 ->

        assertEquals(null, singlyLinkedList.removeAfter(0)?.data)

        val secondExpectedValue = 2
        singlyLinkedList.append(secondExpectedValue)
//      list = 1 -> 2 ->
        assertEquals(secondExpectedValue, singlyLinkedList.removeAfter(0)?.data)
//      list = 1 ->

        assertEquals(null, singlyLinkedList.removeAfter(0)?.data)

        val thirdExpectedValue = 2
        singlyLinkedList.append(secondExpectedValue)
        singlyLinkedList.append(thirdExpectedValue)
//      list = 1 -> 2 -> 3 ->

        assertEquals(null, singlyLinkedList.removeAfter(2)?.data)
//      list = 1 -> 2 -> 3 ->

        assertEquals(thirdExpectedValue, singlyLinkedList.removeAfter(1)?.data)
//      list = 1 -> 2 ->

        assertEquals(null, singlyLinkedList.get(1)?.next?.data)
    }

    @Test
    fun `assert removeByKey success`() {
        val singlyLinkedList = SinglyLinkedListImpl<Int>()

        assertEquals(null, singlyLinkedList.removeByKey2(1)?.data)
        val firstExpectedValue = 1
        singlyLinkedList.push(firstExpectedValue)
//      list = 1 ->

        assertEquals(firstExpectedValue, singlyLinkedList.removeByKey2(firstExpectedValue)?.data)
//      list = null

        assertEquals(null, singlyLinkedList.removeByKey2(1)?.data)

        val secondExpectedValue = 2
        singlyLinkedList.push(firstExpectedValue)
        singlyLinkedList.append(secondExpectedValue)
//      list = 1 -> 2 ->

        assertEquals(secondExpectedValue, singlyLinkedList.removeByKey2(secondExpectedValue)?.data)
//      list = 1 ->

        assertEquals(null, singlyLinkedList.get(headPosition)?.next?.data)

        val thirdExpectedValue = 3
        singlyLinkedList.append(secondExpectedValue)
        singlyLinkedList.append(thirdExpectedValue)
//      list = 1 -> 2 -> 3 ->

        assertEquals(firstExpectedValue, singlyLinkedList.removeByKey2(firstExpectedValue)?.data)
//      list = 2 -> 3 ->

        assertEquals(secondExpectedValue, singlyLinkedList.get(headPosition)?.data)

        assertEquals(null, singlyLinkedList.removeByKey2(4)?.data)

        singlyLinkedList.push(firstExpectedValue)
//      list = 1 -> 2 -> 3 ->

        assertEquals(secondExpectedValue, singlyLinkedList.removeByKey2(secondExpectedValue)?.data)
//      list = 1 -> 3 ->

        assertEquals(thirdExpectedValue, singlyLinkedList.get(headPosition)?.next?.data)
    }

    @Test
    fun `assert removeByKeyRecursively success`() {
        val singlyLinkedList = SinglyLinkedListImpl<Int>()

        assertEquals(null, singlyLinkedList.removeByKey(null, 1)?.data)
        val firstExpectedValue = 1
        val head = singlyLinkedList.push(firstExpectedValue)
//      list = 1 ->

        assertEquals(firstExpectedValue, singlyLinkedList.removeByKey(head, firstExpectedValue)?.data)
//      list = null

        assertEquals(null, singlyLinkedList.removeByKey(head, firstExpectedValue)?.data)

        val secondExpectedValue = 2
        val head2 = singlyLinkedList.push(firstExpectedValue)
        singlyLinkedList.append(secondExpectedValue)
//      list = 1 -> 2 ->

        assertEquals(secondExpectedValue, singlyLinkedList.removeByKey(head2, secondExpectedValue)?.data)
//      list = 1 ->

        assertEquals(null, singlyLinkedList.get(headPosition)?.next?.data)

        val thirdExpectedValue = 3
        singlyLinkedList.append(secondExpectedValue)
        singlyLinkedList.append(thirdExpectedValue)
//      list = 1 -> 2 -> 3 ->

        assertEquals(firstExpectedValue, singlyLinkedList.removeByKey(head2, firstExpectedValue)?.data)
//      list = 2 -> 3 ->

        assertEquals(secondExpectedValue, singlyLinkedList.get(headPosition)?.data)

        val head3 = singlyLinkedList.push(firstExpectedValue)
//      list = 1 -> 2 -> 3 ->

        assertEquals(secondExpectedValue, singlyLinkedList.removeByKey(head3, secondExpectedValue)?.data)
//      list = 1 -> 3 ->

        assertEquals(thirdExpectedValue, singlyLinkedList.get(headPosition)?.next?.data)

        assertEquals(null, singlyLinkedList.removeByKey(head3, 4)?.data)
    }

    @Test
    fun `assert get success`() {
        val singlyLinkedList = SinglyLinkedListImpl<Int>()

        val firstExpectedValue = 1
        val head = singlyLinkedList.push(firstExpectedValue)
//      list = 1 ->
        assertEquals(firstExpectedValue, singlyLinkedList.get(head, firstExpectedValue)?.data)

        singlyLinkedList.removeHead()

        val secondExpectedValue = 2
        val head2 = singlyLinkedList.push(secondExpectedValue)
        singlyLinkedList.append(firstExpectedValue)
//      list = 2 -> 1 ->

        assertEquals(secondExpectedValue, singlyLinkedList.get(head2, secondExpectedValue)?.data)

        assertEquals(firstExpectedValue, singlyLinkedList.get(head2, firstExpectedValue)?.data)

        val thirdExpectedValue = 3
        singlyLinkedList.append(thirdExpectedValue)
//      list = 2 -> 1 -> 3 ->

        assertEquals(thirdExpectedValue, singlyLinkedList.get(head2, thirdExpectedValue)?.data)

        assertEquals(null, singlyLinkedList.get(head2, 4)?.data)
    }

    @Test
    fun `assert Get by position success`() {
        val singlyLinkedList = SinglyLinkedListImpl<Int>()

        val firstExpectedValue = 1
        singlyLinkedList.push(firstExpectedValue)
//      list = 1 ->
        assertEquals(firstExpectedValue, singlyLinkedList.get(headPosition)?.data)

        singlyLinkedList.removeHead()

        val secondExpectedValue = 2
        singlyLinkedList.push(secondExpectedValue)
        singlyLinkedList.append(firstExpectedValue)
//      list = 2 -> 1 ->

        assertEquals(secondExpectedValue, singlyLinkedList.get(headPosition)?.data)

        assertEquals(firstExpectedValue, singlyLinkedList.get(1)?.data)

        val thirdExpectedValue = 3
        singlyLinkedList.append(thirdExpectedValue)
//      list = 2 -> 1 -> 3 ->

        assertEquals(thirdExpectedValue, singlyLinkedList.get(2)?.data)

        assertEquals(null, singlyLinkedList.get(4)?.data)
    }
}