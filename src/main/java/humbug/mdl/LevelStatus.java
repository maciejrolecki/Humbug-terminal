/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humbug.mdl;

/**
 * LevelStatus represents the state of the game. Can either be: /NOT_STARTED
 * which as the name indicates, it has not started yet /IN_PROGRESS which means
 * the game has started /FAIL means that the user failed to win /WIN means that
 * he finished correctly the level.
 *
 * @author @author Maciej Rolecki (g54931) <54931@etu.he2b.be>
 */
public enum LevelStatus {
    NOT_STARTED,
    IN_PROGRESS,
    FAIL,
    WIN;
}
