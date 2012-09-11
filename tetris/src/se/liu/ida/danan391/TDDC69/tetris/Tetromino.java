package se.liu.ida.danan391.TDDC69.tetris;

/**
 * Created with IntelliJ IDEA.
 * User: pooze
 * Date: 9/1/12
 * Time: 10:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tetromino extends GameItem {

    //TODO: Need to generalize the Tetromino contructor
    public Tetromino() {
        super(4, Rotation.WEST);
        generateLBlock();
    }
    private void generateIBlock() {
        this.blocks[0] = new Block(0,0);
        this.blocks[1] = new Block(0,1);
        this.blocks[2] = new Block(0,2);
        this.blocks[3] = new Block(0,3);
    }
    private void generateLBlock() {
        this.blocks[0] = new Block(0,0);
        this.blocks[1] = new Block(0,1);
        this.blocks[2] = new Block(1,0);
        this.blocks[3] = new Block(2,0);
        /*
        super.add(new Block(0, 0));
        super.add(new Block(0, 1));
        super.add(new Block(1, 0));
        super.add(new Block(2, 0));
        */
    }
    private void generateOBlock() {
        this.blocks[0] = new Block(0,0);
        this.blocks[1] = new Block(0,1);
        this.blocks[2] = new Block(1,0);
        this.blocks[3] = new Block(1,1);
    }
}
