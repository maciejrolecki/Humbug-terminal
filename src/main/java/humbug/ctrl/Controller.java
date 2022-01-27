/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humbug.ctrl;

import static humbug.mdl.LevelStatus.*;
import humbug.mdl.Model;
import humbug.mdl.Position;
import humbug.mdl.animals.Animal;
import humbug.vw.text.InterfaceView;

/**
 * Controls the mechanisms of the game and how it proceeds.
 *
 * @author Maciej Rolecki (g54931)
 */
public class Controller {

    private final Model game;
    private final InterfaceView view;

    /**
     * Lets the player see the visual display of the game.
     *
     * @param game decides which game to play.
     * @param view decides how to visualize it.
     */
    public Controller(Model game, InterfaceView view) {
        this.game = game;
        this.view = view;
    }

    /**
     * Starts the game.Starts the game at the first level. Displays it and asks
     * the user which animal he would like to move by its position and then in
     * which direction. the game can end if the user puts all the animals on
     * stars or if an animal falls from the board. If the user enters an invalid
     * position when asked, it will display "Invalid entry. TRY AGAIN." and ask
     * for a new entry.
     *
     * @param nLevel Indicates at which level to start the game.
     */
    public void startGame(int nLevel) {
        String change = "\u001b[31m = = = = = = = = = = = = = = = = = = = = \u001b[0m";
        int lastLevel = 100;
        int currentLevel = nLevel;
        view.displayMessage("\u001b[31mWelcome to HUMBUG");
        view.displayMessage(change);
        view.displayMessage("\u001b[31mYou will start playing level " + currentLevel + " now.");
        view.displayMessage("\u001b[31mIn order to win a game, all the animals have to arrive");
        view.displayMessage("\u001b[31mon a STAR which is represented by '*'.You have a");
        view.displayMessage("\u001b[31mlimited number of moves in order to win a game and if");
        view.displayMessage("\u001b[31mone of the animals falls, you will restart the level.\u001b[0m");
        while (currentLevel < lastLevel + 1) {
            game.startLevel(currentLevel);
            while (game.getLevelStatus().equals(IN_PROGRESS)) {
                view.displayMessage(change);
                view.displayBoard(game.getBoard(), game.getAnimals());
                view.displayRemainingMoves(game.getRemainingMoves());
                if (game.getRemainingMoves() != 0) {
                    int i = 0;
                    Position k = null;
                    while (i == 0) {
                        k = view.askPosition();
                        if (game.getBoard().isInside(k)) {
                            for (Animal animal : game.getAnimals()) {
                                if (animal.getPositionOnBoard().equals(k) && !animal.isOnStar()) {
                                    i = 1;
                                }
                            }
                            if (i == 0) {
                                view.displayMessage("No animals on this position.");
                            }
                        } else {
                            view.displayMessage("Given position is not found on the gameboard.");
                        }
                    }
                    game.move(k, view.askDirection());
                }
                if (game.getLevelStatus().equals(FAIL)) {
                    for (Animal animal : game.getAnimals()) {
                        if (animal.getPositionOnBoard() == null) {
                            view.displayMessage(change);
                            view.displayMessage("\u001b[31mOne of the animals fell from the plateau.\u001b[0m");
                            view.displayMessage("\u001b[31mYou will restart the level.\u001b[0m");
                        }
                    }
                    if (game.getRemainingMoves() <= 0) {
                        view.displayMessage(change);
                        view.displayMessage("\u001b[31mYou used all your available moves.\u001b[0m");
                        view.displayMessage("\u001b[31mYou will restart the level.\u001b[0m");
                    }
                    break;
                }
                if (game.getLevelStatus().equals(WIN)) {
                    view.displayBoard(game.getBoard(), game.getAnimals());
                    currentLevel++;
                    if (currentLevel - 1 != lastLevel) {
                        view.displayMessage(change);
                        view.displayMessage("You will start playing level " + currentLevel + " now.");
                    }
                }
            }
            if (currentLevel - 1 == lastLevel && game.getLevelStatus().equals(WIN)) {
                view.displayMessage("\u001b[32mYou finished the game\u001b[0m");
                view.displayMessage("\u001b[32mMy Congratulations\u001b[0m");
                break;
            }
        }
    }
}
