/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */
package ex25;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    //String only contains numbers and is less than 8
    @Test
    void numbersAndLessThan8() {
        App newApp = new App();

        int actual = newApp.passwordValidator("1234");
        int expected = 1;

        assertEquals(expected, actual);
    }

    //String only contains letters and is less than 8
    @Test
    void lettersAndLessThan8() {
        App newApp = new App();

        int actual = newApp.passwordValidator("abcd");
        int expected = 2;

        assertEquals(expected, actual);
    }

    //String only contains numbers and letters and is 8 or more characters
    @Test
    void numAndLettersMoreThan8() {
        App newApp = new App();

        int actual = newApp.passwordValidator("abcd123456");
        int expected = 3;

        assertEquals(expected, actual);
    }

    //String contains numbers, letters, and special characters and is 8 or more characters
    @Test
    void allCharsMoreThan8() {
        App newApp = new App();

        int actual = newApp.passwordValidator("abcd1234*^");
        int expected = 4;

        assertEquals(expected, actual);
    }
}

