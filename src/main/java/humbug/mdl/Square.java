/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humbug.mdl;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Square represents a cell on a board. it has a type GRASS or STAR. A square
 * doesn’t know where it is on the board.
 *
 * @author Maciej Rolecki (g54931)
 */
public class Square {

    private SquareType type;
    private boolean northWall;
    private boolean southWall;
    private boolean eastWall;
    private boolean westWall;

    /**
     * Default constructor for Square object.
     */
    public Square() {
    }

    public Square(SquareType squareType) {
        this.type = squareType;
    }

    /**
     * Simple getter of Square type.
     *
     * @return type of Square.
     */
    @JsonProperty("type")
    public SquareType getSquareType() {
        return type;
    }

    /**
     * Simple setter of Square type. Either GRASS, STAR or null.
     *
     * @param type GRASS or STAR.
     */
    public void setSquareType(SquareType type) {
        this.type = type;
    }

    /**
     * Sets the parameter to a true or false value depending on the users input.
     * True stating that the is a wall present. False if there is none. Concerns
     * the northern wall parameter on a Square object.
     *
     * @param northWall either true or false.
     */
    public void setNorthWall(boolean northWall) {
        this.northWall = northWall;
    }

    /**
     * Sets the parameter to a true or false value depending on the users input.
     * True stating that the is a wall present. False if there is none. Concerns
     * the southern wall parameter on a Square object.
     *
     * @param southWall either true or false.
     */
    public void setSouthWall(boolean southWall) {
        this.southWall = southWall;
    }

    /**
     * Sets the parameter to a true or false value depending on the users input.
     * True stating that the is a wall present. False if there is none. Concerns
     * the eastern wall parameter on a Square object.
     *
     * @param eastWall either true or false.
     */
    public void setEastWall(boolean eastWall) {
        this.eastWall = eastWall;
    }

    /**
     * Sets the parameter to a true or false value depending on the users input.
     * True stating that the is a wall present. False if there is none. Concerns
     * the western wall parameter on a Square object.
     *
     * @param westWall either true or false.
     */
    public void setWestWall(boolean westWall) {
        this.westWall = westWall;
    }

    /**
     * Verifies if there is a wall in a certain direction on a Square. Returns
     * true there is one, false otherwise.
     *
     * @param direction the given direction to verify.
     * @return either true if there is one, false if none.
     */
    public boolean hasWall(Direction direction) {
        switch (direction) {
            case NORTH:
                return this.northWall;
            case SOUTH:
                return this.southWall;
            case EAST:
                return this.eastWall;
            case WEST:
                return this.westWall;
            default:
                throw new IllegalArgumentException("Invalid entry for direction");
        }
    }
}
