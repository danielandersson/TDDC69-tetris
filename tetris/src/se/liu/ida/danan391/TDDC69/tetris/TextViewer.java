package se.liu.ida.danan391.TDDC69.tetris;

/**
 * ida.liu.se.danan391.TDDC69.tetris by pooze
 * 9/5/12
 * Usage:
 */

public class TextViewer {
    private static final char SPACE = (char)Integer.parseInt("3000",16);
    public String convertToText(GameBoard game) {
        StringBuilder outString = new StringBuilder();
        String title = "Tetris";
        for (int i = 0; i < ((game.COLUMS - (title.length()/2) )/ 2); i++) {
            outString.append(SPACE);
        }
        outString.append(title + "\n+");
        for (int i = 0; i < game.COLUMS; i++) {
            outString.append(i);
        }
        outString.append("+\n");
        for (int i = 0; i < game.ROWS; i++) {
            outString.append('|');
            for (int j = game.COLUMS; j > 0; j--) {
                if (game.fallingBlock.exist(game.COLUMS/2 + 1 - j - game.fallingBlock.getMovedX(), -1*game.fallingBlock.getMovedY() - i))
                    outString.append(blockPrint(game.fallingBlock.getBlock(game.COLUMS / 2 + 1 - j - game.fallingBlock.getMovedX(), -1 * game.fallingBlock.getMovedY() - i)));
                else
                    outString.append(SPACE);
            }
            outString.append("|\n");
        }
        /* This is the section for the bottom line.
        outString.append('+');
        for (int i = 0; i < game.COLUMS; i++) {
            outString.append('-');
        }
        outString.append("+\n");
        */
        return outString.toString();
    }
    private Character blockPrint(Block block) {
        switch (block.getColor()) {
            case BLACK:
                return '$';
            case BLUE:
                return '@';
            case GREEN:
                return '&';
            case RED:
                return '#';
            case YELLOW:
                return '%';
            default:
                return '¶';
        }
    }

    // Print the GameBoard in the console
    private void debugPrint(GameBoard game) {
        String title = "Tetris";
        for (int i = 0; i < ((game.COLUMS - (title.length()/2) )/ 2); i++) {
            System.out.print(SPACE);
        }
        System.out.println(title);
        System.out.print('+');
        for (int i = 0; i < game.COLUMS; i++) {
            System.out.print(i);
        }
        System.out.println('+');
        for (int i = 0; i < game.ROWS; i++) {
            System.out.print("|");
            for (int j = game.COLUMS; j > 0; j--) {
                if (game.fallingBlock.exist(game.COLUMS/2 + 1 - j - game.fallingBlock.getMovedX(), -1*game.fallingBlock.getMovedY() - i))
                {
                    System.out.print('#');
                }
                else
                    System.out.print(SPACE);
            }
            System.out.println('|');
        }
        System.out.print('+');
        for (int i = 0; i < game.COLUMS; i++) {
            System.out.print('-');
        }
        System.out.println('+');
    }
}
