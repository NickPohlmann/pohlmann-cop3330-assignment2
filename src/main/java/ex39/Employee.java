/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex39;

public class Employee {
    private String firstName;
    private String lastName;
    private String position;
    private String separationDate;

    public Employee(String firstName, String lastname, String position, String separationDate) {
        this.firstName = firstName;
        this.lastName = lastname;
        this.position = position;
        this.separationDate = separationDate;
    }

    public boolean doesContainSubStringInFullName(String subString) {
        String lastName = this.getLastName();
        String firstName = this.getFirstName();
        return firstName.contains(subString) || lastName.contains(subString);
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPosition() {
        return this.position;
    }

    public String getSeparationDate() {
        return this.separationDate;
    }
}
