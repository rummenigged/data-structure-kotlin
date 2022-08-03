package sortingAlgorithms

class MergeSort(

) {
    fun sort(array: Array<Int>, leftIndex: Int = 0, rightIndex: Int = array.size - 1): List<Int>{
        if (leftIndex < rightIndex){
            val medium = (leftIndex + (rightIndex - 1)) / 2

            sort(array, leftIndex, medium)
            sort(array, medium + 1, rightIndex)

            merge(array, leftIndex, medium, rightIndex)
        }
        return array.toList()
    }

    private fun merge(array: Array<Int>, left: Int, medium: Int, right: Int){
        val sizeLeft = medium - left + 1
        val sizeRight = right - medium

        val leftArray: Array<Int> = IntArray(sizeLeft).toTypedArray()
        val rightArray: Array<Int> = IntArray(sizeRight).toTypedArray()

        for (i in 0 until sizeLeft){
            leftArray[i] = array[left + i]
        }

        for (j in 0 until sizeRight){
            rightArray[j] = array[medium + 1 + j]
        }

        var leftIndex = 0
        var rightIndex = 0

        var k = left
        while (leftIndex < sizeLeft && rightIndex < sizeRight){
            if (leftArray[leftIndex] <= rightArray[rightIndex]){
                array[k] = leftArray[leftIndex]
                leftIndex++
            }else{
                array[k] = rightArray[rightIndex]
                rightIndex++
            }
            k++
        }

        while (leftIndex < sizeLeft){
            array[k] = leftArray[leftIndex]
            leftIndex++
            k++
        }

        while (rightIndex < sizeRight){
            array[k] = rightArray[rightIndex]
            rightIndex++
            k++
        }
    }
}