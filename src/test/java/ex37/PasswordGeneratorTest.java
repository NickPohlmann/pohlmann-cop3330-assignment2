/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex37;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordGeneratorTest {

    //Test getRandomNum for when bound = 1
    @Test
    void testGetRandomNumBound1() {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        int actual = passwordGenerator.getRandomNum(1);
        assertTrue(actual == 0);
    }

    //Test getRandomNum for when bound = 10
    @Test
    void testGetRandomNumBound10() {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        int actual = passwordGenerator.getRandomNum(10);
        assertTrue(actual >= 0 && actual <= 9);
    }

    //Test getRandomNum for when bound = max int value
    @Test
    void testGetRandomNumBoundMaxInt() {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        int actual = passwordGenerator.getRandomNum(Integer.MAX_VALUE);
        assertTrue(actual >= 0 && actual <= Integer.MAX_VALUE - 1);
    }
}
