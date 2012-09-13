package se.liu.ida.danan391.TDDC69.tetris;
import java.util.Random;
/**
 * ida.liu.se.danan391.TDDC69.tetris by pooze
 * 9/11/12
 * Usage:
 */
public class SquareColor {
    private Color color;

    public SquareColor() {
        this.color = this.randomColor();
    }
    public SquareColor(Color color) {
        this.color = color;
    }
    private Color randomColor() {
        int pick = new Random().nextInt(Color.values().length);
        return Color.values()[pick];
    }
    public Color getColor() {
        return this.color;
    }





}
