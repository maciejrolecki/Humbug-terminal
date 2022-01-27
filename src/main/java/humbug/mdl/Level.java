/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humbug.mdl;

import com.fasterxml.jackson.databind.ObjectMapper;
import humbug.mdl.animals.Animal;
import java.io.IOException;

/**
 * Determines the levels that a user can play.
 *
 * @author @author Maciej Rolecki (g54931) <54931@etu.he2b.be>
 */
public class Level {
    private static Level readLevel(int levelIndicator) {
        try {
            var objectMapper = new ObjectMapper();
            var inputStream = Level.class.getResourceAsStream(
                    "/data/level-" + levelIndicator + ".json");
            var level = objectMapper.readValue(inputStream, Level.class);
            return level;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    /**
     * Gets all the information needed to start the game about a level.
     *
     * @param levelNumber Which level to start.
     * @return The level that was asked for.
     */
    public static Level getLevel(int levelNumber) {
        Level level = readLevel(levelNumber);
        return level;
    }

    private Board board;
    private int nMoves;
    private Animal[] animals;


    /**
     * Default constructor for Level object.
     */
    public Level() {
    }

    ;
    /**
     * A basic constructor for a Level object.
     *
     * @param board The board on which the game will be played.
     * @param nMoves How many moves the user has to do to win "properly".
     * @param animals Which animals are there on the board and where.
     */
    public Level(Board board, int nMoves, Animal... animals) {
        this.board = board;
        this.nMoves = nMoves;
        this.animals = animals;
    }

    /**
     * A simple getter for Board objects.
     *
     * @return a given playboard.
     */
    public Board getBoard() {
        return this.board;
    }

    /**
     * A simple getter for an Animal array.
     *
     * @return an array of animals.
     */
    public Animal[] getAnimals() {
        return this.animals;
    }

    /**
     * A simple getter for an integer indicating how many moves have to be made
     * for a proper WIN.
     *
     * @return an integer.
     */
    public int getnMoves() {
        return this.nMoves;
    }
}
