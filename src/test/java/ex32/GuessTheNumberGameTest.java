/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex32;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GuessTheNumberGameTest {

    //Tests correctNum for when difficulty is 1
    @Test
    void testCorrectNumDifficulty1() {
        NumberGame numberGame = new NumberGame();

        int actual = numberGame.getCorrectNum(1);
        assertTrue(actual >= 1 && actual <= 10);
    }

    //Tests correctNum for when difficulty is 2
    @Test
    void testCorrectNumDifficulty2() {
        NumberGame numberGame = new NumberGame();

        int actual = numberGame.getCorrectNum(2);
        assertTrue(actual >= 1 && actual <= 100);
    }

    //Tests correctNum for when difficulty is 3
    @Test
    void testCorrectNumDifficulty3() {
        NumberGame numberGame = new NumberGame();

        int actual = numberGame.getCorrectNum(3);
        assertTrue(actual >= 1 && actual <= 1000);
    }

    //Tests validateYourGuess for when yourGuess is valid, given int
    @Test
    void testValidateYourGuessValidGivenInt() {
        NumberGame numberGame = new NumberGame();

        boolean actual = numberGame.validateYourGuess("4");
        assertTrue(actual);
    }

    //Tests validateYourGuess for when yourGuess is not valid, given double
    @Test
    void testValidateYourGuessNotValidGiveDouble() {
        NumberGame numberGame = new NumberGame();

        boolean actual = numberGame.validateYourGuess("4.5");
        assertFalse(actual);
    }

    //Tests validateYourGuess for when yourGuess is not valid, given letters
    @Test
    void testValidateYourGuessNotValidGiveLetters() {
        NumberGame numberGame = new NumberGame();

        boolean actual = numberGame.validateYourGuess("abc34");
        assertFalse(actual);
    }
}
