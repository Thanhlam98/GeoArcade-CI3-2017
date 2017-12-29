import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    BufferedImage background;
    BufferedImage player;
    BufferedImage backBuffered;
    BufferedImage enemy;
    BufferedImage enemy2;
    Graphics graphics;
    public int positionPlayerX = 200;
    public int positionPlayerY = 300;

    public int posEnemyX = 250;
    public int posEnemyY = 0;

    public int posE2X = 300;
    public int posE2Y = 0;

    public GameCanvas() {
        this.setSize(400, 600);
        this.setVisible(true);
        this.setupBackBuffered();
        this.setupBackground();
        this.setupPlayer();
        this.setupEnemy();
        this.setupEnemy2();
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupBackground() {
        try {
            this.background = ImageIO.read(new File("resources/background/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupPlayer() {
        try {
            this.player = ImageIO.read(new File("resources/player/straight.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupEnemy() {
        try {
            this.enemy = ImageIO.read(new File("resources/square/enemy_square_small.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setupEnemy2() {
        try {
            this.enemy2 = ImageIO.read(new File("resources/square/enemy_square_small.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.graphics.drawImage(this.background, 0, 0, null);
        this.graphics.drawImage(this.player, this.positionPlayerX, this.positionPlayerY,null);
        this.graphics.drawImage(this.enemy, this.posEnemyX, this.posEnemyY,null);
        this.graphics.drawImage(this.enemy2, this. posE2X, this.posE2Y, null);
        this.repaint();
    }
}