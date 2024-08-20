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
    }

    // intialise each cell in grid
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            cells[i][j] = new Cell();
        }
    }









}
