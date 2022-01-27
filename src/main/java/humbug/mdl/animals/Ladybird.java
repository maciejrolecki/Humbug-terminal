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
 *
 * @author @author Maciej Rolecki (g54931) <54931@etu.he2b.be>
 */
public class Ladybird extends Animal {
/**
     * Default constructor for Ladybird object.
     */
    public Ladybird() {
    }
    /**
     * Creates an object of class Ladybird.
     *
     * @param positionOnBoard the position of the animal on the board.
     */
    public Ladybird(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * Moves the ladybird on a board in a direction.
     *
     * @param board representation of the game level.
     * @param direction in which direction the animal has to go.
     * @param animals which animal is to be moved.
     * @return the new position of the animal.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        int i = 0;
        int lim = 2;
        Position posBefore;
        Position posAfter=null;
        while (i < lim) {
            posBefore = this.getPositionOnBoard();
            posAfter = this.moveOnTheGround(board, direction, animals);
            if (posAfter == null) {
                return posAfter;
            }
            if (posAfter.equals(posBefore)||i == lim - 1) {
                if (board.getSquareType(posAfter) == SquareType.GRASS) {
                    return posAfter;
                } else if (board.getSquareType(posAfter) == SquareType.STAR) {
                    board.setSquareType(posAfter, SquareType.GRASS);
                    this.setOnStar();
                    return posAfter;
                }
            }
            i++;
        }
        return posAfter;
    }
}
