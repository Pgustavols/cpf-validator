# CPF Validator 🇧🇷

A robust, test-driven Java utility for validating Brazilian Taxpayer Registry (CPF) numbers. 

This project was built to demonstrate clean code principles, separation of concerns, and unit testing practices. It does not rely on external libraries for the core logic, implementing the official Modulo 11 mathematical algorithm from scratch.

## 🛠️ Technologies Used
* **Java:** Core logic, String manipulation, and mathematical validation.
* **JUnit:** Comprehensive unit testing to ensure reliability against edge cases and false positives.

## 🧠 How it Works
The validation process is split into two main components:
1. **Sanitization:** Removes any masks (dots and dashes) and checks for basic invalid patterns (like sequences of the same number or incorrect length).
2. **Modulo 11 Calculation:** Extracts the first 9 digits and applies the official descending weight multiplication to calculate the first verifying digit. It then repeats the process including the new digit to find the second verifying digit.

## 🚀 How to Run the Tests
This project is designed as a modular utility/library, so it does not contain a `Main` class. To verify its functionality, you should run the test suite:

1. Open the project in your favorite IDE (IntelliJ IDEA, Eclipse, etc.).
2. Navigate to the test directory: `src/test/java/`.
3. Right-click on `CpfValidatorTest.java` and select **Run 'CpfValidatorTest'**.
4. The test runner will execute all scenarios (valid CPFs, invalid formats, wrong verifying digits, etc.) and display the results.

## 💡 Use Case
This validator is designed to be easily integrated into larger systems, such as user registration forms, banking applications, or any platform that requires reliable Brazilian document verification.
