import dataStructure.CircularLinkedList
import dataStructure.DoublyLinkedListImpl
import dataStructure.SinglyLinkedListImpl

fun main(){
//    listOf(65, 90, 75, 11, 3, 7, 123).also{ unorderedList ->
//        println(unorderedList.toString())
//        MergeSort().run {
//            println(sort(unorderedList.toTypedArray()).toString())
//        }
//    }
    val linkedList = SinglyLinkedListImpl<Int>()
    linkedList.push(4)
    val node3 = linkedList.push(3)
    val node1 = linkedList.push(1)
//    println(linkedList.toString())

    linkedList.append(5)
    linkedList.append(6)
    linkedList.append(7)
    linkedList.append(8)
//    println(linkedList.toString())

    linkedList.insertAfter(node1, 2)
//    println(linkedList.toString())

    linkedList.removeHead()
//    println(linkedList.toString())

    linkedList.removeLast()
//    println(linkedList.toString())

    linkedList.removeAfter(node3)
//    println(linkedList.toString())

    linkedList.removeAfter(node3)
//    println(linkedList.toString())

    linkedList.removeAfter(2)
//    println(linkedList.toString())

    linkedList.removeByKey(key = 2)
//    println(linkedList.toString())

//    println(linkedList.get(key = 3))

    val doublyLinkedList = DoublyLinkedListImpl<Int>()
    doublyLinkedList.push(1)
    val item2 = doublyLinkedList.push(2)
    doublyLinkedList.insertAfter(item2, 3)
    val item4 = doublyLinkedList.append(4)
//    println(doublyLinkedList.toString())

    doublyLinkedList.removeHead()
//    println(doublyLinkedList.toString())

    doublyLinkedList.removeLast()
//    println(doublyLinkedList.toString())

    doublyLinkedList.append(5)
    doublyLinkedList.append(6)
    doublyLinkedList.append(7)
    doublyLinkedList.append(8)
//    println(doublyLinkedList.toString())

    doublyLinkedList.removeAfter(3)
//    println(doublyLinkedList.toString())

    doublyLinkedList.removeByKey2(6)
//    println(doublyLinkedList.toString())

    doublyLinkedList.removeByKey(key = 8)
//    println(doublyLinkedList.toString())

    val circularLinkedList = CircularLinkedList<Int>()
    circularLinkedList.push(3)
    val item2c = circularLinkedList.push(2)
    circularLinkedList.push(1)
    println(circularLinkedList.toString())

    val item4c = circularLinkedList.insertAfter(item2c, 4)
    println(circularLinkedList.toString())
    println(item4c.next.toString())

    circularLinkedList.apply {
        println(append(5).next)
        println(toString())
        println(get(key = 5)?.next)
        removeHead()
        println(toString())
        println(get(key = 5)?.next)
        removeAfter(3)
        println(toString())
//        println(get(key = 5)?.next)
    }
}

