package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Game Of Life");
        System.out.println("Enter number of rows: ");
        int rows = scanner.nextInt();

        System.out.println("Enter number of columns: ");
        int columns = scanner.nextInt();

        // initiliase grid
//        Grid grid = new Grid(rows, columns);

        scanner.close();



    }
}