package sortingAlgorithms

class BubbleSort(
    private val array: List<Int>
) {

    fun sort(): List<Int> {
        val resultArray: Array<Int> = array.toTypedArray()
        val n = resultArray.size
        for (i in 0 until (n - 1)){
            for (j in 0 until (n - i - 1)){
                if (resultArray[j] > resultArray[j + 1]){
                    val temp = resultArray[j]
                    resultArray[j] = resultArray[j + 1]
                    resultArray[j + 1] = temp
                }
            }
        }

        return resultArray.toList()
    }
}