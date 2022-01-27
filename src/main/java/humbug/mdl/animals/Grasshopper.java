/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humbug.mdl.animals;

import humbug.mdl.Board;
import humbug.mdl.Direction;
import humbug.mdl.Position;

/**
 *
 * @author @author Maciej Rolecki (g54931) <54931@etu.he2b.be>
 */
public class Grasshopper extends Animal {

    /**
     * Default constructor for Grasshopper object.
     */
    public Grasshopper() {
    }

    /**
     * Creates an object of class Grasshopper.
     *
     * @param positionOnBoard the position of the animal on the board.
     */
    public Grasshopper(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * Moves the grasshopper on a board in a direction.
     *
     * @param board representation of the game level.
     * @param direction in which direction the animal has to go.
     * @param animals which animal is to be moved.
     * @return the new position of the animal.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        return this.moveInTheAirXTimes(board, direction, 1, animals);
    }
}
