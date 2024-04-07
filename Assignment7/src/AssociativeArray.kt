import java.security.cert.TrustAnchor
import kotlin.math.absoluteValue

/**
 * Represents a mapping of keys to values.
 * @param K the type of the keys
 * @param V the type of the values
 */
class AssociativeArray<K, V> {

    private var buckets: Array<AssociationList<K,V>> = Array (53) {AssociationList<K,V>()}
    private val primes = listOf(53, 97, 193, 389, 769, 1543)
    private val keys = mutableSetOf<K>()

    /**
     * @param key the key to be hashed
     * @return int hash code value of a key to determine bucket
     */
    private fun hash(key: K): Int {
        return key.hashCode().absoluteValue % buckets.size
    }

    /**
     * Increases number of buckets to the next recommended prime number if the number of elements in a bucket is greater
     * than 3 and rehashes the entire associative array
     *
     * @param original the original associative array to be rehashed
     */
    private fun reHash(original: Array<AssociationList<K,V>>){
        val newSize = primes[(primes.indexOf(buckets.size)) + 1]

        buckets = Array(newSize) {AssociationList<K,V>()}

        for (bucket in buckets) {
            for (pair in bucket) {
                val newIndex = pair.first.hashCode().absoluteValue % buckets.size
            }
        }
    }


    /**
     * Insert the mapping from the key, [k], to the value, [v].
     * If the key already maps to a value, replace the mapping.
     */
    operator fun set(k: K, v: V) {
        val bucket = hash(k)
        if (buckets[bucket].size() > 3) {
            reHash(buckets)
        }
        buckets[bucket][k] = v
        keys.add(k)
    }

    /**
     * @return true if [k] is a key in the associative array
     */
    operator fun contains(k: K): Boolean {
        for (bucket in buckets) {
            if (bucket.contains(k)) {
                return true
            }
        }
        return false
    }

    /**
     * @return the value associated with the key [k] or null if it doesn't exist
     */
    operator fun get(k: K): V? {
        for (bucket in buckets) {
            if (bucket[k] != null) {
                return bucket[k]
            }
        }
        return null
    }

    /**
     * Remove the key, [k], from the associative array
     * @param k the key to remove
     * @return true if the item was successfully removed and false if the element was not found
     */
    fun remove(key: K): Boolean {
        val index = hash(key)
        val bucket = buckets[index]
        if (bucket.contains(key)) {
            buckets[index].remove(key)
            return true
        }
        return false
    }


    /**
     * @return the number of elements stored in the hash table
     */
    fun numElements(): Int {
        var size = 0
        for (bucket in buckets) {
            size += bucket.size()
        }
        return size
    }


    /**
     * @return the full list of key value pairs for the associative array
     */
    fun keyValuePairs(): MutableList<Pair<K, V>> {

        val resultList: MutableList<Pair<K,V>> = mutableListOf()

        for (bucket in buckets) {
            for (pair in bucket) {
                resultList.add(pair)
            }
        }
        return resultList
    }
}

/**
 * Association list class that represents the individual buckets of the associative array class
 * @param K the type of the keys
 * @param V the type of the values
 */
class AssociationList<K,V>{
    private val list: MutableList<Pair<K,V>> = mutableListOf()

    /**
     * @return the value of the key and null if the key is not in the list
     */
    operator fun get(key: K): V? {
        for (pair in list){
            if (pair.first == key){
                return pair.second
            }
        }
        return null
    }

    /**
     * Add the key to the list as a pair of the key [key] and value [value]
     */
    operator fun set(key: K, value: V) {
        list.add(Pair(key,value))
    }

    /**
     * @return true if the list is empty and false otherwise
     */
    fun isEmpty(): Boolean{
        return list.isEmpty()
    }

    /**
     * @return an int representing the size of the list
     */
    fun size(): Int {
        return list.size
    }

    /**
     * removes the key [key] from the list
     */
    fun remove(key: K){
        for (pair in list) {
            if (pair.first == key) {
                list.remove(pair)
                break
            }
        }
    }

    /**
     * Iterator method that allows for iteration through the list
     */
    operator fun iterator(): Iterator<Pair<K, V>> {
        return list.iterator()
    }

    /**
     * @returns true if key [key] is in the list and false if key is not in the list
     */
    fun contains(key: K): Boolean {
        for (pair in list) {
            if (pair.first == key) {
                return true
            }
        }
        return false
    }
}