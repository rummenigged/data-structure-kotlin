package sortingAlgorithms

class SelectionSort(
    private val array: List<Int>
) {

    fun sort(isDecrisingOrder: Boolean = false): List<Int> {
        val resultArray: Array<Int> = array.toTypedArray()
        val n = resultArray.size
        for (i in 0 until (n - 1)){
            var minIdx = i
            for (j in (i+1) until n){
                if (isDecrisingOrder){
                    if (resultArray[j] > resultArray[minIdx]){
                        minIdx = j
                    }
                }else if (resultArray[j] < resultArray[minIdx]){
                    minIdx = j
                }
            }

            val temp = resultArray[minIdx]
            resultArray[minIdx] = resultArray[i]
            resultArray[i] = temp
        }

        return resultArray.toList()
    }
}