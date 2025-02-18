import javax.swing.*;
import java.awt.*;
import java.io.FileReader;

public class GamePanel extends JPanel {
    private final String filePath;

    GamePanel(String filePath) {
        this.filePath = filePath;
        this.setBackground(Color.BLACK);
        this.setOpaque(true);
    }

    private void loadLevel() {

    }
}
