/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */
package ex24;

import java.util.HashMap;
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();

        myApp.printString("Enter two strings and I'll tell you if they are anagrams:");
        String firstString = myApp.readInput("Enter the first string: ");
        String secondString = myApp.readInput("Enter the second string: ");
        Boolean anagram = myApp.isAnagram(firstString, secondString);
        String outputString = generateOutputString(anagram, firstString, secondString);
        myApp.printString(outputString);
    }

    private static String generateOutputString(Boolean anagram, String firstString, String secondString) {
        if(anagram) {
            return String.format("\"%s\" and \"%s\" are anagrams.", firstString, secondString);
        }
        return String.format("\"%s\" and \"%s\" are not anagrams.", firstString, secondString);
    }

    private Boolean isAnagram(String firstString, String secondString) {
        int lenFirstStr = computeLength(firstString);
        int lenSecondStr = computeLength(secondString);
        if (lenFirstStr != lenSecondStr) {
            System.out.println("The strings were not the same length so they can't be anagrams.");
            System.exit(0);
        }
        char arrFirstStr[] = createArray(lenFirstStr, firstString);
        char arrSecondStr[] = createArray(lenSecondStr, secondString);

        int countIntHM = 0;
        HashMap<Character, Integer> hm1 = new HashMap<>();
        for (int i = 0; i < lenFirstStr; i++) {
            if (hm1.get(arrFirstStr[i]) == null) {
                hm1.put(arrFirstStr[i], 1);
            } else {
                countIntHM = hm1.get(arrFirstStr[i]);
                countIntHM = countIntHM + 1;
                hm1.put(arrFirstStr[i], countIntHM);
            }
        }

        for (int j = 0; j < lenSecondStr; j++) {
            if (!hm1.containsKey(arrSecondStr[j])) {
                return false;
            }
            if (hm1.get(arrSecondStr[j]) == 0) {
                return false;
            }

            countIntHM = hm1.get(arrSecondStr[j]);
            countIntHM = countIntHM - 1;
            hm1.put(arrSecondStr[j], countIntHM);
        }
        return true;
    }

    private char[] createArray(int strLen, String str) {
        char arr[];
        arr = new char[strLen];
        for (int i = 0; i < strLen; i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }

    private int computeLength(String str) {
        int length = str.length();
        return length;
    }

    private String readInput(String str) {
        System.out.print(str);
        String input = in.nextLine();
        return input;
    }

    private void printString (String str) {
        System.out.println(str);
    }
}
