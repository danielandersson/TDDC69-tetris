package se.liu.ida.danan391.TDDC69.tetris;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: pooze
 * Date: 9/1/12
 * Time: 10:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tetromino extends GameItem {

    private static final int NUMBER_OF_BLOCKS = 5;
    public Tetromino() {
        super(4, Rotation.WEST);
        generateBlock(randomBlockNumber());
        //generateBlock(2);
    }
    private int randomBlockNumber(){
        Random generator = new Random(System.currentTimeMillis());
        return generator.nextInt(NUMBER_OF_BLOCKS);
    }
    private void generateBlock(int BlockID) {
        switch (BlockID) {
            case 0:
                generateIBlock();
                break;
            case 1:
                generateLBlock();
                break;
            case 2:
                generateOBlock();
                break;
            case 3:
                generateFBlock();
            case 4:
                generateSBlock();
            default:
                break;
        }
    }
    private void generateIBlock() {
        getBlockList()[0] = new Block(0,0, Color.RED);
        getBlockList()[1] = new Block(0,1, Color.RED);
        getBlockList()[2] = new Block(0,2, Color.RED);
        getBlockList()[3] = new Block(0,3, Color.RED);
    }
    private void generateLBlock() {
        getBlockList()[0] = new Block(0,0, Color.GREEN);
        getBlockList()[1] = new Block(0,1, Color.GREEN);
        getBlockList()[2] = new Block(1,0, Color.GREEN);
        getBlockList()[3] = new Block(2,0, Color.GREEN);
    }
    private void generateOBlock() {
        getBlockList()[0] = new Block(0,0, Color.BLUE);
        getBlockList()[1] = new Block(0,1, Color.BLUE);
        getBlockList()[2] = new Block(1,0, Color.BLUE);
        getBlockList()[3] = new Block(1,1, Color.BLUE);
    }
    private void generateFBlock() {
        getBlockList()[0] = new Block(0,0, Color.YELLOW);
        getBlockList()[1] = new Block(0,1, Color.YELLOW);
        getBlockList()[2] = new Block(0,2, Color.YELLOW);
        getBlockList()[3] = new Block(1,1, Color.YELLOW);
    }
    private void generateSBlock() {
        getBlockList()[0] = new Block(0,0, Color.PINK);
        getBlockList()[1] = new Block(0,1, Color.PINK);
        getBlockList()[2] = new Block(1,1, Color.PINK);
        getBlockList()[3] = new Block(1,2, Color.PINK);
    }
}
