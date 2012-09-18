package se.liu.ida.danan391.TDDC69.tetris;

/**
 * ida.liu.se.danan391.TDDC69.tetris by pooze
 * 9/3/12
 * Usage:
 */
public class GameBoard {
    public static final int ROWS = 20;
    public static final int COLUMS = 10;
    protected GameItem fallingBlock;
    protected Color [][] placedBlocks = new Color[ROWS][COLUMS];
    public GameBoard() {
        System.out.println("+ Generated GameBoard");
        fallingBlock = new Tetromino();
        fallingBlock.print();
        fallingBlock.rotate();
        fallingBlock.print();
    }

    public void update() {
        // TODO: Some input handling
        if (fallingBlock.inside())
            fallingBlock.move(Direction.DOWN);
        else {
            for (Block block : fallingBlock.getBlockList()){
                placedBlocks[block.getYCoord()][block.getXCoord()] = block.getColor();
            }
            fallingBlock = new Tetromino();
        }

    }
}
