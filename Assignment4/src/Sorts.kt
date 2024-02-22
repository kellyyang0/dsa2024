import kotlin.math.pow

/**
 * Radix sort
 * @param original the unsorted list
 * @return the sorted list
 */
fun radixSort(original:List<Double>): List<Double> {
    val queueArray = Array<Queue<Double>>(10){Queue<Double>()}
    val sortedList: MutableList<Double> = mutableListOf()
    var exponent = 1.0
    var longest = 0
    val lengths: MutableList<Int> = mutableListOf()

    for (n in original){
        var count = 0
        var num = n

        if(n.toInt()==0){count = 1}

        while (num > 0){
            num %= 10
            count += 1
        }
//        lengths.addLast(count)
    }

    longest = lengths.max()

    for(n in 0..longest) {
        for (elem in original) {
            val base = 10.0
            val digit = (elem % base.pow(exponent)).toInt()
            queueArray[digit].enqueue(elem)
        }
        for (array in queueArray) {
            while (queueArray.isNotEmpty()) {
                sortedList.addLast(array.dequeue())
            }
        }
        exponent += 1
    }
    return sortedList
}
/**                                 
 * Merge sort
 * @param original the unsorted list
 * @return the sorted list          
 */                                 
fun mergeSort(original: List<Double>): List<Double> {
    if (original.size == 1){
        return original
    }

    val firstPart = original.subList(0,original.size/2)
    val secondPart = original.subList(original.size/2, original.size)

    val sortedFirst = mergeSort(firstPart)
    val sortedSecond = mergeSort(secondPart)

    val list: MutableList<Double> = mutableListOf()

    while (sortedFirst.isNotEmpty() && sortedSecond.isNotEmpty()){
        if(sortedFirst.first() < sortedSecond.first()){
            list.addLast(sortedFirst.removeFirst())
        } else {
            list.addLast(sortedSecond.removeFirst())
        }
    }
    return list
}

/**
 * Selection sort
 * @param original the unsorted list
 * @return the sorted list
 */
fun selectionSort(original: List<Double>): List<Double> {
    val list = original.toMutableList()

    for(i in 0..list.size - 1){
        var min = list[i]

        for (unsorted in i..list.size - 1){
            if(unsorted<min){
                min = unsorted.toDouble()
            }
        }
        list[i] = min
    }
    return list
}

/**
 * Heap sort
 * @param original the unsorted list
 * @return the sorted list
 */
fun heapSort(original: List<Double>): List<Double> {
    val list = original.toMutableList()
    val heap = MinHeap<Double>()

    for (num in original) {
        heap.insert(num, num)
    }

    while (!heap.isEmpty()){
        list.addLast(heap.getMin())
    }
    return list
}