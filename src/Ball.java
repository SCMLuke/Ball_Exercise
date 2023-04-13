import java.awt.*;

public class Ball {
    int ballSize = 10;
    Color ballColour = Color.BLUE;
    int xPosition;
    int yPosition;
    int xSpeed = 5;

    public Ball(int ballSize, Color ballColour, int xPosition, int yPosition) {
        this.ballSize = ballSize;
        this.ballColour = ballColour;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getBallSize() {
        return ballSize;
    }

    public void setBallSize(int ballSize) {
        this.ballSize = ballSize;
    }

    public Color getBallColour() {
        return ballColour;
    }

    public void setBallColour(Color ballColour) {
        this.ballColour = ballColour;
    }

    public void drawGraphics(Graphics ball) {
        ball.setColor(this.ballColour);
        ball.fillOval(this.xPosition,this.yPosition,this.ballSize,this.ballSize);
    }

    public void moveBall() {
        this.setxPosition(this.getxPosition()+this.getxSpeed());
    }
}
