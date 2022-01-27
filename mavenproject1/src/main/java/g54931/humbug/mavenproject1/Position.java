/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54931.humbug.mavenproject1;

/**
 *
 * @author @author Maciej Rolecki (g54931) <54931@etu.he2b.be>
 */
public class Position {

    private int row;
    private int column;

    /**
     * Default constructor for Position object.
     */
    public Position() {
    }

    /**
     * Constructor of position defined by row and column.
     *
     * @param row horizontal position.
     * @param column vertical position.
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Get the value of row.
     *
     * @return the value of row.
     */
    public int getRow() {
        return row;
    }

    /**
     * Get the value of column.
     *
     * @return the value of column.
     */
    public int getColumn() {
        return column;
    }
}
