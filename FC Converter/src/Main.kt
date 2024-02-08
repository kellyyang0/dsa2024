fun main() {

    val measurement: String

    // Ask user which conversion is wanted
    print("Type F2C for Fahrenheit to Celsius and C2F for Celsius to Fahrenheit")
    val enteredWay: String = readln()

    // Initialize measurement variable with correct type
    measurement = if (enteredWay == "C2F") {
        "Fahrenheit"
    } else {
        "Celsius"
    }

    // Ask user to input starting temperature
    print("Please enter in the temp: ")
    val enteredNum: Double = readln().toDouble()

    // Call converter function and store into variable
    val convertedNum: Double = converter(enteredNum, measurement)

    // Print final conversion
    print("$enteredNum $measurement is $convertedNum")
}

/**
 * Converts Fahrenheit to Celsius and vice-versa
 *
 * @param orgNum value to be converted
 * @param cOrF desired target unit
 * @return [orgNum] converted to the unit given in [cOrF]
 */
fun converter(orgNum: Double, cOrF: String): Double {
    return if (cOrF == "Celsius") {
        //Fahrenheit to Celsius conversion formula
        (orgNum - 32) * (5.0 / 9.0)
    } else {
        //Celsius to Fahrenheit conversion formula
        (orgNum * (9.0 / 5.0)) + 32
    }
}

