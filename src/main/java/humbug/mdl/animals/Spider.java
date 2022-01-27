/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humbug.mdl.animals;

import humbug.mdl.Board;
import humbug.mdl.Direction;
import humbug.mdl.Position;
import humbug.mdl.SquareType;

/**
 * Defines what a spider is, verifies or sets its position and moves it.
 *
 * @author Maciej Rolecki (g54931)
 */
public class Spider extends Animal {
/**
     * Default constructor for Spider object.
     */
    public Spider() {
    }
    /**
     * Creates an object of class Snail
     *
     * @param positionOnBoard the position of the animal on the board.
     */
    public Spider(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * Moves the spider on a board in a direction.
     *
     * @param board representation of the game level.
     * @param direction in which direction the animal has to go.
     * @param animals which animal is to be moved.
     * @return the new position of the animal.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        while (true) {
            Position posBefore = this.getPositionOnBoard();
            Position posAfter = this.moveOnTheGround(board, direction, animals);
            if (posAfter == null) {
                return posAfter;
            }
            if (posAfter.equals(posBefore)) {
                if (board.getSquareType(posAfter) == SquareType.GRASS) {
                    return posAfter;
                } else if (board.getSquareType(posAfter) == SquareType.STAR) {
                    board.setSquareType(posAfter, SquareType.GRASS);
                    this.setOnStar();
                    return posAfter;
                }
            }
        }
    }
}
