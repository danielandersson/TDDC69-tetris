package se.liu.ida.danan391.TDDC69.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * ida.liu.se.danan391.TDDC69.tetris by pooze
 * 9/3/12
 * Usage:
 */
public class TestTetris {
    public static void main(String[] args) {
        final GameBoard gameBoard = new GameBoard();
        //final TextViewer textOutput = new TextViewer();
        //final TetrisFrame mainFrame = new TetrisFrame(gameBoard, textOutput.convertToText(gameBoard));
        final TetrisFrame mainFrame = new TetrisFrame(gameBoard);
        mainFrame.setVisible(true);

        final Action doOneStep = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameBoard.update();
                mainFrame.repaint();
                //mainFrame.setText(textOutput.convertToText(gameBoard));
            }
        };

        final Timer clockTimer = new Timer(1000, doOneStep);
        clockTimer.setCoalesce(true);
        // Note: Just for debug
        // clockTimer.setLogTimers(true);
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
