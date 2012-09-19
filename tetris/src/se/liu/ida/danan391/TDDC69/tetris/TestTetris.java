package se.liu.ida.danan391.TDDC69.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * ida.liu.se.danan391.TDDC69.tetris by pooze
 * 9/3/12
 * Usage:
 */
public class TestTetris {
    public static void main(String[] args) {
        final GameBoard gameBoard = new GameBoard();
        final TetrisFrame mainFrame = new TetrisFrame(gameBoard);
        mainFrame.setVisible(true);
        final Timer clockTimer;
        final Action doOneStep = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!gameBoard.gameOver())
                    gameBoard.update();
                else {
                    mainFrame.setStatus("GAME OVER!");
                }
            }
        };
        clockTimer = new Timer(250, doOneStep);
        clockTimer.setCoalesce(true);
        clockTimer.start();


        /*
        boolean runGame = true;
        long testTime = System.currentTimeMillis();
        /*
        while (runGame) {
            if (testTime+1000 < System.currentTimeMillis())
            {
                testTime = System.currentTimeMillis();
                gameBoard.update();
                mainFrame.setText(textOutput.convertToText(gameBoard));
            }

        }
        */
    }
}
