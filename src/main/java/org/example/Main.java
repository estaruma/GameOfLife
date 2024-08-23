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

        System.out.println("Enter number of generations: ");
        int generations = scanner.nextInt();

        // Initialize the game
        GameOfLife gameOfLife = new GameOfLife(rows, columns, generations);

        // display all dead cells grid
        System.out.println("Initial grid:");
        gameOfLife.getGrid().displayGrid();

        // initiliase grid
        // Grid grid = new Grid(rows, columns);
        System.out.println("Do you want a random grid (y/n): ");
        String initialiseRandom = scanner.next();


        if (initialiseRandom.equalsIgnoreCase("y")) {
            gameOfLife.getGrid().initialiseRandom();
            System.out.println("Randomly initialized grid:");
        } else {
            scanner.nextLine();

            System.out.println("Enter grid config, '*' for alive cells and '.' for dead cells:");
            for (int i = 0; i < rows; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < columns; j++) {
                    gameOfLife.getGrid().setCellState(i, j, line.charAt(j) == '*');
                }
            }
        }

        gameOfLife.start();

        scanner.close();

        }
    }