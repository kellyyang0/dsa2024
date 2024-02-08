class MainKtTest {

    @org.junit.jupiter.api.Test
    fun converter() {
        val convertedFahrenheit = converter(30.0, "Celsius")
        val incorrectValue = 123123.0
        val correctValue = 86.0

        //Test that incorrect value returns True
        assert(convertedFahrenheit != incorrectValue)

        //Test that correct value returns True
        assert(convertedFahrenheit == correctValue)

    }
}