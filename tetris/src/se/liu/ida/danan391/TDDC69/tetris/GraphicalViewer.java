package se.liu.ida.danan391.TDDC69.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.geom.Rectangle2D;


public class GraphicalViewer extends JComponent implements BoardListener {
    private static final int width = 300;
    private static final int height = 600;

    private static final int GAMEITEMWIDTH = width/10;
    private static final int GAMEITEMHEIGHT = height/20;

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
        paintFallingBlock(g2);
        paintPlacedBlock(g2);
    }
    private void paintBG(final Graphics2D g2) {
        g2.setColor(Color.BLACK);
        g2.fill(new Rectangle2D.Double(0,0,this.getWidth(),this.getHeight()));
    }
    private void paintFallingBlock(final Graphics2D g2) {
        for (Block block : game.getFallingBlock().getBlockList()){
            g2.setColor(translateColor(block.getColor()));
            int calcX = ((int) (width/2 + GAMEITEMWIDTH*block.getXCoord() - GAMEITEMWIDTH*Math.floor(game.getFallingBlock().getWidth() / 2) - GAMEITEMWIDTH*game.getFallingBlock().getMovedX()));
            int calcY = GAMEITEMHEIGHT*block.getYCoord()-GAMEITEMHEIGHT*game.getFallingBlock().getMovedY()-4*GAMEITEMHEIGHT;
            g2.fill(new Rectangle2D.Double(calcX, calcY, GAMEITEMWIDTH, GAMEITEMHEIGHT));
        }
    }
    private void paintPlacedBlock(final Graphics2D g2) {
        for (int i = 0; i < game.ROWS; i++) {
            for (int j = 0; j < game.COLUMS; j++) {
                if (game.getPlacedBlocks()[i][j] != null) {
                    g2.setColor(translateColor(game.getPlacedBlocks()[i][j]));
                    int calcX = j*GAMEITEMWIDTH;
                    int calcY = (i-4)*GAMEITEMHEIGHT;
                    g2.fill(new Rectangle2D.Double(calcX, calcY, GAMEITEMWIDTH, GAMEITEMHEIGHT));
                }
            }
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
    @Override
    public void boardChanged() {
        this.repaint();
    }
}
