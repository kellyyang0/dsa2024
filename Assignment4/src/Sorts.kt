import kotlin.math.exp
import kotlin.math.floor
import kotlin.math.pow

/**
 * Radix sort
 * @param original the unsorted list
 * @return the sorted list
 */
fun radixSort(original:List<Int>): List<Int> {
    val queueArray = Array(10){ArrayDeque<Int>()}
    val sortedList: MutableList<Int> = original.toMutableList()
    var exponent = 0
    var longest = 0
    val lengths: MutableList<Int> = mutableListOf()

    for (n in original){
        var count = 0
        var num = n

        if(n.toInt()==0){count = 1}

        while (num > 0){
            num /= 10
            count += 1
        }
        lengths.addLast(count)
    }

    longest = lengths.max()

    assert(longest == original.maxOfOrNull { e -> e.toString().length })

    for(n in 0..<longest) {

        for (elem in sortedList) {
            val base = 10.0
            val trunced = (elem / base.pow(exponent)).toInt()
            val digit = trunced % 10
            queueArray[digit].addFirst(elem)
        }

        sortedList.clear()

        for (queue in queueArray) {
            while (!queue.isEmpty()) {
                sortedList.addLast(queue.removeLast())
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
fun mergeSort(original: List<Int>): List<Int> {
    val list = original.toMutableList()

    if (list.size < 2){
        return list
    }

    val firstPart = list.subList(0,list.size/2)
    val secondPart = list.subList(list.size/2, list.size)

    val sortedFirst = mergeSort(firstPart)
    val sortedSecond = mergeSort(secondPart)

    val sorted: MutableList<Int> = mutableListOf()

    while (sortedFirst.isNotEmpty() || sortedSecond.isNotEmpty()){
        if((sortedFirst.firstOrNull() ?: Int.MAX_VALUE) < (sortedSecond.firstOrNull() ?: Int.MAX_VALUE)){
            sorted.addLast(sortedFirst.removeFirst())
        } else {
            sorted.addLast(sortedSecond.removeFirst())
        }
    }
    return sorted
}

/**
 * Selection sort
 * @param original the unsorted list
 * @return the sorted list
 */
fun selectionSort(original: List<Int>): List<Int> {
    val list = original.toMutableList()

    for(i in 0..<list.size){
        var min = list[i]
        var minIndex = i

        for (j in i..<list.size){
            val unsorted = list[j]

            if(unsorted<min){
                minIndex = j
                min = unsorted
            }
        }
        list[minIndex] = list[i]
        list[i] = min
    }
    return list
}

/**
 * Heap sort
 * @param original the unsorted list
 * @return the sorted list
 */
fun heapSort(original: List<Int>): List<Int> {
    val list = mutableListOf<Int>()
    val heap = MinHeap<Int>()

    for (num in original) {
        heap.insert(num, num.toDouble())
    }

    while (!heap.isEmpty()){
        list.addLast(heap.getMin())
    }
    return list
}