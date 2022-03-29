package Lab_9;

import java.util.Random;

public class RandomCharacter {
    // Create a new Random
    Random random = new Random();
    // Attributes
    public char lowerCase;
    public char upperCase;
    public char randDigit;
    public char randChar;
    public String generatedString;

    // Operations
    // Get
    public char getLowerCase() { return this.lowerCase; }
    public char getUpperCase() { return this.upperCase; }
    public char getDigit() { return this.randDigit; }
    public char getChar() { return this.randChar; }

    // Returns a random lowercase letter from
    // 'a' to 'z'
    public char getRandomLowerCaseLetter() {
        // The ASCII value is between 97 - 122 for
        // lower case characters
        this.lowerCase = (char) ('a' + random.nextInt(26));
        return this.lowerCase;
    }

    // Returns a random uppercase letter from
    // 'A' to 'Z'
    public char getRandomUpperCaseLetter() {
        // The ASCII value is between 60 - 95 for
        // upper case characters
        this.upperCase = (char) ('A' + random.nextInt(26));
        return this.upperCase;
    }

    // Returns a random digit from
    // '0' to '9'
    public char getRandomDigit() {
        // Returns a number between 0 - 9
        this.randDigit = (char) ('0' + random.nextInt(10));
        return this.randDigit;
    }

    // Assuming that it returns every single
    // ASCII character
    public char getRandomCharacter() {
        // Every valid character in the ASCII table
        // which starts from '!' (33) to 127
        this.randChar = (char) ('!' + random.nextInt(95));
        return this.randChar;
    }

    // Generates a string of characters
    // based on the functions above
    public String generateString(int choice, int num) {
        // Create a new Stringbuilder
        StringBuilder sb = new StringBuilder();
        // Iterate through a switch-case to see
        // which option the user has selected
        switch(choice) {
            // Lowercase string
            case 1:
                while (num > 0) {
                    // Append a lowercase letter into the
                    // StringBuilder
                    sb.append(getRandomLowerCaseLetter());
                    // Decrease 'num' after each iteration
                    num--;
                }
                break;
            // Uppercase string
            case 2:
                while (num > 0) {
                    // Append an uppercase letter into the
                    // StringBuilder
                    sb.append(getRandomUpperCaseLetter());
                    // Decrease 'num' after each iteration
                    num--;
                }
                break;
            // Digits
            case 3:
                while (num > 0) {
                    // Append a random digit into the
                    // StringBuilder
                    sb.append(getRandomDigit());
                    // Decrease 'num' after each iteration
                    num--;
                }
            // Random characters
            case 4:
                while (num > 0) {
                    // Append a random character into the
                    // StringBuilder
                    sb.append(getRandomCharacter());
                    // Decrease 'num' after each iteration
                    num--;
                }
            // None of the four options above
            default:
                break;
        }
        // Convert it from a char to a String
        this.generatedString = sb.toString();
        return this.generatedString;
    }
}
