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

        final GraphicalViewer graphicalViewer = new GraphicalViewer(gameBoard);

        final TetrisFrame mainFrame = new TetrisFrame(gameBoard, graphicalViewer);
        mainFrame.setVisible(true);
        gameBoard.addBoardListener(graphicalViewer);


        final Action doOneStep = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameBoard.update();
            }
        };

        final Action moveDown = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameBoard.getFallingBlock().move(Direction.DOWN);
                System.out.println("hej");
            }
        };

        KeyStroke key = KeyStroke.getKeyStroke("ENTER");
        graphicalViewer.getInputMap().put(key, "doMoveDownAction");
        graphicalViewer.getActionMap().put("doMoveDownAction", moveDown);

        final Timer clockTimer = new Timer(1000, doOneStep);
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
