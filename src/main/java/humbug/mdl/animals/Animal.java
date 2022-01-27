/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humbug.mdl.animals;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import humbug.mdl.Board;
import humbug.mdl.Direction;
import humbug.mdl.Position;
import humbug.mdl.SquareType;

/**
 * Defines what are animals and what they can do.
 *
 * @author Maciej Rolecki (g54931)
 */
@JsonTypeInfo(use = Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
    @Type(value = Bumblebee.class),
    @Type(value = Butterfly.class),
    @Type(value = Grasshopper.class),
    @Type(value = Ladybird.class),
    @Type(value = Snail.class),
    @Type(value = Spider.class)
})
public abstract class Animal {

    private Position positionOnBoard;
    private boolean onStar = false;

    /**
     * Default constructor for Animal object.
     */
    protected Animal() {
    }

    /**
     * Creates an object of Animal class.
     *
     * @param positionOnBoard defines where the animal is on the board.
     */
    protected Animal(Position positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }

    /**
     * Moves the animal on a board in a direction.
     *
     * @param board represents the game level.
     * @param direction in which direction the animal has to go.
     * @param animals which animal is to be moved.
     * @return the new position of the animal.
     */
    public abstract Position move(Board board, Direction direction, Animal... animals);

    /**
     * Sets an animals position to positionOnBoard.
     *
     * @param positionOnBoard a new position.
     */
    protected void setPositionOnBoard(Position positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }

    /**
     * Verifies what is the current location of an animal.
     *
     * @return the said location.
     */
    public Position getPositionOnBoard() {
        return positionOnBoard;
    }

    /**
     * Sets the onStar attribute to true.
     */
    protected void setOnStar() {
        this.onStar = true;
    }

    /**
     * Verifies if an animal"s onStar attribute is true.
     *
     * @return true if Animal is on squareType STAR.
     */
    public boolean isOnStar() {
        return this.onStar;
    }

    /**
     * Verifies if the given position is occupied by an Animal.
     *
     * @param position the given position.
     * @param animals all the animals.
     * @return true if position is occupied and false if empty.
     */
    protected boolean nextPositionOccupied(Position position, Animal... animals) {
        for (Animal animal : animals) {
            if (animal.getPositionOnBoard().equals(position) && !animal.isOnStar()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Moves an animal on a board in a direction by crawling. It cannot go over
     * nor under walls. Will be stopped by other animals.
     *
     * @param board representation of the game level.
     * @param direction in which direction the animal has to go.
     * @param animals which animal is to be moved.
     * @return the new position of the animal.
     */
    protected Position moveOnTheGround(Board board, Direction direction, Animal... animals) {
        Position position = this.getPositionOnBoard();
        Position finalPosition = position.next(direction);
        if (board.getSquare(position).hasWall(direction)
                || board.isInside(finalPosition)
                && board.getSquare(finalPosition).hasWall(direction.opposite())) {
            return position;
        } else if (!board.isInside(finalPosition)) {
            this.setPositionOnBoard(null);
            return null;
        } else if (nextPositionOccupied(finalPosition, animals)) {
            return this.getPositionOnBoard();
        } else {
            this.setPositionOnBoard(finalPosition);
            return this.getPositionOnBoard();
        }
    }

    /**
     * Moves an animal on a board in a direction by flying.It can go over walls.
     * returns the new position while landing on it without worrying if the
     * square is occupied or not, or if there even is a square.
     *
     * @param board representation of the game level.
     * @param direction in which direction the animal has to go.
     * @param animals which animal is to be moved.
     * @param times how many positions to move forward.
     * @return the new position of the animal.
     */
    protected Position moveInTheAirXTimes(Board board, Direction direction, int times, Animal... animals) {
        int i = 0;
        while (i < times - 1) {
            Position position = this.getPositionOnBoard();
            this.setPositionOnBoard(position.next(direction));
            i++;
        }
        Position finalPos = this.getPositionOnBoard().next(direction);
        while (true) {
            if (!board.isInside(finalPos)||finalPos==null) {
                this.setPositionOnBoard(null);
                return null;
            }
            if (!nextPositionOccupied(finalPos, animals)) {
                if (board.getSquareType(finalPos) == SquareType.GRASS) {
                    this.setPositionOnBoard(finalPos);
                    return finalPos;
                } else if (board.getSquareType(finalPos) == SquareType.STAR) {
                    this.setPositionOnBoard(finalPos);
                    board.setSquareType(finalPos, SquareType.GRASS);
                    this.setOnStar();
                    return finalPos;
                }
            }
            if (nextPositionOccupied(finalPos, animals)) {
                finalPos = finalPos.next(direction);
            }
        }
    }
}
