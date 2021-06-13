/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex36;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StatisticsCalculatorTest {

    //Tests average for when the array list only has 1 value
    @Test
    void testAverageOnly1Value() {
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        ArrayList<Integer> oneValueArrayList = new ArrayList<Integer>();
        oneValueArrayList.add(5);
        double actual = statisticsCalculator.average(oneValueArrayList);
        double expected = (5.0);
        double delta = 0.0;

        assertEquals(expected, actual, delta);
    }

    //Tests average for when the array list only has an even amount of ints
    @Test
    void testAverageOnlyEven() {
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        ArrayList<Integer> evenValueArrayList = new ArrayList<Integer>();
        evenValueArrayList.add(5);
        evenValueArrayList.add(6);
        evenValueArrayList.add(7);
        evenValueArrayList.add(8);
        evenValueArrayList.add(9);
        evenValueArrayList.add(10);
        double actual = statisticsCalculator.average(evenValueArrayList);
        double expected = (7.0);
        double delta = 0.0;

        assertEquals(expected, actual, delta);
    }

    //Tests average for when the array list only has an odd amount of ints
    @Test
    void testAverageOnlyOdd() {
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        ArrayList<Integer> oddValueArrayList = new ArrayList<Integer>();
        oddValueArrayList.add(5);
        oddValueArrayList.add(6);
        oddValueArrayList.add(7);
        oddValueArrayList.add(8);
        oddValueArrayList.add(9);
        oddValueArrayList.add(10);
        oddValueArrayList.add(11);
        double actual = statisticsCalculator.average(oddValueArrayList);
        double expected = (8.0);
        double delta = 0.0;

        assertEquals(expected, actual, delta);
    }

    //Tests max for when the array list for the max value when it is entered as the first value
    @Test
    void testMaxFirstValue() {
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        ArrayList<Integer> maxValueFirst = new ArrayList<Integer>();
        maxValueFirst.add(34);
        maxValueFirst.add(24);
        maxValueFirst.add(20);
        maxValueFirst.add(29);
        maxValueFirst.add(32);
        maxValueFirst.add(9);
        int actual = statisticsCalculator.max(maxValueFirst);
        int expected = 34;
        assertEquals(expected, actual);
    }

    //Tests max for when the array list for the max value when it is entered as the last value
    @Test
    void testMaxLastValue() {
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        ArrayList<Integer> maxValueLast = new ArrayList<Integer>();
        maxValueLast.add(12);
        maxValueLast.add(15);
        maxValueLast.add(120);
        maxValueLast.add(122);
        maxValueLast.add(112);
        maxValueLast.add(136);
        int actual = statisticsCalculator.max(maxValueLast);
        int expected = 136;
        assertEquals(expected, actual);
    }

    //Tests max for when the array list only has one value
    @Test
    void testMaxOneValue() {
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        ArrayList<Integer> maxOneValue = new ArrayList<Integer>();
        maxOneValue.add(30);
        int actual = statisticsCalculator.max(maxOneValue);
        int expected = 30;
        assertEquals(expected, actual);
    }

    //Tests min for when the array list for the min value when it is entered as the first value
    @Test
    void testMinFirstValue() {
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        ArrayList<Integer> minValueFirst = new ArrayList<Integer>();
        minValueFirst.add(2);
        minValueFirst.add(24);
        minValueFirst.add(20);
        minValueFirst.add(29);
        minValueFirst.add(32);
        minValueFirst.add(9);
        int actual = statisticsCalculator.min(minValueFirst);
        int expected = 2;
        assertEquals(expected, actual);
    }

    //Tests min for when the array list for the min value when it is entered as the last value
    @Test
    void testMinLastValue() {
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        ArrayList<Integer> minValueLast = new ArrayList<Integer>();
        minValueLast.add(12);
        minValueLast.add(15);
        minValueLast.add(120);
        minValueLast.add(122);
        minValueLast.add(112);
        minValueLast.add(9);
        int actual = statisticsCalculator.min(minValueLast);
        int expected = 9;
        assertEquals(expected, actual);
    }

    //Tests min for when the array list only has one value
    @Test
    void testMinOneValue() {
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        ArrayList<Integer> minOneValue = new ArrayList<Integer>();
        minOneValue.add(30);
        int actual = statisticsCalculator.min(minOneValue);
        int expected = 30;
        assertEquals(expected, actual);
    }

    //Tests std for when the array list only has one value
    @Test
    void testSTDOneValue() {
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        ArrayList<Integer> stdOneValue = new ArrayList<Integer>();
        stdOneValue.add(30);
        double actual = statisticsCalculator.std(stdOneValue, 30);
        double expected = 0.0;
        double delta = 0.0;
        assertEquals(expected, actual, delta);
    }

    //Tests std for when the array list only has normal values
    @Test
    void testSTDNormalValues() {
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        ArrayList<Integer> stdNormalValues = new ArrayList<Integer>();
        stdNormalValues.add(10);
        stdNormalValues.add(16);
        stdNormalValues.add(120);
        stdNormalValues.add(14);
        stdNormalValues.add(26);
        double actual = statisticsCalculator.std(stdNormalValues, 37.2);
        double expected = 41.73439828247198;
        double delta = 0.0;
        assertEquals(expected, actual, delta);
    }
}
