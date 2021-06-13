/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex40;

import ex39.Employee;
import ex39.SortingRecords;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public class FilteringRecordsTest {

    //Tests filterEmployees for when substring == full first name
    @Test
    void testSortListLastNameOnePerson() {
        FilteringRecords filteringRecords = new FilteringRecords();

        HashMap<String, Employee> employeesByLastName = new HashMap<String, Employee>();
        employeesByLastName.put("Johnson", new Employee("John", "Johnson", "Manager", "2016-12-31"));
        employeesByLastName.put("Xiong", new Employee("Tou", "Xiong", "Software Engineer", "2016-10-05"));
        employeesByLastName.put("Michaelson", new Employee("Michaela", "Michaelson", "District Manager", "2015-12-19"));
        employeesByLastName.put("Jacobson", new Employee("Jake", "Jacobson", "Programmer", ""));
        employeesByLastName.put("Jackson", new Employee("Jacquelyn", "Jackson", "DBA", ""));
        employeesByLastName.put("Webber", new Employee("Sally", "Webber", "Web Developer", "2015-12-18"));
        ArrayList<String> actualLastNames = new ArrayList<String>();
        actualLastNames.add("Johnson");
        actualLastNames.add("Xiong");
        actualLastNames.add("Michaelson");
        actualLastNames.add("Jacobson");
        actualLastNames.add("Jackson");
        actualLastNames.add("Webber");
        ArrayList<String> expectedLastNames = new ArrayList<String>();
        expectedLastNames.add("Johnson");

        ArrayList<String> actualFiltered = filteringRecords.filterEmployees(employeesByLastName, actualLastNames, "Johnson");

        assertEquals(expectedLastNames, actualFiltered);
    }

    //Tests filterEmployees for when substring == " "
    @Test
    void testSortListLastNameSpace() {
        FilteringRecords filteringRecords = new FilteringRecords();

        HashMap<String, Employee> employeesByLastName = new HashMap<String, Employee>();
        employeesByLastName.put("Johnson", new Employee("John", "Johnson", "Manager", "2016-12-31"));
        employeesByLastName.put("Xiong", new Employee("Tou", "Xiong", "Software Engineer", "2016-10-05"));
        employeesByLastName.put("Michaelson", new Employee("Michaela", "Michaelson", "District Manager", "2015-12-19"));
        employeesByLastName.put("Jacobson", new Employee("Jake", "Jacobson", "Programmer", ""));
        employeesByLastName.put("Jackson", new Employee("Jacquelyn", "Jackson", "DBA", ""));
        employeesByLastName.put("Webber", new Employee("Sally", "Webber", "Web Developer", "2015-12-18"));
        ArrayList<String> actualLastNames = new ArrayList<String>();
        actualLastNames.add("Johnson");
        actualLastNames.add("Xiong");
        actualLastNames.add("Michaelson");
        actualLastNames.add("Jacobson");
        actualLastNames.add("Jackson");
        actualLastNames.add("Webber");
        ArrayList<String> expectedLastNames = new ArrayList<String>();

        ArrayList<String> actualFiltered = filteringRecords.filterEmployees(employeesByLastName, actualLastNames, " ");

        assertEquals(expectedLastNames, actualFiltered);
    }
}
