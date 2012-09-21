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
    private final GameBoard game;
    private JTextArea textArea;
    private final JLabel status;
    private GraphicalViewer graphicalViewer;

    private boolean pauseGUI = false;

    public TetrisFrame(final GameBoard game) {
        super("Tetris");
        this.game = game;

        graphicalViewer = new GraphicalViewer(this.game);
        game.addBoardListener(graphicalViewer);


        final Action rotate = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ROTATE");
                game.getFallingBlock().rotate();
            }
        };
        final Action moveDown = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (game.getFallingBlock().canMakeMove(Direction.DOWN, game.getPlacedBlocks())) {
                    System.out.println("DOWN");
                    game.getFallingBlock().move(Direction.DOWN);
                }
            }
        };
        final Action moveLeft = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (game.getFallingBlock().canMakeMove(Direction.LEFT, game.getPlacedBlocks())) {
                    System.out.println("LEFT");
                    game.getFallingBlock().move(Direction.LEFT);
                }
            }
        };
        final Action moveRight = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (game.getFallingBlock().canMakeMove(Direction.RIGHT, game.getPlacedBlocks())) {
                    System.out.println("RIGHT");
                    game.getFallingBlock().move(Direction.RIGHT);
                }
            }
        };


        graphicalViewer.getInputMap().put(KeyStroke.getKeyStroke("UP"), "rotate");
        graphicalViewer.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "moveDown");
        graphicalViewer.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
        graphicalViewer.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
        graphicalViewer.getActionMap().put("rotate", rotate);
        graphicalViewer.getActionMap().put("moveDown", moveDown);
        graphicalViewer.getActionMap().put("moveLeft", moveLeft);
        graphicalViewer.getActionMap().put("moveRight", moveRight);


        super.setLayout(new BorderLayout());
        this.status = new JLabel("Ready!");
        this.status.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        final JFrame close = new JFrame();
        //super.add(createButtonPanel(), BorderLayout.NORTH);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        JMenuItem menuItem = new JMenuItem("Quit");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int answer = JOptionPane.showConfirmDialog
                        (close, "Do you wanna quit?", "Quit?", JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });
        menu.add(menuItem);
        super.setJMenuBar(menuBar);


        super.add(graphicalViewer, BorderLayout.CENTER);
        super.add(status, BorderLayout.SOUTH);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        super.addWindowListener(new WindowAdapter(){
            public void windowClosing(final WindowEvent e){
                int answer = JOptionPane.showConfirmDialog
                        (close, "Do you wanna quit?", "Quit?", JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });
        super.pack();
    }
    public void setStatus(String text){
        this.status.setText(text);
    }
    public boolean isPauseGUI() {
        return pauseGUI;
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
