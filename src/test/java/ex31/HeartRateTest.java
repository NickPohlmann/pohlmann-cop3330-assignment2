/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */
package ex31;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeartRateTest {

    //Tests calculateTargetHR for when age 22, resting pulse 65, and intensity of 55%
    @Test
    void testCalculateTargetHRGivenCaseLowest() {
        HeartRateTracker heartRateTracker = new HeartRateTracker();

        int actual = heartRateTracker.calculateTargetHR(65, 22, 55);
        int expected = 138;

        assertEquals(expected, actual);
    }

    //Tests calculateTargetHR for when age 22, resting pulse 65, and intensity of 95%
    @Test
    void testCalculateTargetHRGivenCaseHighest() {
        HeartRateTracker heartRateTracker = new HeartRateTracker();

        int actual = heartRateTracker.calculateTargetHR(65, 22, 95);
        int expected = 191;

        assertEquals(expected, actual);
    }

    //Tests calculateTargetHR for when age 0, resting pulse 0, and intensity of 55%
    @Test
    void testCalculateTargetHRZerosForInputValuesLowestIntensity() {
        HeartRateTracker heartRateTracker = new HeartRateTracker();

        int actual = heartRateTracker.calculateTargetHR(0, 0, 55);
        int expected = 121;

        assertEquals(expected, actual);
    }

    //Tests createTable for when age 22, resting heart rate 65, and intensity between 55%-95%
    @Test
    void testCreateTable() {
        HeartRateTracker heartRateTracker = new HeartRateTracker();

        String actual = heartRateTracker.createTable(65,22);
        String expected = "Resting Pulse: 65 \t Age: 22\n" +
                "\n" +
                "Intensity    | Rate   \n" +
                "-------------|--------\n" +
                "55%          | 138 bpm\n" +
                "60%          | 145 bpm\n" +
                "65%          | 151 bpm\n" +
                "70%          | 158 bpm\n" +
                "75%          | 165 bpm\n" +
                "80%          | 171 bpm\n" +
                "85%          | 178 bpm\n" +
                "90%          | 185 bpm\n" +
                "95%          | 191 bpm\n";

        assertEquals(expected, actual);
    }
}
