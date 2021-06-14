/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex39;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SortingRecords {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        SortingRecords sortingRecords = new SortingRecords();
        HashMap<String, Employee> employeesByLastName = sortingRecords.getEmployeeMapByLastName();
        ArrayList<String> lastNames = sortingRecords.getListLastNames();
        sortingRecords.sortListLastName(lastNames);
        String outputString = sortingRecords.generateOutputString(lastNames, employeesByLastName);
        sortingRecords.printOutputString(outputString);
    }

    private void printOutputString(String outputString) {
        System.out.println(outputString);
    }

    private String generateOutputString(ArrayList<String> lastNames, HashMap<String, Employee> employeesByLastName) {
        String outputString = "Name                | Position          | Separation Date\n";
        outputString += "--------------------|-------------------|----------------\n";
        for (int i = 0; i < lastNames.size(); i++) {
            Employee currentEmployee = employeesByLastName.get(lastNames.get(i));
            String nameSpacing = getNameSpacing(currentEmployee);
            String positonSpacing = getPositionSpacing(currentEmployee);
            String separationDateSpacing = getSeparationDateSpacing(currentEmployee);
            outputString += String.format("%s%s|%s%s|%s%s\n", currentEmployee.getFullName(), nameSpacing, currentEmployee.getPosition(), positonSpacing, currentEmployee.getSeparationDate(), separationDateSpacing);
        }
        return outputString;
    }

    private String getSeparationDateSpacing(Employee currentEmployee) {
        int lenSeparationDate = currentEmployee.getSeparationDate().length();
        int numSpaces = 20 - lenSeparationDate;
        String spaces = "";
        for (int i = 0; i < numSpaces; i++ ) {
            spaces += " ";
        }
        return spaces;
    }

    private String getPositionSpacing(Employee currentEmployee) {
        int lenPosition = currentEmployee.getPosition().length();
        int numSpaces = 19 - lenPosition;
        String spaces = "";
        for (int i = 0; i < numSpaces; i++ ) {
            spaces += " ";
        }
        return spaces;
    }

    private String getNameSpacing(Employee currentEmployee) {
        int lenFullName = currentEmployee.getFullName().length();
        int numSpaces = 20 - lenFullName;
        String spaces = "";
        for (int i = 0; i < numSpaces; i++ ) {
            spaces += " ";
        }
        return spaces;
    }

    private HashMap<String, Employee> getEmployeeMapByLastName() {
        HashMap<String, Employee> employeesByLastName = new HashMap<String, Employee>();
        employeesByLastName.put("Johnson", new Employee("John", "Johnson", "Manager", "2016-12-31"));
        employeesByLastName.put("Xiong", new Employee("Tou", "Xiong", "Software Engineer", "2016-10-05"));
        employeesByLastName.put("Michaelson", new Employee("Michaela", "Michaelson", "District Manager", "2015-12-19"));
        employeesByLastName.put("Jacobson", new Employee("Jake", "Jacobson", "Programmer", ""));
        employeesByLastName.put("Jackson", new Employee("Jacquelyn", "Jackson", "DBA", ""));
        employeesByLastName.put("Webber", new Employee("Sally", "Webber", "Web Developer", "2015-12-18"));
        return employeesByLastName;
    }

    protected void sortListLastName(ArrayList<String> lastNames) {
        lastNames.sort(String::compareToIgnoreCase);
    }

    private ArrayList<String> getListLastNames() {
        ArrayList<String> lastNames = new ArrayList<String>();
        lastNames.add("Johnson");
        lastNames.add("Xiong");
        lastNames.add("Michaelson");
        lastNames.add("Jacobson");
        lastNames.add("Jackson");
        lastNames.add("Webber");
        return lastNames;
    }
}
