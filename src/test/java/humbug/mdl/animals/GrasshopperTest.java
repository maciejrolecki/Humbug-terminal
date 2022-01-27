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
public class GrasshopperTest {

    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)}
        });
        animals = new Animal[]{
            new Grasshopper(new Position(1, 1)),
            new Grasshopper(new Position(1, 0)),
            new Snail(new Position(0, 0)),
            new Snail(new Position(2, 2))
        };
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_noAnimalNorth_noFall() {
        System.out.println("move North and no fall");
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = new Position(0, 1);
        Position result = instance.move(board, Direction.NORTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_noAnimalSouth_noFall() {
        System.out.println("move South and no fall");
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = new Position(2, 1);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_noAnimalEast_noFall() {
        System.out.println("move East and no fall");
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = new Position(1, 2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_noAnimalWest_noFall() {
        System.out.println("move West and no fall");
        Grasshopper instance = (Grasshopper) animals[0];
        Grasshopper inTheWay = (Grasshopper) animals[1];
        inTheWay.setPositionOnBoard(new Position(2, 0));
        Position expResult = new Position(1, 0);
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_noAnimalNorth_fall() {
        System.out.println("move North and fall");
        Grasshopper instance = (Grasshopper) animals[1];
        instance.setPositionOnBoard(new Position(0, 1));
        Position expResult = null;
        Position result = instance.move(board, Direction.NORTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_noAnimalSouth_fall() {
        System.out.println("move South and fall");
        Grasshopper instance = (Grasshopper) animals[1];
        instance.setPositionOnBoard(new Position(2, 1));
        Position expResult = null;
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_noAnimalEast_fall() {
        System.out.println("move East and fall");
        Grasshopper instance = (Grasshopper) animals[1];
        instance.setPositionOnBoard(new Position(1, 2));
        Position expResult = null;
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_noAnimalWest_fall() {
        System.out.println("move West and fall");
        Grasshopper instance = (Grasshopper) animals[1];
        Position expResult = null;
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_animalNorth_fall() {
        System.out.println("move animal in front North and fall");
        Grasshopper instance = (Grasshopper) animals[1];
        Position expResult = null;
        Position result = instance.move(board, Direction.NORTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_animalSouth_fall() {
        System.out.println("move animal in front South and fall");
        Grasshopper instance = (Grasshopper) animals[1];
        instance.setPositionOnBoard(new Position(1, 2));
        Position expResult = null;
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_animalEast_fall() {
        System.out.println("move animal in front East and fall");
        Grasshopper instance = (Grasshopper) animals[1];
        instance.setPositionOnBoard(new Position(2, 1));
        Position expResult = null;
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_animalWest_fall() {
        System.out.println("move animal in front West and fall");
        Grasshopper instance = (Grasshopper) animals[1];
        instance.setPositionOnBoard(new Position(0, 1));
        Position expResult = null;
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_animalNorth_noFall() {
        System.out.println("move animal in front North and no fall");
        Grasshopper instance = (Grasshopper) animals[1];
        instance.setPositionOnBoard(new Position(2, 1));
        Position expResult = new Position(0, 1);
        Position result = instance.move(board, Direction.NORTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_animalSouth_noFall() {
        System.out.println("move animal in front South and no fall");
        Grasshopper instance = (Grasshopper) animals[1];
        instance.setPositionOnBoard(new Position(0, 1));
        Position expResult = new Position(2, 1);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_animalEast_noFall() {
        System.out.println("move animal in front East and no fall");
        Grasshopper instance = (Grasshopper) animals[1];
        Position expResult = new Position(1, 2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_animalWest_noFall() {
        System.out.println("move animal in front West and no fall");
        Grasshopper instance = (Grasshopper) animals[1];
        instance.setPositionOnBoard(new Position(1, 2));
        Position expResult = new Position(1, 0);
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_passOnUsedStar() {
        System.out.println("move and pass on star without win");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(STAR), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS), null},
            {null, null, new Square(STAR), null}
        });
        animals = new Animal[]{
            new Grasshopper(new Position(0, 0)),
            new Grasshopper(new Position(0, 2))
        };
        Grasshopper instance = (Grasshopper) animals[0];
        Grasshopper instance2 = (Grasshopper) animals[1];
        instance.move(board, Direction.EAST, animals);
        Position expResult = new Position(0, 1);
        Position result = instance2.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
        assertTrue(animals[0].isOnStar());
        assertFalse(animals[1].isOnStar());
        assertTrue(board.getSquareType(new Position(0, 1)) == GRASS);
    }

    /**
     * Test of move method, of class Grasshopper.
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
            new Grasshopper(new Position(0, 0))
        };
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = new Position(0, 1);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
        assertTrue(animals[0].isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMoveWallNorthOnSameSquare() {
        System.out.println("move to north with wall to the north on same square");
        this.board.getSquare(new Position(1, 1)).setNorthWall(true);
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = new Position(0, 1);
        Position result = instance.move(board, Direction.NORTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMoveWallSouthOnSameSquare() {
        System.out.println("move to south with wall to the south on same square");
        this.board.getSquare(new Position(1, 1)).setSouthWall(true);
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = new Position(2, 1);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMoveWallEastOnSameSquare() {
        System.out.println("move east with wall to the east on same square");
        this.board.getSquare(new Position(1, 1)).setEastWall(true);
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = new Position(1, 2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMoveWallWestOnSameSquare() {
        System.out.println("move west with wall to the west on same square");
        this.board.getSquare(new Position(1, 1)).setWestWall(true);
        Grasshopper instance = (Grasshopper) animals[0];
        Grasshopper inTheWay = (Grasshopper) animals[1];
        inTheWay.setPositionOnBoard(new Position(2, 0));
        Position expResult = new Position(1, 0);
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMoveNorthWallOnDifferentSquare() {
        System.out.println("move to north with wall to the north on different square");
        this.board.getSquare(new Position(0, 1)).setSouthWall(true);
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = new Position(0, 1);
        Position result = instance.move(board, Direction.NORTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMoveSouthWallOnDifferentSquare() {
        System.out.println("move to south with wall to the south on different square");
        this.board.getSquare(new Position(2, 1)).setNorthWall(true);
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = new Position(2, 1);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMoveEastWallOnDifferentSquare() {
        System.out.println("move east with wall to the east on different square");
        this.board.getSquare(new Position(1, 2)).setWestWall(true);
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = new Position(1, 2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMoveWestWallOnDifferentSquare() {
        System.out.println("move west with wall to the west on different square");
        this.board.getSquare(new Position(1, 0)).setEastWall(true);
        Grasshopper instance = (Grasshopper) animals[0];
        Grasshopper inTheWay = (Grasshopper) animals[1];
        inTheWay.setPositionOnBoard(new Position(1, 2));
        Position expResult = new Position(1, 0);
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

}
