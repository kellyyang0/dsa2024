import org.example.BinaryWriter
import kotlin.math.ceil
import kotlin.math.log2
import kotlin.math.pow

/**
 * Lempel-Ziv compression algorithm
 * @param input the binary data to be compressed
 * @return a pair of the compressed binary data and the bit size used to write the compression
 */
fun compress(input: ByteArray): Pair<ByteArray, Int> {

    // Convert input ByteArray into a binary String
    val binaryString = StringBuilder()
    for (byte in input) {
        for (i in 7 downTo 0) {
            val bit = (byte.toInt() shr i) and 0x01
            binaryString.append(bit)
        }
    }

    val bits = binaryString.toString()
    val size = bits.length

    //Maps string of symbols from original source (key) to identifier (value)
    val codeBook: MutableMap<String, Int> = mutableMapOf("" to 0)

    var curr = ""
    var i = 0
    var lastCode = 0
    val result = mutableListOf<Pair<Int, Char>>() //Identifier for new chunk as a pair to separate identifier to previous and new bit

    while (i < size) {
        val new = curr + bits[i]

        if (codeBook[new] == null) { // if new chunk is not in the codebook already, add
            codeBook[new] = lastCode + 1
            lastCode += 1

            result.add(Pair(codeBook[curr]!!, bits[i]))
            curr = ""
        } else {
            curr = new
        }
        i++
    }

    val output = BinaryWriter(true)
    val codePartSize = ceil(log2(result.size.toDouble())).toInt() //Calculate number of bits needed to store the code part

    for (pair in result) { //Write result to binary
        output.write(pair.first, codePartSize)
        output.write(pair.second == '1')
    }

    return Pair(output.toByteArray(), codePartSize + 1)
}

/**
 * Decompression algorithm for Lempel Ziv
 * @param input the binary data to be decompressed
 * @param chunkSize the bit size used to write the input data
 * @return binary data of the original data after decompression
 */
fun decompress(input: ByteArray, chunkSize: Int): ByteArray {

    // Convert input ByteArray into a binary String
    val binaryString = StringBuilder()
    for (byte in input) {
        for (i in 7 downTo 0) {
            val bit = (byte.toInt() shr i) and 0x01
            binaryString.append(bit)
        }
    }

    val bits = binaryString.toString()
    val chunkCount = bits.length / chunkSize //Number of chunks in the entire input data

    val codeBook = mutableListOf("") //Reconstructing the codeBook
    val output = BinaryWriter()

    for (i in 0..<chunkCount) {
        val chunk = bits.substring(i * chunkSize, (i + 1) * chunkSize)

        val code = chunk.substring(0, chunkSize - 1)
        val endBit = chunk[chunkSize-1]

        val uncompressedChunk = codeBook[valueOfBinaryStringNum(code)] + endBit

        for (char in uncompressedChunk) {
            output.write(char == '1')
        }

        codeBook.add(uncompressedChunk)
    }

    return output.toByteArray()
}

/**
 * Helper function to find the index of a chunk in the code book
 * @param binaryString the chunk of binary data as a String
 * @return the index of the chunk in the code book
 */
fun valueOfBinaryStringNum(binaryString: String): Int {
    val reversed = binaryString.reversed()
    var value = 0

    reversed.forEachIndexed { index, c ->
        if (c == '1') {
            value += 2.0.pow(index).toInt()
        }
    }
    return value
}