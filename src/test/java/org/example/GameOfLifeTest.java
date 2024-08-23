package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {

    private Grid grid;
    private GameOfLife gameOfLife;

    @BeforeEach
    public void setUp() {
        int rows = 3;
        int columns = 3;
        int generations = 1;
        gameOfLife = new GameOfLife(rows, columns, generations);
        grid = gameOfLife.getGrid();
    }

    @Test
    public void userInputGridTest() {
        grid.setCellState(0, 0, true);
        grid.setCellState(1, 1, true);
        grid.setCellState(2, 2, true);

        String expected = "* . . \n. * . \n. . * \n";
        assertEquals(expected, gridToString());
    }

    @Test
    public void singleCellDiesTest() {
        grid.setCellState(1, 1, true);
        String initialGrid = "* . . \n. . . \n. . . \n";

        gameOfLife.start();

        String finalGrid = ". . . \n. . . \n. . . \n";
        assertEquals(finalGrid, gridToString(), "After 1 gen, the single cell should die");
    }

    // two or less, cells will die
    @Test
    public void underpopulationTest() {
        grid.setCellState(1, 1, true);
        grid.setCellState(0,1, true);

        assertTrue(grid.getCell(1,1).isAlive());

        grid.update();

        assertFalse(grid.getCell(1,1).isAlive());
    }

    @Test
    public void overcrowdingTest() {
        grid.setCellState(1, 1, true);
        grid.setCellState(0,0, true);
        grid.setCellState(0, 1, true);
        grid.setCellState(0,2, true);
        grid.setCellState(1, 0, true);

        assertTrue(grid.getCell(1,1).isAlive());

        grid.update();

        assertFalse(grid.getCell(1,1).isAlive());
    }

    @Test
    public void survivalTest() {
        grid.setCellState(1, 1, true);
        grid.setCellState(0, 0, true);
        grid.setCellState(0, 1, true);

        assertTrue(grid.getCell(1,1).isAlive());

        grid.update();

        assertTrue(grid.getCell(1,1).isAlive());
    }


    private String gridToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getColumns(); j++) {
                sb.append(grid.getCell(i, j)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}