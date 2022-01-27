/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humbug.mdl;

/**
 * Represents the direction in which movements can ba made.
 *
 * @author Maciej Rolecki (g54931)
 */
public enum Direction {
    NORTH(-1, 0),
    SOUTH(1, 0),
    EAST(0, 1),
    WEST(0, -1);

    private final int deltaRow;
    private final int deltaColumn;

    /**
     * Direction represents a movement.
     *
     * @param deltaRow represents how many steps to make horizontally.
     * @param deltaColumn represents how many steps to make vertically.
     */
    private Direction(int deltaRow, int deltaColumn) {
        this.deltaRow = deltaRow;
        this.deltaColumn = deltaColumn;
    }

    /**
     * Simple getter of deltaRow.
     *
     * @return row number of Direction.
     */
    public int getDeltaRow() {
        return deltaRow;
    }

    /**
     * Simple getter of deltaColumn.
     *
     * @return column number of Direction.
     */
    public int getDeltaColumn() {
        return deltaColumn;
    }

    /**
     * Returns the direction opposite to the one on which the code is applied.
     *
     * @return the opposite direction.
     */
    public Direction opposite() {
        switch (this) {
            case NORTH:
                return SOUTH;
            case SOUTH:
                return NORTH;
            case EAST:
                return WEST;
            case WEST:
                return EAST;
        }
        return null;
    }
}
