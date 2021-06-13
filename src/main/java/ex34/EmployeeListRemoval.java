/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex34;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeListRemoval {
    static Scanner in = new Scanner(System.in);

    public static void main(String [] args) {
        EmployeeListRemoval newRemoval = new EmployeeListRemoval();

        ArrayList<String> employeeList = newRemoval.createOriginalEmployeeString();
        System.out.println(String.format("There are %d employees: ", employeeList.size()));
        newRemoval.printArrayList(employeeList);
        String employeeToRemove = newRemoval.readInput("Enter an employee name to remove: ");
        newRemoval.removeEmployee(employeeList, employeeToRemove);
        newRemoval.printArrayList(employeeList);
    }

    protected void removeEmployee(ArrayList<String> originalEmployeeList, String employeeToRemove) {
        originalEmployeeList.remove(employeeToRemove);
    }

    private String readInput(String str) {
        System.out.print(str);
        String input = in.nextLine();
        return input;
    }

    private void printArrayList(ArrayList<String> originalEmployees) {
        for (int i = 0; i < originalEmployees.size(); i++) {
            System.out.println(originalEmployees.get(i));
        }
    }

    protected ArrayList<String> createOriginalEmployeeString() {
        ArrayList<String> originalEmployees = new ArrayList<String>();
        originalEmployees.add("John Smith");
        originalEmployees.add("Jackie Jackson");
        originalEmployees.add("Chris Jones");
        originalEmployees.add("Amanda Cullen");
        originalEmployees.add("Jeremy Goodwin");
        return originalEmployees;
    }
}
