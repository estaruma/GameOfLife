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

    // Set the state of a specific cell
    public void setCellState(int row, int column, boolean isAlive) {
        if (row >= 0 && row < rows && column >= 0 && column < columns) {
            cells[row][column].setAlive(isAlive);
        }
    }


    // count living neighbours
    public int countAliveNeighbours(int row, int column) {
        int aliveNeighbours = 0;

        // loop through cells
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Skip the cell itself
                if (i == 0 && j == 0) continue;

                Cell neighbour = getCell((row), column);
                if (neighbour != null && neighbour.isAlive()) {
                    aliveNeighbours++;
                }
            }

        }
        return aliveNeighbours;
    }

    // update grid

    public void update() {
        Cell[][] nextGen = new Cell[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int aliveNeighbors = countAliveNeighbours(i, j);
                boolean currentState = cells[i][j].isAlive();
                boolean nextState;


                //apply game rules
                if (currentState && (aliveNeighbors < 2 || aliveNeighbors > 3)) {
                    nextState = false; // Cell dies due to underpopulation or overpopulation
                } else if (!currentState && aliveNeighbors == 3) {
                    nextState = true; // Cell becomes alive by reproduction
                } else {
                    nextState = currentState; // Cell stays in its current state
                }

                nextGen[i][j] = new Cell(nextState);
            }
        }

        // Update the cells to the new generation
        cells = nextGen;

        }

        public void displayGrid() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.println(cells[i][j] + " ");
                }
                System.out.println();
            }
        }

}


