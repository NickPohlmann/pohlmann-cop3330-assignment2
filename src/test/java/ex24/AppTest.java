/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */
package ex24;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    //Testing two words that are not of equal length
    @Test
    void notSameLength() {
        App newApp = new App();

        boolean actual = newApp.isAnagram("Hello", "Hi");
        boolean expected = false;

        assertEquals(expected, actual);
    }

    //Testing two words that are the same length and are anagrams
    @Test
    void isAnagram() {
        App newApp = new App();

        boolean actual = newApp.isAnagram("note","tone");
        boolean expected = true;

        assertEquals(expected, actual);
    }

    //Testing two words that are the same length but are not anagrams
    @Test
    void isNotAnagram() {
        App newApp = new App();

        boolean actual = newApp.isAnagram("note","look");
        boolean expected = false;

        assertEquals(expected, actual);
    }

    //Testing where String 1 is empty
    @Test
    void strOneEmpty() {
        App newApp = new App();

        boolean actual = newApp.isAnagram("","look");
        boolean expected = false;

        assertEquals(expected, actual);
    }

    //Testing where String 2 is empty
    @Test
    void strTwoEmpty() {
        App newApp = new App();

        boolean actual = newApp.isAnagram("note","");
        boolean expected = false;

        assertEquals(expected, actual);
    }

    //Testing where both strings are empty
    @Test
    void bothStrEmpty() {
        App newApp = new App();

        boolean actual = newApp.isAnagram("","");
        boolean expected = true;

        assertEquals(expected, actual);
    }
}
