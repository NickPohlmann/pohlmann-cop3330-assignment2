/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex34;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeListRemovalTest {

    //Tests removeEmployee for when the first employee is removed
    @Test
     void testRemoveEmployeeFirst() {
        EmployeeListRemoval employeeListRemoval = new EmployeeListRemoval();
        ArrayList<String> employeeListActual = employeeListRemoval.createOriginalEmployeeString();
        ArrayList<String> employeeListExpected = employeeListRemoval.createOriginalEmployeeString();
        employeeListRemoval.removeEmployee(employeeListActual, employeeListActual.get(0));
        employeeListExpected.remove(employeeListExpected.get(0));
        assertEquals(employeeListExpected, employeeListActual);
    }

    //Tests removeEmployee for when the last employee is removed
    @Test
    void testRemoveEmployeeLast() {
        EmployeeListRemoval employeeListRemoval = new EmployeeListRemoval();
        ArrayList<String> employeeListActual = employeeListRemoval.createOriginalEmployeeString();
        ArrayList<String> employeeListExpected = employeeListRemoval.createOriginalEmployeeString();
        employeeListRemoval.removeEmployee(employeeListActual, employeeListActual.get(4));
        employeeListExpected.remove(employeeListExpected.get(4));
        assertEquals(employeeListExpected, employeeListActual);
    }
}
