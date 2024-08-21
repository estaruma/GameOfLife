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
    public void initializeFromPattern(boolean[][] pattern) {
        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern[i].length; j++) {
                grid.setCellState(i, j, pattern[i][j]);
            }
        }
    }

}
