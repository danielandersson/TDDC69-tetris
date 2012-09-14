package se.liu.ida.danan391.TDDC69.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ida.liu.se.danan391.TDDC69.tetris by pooze
 * 9/5/12
 * Usage:
 */
public class TetrisFrame extends JFrame {
    private GameBoard game;
    private JTextArea textArea;
    private JLabel status;

    private boolean pauseGUI = false;

    public TetrisFrame(GameBoard game) {
        super("Tetris");
        super.setLayout(new BorderLayout());
        final GraphicalViewer graphicalViewer = new GraphicalViewer(game);
        this.status = new JLabel("Ready!");
        this.status.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        super.add(createButtonPanel(), BorderLayout.NORTH);
        super.add(graphicalViewer, BorderLayout.CENTER);
        super.add(status, BorderLayout.SOUTH);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        final JFrame close = new JFrame();
        super.addWindowListener(new WindowAdapter(){
            public void windowClosing(final WindowEvent e){
                int answer = JOptionPane.showConfirmDialog
                        (close, "Do you wanna quit?", "Quit?", JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });
        this.game = game;
        super.pack();
    }

    public TetrisFrame(GameBoard game, String initText) {
        super("Tetris");
        super.setLayout(new BorderLayout());
        this.textArea = new JTextArea(initText);
        this.textArea.setBorder(BorderFactory.createEtchedBorder());
        this.status = new JLabel("Ready!");
        this.status.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        super.add(createButtonPanel(), BorderLayout.NORTH);
        super.add(textArea, BorderLayout.CENTER);
        super.add(status, BorderLayout.SOUTH);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        final JFrame close = new JFrame();
        super.addWindowListener(new WindowAdapter(){
            public void windowClosing(final WindowEvent e){
                int answer = JOptionPane.showConfirmDialog
                        (close, "Do you wanna quit?", "Quit?", JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });
        this.game = game;
        super.pack();
    }
    public boolean isPauseGUI() {
        return pauseGUI;
    }
    public void setText(String text) {
        textArea.setText(text);
    }
    private JPanel createButtonPanel() {
        final JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton button = new JButton("New Game");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //game.reset();
            }
        });
        buttons.add(button);
        button = new JButton("Pause");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //game.pause();
                if (isPauseGUI()){
                    pauseGUI=false;
                    status.setText("Running");
                }
                else{
                    pauseGUI=true;
                    status.setText("Paused");
                }
            }
        });
        buttons.add(button);
        return buttons;
    }
}
