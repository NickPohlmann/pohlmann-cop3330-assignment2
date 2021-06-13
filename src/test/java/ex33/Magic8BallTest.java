/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex33;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Magic8BallTest {

    //Tests getRandomNum for when bound = 1
    @Test
    void testGetRandomNumBound1() {
        Magic8Ball magic8Ball = new Magic8Ball();

        int actual = magic8Ball.getRandomNum(1);
        assertTrue(actual == 0);
    }

    //Tests getRandomNum for when bound = 4
    @Test
    void testGetRandomNumBound4() {
        Magic8Ball magic8Ball = new Magic8Ball();

        int actual = magic8Ball.getRandomNum(4);
        assertTrue(actual <= 3 && actual >= 0);
    }

    //Tests getRandomNum for when bound = max value of int
    @Test
    void testGetRandomNumBoundMax() {
        Magic8Ball magic8Ball = new Magic8Ball();

        int actual = magic8Ball.getRandomNum(Integer.MAX_VALUE);
        assertTrue(actual <= Integer.MAX_VALUE-1 && actual >= 0);
    }
}
