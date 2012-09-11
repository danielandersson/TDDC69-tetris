package se.liu.ida.danan391.TDDC69.tetris;

/**
 * Created with IntelliJ IDEA.
 * User: pooze
 * Date: 9/1/12
 * Time: 10:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestTetromino {
    public static void main(String[] args) {
        System.out.println("Starting up the system...");
        Tetromino testTetro = new Tetromino();
        testTetro.print();
        testTetro.rotate();
        testTetro.print();
        testTetro.rotate();
        testTetro.print();
        testTetro.rotate();
        testTetro.print();
        testTetro.rotate();
        testTetro.print();
    }
}
