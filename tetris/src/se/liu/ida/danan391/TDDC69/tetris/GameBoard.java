package se.liu.ida.danan391.TDDC69.tetris;

import java.util.ArrayList;

/**
 * ida.liu.se.danan391.TDDC69.tetris by pooze
 * 9/3/12
 * Usage:
 */
public class GameBoard {
    public static final int ROWS = 24;
    public static final int COLUMS = 10;
    private Tetromino getFallingBlock;
    private Color [][] placedBlocks = new Color[ROWS][COLUMS];
    private ArrayList<BoardListener> BoardListeners = new ArrayList<BoardListener>();
    public GameBoard() {
        System.out.println("+ Generated GameBoard");
        getFallingBlock = new Tetromino();
        getFallingBlock().print();
        getFallingBlock().rotate();
        getFallingBlock().print();
    }

    public void addBoardListener(BoardListener bl) {
        BoardListeners.add(bl);
    }

    private void removeFull() {
        int i;
        for (i = 0; i < ROWS; i++) {
            if (fullRow(getPlacedBlocks()[i])){
                for (int j = i; j > 0;j--)
                    getPlacedBlocks()[j] = getPlacedBlocks()[j-1];
            }
        }
    }

    private boolean fullRow(Color [] row) {
        for(Color column : row){
            if (column == null)
                return false;
        }
        return true;
    }

    private void notifyListeners() {
        for (BoardListener bl : BoardListeners) {
            bl.boardChanged();
        }

    }
    public boolean gameOver() {
        for (Color column : getPlacedBlocks()[3]){
            if (column != null)
                return true;
        }
        return false;
    }

    public void update() {
        if (getFallingBlock().inside() && getFallingBlock.canMakeMove(Direction.DOWN, placedBlocks))
            getFallingBlock().move(Direction.DOWN);
        else {
            for (Block block : getFallingBlock().getBlockList()){
                getPlacedBlocks()[block.getYCoord()- getFallingBlock().getMovedY()][((int) (GameBoard.COLUMS / 2 + block.getXCoord() - Math.floor(getFallingBlock.getWidth() / 2) - getFallingBlock().getMovedX()))] = block.getColor();
            }
            removeFull();
            getFallingBlock = new Tetromino();
        }
        notifyListeners();
    }
    public GameItem getFallingBlock() {
        return getFallingBlock;
    }
    public Color[][] getPlacedBlocks() {
        return placedBlocks;
    }
}
