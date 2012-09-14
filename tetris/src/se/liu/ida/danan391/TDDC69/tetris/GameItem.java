package se.liu.ida.danan391.TDDC69.tetris;

import java.util.Arrays;

/**
 * ida.liu.se.danan391.TDDC69.tetris by pooze
 * 9/3/12
 * Usage:
 *
 */

public abstract class GameItem extends BlockList {
    private int SIZE;
    private Block [] blocks;
    private Rotation currentRotation = Rotation.WEST;
    private int movedX = 0;
    private int movedY = 0;
    public GameItem(int size, Rotation rotation) {
        this.SIZE = size;
        this.currentRotation = rotation;
        blocks = new Block[SIZE];
    }

    public int getWidth() {
        int biggestX = 0;
        for (int i = 0; i < blocks.length; i++){
            if (blocks[i].getXCoord() > biggestX)
                biggestX = blocks[i].getXCoord();
        }
        return biggestX + 1;
    }

    public int getMovedX() {
        return movedX;
    }
    public int getMovedY() {
        return movedY;
    }
    public Block [] getBlockList() {
        return this.blocks;
    }
    public Block getBlock(int XCoord, int YCoord) {
        int i =0;
        while(blocks[i].getXCoord() != XCoord && blocks[i].getXCoord() != XCoord) {
            i++;
        }
        return blocks[i];
    }
    public boolean move(Direction direction) {
        switch (direction) {
            case DOWN:
                this.movedY -= 1;
                break;
            case UP:
                this.movedY += 1;
                break;
            case RIGHT:
                this.movedX += 1;
                break;
            case LEFT:
                this.movedX -= 1;
                break;
        }
        return true;
    }
    public void rotate() {
        int tempX, tempY;
        switch (this.currentRotation) {
            case EAST :
                for (int i = 0; i < blocks.length; i++) {
                    tempX = blocks[i].getXCoord();
                    tempY = blocks[i].getYCoord();
                    blocks[i].setXCoord(tempY);
                    blocks[i].setYCoord(tempX);
                }
                this.currentRotation = Rotation.NORTH;
                break;
            case NORTH :
                for (int i = 0; i < blocks.length; i++) {
                    tempX = blocks[i].getXCoord();
                    tempY = blocks[i].getYCoord();
                    blocks[i].setXCoord(tempY);
                    blocks[i].setYCoord(tempX);
                }
                this.currentRotation = Rotation.WEST;
                break;
            case WEST :
                for (int i = 0; i < blocks.length; i++) {
                    tempX = blocks[i].getXCoord();
                    tempY = blocks[i].getYCoord();
                    blocks[i].setXCoord(tempY);
                    blocks[i].setYCoord(tempX);
                }
                this.currentRotation = Rotation.SOUTH;
                break;
            case SOUTH :
                for (int i = 0; i < blocks.length; i++) {
                    tempX = blocks[i].getXCoord();
                    tempY = blocks[i].getYCoord();
                    blocks[i].setXCoord(tempY);
                    blocks[i].setYCoord(tempX);
                }
                this.currentRotation = Rotation.EAST;
                break;
        }

    }
    public void print() {
        int nblock = 0;
        for (int i = 5; i >= -5; i--) {
            for (int j = -5; j <= 5; j++) {
                if (this.exist(j - this.getMovedX(), i - this.getMovedY())) {
                    System.out.print("X");
                    if (nblock < blocks.length-1)
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
    public boolean exist(int XCoord, int YCoord) {
        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i].getXCoord() == XCoord && blocks[i].getYCoord() == YCoord)
                return true;
        }
        return false;
    }
    public boolean inside() {
        return true;
    }

}
