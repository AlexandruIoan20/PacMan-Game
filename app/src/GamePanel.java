import entities.Block;
import entities.Enemy;
import entities.Player;
import game_constants.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import entities.Block;

public class GamePanel extends JPanel implements KeyListener {
    private final String filePath;
    private final int N = Constants.N.getValue();
    Block game_matrix[][] = new Block[N][N];
    Player player;

    GamePanel(String filePath) {
        this.filePath = filePath;
        this.setBackground(Color.BLACK);
        this.setOpaque(true);
        this.setLayout(new GridLayout(N, N));

        this.loadLevel();
        this.showGame();

        this.setFocusable(true);
        this.addKeyListener(this);

        // Request focus after the panel is visible
        SwingUtilities.invokeLater(this::requestFocusInWindow);
    }

    private void loadLevel() {
        try {
            File file = new File(filePath);

            FileReader fileReader = new FileReader(file);
            System.out.println("Game file readed");

            int character, line_counter = 0, e_counter = 0;
            while((character = fileReader.read()) != -1) {
                // Convert from read int to real int
                char c = (char) character;

                int value = Character.getNumericValue(c);
                if(value != -1) {
                    if(value == Constants.PLAYER_VALUE.getValue()) {
                        game_matrix[line_counter][e_counter] = new Player(value, line_counter, e_counter);
                        player = new Player(value, line_counter, e_counter);
                    }
                    else if(value == Constants.ENEMY_VALUE.getValue()) game_matrix[line_counter][e_counter] = new Enemy(value);
                    else game_matrix[line_counter][e_counter] = new Block(Character.getNumericValue(c));
                    this.add(game_matrix[line_counter][e_counter]);

                    e_counter++;
                    if (e_counter == N) {
                        e_counter = 0;
                        line_counter++;
                    }
                }
            }
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        } catch(IOException e) {
            System.out.println("The program was unable to read the file");
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException");
        }
    }

    private void showGame() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(game_matrix[i][j].getBlockValue() + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        player.move();
        System.out.println(player.getPlayerI());
        System.out.println(player.getPlayerJ());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
