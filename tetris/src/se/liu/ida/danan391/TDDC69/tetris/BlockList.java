package se.liu.ida.danan391.TDDC69.tetris;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created with IntelliJ IDEA.
 * User: pooze
 * Date: 9/3/12
 * Time: 8:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class BlockList{
    private List<Block> blockList;

    public BlockList() {
        System.out.println("+ A BlockList was generated");
        blockList = new ArrayList();
    }

    public void add(Tetromino tetromino) {
        for (int i = 0; i < blockList.size(); i++) {
            blockList.add(tetromino.getBlock(i));
        }
    }
    public void add(Block block) {
        blockList.add(block);
    }
    public Block getBlock(int i) {
        return blockList.get(i);
    }
    public int length(){
        return blockList.size();
    }
    public List getBlocks() {
        return blockList;
    }
}
