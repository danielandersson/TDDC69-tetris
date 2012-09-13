package se.liu.ida.danan391.TDDC69.tetris;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: pooze
 * Date: 9/1/12
 * Time: 10:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tetromino extends GameItem {

    private static final int SIZE = 4;
    private static final int numberOfBlocks = 3;
    private int index;
    public Tetromino() {
        super(4, Rotation.WEST);
        Random generator = new Random();
        index = generator.nextInt(numberOfBlocks);
        generateBlock(index);

    }
    // TODO: Check if this is the correct way to increase "index" before the method call
    public void nextBlock() {
        if (index < numberOfBlocks)
            generateBlock(++index);
        else{
            index = 0;
            generateBlock(index);
        }

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
}
