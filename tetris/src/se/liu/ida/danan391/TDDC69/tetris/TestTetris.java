package se.liu.ida.danan391.TDDC69.tetris;

import javax.swing.*;
import java.awt.*;

/**
 * ida.liu.se.danan391.TDDC69.tetris by pooze
 * 9/3/12
 * Usage:
 */
public class TestTetris {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        TextViewer textOutput = new TextViewer();
        TetrisFrame mainFrame = new TetrisFrame(gameBoard, textOutput.convertToText(gameBoard));
        mainFrame.setVisible(true);
        boolean runGame = true;
        long testTime = System.currentTimeMillis();
        while (runGame) {
            if (testTime+1000 < System.currentTimeMillis())
            {
                testTime = System.currentTimeMillis();
                gameBoard.update();
                mainFrame.setText(textOutput.convertToText(gameBoard));
            }

        }
    }
}
