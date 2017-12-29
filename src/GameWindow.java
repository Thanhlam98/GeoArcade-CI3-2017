import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    private long lastTime = 0;
    int vx = 3;
    int vy = 3;

    public GameWindow() {
        this.setSize(400, 600);
        this.setupGameCanvas();
        this.setVisible(true);
        this.event();
    }

    private void setupGameCanvas() {
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
    }

    private void event() {
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                gameCanvas.positionPlayerX = e.getX();
                gameCanvas.positionPlayerY = e.getY();
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.renderAll();
                gameCanvas.posE2Y += 3;
                gameCanvas.posEnemyX += vx;
                gameCanvas.posEnemyY += vy;
                if(gameCanvas.posEnemyX >= 360) {
                    vx = - 3;
                }
                else if(gameCanvas.posEnemyX <= 0) {
                    vx = 3;
                }
                if(gameCanvas.posEnemyY >= 530) {
                    vy = - 3;
                }
                if(gameCanvas.posEnemyY <= 0) {
                    vy = 3;
                }
                this.lastTime = currentTime;
            }
        }
    }
}
