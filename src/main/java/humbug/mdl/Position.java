/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humbug.mdl;

import java.util.Objects;

/**
 * Position represents the position of an object on a board and is defined by
 * row and column.
 *
 * @author Maciej Rolecki (g54931)
 */
public class Position {

    private int row;
    private int column;

    /**
     * Default constructor for Position object.
     */
    public Position() {
    }

    /**
     * Constructor of position defined by row and column.
     *
     * @param row horizontal position.
     * @param column vertical position.
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Get the value of row.
     *
     * @return the value of row.
     */
    public int getRow() {
        return row;
    }

    /**
     * Get the value of column.
     *
     * @return the value of column.
     */
    public int getColumn() {
        return column;
    }

    /**
     * Indicates whether a Position type object is "equal to" this one. Verifies
     * if their references are the same. Verifies if the objects are of the same
     * class. Verifies if their coordinates are the same.
     *
     * @param obj the reference Position type object with which to compare.
     * @return true if this object is the same as the obj argument; false
     * otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.row != other.row) {
            return false;
        }
        return this.column == other.column;
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value.
     */
    @Override
    public int hashCode() {
        return (Objects.hashCode(row)+7) * (Objects.hashCode(column)+13);
    }

    /**
     * Returns a string representation of the object. In general, the toString
     * method returns a string that "textually represents" this object. The
     * result should be a concise but informative representation that is easy
     * for a person to read.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "(" + row + "," + column + ')';
    }

    /**
     * Returns the position next to a starting point in the designated
     * direction.
     *
     * @param dir designated direction.
     * @return the new position.
     */
    public Position next(Direction dir) {
        return new Position(this.row + dir.getDeltaRow(), this.column + dir.getDeltaColumn());
    }
}
