package humbug.mdl.animals;

import humbug.mdl.Board;
import humbug.mdl.Direction;
import humbug.mdl.Position;
import humbug.mdl.Square;
import static humbug.mdl.SquareType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Pierre Bettens (pbt) <pbettens@he2b.be>
 */
public class SnailTest {

    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(STAR)}
        });
        animals = new Animal[]{
            new Snail(new Position(0, 0)),
            new Snail(new Position(1, 2)),
            new Snail(new Position(1, 1))
        };
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove() {
        System.out.println("move_general");
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 1); //.next(Direction.EAST);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove_next_notfree() {
        System.out.println("move next case not free");
        Snail instance = (Snail) animals[0];
        animals[1].setPositionOnBoard(new Position(0, 1));
        Position expResult = new Position(0, 0); //don't move
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove_next_onstar() {
        System.out.println("move next on star");
        Snail instance = (Snail) animals[1];
        Position expResult = new Position(2, 2);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
        assertTrue(instance.isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove_next_notinside_2() {
        System.out.println("move next case null");
        Snail instance = (Snail) animals[0];
        Position expResult = null; // move and fall
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMoveWallNorthOnSameSquareSnail0() {
        System.out.println("move to north with wall to the north on same square");
        this.board.getSquare(new Position(0, 0)).setNorthWall(true);
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.NORTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMoveWallSouthOnSameSquareSnail0() {
        System.out.println("move to south with wall to the south on same square");
        this.board.getSquare(new Position(0, 0)).setSouthWall(true);
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMoveWallEastOnSameSquareSnail0() {
        System.out.println("move east with wall to the east on same square");
        this.board.getSquare(new Position(0, 0)).setEastWall(true);
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMoveWallWestOnSameSquareSnail0() {
        System.out.println("move west with wall to the west on same square");
        this.board.getSquare(new Position(0, 0)).setWestWall(true);
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMoveNorthWallOnDifferentSquareSnail2() {
        System.out.println("move to north with wall to the north on different square");
        this.board.getSquare(new Position(0, 1)).setSouthWall(true);
        Snail instance = (Snail) animals[2];
        Position expResult = new Position(1, 1);
        Position result = instance.move(board, Direction.NORTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMoveSouthWallOnDifferentSquareSnail2() {
        System.out.println("move to south with wall to the south on different square");
        this.board.getSquare(new Position(2, 1)).setNorthWall(true);
        Snail instance = (Snail) animals[2];
        Position expResult = new Position(1, 1);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMoveEastWallOnDifferentSquareSnail2() {
        System.out.println("move east with wall to the east on different square");
        this.board.getSquare(new Position(1, 2)).setWestWall(true);
        Snail instance = (Snail) animals[2];
        Position expResult = new Position(1, 1);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMoveWestWallOnDifferentSquareSnail2() {
        System.out.println("move west with wall to the west on different square");
        this.board.getSquare(new Position(1, 0)).setEastWall(true);
        Snail instance = (Snail) animals[2];
        Position expResult = new Position(1, 1);
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }
}
