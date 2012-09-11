package se.liu.ida.danan391.TDDC69.tetris;

/**
 * Created with IntelliJ IDEA.
 * User: pooze
 * Date: 9/1/12
 * Time: 10:06 PM
 * To change this template use File | Settings | File Templates.
 */

// TODO: Need to find some way to iterate over ArrayList BlockList to get the same function as the Array Tetromino
public class TetrominoL {
    private final int SIZE = 4;
    private BlockList blocks;
    private Rotation currentRotation = Rotation.WEST;

    public TetrominoL() {
        blocks = new BlockList();
        currentRotation = Rotation.EAST;
    }
    public BlockList getBlock() {
        return this.blocks;
    }
    public void move(Direction direction) {
        switch (direction) {
            case DOWN:
                System.out.println("Move the tetromino DOWN");
                break;
            case RIGHT:
                System.out.println("Move the tetromino RIGTH");
                break;
            case LEFT:
                System.out.println("Move the tetromino LEFT");
                break;
            case UP:
                System.out.println("Move the tetromino UP");
                break;
        }
    }
    public void rotate() {
        int tempX, tempY;
        switch (this.currentRotation) {
            case EAST :
                break;
            case NORTH :
                break;
            case WEST :
                break;
            case SOUTH :
                break;
        }

    }
    public void print() {
        int nblock = 0;
        for (int i = 5; i >= -5; i--) {
            for (int j = -5; j <= 5; j++) {
                if (this.exist(j, i)) {
                    System.out.print("X");
                    if (nblock < blocks.length()-1)
                        nblock++;
                }
                else
                if (i == 0)
                    System.out.print("-");
                else
                if (j == 0)
                    System.out.print("|");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    private boolean exist(int XCoord, int YCoord) {
        return false;
    }


}
