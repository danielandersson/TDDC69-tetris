package se.liu.ida.danan391.TDDC69.tetris;

/**
 * ida.liu.se.danan391.TDDC69.tetris by pooze
 * 9/3/12
 * Usage:
 */
public class GameBoard {
    public static final int ROWS = 10;
    public static final int COLUMS = 10;
    protected GameItem tetromino;
    public GameBoard() {
        System.out.println("+ Generated GameBoard");
        tetromino = new Tetromino();
        tetromino.print();
        tetromino.rotate();
        tetromino.print();
    }

    public void update() {
        // TODO: Some input handling
        if (tetromino.inside())
            tetromino.move(Direction.DOWN);
    }
}
