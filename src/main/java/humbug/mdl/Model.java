/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humbug.mdl;

import humbug.mdl.animals.Animal;

/**
 * Defines what are the required methods in a game.
 *
 * @author Maciej Rolecki (g54931)
 */
public interface Model {

    /**
     * Returns the board on which the game will take place.
     *
     * @return a board.
     */
    public Board getBoard();

    /**
     * Returns the animals that will be used in the game.
     *
     * @return an array with animals in it.
     */
    public Animal[] getAnimals();
    
     /**
     * Returns the number of moves that the user may still use.
     *
     * @return a board.
     */
    public int getRemainingMoves();

    /**
     * Starts the game on a desired level.
     *
     * @param level defines the level at which the user wants to start the game.
     */
    public void startLevel(int level);

    /**
     * Defines the state of a game.
     *
     * @return the state of the level that is currently being played.
     */
    public LevelStatus getLevelStatus();

    /**
     * Moves the animal in a certain direction if there is one on a given
     * position.
     *
     * @param position the animal's position.
     * @param direction the direction in which it has to move.
     */
    public void move(Position position, Direction direction);

}
