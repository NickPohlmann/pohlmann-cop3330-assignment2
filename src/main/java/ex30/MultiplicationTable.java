/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */
package ex30;

import java.util.ArrayList;

public class MultiplicationTable {
    public static void main(String[] args) {
        MultiplicationTable myTable = new MultiplicationTable();
        String table = myTable.createTable();
        myTable.printTable(table);
    }

    private void printTable(String table) {
        System.out.println(table);
    }

    protected String createTable() {
        String table = "";
        for (int i = 1; i < 13; i++) {
            for (int j = 1; j < 13; j++) {
                int numForTable = i * j;
                String leadingSpaces = getLeadingSpaces(numForTable);
                table += String.format("%s%d", leadingSpaces, numForTable);
            }
            table += "\n";
        }
        return table;
    }

    protected String getLeadingSpaces(int numForTable) {
        String leadingSpaces = "";
        int spaceBetweenNum = 6;
        String getLenOfNum = String.format("%d", numForTable);
        int lenOfNum = getLenOfNum.length();
        int numSpaces = spaceBetweenNum - lenOfNum;
        for (int i = 0; i < numSpaces; i++) {
            leadingSpaces += " ";
        }
        return leadingSpaces;
    }
}
