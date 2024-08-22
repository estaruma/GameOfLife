package org.example;

//Manages game, setup, execution and display
public class GameOfLife {

    private Grid grid;
    private int generations;

    public GameOfLife(int rows, int columns, int generations) {
        this.grid = new Grid(rows, columns);
        this.generations = generations;
    }

    // initialise simulaion
    public void start() {
        for (int i = 0; i < generations; i++) {
            System.out.println("Generation " + (i+1) + ":");
            grid.displayGrid();
            grid.update();
        }
    }

    public Grid getGrid() {
        return grid;
    }
}
