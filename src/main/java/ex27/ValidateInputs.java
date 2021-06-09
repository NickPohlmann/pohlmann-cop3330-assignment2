/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */
package ex27;

import java.util.ArrayList;
import java.util.Scanner;

public class ValidateInputs {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ValidateInputs newInputs = new ValidateInputs();

        String firstName = newInputs.readInput("Enter the first name: ");
        String lastName = newInputs.readInput("Enter the last name: ");
        String zipCode = newInputs.readInput("Enter the ZIP code: ");
        String employeeID = newInputs.readInput("Enter an employee ID: ");
        ArrayList<String> outputString = newInputs.validateInput(firstName, lastName, zipCode, employeeID);
        newInputs.printOutputString(outputString);
    }

    private void printOutputString(ArrayList<String> outputString) {
        if (outputString.size() == 1) {
            System.out.println("There were no errors found.");
        } else {
            for (int i = 1; i < outputString.size(); i++) {
                System.out.println(outputString.get(i));
            }
        }

    }

    public ArrayList<String> validateInput(String firstName, String lastName, String zipCode, String employeeID) {

        ArrayList<String> errors = new ArrayList<String>();
        String firstNameErrors = validateFirstName(firstName);
        String lastNameErrors = validateLastName(lastName);
        String zipCodeErrors = validateZIPCode(zipCode);
        String employeeIDErrors = validateEmployeeID(employeeID);

        if (firstName.length() != 0) {
            errors.add(firstNameErrors);
        }
        if (lastNameErrors.length() != 0) {
            errors.add(lastNameErrors);
        }
        if (zipCodeErrors.length() != 0) {
            errors.add(zipCodeErrors);
        }
        if (employeeIDErrors.length() != 0) {
            errors.add(employeeIDErrors);
        }
        return errors;
    }


    private String validateEmployeeID(String employeeID) {
        int lengthEmployeeID = getLength(employeeID);
        boolean isIDValid = true;
        char[] employeeIDArray = employeeID.toCharArray();
        while (isIDValid) {
            for (int i = 0; i < 2; i++) {
                char character = employeeIDArray[i];
                if (!(character >= 'a' && character <= 'z')) {
                    isIDValid = false;
                }
            }
        }
        while (isIDValid) {
            try {
                int i = Integer.parseInt(employeeID.substring(3, 6));
            } catch (NumberFormatException nfe) {
                isIDValid = false;
            }
        }
        while (isIDValid) {
            char character = employeeIDArray[2];
            if (!(character == '-')) {
                isIDValid = false;
            }
        }

        if (lengthEmployeeID == 0) {
            return "The employee ID must be filled in.";
        } else if (lengthEmployeeID < 7) {
            return "The employee ID is too short. The employee ID must start with two letters, followed by a hyphen and the finish with four numbers.";
        } else if (lengthEmployeeID > 7) {
            return "The employee ID is too long. The employee ID must start with two letters, followed by a hyphen and the finish with four numbers.";
        } else if (isIDValid == false) {
            return String.format("%s is not a valid ID.", employeeID);
        } else {
            return "";
        }
    }

    private String validateZIPCode(String zipCode) {
        int lengthZipCode = getLength(zipCode);
        boolean areLettersPresent = false;
        try {
            int i = Integer.parseInt(zipCode);
        } catch (NumberFormatException nfe) {
            areLettersPresent = true;
        }
        if (lengthZipCode == 0) {
            return "The ZIP code must be filled in.";
        } else if (lengthZipCode < 5) {
            return "The ZIP code entered has to few numbers. A ZIP code must have five numbers.";
        } else if (lengthZipCode > 5) {
            return "The ZIP code entered has to many numbers. A ZIP code must have five numbers.";
        } else if (areLettersPresent) {
            return "The ZIP must be numeric.";
        } else {
            return "";
        }
    }

    private String validateLastName(String lastName) {
        int lengthLastName = getLength(lastName);
        if (lengthLastName == 0) {
            return "The last name must be filled in.";
        } else if (lengthLastName < 3) {
            return String.format("\"%s\" is not a valid first name. It is too short.", lastName);
        } else {
            return "";
        }
    }

    private String validateFirstName(String firstName) {
        int lengthFirstName = getLength(firstName);
        if (lengthFirstName == 0) {
            return "The first name must be filled in.";
        } else if (lengthFirstName < 3) {
            return String.format("\"%s\" is not a valid first name. It is too short.", firstName);
        } else {
            return "";
        }
    }


    private int getLength(String str) {
        int length = str.length();
        return length;
    }

    private String readInput(String str) {
        System.out.print(str);
        String input = in.nextLine();
        return input;
    }
}
