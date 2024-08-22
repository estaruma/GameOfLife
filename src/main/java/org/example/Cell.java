package org.example;

// represents a single cell in the grid
// dead or alive

public class Cell {

    private boolean isAlive;

    //constructor to initilise the cell state
    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    // set default constructor as dead
    public Cell() {
        this(false);
    }

    // getters for cell state
    public boolean isAlive() {
        return isAlive;
    }


    // setters for cell state
    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    // returns string representation of cell state
    @Override
    public String toString() {
        if (isAlive) {
            // living cell
            return "*";
        } else {
            // dead cell
            return ".";
        }
    }
}
