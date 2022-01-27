/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humbug.vw.text;

import humbug.mdl.animals.Ladybird;
import humbug.mdl.animals.Grasshopper;
import humbug.mdl.animals.Spider;
import humbug.mdl.animals.Butterfly;
import humbug.mdl.animals.Animal;
import humbug.mdl.animals.Snail;
import humbug.mdl.animals.Bumblebee;
import humbug.mdl.Square;
import humbug.mdl.Position;
import humbug.mdl.Board;
import humbug.mdl.Direction;
import static humbug.mdl.Direction.*;
import java.util.Scanner;

/**
 * Lets the user visualize the state of the level.
 *
 * @author Maciej Rolecki (g54931)
 */
public class View implements InterfaceView {

    //Color Codes and different walls.
    String defaultColor = "\u001b[0m";
    String greenBackground = defaultColor + "\u001b[42m";
    String redBoldCharacter = "\u001b[31;1m";
    String pieceOfGrass = greenBackground + " " + defaultColor;
    String lineOfGrass = pieceOfGrass + pieceOfGrass + pieceOfGrass;
    String starColored = greenBackground + redBoldCharacter + " *" + greenBackground + " " + defaultColor;
    String emptySpace = defaultColor + "   ";
    String horizontalSquareLimit = greenBackground + "---" + defaultColor;
    String verticalSquareLimit = greenBackground + "|" + defaultColor;
    String horizontalWall = greenBackground + redBoldCharacter + "===" + defaultColor;
    String verticalWall = greenBackground + redBoldCharacter + "|" + defaultColor;

    /**
     * Displays the Board given as the parameter with the animals on it if there
     * are any.
     *
     * @param board a given board.
     * @param animals a given set of animals to display on the board.
     */
    @Override
    public void displayBoard(Board board, Animal... animals) {
        String[][] table = boardAsString(board, animals);
        for (String[] table1 : table) {
            for (String item : table1) {
                System.out.print(item);
            }
            System.out.println("");
        }
    }

    /**
     * Returns a given array as an array of Strings.
     *
     * @param board a given array.
     * @return an array of Strings.
     */
    private String[][] boardAsString(Board board, Animal... animals) {

        // creation of the String array.
        int maxCol = board.getNbColumn(0);
        String[][] table = new String[4 * board.getNbRow() + 2][maxCol * 2 + 4];
        table[0][0] = " ";

        for (String[] table1 : table) {
            for (int j = 0; j < table1.length; j++) {
                table1[j] = " ";
            }
        }

        // Putting in place row and column indicators
        for (int i = 0; i < board.getNbRow(); i++) {
            table[3 + i * 4][0] = String.valueOf(i) + " ";
            table[0][0]
                    = table[i * 4 + 1][0]
                    = table[i * 4 + 2][0]
                    = table[i * 4 + 4][0]
                    = table[i * 4 + 5][0]
                    = "  ";
        }
        for (int i = 1; i < maxCol * 2 + 1; i = i + 2) {
            table[0][i + 1] = " " + String.valueOf((i - 1) / 2) + " ";
            table[0][i] = table[0][i + 2] = " ";
        }

        // Filling the squares
        for (int i = 1, line = 0; i < (6 + 4 * (board.getNbRow() - 2)); i = i + 4, line++) {
            for (int j = 2, col = 0; j < maxCol * 2 + 1; j = j + 2, col++) {
                Position position = new Position(line, col);
                Square positionToSquare = board.getSquare(position);
                if (line == 0) {
                    if (board.isInside(position)) {
                        if (positionToSquare.hasWall(Direction.NORTH)) {
                            table[i][j] = horizontalWall;
                        } else {
                            table[i][j] = horizontalSquareLimit;
                        }
                        table[i][j + 1] = table[i][j - 1] = pieceOfGrass;
                    } else {
                        table[i][j] = emptySpace;
                        table[i][j + 1] = " ";
                    }
                }
                if (col == 0) {
                    if (board.isInside(position)) {
                        if (positionToSquare.hasWall(Direction.WEST)) {
                            table[i + 1][j - 1] = table[i + 2][1] = table[i + 3][1] = verticalWall;
                        } else {
                            table[i + 1][j - 1] = table[i + 2][1] = table[i + 3][1] = verticalSquareLimit;
                        }
                        table[i + 4][j - 1] = pieceOfGrass;
                    } else {
                        table[i + 1][j - 1] = table[i + 2][1] = table[i + 3][1] = table[i + 4][j - 1] = " ";
                    }
                }
                for (int k = 1; k <= 4; k++) {
                    table[i + k][j] = emptySpace;
                }
                if (board.isInside(position)) {
                    table[i + 1][j] = table[i + 3][j] = lineOfGrass;
                    switch (board.getSquareType(position)) {
                        case GRASS:
                            table[i + 2][j] = greenBackground + animalPresent(position, animals)
                                    + defaultColor;
                            break;
                        case STAR:
                            table[i + 2][j] = starColored;
                            break;
                    }
                }
                table[i + 1][j + 1] = table[i + 2][j + 1] = table[i + 3][j + 1] = table[i + 4][j + 1] = " ";
                if (board.isInside(position) || board.isInside(new Position(line, col + 1))) {
                    table[i + 1][j + 1] = table[i + 2][j + 1] = table[i + 3][j + 1] = verticalSquareLimit;
                }
                if (board.isInside(position)
                        && positionToSquare.hasWall(Direction.EAST)
                        || board.isInside(new Position(line, col + 1))
                        && board.getSquare(new Position(line, col + 1)).hasWall(Direction.EAST.opposite())) {
                    table[i + 1][j + 1] = table[i + 2][j + 1] = table[i + 3][j + 1] = verticalWall;
                }

                if (board.isInside(position) || board.isInside(new Position(line + 1, col))) {
                    table[i + 4][j] = horizontalSquareLimit;
                    table[i + 4][j - 1] = table[i + 4][j + 1] = pieceOfGrass;
                }
                if (board.isInside(position)
                        && positionToSquare.hasWall(Direction.SOUTH)
                        || board.isInside(new Position(line + 1, col))
                        && board.getSquare(new Position(line + 1, col)).hasWall(Direction.SOUTH.opposite())) {
                    table[i + 4][j] = horizontalWall;
                }

                if (!board.isInside(position) && (board.isInside(new Position(line + 1, col)) || board.isInside(new Position(line, col + 1)))) {
                    table[i + 4][j + 1] = pieceOfGrass;
                }
            }
        }
        animalSpeciesDisplay(table);
        //System.out.println(board.getSquareType(new Position(1, 0)));
        return table;
    }

    /**
     * Displays a given message.
     *
     * @param message a given message.
     */
    @Override
    public void displayError(String message) {
        System.out.println(message);
    }

    /**
     * Displays a given message.
     *
     * @param message a given message.
     */
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Asks the user for a number. if the entry is not a number, displays "La
     * valeur entrée n’est pas un entier.".
     *
     * @return the given number.
     */
    private int askNumber() {
        Scanner keyboard = new Scanner(System.in);
        while (!keyboard.hasNextInt()) { //si l’entrée saisie n’est pas un entier
            displayMessage("\u001b[31mThe input is not an integer\u001b[0m");
            keyboard.next(); // on n’en fait rien, on attend une nouvelle entrée
        }
        return keyboard.nextInt();
    }

    /**
     * Asks the user for a direction. Accepts 4 entries : N, S, E, W. If
     * anything else is entered displays "Entrée incorrecte." and asks for a new
     * direction.
     *
     * @return either NORTH, SOUTH, EAST, or WEST.
     */
    @Override
    public Direction askDirection() {
        Scanner keyboard = new Scanner(System.in);
        String dir = null;
        while (dir == null) {
            displayMessage("Please choose in which direction to move the animal:"
                    + "(N, S, E, W).");
            dir = keyboard.nextLine();
            switch (dir.toUpperCase()) {
                case "N":
                    return NORTH;
                case "S":
                    return SOUTH;
                case "E":
                    return EAST;
                case "W":
                    return WEST;
                default:
                    dir = null;
                    displayMessage("Invalid entry.");
            }
        }
        return null;
    }

    /**
     * Verifies if an animal is present on a given position and returns a letter
     * corresponding to the animal. Returns an empty space : " ".
     *
     * @param position a given position to verify.
     * @param animals list of animals to verify.
     * @return a letter corresponding to the animal on the given position, E in
     * case of a snail, A in case of a spider, if none returns a empty space "
     * ".
     */
    private String animalPresent(Position position, Animal... animals) {
        for (Animal animal : animals) {
            if (animal.getPositionOnBoard().equals(position) && !animal.isOnStar()) {
                if (animal instanceof Spider) {
                    return " A ";
                }
                if (animal instanceof Bumblebee) {
                    return " B ";
                }
                if (animal instanceof Ladybird) {
                    return " C ";
                }
                if (animal instanceof Snail) {
                    return " E ";
                }
                if (animal instanceof Butterfly) {
                    return " P ";
                }
                if (animal instanceof Grasshopper) {
                    return " S ";
                }
            }
        }
        return "   ";
    }

    /**
     * Display a list of animals that can appear on the board.
     *
     * @param table in which the possible animals will be displayed.
     */
    private void animalSpeciesDisplay(String[][] table) {
        table[0][table[0].length - 1] = "\u001b[43;30mPossible animals \u001b[0m";
        table[2][table[0].length - 1] = "A for Spider";
        table[3][table[0].length - 1] = "B for Bumblebee";
        table[4][table[0].length - 1] = "C for Ladybird";
        table[5][table[0].length - 1] = "E for Snail";
        table[6][table[0].length - 1] = "P for Butterfly";
        table[7][table[0].length - 1] = "S for Grasshopper";
    }

    /**
     * Gives a template for displaying remaining moves for a game.
     *
     * @param nMoves indicates how many moves are left.
     */
    @Override
    public void displayRemainingMoves(int nMoves) {
        System.out.println("You have " + nMoves + " remaining moves.");
    }

    /**
     * Asks the user to introduce coordinates of a position that could be
     * present on the board.returns it as a Position type object.
     *
     * @return the position corresponding to the given coordinates.
     */
    @Override
    public Position askPosition() {
        int row, column;
        displayMessage("Enter row number : ");
        row = askNumber();

        displayMessage("Enter column number : ");
        column = askNumber();
        return new Position(row, column);
    }
}
