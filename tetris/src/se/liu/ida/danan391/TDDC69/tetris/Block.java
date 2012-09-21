package se.liu.ida.danan391.TDDC69.tetris;

/**
 * Created with IntelliJ IDEA.
 * User: pooze
 * Date: 9/1/12
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Block extends SquareColor {
    private int XCoord;
    private int YCoord;
    private final SquareColor color;

    public Block(int X, int Y, Color color) {
        this.XCoord = X;
        this.YCoord = Y;
        this.color = new SquareColor(color);
    }
    public int getXCoord() {
        return XCoord;
    }
    public void setXCoord(int XCoord) {
        this.XCoord = XCoord;
    }
    public int getYCoord() {
        return YCoord;
    }
    public void setYCoord(int YCoord) {
        this.YCoord = YCoord;
    }
    public Color getColor() {
        return this.color.getColor();
    }
}
