/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex35;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PickAWinnerTest {

    //Tests getRandomNum for when bound = 1
    @Test
    void testGetRandomNumBound1() {
        PickAWinner pickAWinner = new PickAWinner();

        int actual = pickAWinner.getRandomNum(1);
        assertTrue(actual == 0);
    }

    //Tests getRandomNum for when bound = 10
    @Test
    void testGetRandomNumBound10() {
        PickAWinner pickAWinner = new PickAWinner();

        int actual = pickAWinner.getRandomNum(10);
        assertTrue(actual >= 0 && actual <= 9);
    }

    //Tests getRandomNum for when bound = max int
    @Test
    void testGetRandomNumBoundMax() {
        PickAWinner pickAWinner = new PickAWinner();

        int actual = pickAWinner.getRandomNum(Integer.MAX_VALUE);
        assertTrue(actual >= 0 && actual <= Integer.MAX_VALUE-1);
    }
}
