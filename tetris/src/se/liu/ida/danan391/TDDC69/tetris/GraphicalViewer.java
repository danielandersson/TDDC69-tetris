package se.liu.ida.danan391.TDDC69.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.geom.Rectangle2D;


public class GraphicalViewer extends JComponent {
    private static final int width = 300;
    private static final int height = 600;

    private static final int gameItemWidth = width/10;
    private static final int gameItemHeight = height/20;

    private GameBoard game;

    public GraphicalViewer(GameBoard game) {
        this.game = game;
    }

    public Dimension getPreferredSize() {

        return new Dimension(width, height);
    }


    public void paintComponent(final Graphics g) {
        final Graphics2D g2 = (Graphics2D)g;
        paintBG(g2);
        paintGameItem(g2);
    }

    private void paintBG(final Graphics2D g2) {

    }

    private void paintGameItem(final Graphics2D g2) {
        System.out.println("NEW");
        for (Block block : game.tetromino.getBlockList()){
            g2.setColor(translateColor(block.getColor()));
            int calcX = width/2- (gameItemWidth*game.tetromino.getWidth())/2 + gameItemWidth*block.getXCoord();
            int calcY = gameItemHeight*block.getYCoord()-gameItemHeight*game.tetromino.getMovedY();
            System.out.println(block.getXCoord() + " " + block.getYCoord() + " X:" + calcX + " Y:" + calcY);
            g2.draw(new Rectangle2D.Double(calcX, calcY, gameItemWidth, gameItemHeight));
        }
    }

    private Color translateColor(se.liu.ida.danan391.TDDC69.tetris.Color color) {
        switch (color) {
            case BLACK:
                return Color.BLACK;
            case BLUE:
                return Color.BLUE;
            case GREEN:
                return Color.GREEN;
            case RED:
                return Color.RED;
            case YELLOW:
                return Color.YELLOW;
            default:
                return Color.GRAY;
        }
    }
}
