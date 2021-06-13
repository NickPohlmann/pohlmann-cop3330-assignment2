/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex40;

import ex39.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FilteringRecords {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        FilteringRecords filteringRecords = new FilteringRecords();
        HashMap<String, Employee> employeesByLastName = filteringRecords.getEmployeeMapByLastName();
        ArrayList<String> lastNames = filteringRecords.getListLastNames();
        String searchStr =  filteringRecords.readInput("Enter a search string: ");
        ArrayList<String> resultList = filteringRecords.filterEmployees(employeesByLastName, lastNames, searchStr);
        String outputString = filteringRecords.generateOutputString(resultList, employeesByLastName);
        filteringRecords.printOutputString(outputString);
    }

    protected ArrayList<String> filterEmployees(HashMap<String, Employee> employeesByLastName, ArrayList<String> lastNames, String searchString) {
        ArrayList<String> resultList = new ArrayList<String>();
        for (int i = 0; i < lastNames.size(); i++) {
            Employee currentEmployee = employeesByLastName.get(lastNames.get(i));
            if (currentEmployee.doesContainSubStringInFullName(searchString)) {
                resultList.add(currentEmployee.getLastName());
            }
        }
        return resultList;
    }

    private String readInput(String str) {
        System.out.print(str);
        String input = in.nextLine();
        return input;
    }

    private void printOutputString(String outputString) {
        System.out.println(outputString);
    }

    private String generateOutputString(ArrayList<String> lastNames, HashMap<String, Employee> employeesByLastName) {
        String outputString = "Name                | Position          | Separation Date\n";
        outputString += "--------------------|-------------------|----------------\n";
        for (int i = 0; i < lastNames.size(); i++) {
            Employee currentEmployee = employeesByLastName.get(lastNames.get(i));
            outputString += String.format("%s  | %s  | %s\n", currentEmployee.getFullName(), currentEmployee.getPosition(), currentEmployee.getSeparationDate());
        }
        return outputString;
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
