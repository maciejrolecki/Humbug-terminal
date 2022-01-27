/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humbug.mdl.animals;

import humbug.mdl.Board;
import humbug.mdl.Direction;
import humbug.mdl.Position;
import humbug.mdl.Square;
import static humbug.mdl.SquareType.GRASS;
import static humbug.mdl.SquareType.STAR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author @author Maciej Rolecki (g54931) <54931@etu.he2b.be>
 */
public class LadybirdTest {

    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals = new Animal[]{
            new Ladybird(new Position(0, 0)),
            new Snail(new Position(1, 2)),
            new Ladybird(new Position(1, 1))
        };
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove() {
        System.out.println("move and fall");
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = null; // fall
        Position result = instance.move(board, Direction.NORTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove_endline() {
        System.out.println("move end line and noFall");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove_tootheranimal() {
        System.out.println("move to other animal");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals[1] = new Snail(new Position(0, 2));
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 1);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove_next_notfree() {
        System.out.println("move next case not free");
        Ladybird instance = (Ladybird) animals[0];
        animals[1].setPositionOnBoard(new Position(0, 1));
        Position expResult = new Position(0, 0); //don't move
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove_next_notinside() {
        System.out.println("move next case null and fall");
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = null; // fall
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove_passOnStar() {
        System.out.println("move and pass on star without win");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(STAR), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS), null},
            {null, null, new Square(STAR), null}
        });
        animals = new Animal[]{
            new Ladybird(new Position(0, 0))
        };
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
        assertFalse(animals[0].isOnStar());
        assertTrue(board.getSquareType(new Position(0, 1)) == STAR);
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove_nextOnStar() {
        System.out.println("move, next on star and win");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(STAR), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS), null},
            {null, null, new Square(STAR), null}
        });
        animals = new Animal[]{
            new Ladybird(new Position(0, 0)),
            new Snail(new Position(0, 2))
        };
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 1);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
        assertTrue(animals[0].isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMoveWallNorthOnSameSquare() {
        System.out.println("move to north with wall to the north on same square");
        this.board.getSquare(new Position(0, 0)).setNorthWall(true);
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.NORTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMoveWallSouthOnSameSquare() {
        System.out.println("move to south with wall to the south on same square");
        this.board.getSquare(new Position(0, 0)).setSouthWall(true);
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMoveWallEastOnSameSquare() {
        System.out.println("move east with wall to the east on same square");
        this.board.getSquare(new Position(0, 0)).setEastWall(true);
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMoveWallWestOnSameSquare() {
        System.out.println("move west with wall to the west on same square");
        this.board.getSquare(new Position(0, 0)).setWestWall(true);
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMoveNorthWallOnDifferentSquare() {
        System.out.println("move to north with wall to the north on different square");
        this.board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(STAR)}
        });
        this.board.getSquare(new Position(0, 1)).setSouthWall(true);
        Ladybird instance = (Ladybird) animals[2];
        Position expResult = new Position(1, 1);
        Position result = instance.move(board, Direction.NORTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMoveSouthWallOnDifferentSquareSpider2() {
        System.out.println("move to south with wall to the south on different square");
        this.board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(STAR)}
        });
        this.board.getSquare(new Position(2, 1)).setNorthWall(true);
        Ladybird instance = (Ladybird) animals[2];
        Position expResult = new Position(1, 1);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMoveEastWallOnDifferentSquareSpider2() {
        System.out.println("move east with wall to the east on different square");
        this.board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(STAR)}
        });
        this.board.getSquare(new Position(1, 2)).setWestWall(true);
        Ladybird instance = (Ladybird) animals[2];
        Position expResult = new Position(1, 1);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMoveWestWallOnDifferentSquareSpider2() {
        System.out.println("move west with wall to the west on different square");
        this.board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(STAR)}
        });
        this.board.getSquare(new Position(1, 0)).setEastWall(true);
        Ladybird instance = (Ladybird) animals[2];
        Position expResult = new Position(1, 1);
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

}
