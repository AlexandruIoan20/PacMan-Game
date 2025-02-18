import game_constants.Constants;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import game_constants.Constants;

public class GamePanel extends JPanel {
    private final String filePath;
    private final int N = Constants.N.getValue();
    int game_matrix[][] = new int[N][N];

    GamePanel(String filePath) {
        this.filePath = filePath;
        this.setBackground(Color.BLACK);
        this.setOpaque(true);

        this.loadLevel();
        this.showGame();
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

                if(Character.getNumericValue(c) != -1) {
                    game_matrix[line_counter][e_counter] = Character.getNumericValue(c);

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
                System.out.print(game_matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
