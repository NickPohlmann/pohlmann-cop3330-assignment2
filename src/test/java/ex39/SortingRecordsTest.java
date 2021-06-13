/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex39;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class SortingRecordsTest {

    //Tests sortListLastName for when just one person
    @Test
    void testSortListLastNameOnePerson() {
        SortingRecords sortingRecords = new SortingRecords();

        ArrayList<String> actualLastNames = new ArrayList<String>();
        actualLastNames.add("Johnson");
        ArrayList<String> expectedLastNames = new ArrayList<String>();
        expectedLastNames.add("Johnson");

        sortingRecords.sortListLastName(actualLastNames);

        assertEquals(expectedLastNames, actualLastNames);
    }

    //Tests sortListLastName for when 5 people in reverse order
    @Test
    void testSortListLastName5PeopleReversed() {
        SortingRecords sortingRecords = new SortingRecords();

        ArrayList<String> actualLastNames = new ArrayList<String>();
        actualLastNames.add("Xiong");
        actualLastNames.add("Webber");
        actualLastNames.add("Michaelson");
        actualLastNames.add("Johnson");
        actualLastNames.add("Jacobson");
        actualLastNames.add("Jackson");
        ArrayList<String> expectedLastNames = new ArrayList<String>();
        expectedLastNames.add("Jackson");
        expectedLastNames.add("Jacobson");
        expectedLastNames.add("Johnson");
        expectedLastNames.add("Michaelson");
        expectedLastNames.add("Webber");
        expectedLastNames.add("Xiong");

        sortingRecords.sortListLastName(actualLastNames);

        assertEquals(expectedLastNames, actualLastNames);
    }
}
