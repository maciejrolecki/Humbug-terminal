/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humbug.vw.text;

import humbug.mdl.Board;
import humbug.mdl.Direction;
import humbug.mdl.Position;
import humbug.mdl.animals.Animal;

/**
 * Lets the user visualize the state of the level.
 *
 * @author Maciej Rolecki (g54931)
 */
public interface InterfaceView {

    /**
     * Displays the Board given as the parameter with the animals on it if there
     * are any.
     *
     * @param board a given board.
     * @param animals a given set of animals to display on the board.
     */
    public void displayBoard(Board board, Animal... animals);

    /**
     * Displays a given message.
     *
     * @param message a given message.
     */
    public void displayError(String message);

    /**
     * Displays a given message.
     *
     * @param message a given message.
     */
    public void displayMessage(String message);

    /**
     * Gives a template for displaying remaining moves for a game.
     *
     * @param nMoves indicates how many moves are left.
     */
    public void displayRemainingMoves(int nMoves);

    /**
     * Asks the user for a direction. Accepts 4 entries : N, S, E, W. If
     * anything else is entered displays "Entrée incorrecte." and asks for a new
     * direction.
     *
     * @return either NORTH, SOUTH, EAST, or WEST.
     */
    public Direction askDirection();

    /**
     * Asks the user to introduce coordinates of a position that could be
     * present on the board.returns it as a Position object if it is an
     * accessible position on the game board.
     *
     * @return the position corresponding to the given coordinates.
     */
    public Position askPosition();
}
