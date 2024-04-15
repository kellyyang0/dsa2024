import java.io.File
import java.io.FileOutputStream
import java.io.PrintWriter

fun main() {

    //Compressing a text using Lempel Ziv
    val fileName = "GreenEggsAndHam.txt" //Replace with name of file
    val text = File("texts/raw/$fileName").readBytes()

    println("input size: ${text.size}")

    val compressed = compress(text)

    println("compressed size: ${compressed.first.size}")

    val compressedFile = File("texts/compressed/$fileName")
    if (!compressedFile.createNewFile()) PrintWriter(compressedFile).close()
    val outputWriter = FileOutputStream(compressedFile)
    outputWriter.write(compressed.second)
    outputWriter.write(compressed.first)
    outputWriter.close()

    //Decompress the ByteArray using Lempel Ziv
    val decompressedFile = File("texts/decompressed/$fileName")
    if (!decompressedFile.createNewFile()) PrintWriter(decompressedFile).close()
    val decompressedWriter = FileOutputStream(decompressedFile)
    val decompressedData = decompress(compressed.first, compressed.second)
    decompressedWriter.write(decompressedData)
    decompressedWriter.close()

    println("% Reduced: ${((compressed.first.size.toDouble() - text.size.toDouble())/text.size.toDouble()) * 100}")

    assert(decompressedData.contentEquals(text)) //Starting text and ending are the same!
}