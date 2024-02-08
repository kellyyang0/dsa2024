class MyMutableIntList {

    private var myArray = IntArray(1)
    private var nextSlot: Int = 0  //stores the index of the next slot filled when new element added

    /**
     * Add [element] to the end of the list
     */
    fun add(element: Int){

        if(nextSlot<myArray.size) {
            myArray[nextSlot] = element
            nextSlot += 1
        } else {
            val temp = myArray
            myArray = IntArray(myArray.size*2)

            for(i in 0..<nextSlot){
                temp[i] = myArray[i]
            }
            myArray[nextSlot] = element
            nextSlot += 1
        }
    }

    /**
     * Remove all elements from the list
     */
    fun clear(): IntArray{
        return IntArray(nextSlot)
    }

    /*
     * @return the size of the list
     */
    fun size():Int {
        return nextSlot
    }

    /**
     * @param index the index to return
     * @return the element at [index]
     */
    operator fun get(index: Int):Int{
        return myArray[index]
    }

    /**
     * Store [value] at position [index]
     * @param index the index to set
     * @param value to store at [index]
     */
    operator fun set(index: Int, value: Int){
        myArray[index] = value
    }
}