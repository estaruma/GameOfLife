package org.example;

// manages the grid of cells and their interactions
public class Grid {

    private int rows;
    private int columns;

    // 2d array grid
    private Cell[][] cells;

    // constructor to create board
    // can accept an arbitrary grid of cells

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        cells = new Cell[rows][columns];

        // intialise each cell in grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    // get specific cell in the grid
    public Cell getCell(int row, int column) {
        if (row >= 0 && row < rows && column >= 0 && column < columns) {
            return cells[row][column];
        }
        return null;
    }

    // count living neighbours

    public int countAliveNeighbours(int row, int column) {
        int aliveNeighbours = 0;

        // loop through cells
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                Cell neighbour = getCell((row), column);
                if (neighbour != null && neighbour.isAlive()) {
                    aliveNeighbours++;
                }
            }

        }
        return aliveNeighbours;
    }

}


