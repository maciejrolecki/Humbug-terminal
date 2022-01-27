/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humbug.mdl;

import static humbug.mdl.SquareType.*;

/**
 * Board will be used as the base for different levels.
 *
 * @author Maciej Rolecki (g54931)
 */
public class Board {

    private Square[][] squares;

    /**
     * Default constructor for Board object.
     */
    public Board() {
    }

    /**
     * Sends the board of squares into a Board object.
     *
     * @param squares board of squares.
     */
    public Board(Square[][] squares) {
        this.squares = squares;
    }

    /**
     * Returns the gameboard corresponding to a level in the game.
     *
     * @return returns a two dimensional table composed of either a null or
     * squares composed either of grass or containing a star.
     */
    public Square[][] getSquares() {
        return squares;
    }

    /**
     * Returns the number of rows found in the array.
     *
     * @return row number.
     */
    public int getNbRow() {
        return this.squares.length;
    }

    /**
     * Returns the number of columns found in the array.
     *
     * @param i indicator of which row to measure.
     * @return column number.
     */
    public int getNbColumn(int i) {
        return this.squares[i].length;
    }

    /**
     * Verifies if a specified position is included in a specific array.
     *
     * @param position the location that requires a check.
     * @return true if it is true and false if it is not.
     */
    public boolean isInside(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Entrée invalide : hors tableau.");
        }
        if (position.getRow() > this.getNbRow() - 1 || position.getRow() < 0) {
            return false;
        }
        if (position.getColumn() > this.getNbColumn(position.getRow()) - 1 || position.getColumn() < 0) {
            return false;
        }
        try {
            getSquareType(position).equals(GRASS);
            getSquareType(position).equals(STAR);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return getSquareType(position).equals(GRASS) || getSquareType(position).equals(STAR);
    }

    /**
     * Returns the type of Square present on a certain position.
     *
     * @param position where to check.
     * @return the type of square found on the given position : either GRASS or
     * STAR.
     */
    public SquareType getSquareType(Position position) {
        int row = position.getRow();
        int column = position.getColumn();
        isValidPosition(position);
        return squares[row][column].getSquareType();
    }

    /**
     * Verifies if a certain position is not without a reference type inside.
     *
     * @param position the position to verify.
     * @return nothing if is not null else it throws an
     * IllegalArgumentException.
     */
    private SquareType isValidPosition(Position position) {
        int row = position.getRow();
        int column = position.getColumn();
        try {
            return this.squares[row][column].getSquareType();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Invalid entry : does not have a type.");
        }
    }

    /**
     * Changes the type of square of a position on a board.
     *
     * @param position the position to modify.
     * @param type type of square to set.
     * @throws IllegalArgumentException when the square is of null type.
     */
    public void setSquareType(Position position, SquareType type) throws IllegalArgumentException {
        int row = position.getRow();
        int column = position.getColumn();
        isValidPosition(position);
        this.squares[row][column].setSquareType(type);

    }

    /**
     * Returns the Square on a board tied to a given position.
     *
     * @param position a given position.
     * @return the said Square
     */
    public Square getSquare(Position position) {
        return this.squares[position.getRow()][position.getColumn()];
    }
}
