/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex38;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ValueFilterTest {

    //Tests filterOutOdds for when there are no even numbers
    @Test
    void testFilterOutOddsNoEvenNumbers() {
        ValueFilter valueFilter = new ValueFilter();
        ArrayList<Integer> actual = new ArrayList<Integer>();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        actual.add(1);
        actual.add(3);
        actual.add(5);
        actual.add(7);
        actual.add(9);
        actual = valueFilter.filterOutOdds(actual);
        assertEquals(expected, actual);
    }

    //Tests filterOutOdds for when there are only even numbers
    @Test
    void testFilterOutOddsOnlyEvenNumbers() {
        ValueFilter valueFilter = new ValueFilter();
        ArrayList<Integer> actual = new ArrayList<Integer>();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        actual.add(2);
        actual.add(4);
        actual.add(6);
        actual.add(8);
        actual.add(10);
        expected.add(2);
        expected.add(4);
        expected.add(6);
        expected.add(8);
        expected.add(10);
        actual = valueFilter.filterOutOdds(actual);
        assertEquals(expected, actual);
    }

    //Tests filterOutOdds for when there are odd and even numbers
    @Test
    void testFilterOutOddsEvenAndOddNumbers() {
        ValueFilter valueFilter = new ValueFilter();
        ArrayList<Integer> actual = new ArrayList<Integer>();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        actual.add(2);
        actual.add(3);
        actual.add(6);
        actual.add(7);
        actual.add(10);
        expected.add(2);
        expected.add(6);
        expected.add(10);
        actual = valueFilter.filterOutOdds(actual);
        assertEquals(expected, actual);
    }
}
