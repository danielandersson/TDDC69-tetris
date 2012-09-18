package se.liu.ida.danan391.TDDC69.tetris;

import java.util.ArrayList;

/**
 * ida.liu.se.danan391.TDDC69.tetris by pooze
 * 9/3/12
 * Usage:
 */
public class GameBoard {
    public static final int ROWS = 20;
    public static final int COLUMS = 10;
    private Tetromino fallingBlock;
    private Color [][] placedBlocks = new Color[ROWS][COLUMS];
    private ArrayList<BoardListener> BoardListeners = new ArrayList<BoardListener>();
    public GameBoard() {
        System.out.println("+ Generated GameBoard");
        fallingBlock = new Tetromino();
        getFallingBlock().print();
        getFallingBlock().rotate();
        getFallingBlock().print();
    }

    public void addBoardListener(BoardListener bl) {
        BoardListeners.add(bl);
    }

    private void notifyListeners() {
        for (BoardListener bl : BoardListeners) {
            bl.boardChanged();
        }

    }

    public void update() {
        if (getFallingBlock().inside())
            getFallingBlock().move(Direction.DOWN);
        else {
            for (Block block : getFallingBlock().getBlockList()){
                getPlacedBlocks()[block.getYCoord()- getFallingBlock().getMovedY()][block.getXCoord()- getFallingBlock().getMovedX()] = block.getColor();
            }
            fallingBlock = new Tetromino();
            for (int i =0; i < ROWS; i++) {
                for (int j = 0; j < COLUMS; j++) {
                    System.out.print(" " + getPlacedBlocks()[i][j]);
                }
                System.out.println("");
            }
        }
        notifyListeners();
    }

    public GameItem getFallingBlock() {
        return fallingBlock;
    }

    public Color[][] getPlacedBlocks() {
        return placedBlocks;
    }
}
