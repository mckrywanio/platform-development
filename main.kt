fun main() {
    println("Welcome to Simple Calculator")
    
    while (true) {
        // Display menu options
        println("\nSelect an operation:")
        println("1. Addition")
        println("2. Subtraction")
        println("3. Multiplication")
        println("4. Division")
        println("5. Exit")
        
        // Read user choice
        print("Enter your choice (1-5): ")
        val choice = readLine()?.toIntOrNull()
        
        if (choice == 5) {
            println("Exiting the calculator. Goodbye!")
            break
        }
        
        if (choice == null || choice !in 1..4) {
            println("Invalid choice. Please select a valid operation.")
            continue
        }
        
        // Read the two numbers
        print("Enter the first number: ")
        val num1 = readLine()?.toDoubleOrNull()
        print("Enter the second number: ")
        val num2 = readLine()?.toDoubleOrNull()
        
        if (num1 == null || num2 == null) {
            println("Invalid input. Please enter valid numbers.")
            continue
        }
        
        // Perform the chosen operation
        val result = when (choice) {
            1 -> num1 + num2
            2 -> num1 - num2
            3 -> num1 * num2
            4 -> {
                if (num2 == 0.0) {
                    println("Error: Division by zero is not allowed.")
                    continue
                } else {
                    num1 / num2
                }
            }
            else -> 0.0 // This line should never be reached
        }
        
        // Display the result
        println("The result is: $result")
    }
}