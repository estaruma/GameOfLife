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
    public void initialGridAllDeadTest() {
        String expected = ". . . \n. . . \n. . . \n";
        assertEquals(expected, gridToString());
    }

    @Test
    public void gridInitialisationTest() {
        int rows = 4;
        int columns = 4;
        GameOfLife gameOfLife = new GameOfLife(rows, columns, 1);
        Grid grid = gameOfLife.getGrid();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                assertFalse(grid.getCell(i, j).isAlive(), "cells should be dead at the beginning");
            }
        }
    }

    @Test
    public void testInitialiseRandom() {
        grid.initialiseRandom();
        boolean hasAliveCell = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid.getCell(i, j).isAlive()) {
                    hasAliveCell = true;
                    break;
                }
            }
            if (hasAliveCell) break;
        }
        assertTrue(hasAliveCell, "Grid should have some alive cells");
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


    @Test
    public void EmptyGridRemainsEmptyTest() {
        int rows = 3;
        int columns = 3;
        GameOfLife gameOfLife = new GameOfLife(rows, columns, 1);
        Grid grid = gameOfLife.getGrid();

        gameOfLife.start();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                assertFalse(grid.getCell(i, j).isAlive(), "cells should remain dead");
            }
        }
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