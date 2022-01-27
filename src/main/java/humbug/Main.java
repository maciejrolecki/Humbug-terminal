/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humbug;

import humbug.ctrl.Controller;
import humbug.mdl.Game;
import humbug.vw.text.View;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * Lets the player play the game.
 *
 * @author Maciej Rolecki (g54931)
 */
public class Main {

    /**
     * Main method : starts the game.
     *
     * @param args the command line arguments.
     * @throws UnsupportedEncodingException indicates that the main method may
     * throw an exception regarding the encoding type.
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF8")); 
        Controller controller = new Controller(new Game(), new View());
        controller.startGame(1);
    }
}
