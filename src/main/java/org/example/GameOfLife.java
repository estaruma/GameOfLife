package org.example;

import java.util.Scanner;

//Manages game, setup, execution and display
public class GameOfLife {

    private Grid grid;
    private int generations;

    public GameOfLife(int rows, int columns, int generations) {
        this.grid = new Grid(rows, columns);
        this.generations = generations;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("User input:");
        grid.displayGrid();

    // initialise simulaion
        for (int i = 0; i < generations; i++) {
            grid.update();
            System.out.println("Generation " + (i + 1) + ":");
            grid.displayGrid();
            grid.update();
        }
    }

    public Grid getGrid() {
        return grid;
    }
}
