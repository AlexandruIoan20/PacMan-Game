import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    String filePath = "resources/level.txt";
    GameFrame () {
        this.setTitle("PacMan Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel gamePanel = new GamePanel(filePath);

        this.add(gamePanel);
        this.setSize(570, 570);
        this.getContentPane().setBackground(Color.BLACK);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
