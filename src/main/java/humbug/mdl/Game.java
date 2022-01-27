
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humbug.mdl;

import humbug.mdl.animals.Animal;
import static humbug.mdl.LevelStatus.*;

/**
 * Defines what can happen to a Game object.
 *
 * @author Maciej Rolecki (g54931)
 */
public class Game implements Model {

    private Board board;
    private Animal[] animals;
    private int remainingMoves;
    private int currentLevel;

    /**
     * Returns the board on which the game will take place.
     *
     * @return a board.
     */
    @Override
    public Board getBoard() {
        return this.board;
    }

    /**
     * Returns the animals that will be used in the game.
     *
     * @return an array with animals in it.
     */
    @Override
    public Animal[] getAnimals() {
        return this.animals;
    }

    @Override
    public int getRemainingMoves() {
        return this.remainingMoves;
    }

    /**
     * Starts the game on a desired level.
     *
     * @param levelNumber defines the level at which the user wants to start the
     * game.
     */
    @Override
    public void startLevel(int levelNumber) {
        Level level = Level.getLevel(levelNumber);
        board = level.getBoard();
        animals = level.getAnimals();
        remainingMoves = level.getnMoves();
        currentLevel = levelNumber;
    }

    /**
     * Defines the current state of a game.
     *
     * @return true if the game is finished correctly or by error false if it is
     * not finished.
     */
    @Override
    public LevelStatus getLevelStatus() {
        int i = animals.length;
        if (this.animals == null || this.board == null) {
            return NOT_STARTED;
        }
        for (Animal animal : this.animals) {
            if (animal.getPositionOnBoard() == null) {
                return FAIL;
            }
            if (!animal.isOnStar() && remainingMoves < 0) {
                return FAIL;
            }
            if (animal.isOnStar()) {
                i--;
            }
            if (remainingMoves < 0) {
                return FAIL;
            }
        }
        if (remainingMoves == 0 && i > 0) {
            return FAIL;
        }
        if (i == 0 && remainingMoves == 0) {
            return WIN;
        }
        return IN_PROGRESS;
    }

    /**
     * Moves the animal in a certain direction if there is one on a given
     * position.
     *
     * @param position the animal's position.
     * @param direction the direction in which it has to move.
     */
    @Override
    public void move(Position position, Direction direction) throws IllegalStateException {
        if (this.getLevelStatus().equals(NOT_STARTED)) {
            throw new IllegalStateException();
        }
        if (board.isInside(position)) {
            for (Animal animal : animals) {
                if (animal.getPositionOnBoard().equals(position) && !animal.isOnStar()) {
                    animal.move(board, direction, animals);
                    if (animal.getPositionOnBoard() == null) {
                        break;
                    }
                    if (!animal.getPositionOnBoard().equals(position)) {
                        this.remainingMoves--;
                    }
                }
            }
        }
    }
}
