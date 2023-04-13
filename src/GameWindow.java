import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GameWindow extends JPanel {
    Ball ball;
    int speedModifier = 0;
    private Timer timer = new Timer(100, new TimerAction());

    public GameWindow(int width,int height) {
        this.setBounds(0,0,width,height);

        Color ballColour = Color.BLUE;
        int windowCenterX = width/2;
        int windowCenterY = height/2;

        this.ball = new Ball(100, ballColour,windowCenterX,windowCenterY);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //When mouse is clicked on panel, check to see if the ball was clicked.
                ballClicked(e);
            }
        });
        timer.start();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);	//Tell the parent JPanel to repaint ie redraw
        //Avoids a couple of potential issues

        this.ball.drawGraphics(g);
    }



    private boolean checkForWallHit() {
        boolean hit = false;
        int ballX = this.ball.getxPosition();
        int ballSize = this.ball.getBallSize();

        if (ballX<=0||ballX+ballSize>=this.getWidth()) {
            hit = true;
        }
        return hit;
    }

    private void moveBalls() {
        this.ball.moveBall();
        if (checkForWallHit()) {
            JOptionPane.showMessageDialog(null,
                    "A Ball hit a wall. GAME OVER!");
            timer.stop();
        }
    }



    private void changeSpeedDirection() {
        int currentXSpeed = this.ball.getxSpeed();
        int newSpeed = Math.abs(currentXSpeed) + this.speedModifier;
        if (currentXSpeed < 0) {
            this.ball.setxSpeed(newSpeed);
        } else {
            this.ball.setxSpeed(newSpeed * -1);
        }
    }
    private void ballClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        Rectangle hitBox = new Rectangle(this.ball.getxPosition(),this.ball.getyPosition(),this.ball.getBallSize(),this.ball.getBallSize());

        if (hitBox.contains(mouseX,mouseY)) {
            this.speedModifier++;
            changeSpeedDirection();
        }
    }
    private class TimerAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Whenever the timer fires a tick event, this method is called, which in turn calls our "drive" method.
            moveBalls();
        }
    }
}
