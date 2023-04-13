import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setBounds(100,100,1000,400);
        this.setTitle("Ball Game");

        GameWindow game = new GameWindow(this.getWidth(),this.getHeight());
        game.setBackground(Color.GRAY);
        this.add(game);
    }
}
