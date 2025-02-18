import game_constants.Constants;

import javax.swing.*;
import java.awt.*;

public class Block extends JLabel {
    private int blockValue;
    private final int N = Constants.N.getValue();

    Block (int blockValue) {
        this.blockValue = blockValue;

        this.setPreferredSize(new Dimension(N, N));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(new BorderLayout());

        this.showBlock(this.blockValue);
    }

    int getBlockValue() {
        return this.blockValue;
    }

    void setBlockValue(int blockValue) {
        this.blockValue = blockValue;
    }

    private void showBlock(int blockValue) {
        if(blockValue == Constants.WALL_VALUE.getValue()) {
            this.setOpaque(true);
            this.setBackground(Color.blue);
        }
        else if(blockValue == Constants.EMPTY_VALUE.getValue()) {
            this.setBackground(Color.black);
            this.setOpaque(true);
        }
        else if(blockValue == Constants.POINT_VALUE.getValue()) {
            this.setOpaque(true);
            this.setBackground(Color.white);
            this.setBorder(BorderFactory.createLineBorder(Color.black, 15));
        }
        else if(blockValue == Constants.ENEMY_VALUE.getValue()) {
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setVerticalAlignment(JLabel.CENTER);

            ImageIcon enemyImageIcon = new ImageIcon("resources/enemy.png");
            Image enemyImage = enemyImageIcon.getImage();
            Image scaledImage = enemyImage.getScaledInstance(N, N, Image.SCALE_SMOOTH);
            this.setIcon(new ImageIcon(scaledImage));
            setOpaque(false);
        } else if(blockValue == Constants.PLAYER_VALUE.getValue()) {
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setVerticalAlignment(JLabel.CENTER);

            ImageIcon playerImageIcon = new ImageIcon("resources/pacman.png");
            Image playerImage = playerImageIcon.getImage();
            Image scaledImage = playerImage.getScaledInstance(N, N, Image.SCALE_SMOOTH);
            this.setIcon(new ImageIcon(scaledImage));
            setOpaque(false);
        }
    }
}
