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
public class ButterflyTest {

    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(STAR), new Square(GRASS)},
            {new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(GRASS)}
        });
        animals = new Animal[]{
            new Butterfly(new Position(0, 0)),
            new Butterfly(new Position(4, 4)),
            new Snail(new Position(2, 0)),
            new Snail(new Position(2, 2))
        };
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveNorth_AnimalOnFinalPosition_noFall() {
        System.out.println("move North, animal on final position, and no fall");
        Butterfly instance = (Butterfly) animals[1];
        Snail onFinalPos = (Snail) animals[2];
        onFinalPos.setPositionOnBoard(new Position(1, 4));
        Position expResult = new Position(0, 4);
        Position result = instance.move(board, Direction.NORTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveSouth_AnimalOnFinalPosition_noFall() {
        System.out.println("move South, animal on final position, and no fall");
        Butterfly instance = (Butterfly) animals[0];
        Snail onFinalPos = (Snail) animals[2];
        onFinalPos.setPositionOnBoard(new Position(3, 0));
        Position expResult = new Position(4, 0);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveEast_AnimalOnFinalPosition_noFall() {
        System.out.println("move East, animal on final position, and no fall");
        Butterfly instance = (Butterfly) animals[0];
        Snail onFinalPos = (Snail) animals[2];
        onFinalPos.setPositionOnBoard(new Position(0, 3));
        Position expResult = new Position(0, 4);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveWest_AnimalOnFinalPosition_noFall() {
        System.out.println("move West, animal on final position, and no fall");
        Butterfly instance = (Butterfly) animals[1];
        Snail onFinalPos = (Snail) animals[2];
        onFinalPos.setPositionOnBoard(new Position(4, 1));
        Position expResult = new Position(4, 0);
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveNorth_noAnimalOnFinalPosition_noFall() {
        System.out.println("move North, no animal on final position, and no fall");
        Butterfly instance = (Butterfly) animals[1];
        Position expResult = new Position(1, 4);
        Position result = instance.move(board, Direction.NORTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveSouth_noAnimalOnFinalPosition_noFall() {
        System.out.println("move South, no animal on final position, and no fall");
        Butterfly instance = (Butterfly) animals[0];
        Position expResult = new Position(3, 0);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveEast_noAnimalOnFinalPosition_noFall() {
        System.out.println("move East, no animal on final position, and no fall");
        Butterfly instance = (Butterfly) animals[0];
        Position expResult = new Position(0, 3);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveWest_noAnimalOnFinalPosition_noFall() {
        System.out.println("move West, no animal on final position, and no fall");
        Butterfly instance = (Butterfly) animals[1];
        Position expResult = new Position(4, 1);
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveNorth_animalOnFinalPosition_Fall() {
        System.out.println("move North, animal on final position, and fall");
        Butterfly instance = (Butterfly) animals[1];
        Snail onFinalPos = (Snail) animals[2];
        instance.setPositionOnBoard(new Position(3, 4));
        onFinalPos.setPositionOnBoard(new Position(0, 4));
        Position expResult = null;
        Position result = instance.move(board, Direction.NORTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveSouth_animalOnFinalPosition_Fall() {
        System.out.println("move South, animal on final position, and fall");
        Butterfly instance = (Butterfly) animals[0];
        Snail onFinalPos = (Snail) animals[2];
        instance.setPositionOnBoard(new Position(1, 0));
        onFinalPos.setPositionOnBoard(new Position(4, 0));
        Position expResult = null;
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveEast_animalOnFinalPosition_Fall() {
        System.out.println("move East, animal on final position, and fall");
        Butterfly instance = (Butterfly) animals[0];
        Snail onFinalPos = (Snail) animals[2];
        instance.setPositionOnBoard(new Position(0, 1));
        onFinalPos.setPositionOnBoard(new Position(0, 4));
        Position expResult = null;
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveWest_animalOnFinalPosition_Fall() {
        System.out.println("move West, animal on final position, and fall");
        Butterfly instance = (Butterfly) animals[1];
        Snail onFinalPos = (Snail) animals[2];
        instance.setPositionOnBoard(new Position(4, 3));
        onFinalPos.setPositionOnBoard(new Position(4, 0));
        Position expResult = null;
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveNorth_noAnimalOnFinalPosition_Fall() {
        System.out.println("move North, no animal on final position, and fall");
        Butterfly instance = (Butterfly) animals[0];
        Position expResult = null;
        Position result = instance.move(board, Direction.NORTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveSouth_noAnimalOnFinalPosition_Fall() {
        System.out.println("move South, no animal on final position, and fall");
        Butterfly instance = (Butterfly) animals[1];
        Position expResult = null;
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveEast_noAnimalOnFinalPosition_Fall() {
        System.out.println("move East, no animal on final position, and fall");
        Butterfly instance = (Butterfly) animals[1];
        Position expResult = null;
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveWest_noAnimalOnFinalPosition_Fall() {
        System.out.println("move West, no animal on final position, and fall");
        Butterfly instance = (Butterfly) animals[0];
        Position expResult = null;
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveNorthWithWallOnSquare_noAnimalOnFinalPosition_noFall() {
        System.out.println("move North with  wall on same square, no animal on final position, and no fall");
        Butterfly instance = (Butterfly) animals[1];
        this.board.getSquare(instance.getPositionOnBoard()).setNorthWall(true);
        Position expResult = new Position(1, 4);
        Position result = instance.move(board, Direction.NORTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveSouthWithWallOnSquare_noAnimalOnFinalPosition_noFall() {
        System.out.println("move South with  wall on same square, no animal on final position, and no fall");
        Butterfly instance = (Butterfly) animals[0];
        this.board.getSquare(instance.getPositionOnBoard()).setSouthWall(true);
        Position expResult = new Position(3, 0);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveEastWithWallOnSquare_noAnimalOnFinalPosition_noFall() {
        System.out.println("move East with  wall on same square, no animal on final position, and no fall");
        Butterfly instance = (Butterfly) animals[0];
        this.board.getSquare(instance.getPositionOnBoard()).setEastWall(true);
        Position expResult = new Position(0, 3);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveWestWithWallOnSquare_noAnimalOnFinalPosition_noFall() {
        System.out.println("move West with  wall on same square, no animal on final position, and no fall");
        Butterfly instance = (Butterfly) animals[1];
        this.board.getSquare(instance.getPositionOnBoard()).setWestWall(true);
        Position expResult = new Position(4, 1);
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveNorth_AnimalOnFinalPositionWithWallOnNorthSide_noFall() {
        System.out.println("move North, animal on final position, and no fall");
        Butterfly instance = (Butterfly) animals[1];
        Snail onFinalPos = (Snail) animals[2];
        onFinalPos.setPositionOnBoard(new Position(1, 4));
        this.board.getSquare(onFinalPos.getPositionOnBoard()).setNorthWall(true);
        Position expResult = new Position(0, 4);
        Position result = instance.move(board, Direction.NORTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveSouth_AnimalOnFinalPositionWithWallOnSouthSide_noFall() {
        System.out.println("move South, animal on final position, and no fall");
        Butterfly instance = (Butterfly) animals[0];
        Snail onFinalPos = (Snail) animals[2];
        onFinalPos.setPositionOnBoard(new Position(3, 0));
        this.board.getSquare(onFinalPos.getPositionOnBoard()).setSouthWall(true);
        Position expResult = new Position(4, 0);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveEast_AnimalOnFinalPositionWithWallOnEastSide_noFall() {
        System.out.println("move East, animal on final position, and no fall");
        Butterfly instance = (Butterfly) animals[0];
        Snail onFinalPos = (Snail) animals[2];
        onFinalPos.setPositionOnBoard(new Position(0, 3));
        this.board.getSquare(onFinalPos.getPositionOnBoard()).setEastWall(true);
        Position expResult = new Position(0, 4);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMoveWest_AnimalOnFinalPositionWithWallOnWestSide_noFall() {
        System.out.println("move West, animal on final position, and no fall");
        Butterfly instance = (Butterfly) animals[1];
        Snail onFinalPos = (Snail) animals[2];
        onFinalPos.setPositionOnBoard(new Position(4, 1));
        this.board.getSquare(onFinalPos.getPositionOnBoard()).setWestWall(true);
        Position expResult = new Position(4, 0);
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMove_passOnUsedStar() {
        System.out.println("move and pass on used star without win");
        this.board.getSquare(new Position(0, 3)).setSquareType(STAR);
        Butterfly instance = (Butterfly) animals[0];
        Snail useStar = (Snail) animals[2];
        useStar.setPositionOnBoard(new Position(0, 2));
        useStar.move(board, Direction.EAST, animals);
        Position result = instance.move(board, Direction.EAST, animals);
        Position expResult = new Position(0, 3);
        assertEquals(expResult, result);
        assertTrue(animals[2].isOnStar());
        assertFalse(animals[0].isOnStar());
        assertTrue(board.getSquareType(new Position(0, 3)) == GRASS);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMove_passOnUnusedStar() {
        System.out.println("move and pass on unusedstar without win");
        this.board.getSquare(new Position(0, 2)).setSquareType(STAR);
        Butterfly instance = (Butterfly) animals[0];
        Position result = instance.move(board, Direction.EAST, animals);
        Position expResult = new Position(0, 3);
        assertEquals(expResult, result);
        assertFalse(animals[0].isOnStar());
        assertTrue(board.getSquareType(new Position(0, 2)) == STAR);
    }

    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMove_nextOnStar() {
        System.out.println("move and arrive on star so get win");
        this.board.getSquare(new Position(0, 3)).setSquareType(STAR);
        Butterfly instance = (Butterfly) animals[0];
        Position result = instance.move(board, Direction.EAST, animals);
        Position expResult = new Position(0, 3);
        assertEquals(expResult, result);
        assertTrue(animals[0].isOnStar());
        assertTrue(board.getSquareType(new Position(0, 3)) == GRASS);
    }
    
    /**
     * Test of move method, of class Butterfly.
     */
    @Test
    public void testMove_twoAnimalsOnTheWay_oneMoreOnFinalPositionButOnStar_additionnalWallsInTheWay() {
        board = new Board(new Square[][]{
            {new Square(GRASS)},
            {null},
            {null},
            {new Square(GRASS)},
            {new Square(GRASS)},
            {new Square(GRASS)}
        });
        animals = new Animal[]{
            new Butterfly(new Position(0, 0)),
            new Butterfly(new Position(3, 0)),
            new Snail(new Position(4, 0)),
            new Snail(new Position(5, 0))
        };
        this.board.getSquare(new Position(4,0)).setNorthWall(true);
        this.board.getSquare(new Position(3,0)).setSouthWall(true);
        System.out.println("");
        Butterfly instance = (Butterfly) animals[0];
        Snail onFinalPos = (Snail) animals[3];
        onFinalPos.setOnStar();
        Position expResult = new Position(5, 0);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

}
