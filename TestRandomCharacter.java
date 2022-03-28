package Lab_9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.*;

public class TestRandomCharacter {
    // Attributes
    // Static Variables
    static final int LOWERCHOICE = 1;
    static final int UPPERCHOICE = 2;
    static final int DIGITCHOICE = 3;
    static final int CHARCHOICE = 4;
    static final int NUMOFSTRING = 15;
    // Non-static Variables
    public String lowerString;
    public String upperString;
    public String digitString;
    public String charString;
    public char compareChar;
    public int comparePrime;
    public boolean compareFlag = true;

    // Runs before each test
    @BeforeEach
    void setUp() {
        // Create a new object
        RandomCharacter rc = new RandomCharacter();
        // Generate four strings of each type
        lowerString = rc.generateString(LOWERCHOICE, NUMOFSTRING);
        upperString = rc.generateString(UPPERCHOICE, NUMOFSTRING);
        digitString = rc.generateString(DIGITCHOICE, NUMOFSTRING);
        charString = rc.generateString(CHARCHOICE, NUMOFSTRING);
    }

    @RepeatedTest(5)
    @DisplayName("Each method is working as intended")
    public void testMethods() {
        // Check that the variables are not null
        // i.e. containing something
        assertNotNull(lowerString);
        assertNotNull(upperString);
        assertNotNull(digitString);
        assertNotNull(charString);
    }

    @RepeatedTest(5)
    @DisplayName("Generated string is 15 letters")
    public void testLength() {
        // Compare the variable with the constant
        // 'NUMOFSTRING' = 15
        assertEquals(NUMOFSTRING, lowerString.length());
        assertEquals(NUMOFSTRING, upperString.length());
        assertEquals(NUMOFSTRING, digitString.length());
        assertEquals(NUMOFSTRING, charString.length());
    }

    @RepeatedTest(5)
    @DisplayName("Test the lowercase function")
    public void testLowerCase() {
        // Iterate through each character in the
        // 'lowerString' variable
        for (int i = 0; i < lowerString.length(); i++) {
            // Store each character
            compareChar = lowerString.charAt(i);
            // Check that the character is in lowercase
            assertTrue(Character.isLowerCase(compareChar));
        }
    }

    @RepeatedTest(5)
    @DisplayName("Test the uppercase function")
    public void testUpperCase() {
        // Iterate through each character in the
        // 'upperString' variable
        for (int i = 0; i < upperString.length(); i++) {
            // Store each character
            compareChar = upperString.charAt(i);
            // Check that the character is in uppercase
            assertTrue(Character.isUpperCase(compareChar));
        }
    }

    @RepeatedTest(5)
    @DisplayName("Test the digit function")
    public void testDigits() {
        // Iterate through each character in the
        // 'digitString' variable
        for (int i = 0; i < digitString.length(); i++) {
            // Store each character
            compareChar = digitString.charAt(i);
            // Check that each character is a digit
            assertTrue(Character.isDigit(compareChar));
        }
    }

    @RepeatedTest(5)
    @DisplayName("Test the character function")
    public void testChar() {
        // Iterate through each character in the
        // 'charString' variable
        for (int i = 0; i < charString.length(); i++) {
            // Store each character
            compareChar = charString.charAt(i);
            // Check that each character is a character
            // from the ASCII table
            assertTrue((int) compareChar <= 128);
            assertFalse((int) compareChar > 128 || (int) compareChar < 33);
        }
    }

    @RepeatedTest(5)
    @DisplayName("Test if the generated digit is a prime number")
    public void testPrime() {
        // Iterate through each character in the
        // 'digitString' variable
        for (int i = 0; i < digitString.length(); i++) {
            // Store each character
            compareChar = digitString.charAt(i);
            // Convert the char into a numerical value
            comparePrime = Character.getNumericValue(compareChar);

            // A loop to check if the number is divisible
            // by any number from 2 to number / 2
            for (int j = 2; j <= comparePrime / 2; j++) {
                // If the number is divisible by another number,
                // it is not a prime number
                if (comparePrime % j == 0) {
                    // Set the flag to be false
                    compareFlag = false;
                    // Break out of the loop
                    break;
                }
            }
            // Check if it is a prime number, however
            // this means that the test case only passes
            // if EVERY digit is a prime
            assertTrue(compareFlag);

            // if (compareFlag) { assertTrue(compareFlag); }
            // else { assertFalse(compareFlag); }
        }
    }
}