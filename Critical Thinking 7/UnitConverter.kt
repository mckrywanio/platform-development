import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    var continueConversion = true

    while (continueConversion) {
        println("\n--- Unit Converter ---")
        println("Select the type of conversion:")
        println("1. Temperature")
        println("2. Length")
        println("3. Weight")
        println("4. Exit")
        print("Enter your choice (1-4): ")

        when (scanner.nextInt()) {
            1 -> convertTemperature(scanner)
            2 -> convertLength(scanner)
            3 -> convertWeight(scanner)
            4 -> {
                println("Exiting the Unit Converter. Goodbye!")
                continueConversion = false
            }
            else -> println("Invalid choice. Please select a valid option.")
        }
    }
}

fun convertTemperature(scanner: Scanner) {
    println("\n-- Temperature Conversion --")
    println("Select the conversion:")
    println("1. Celsius to Fahrenheit")
    println("2. Fahrenheit to Celsius")
    println("3. Celsius to Kelvin")
    println("4. Kelvin to Celsius")
    print("Enter your choice (1-4): ")

    val choice = scanner.nextInt()
    print("Enter the temperature value to convert: ")
    val value = scanner.nextDouble()

    val result = when (choice) {
        1 -> celsiusToFahrenheit(value)
        2 -> fahrenheitToCelsius(value)
        3 -> celsiusToKelvin(value)
        4 -> kelvinToCelsius(value)
        else -> {
            println("Invalid choice.")
            return
        }
    }
    println("Converted value: $result")
}

fun convertLength(scanner: Scanner) {
    println("\n-- Length Conversion --")
    println("Select the conversion:")
    println("1. Meters to Feet")
    println("2. Feet to Meters")
    println("3. Kilometers to Miles")
    println("4. Miles to Kilometers")
    print("Enter your choice (1-4): ")

    val choice = scanner.nextInt()
    print("Enter the length value to convert: ")
    val value = scanner.nextDouble()

    val result = when (choice) {
        1 -> metersToFeet(value)
        2 -> feetToMeters(value)
        3 -> kilometersToMiles(value)
        4 -> milesToKilometers(value)
        else -> {
            println("Invalid choice.")
            return
        }
    }
    println("Converted value: $result")
}

fun convertWeight(scanner: Scanner) {
    println("\n-- Weight Conversion --")
    println("Select the conversion:")
    println("1. Kilograms to Pounds")
    println("2. Pounds to Kilograms")
    println("3. Grams to Ounces")
    println("4. Ounces to Grams")
    print("Enter your choice (1-4): ")

    val choice = scanner.nextInt()
    print("Enter the weight value to convert: ")
    val value = scanner.nextDouble()

    val result = when (choice) {
        1 -> kilogramsToPounds(value)
        2 -> poundsToKilograms(value)
        3 -> gramsToOunces(value)
        4 -> ouncesToGrams(value)
        else -> {
            println("Invalid choice.")
            return
        }
    }
    println("Converted value: $result")
}

// Temperature Conversion Functions
fun celsiusToFahrenheit(celsius: Double): Double = celsius * 9 / 5 + 32
fun fahrenheitToCelsius(fahrenheit: Double): Double = (fahrenheit - 32) * 5 / 9
fun celsiusToKelvin(celsius: Double): Double = celsius + 273.15
fun kelvinToCelsius(kelvin: Double): Double = kelvin - 273.15

// Length Conversion Functions
fun metersToFeet(meters: Double): Double = meters * 3.28084
fun feetToMeters(feet: Double): Double = feet / 3.28084
fun kilometersToMiles(kilometers: Double): Double = kilometers / 1.60934
fun milesToKilometers(miles: Double): Double = miles * 1.60934

// Weight Conversion Functions
fun kilogramsToPounds(kilograms: Double): Double = kilograms * 2.20462
fun poundsToKilograms(pounds: Double): Double = pounds / 2.20462
fun gramsToOunces(grams: Double): Double = grams / 28.3495
fun ouncesToGrams(ounces: Double): Double = ounces * 28.3495