import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class Ball extends JPanel implements ActionListener {
    private int x = 70;
    private int y = 50;
    private int xSpeed = 2;
    private int ySpeed = 2;
    private final int diameter = 20;
    private int ballCnt = 0;
    private boolean status;
    private List<BallObserver> observers = new ArrayList<>();

    public Ball(){
        status = false;
    }
    public void paintComponent(Graphics g){
        g.setColor(Color.BLUE);
        g.fillOval(x, y, diameter, diameter);
    }


    public void moveBall() {

        x += xSpeed;
        y += ySpeed;
        if (x < 0 || x > getWidth() - diameter) {
            xSpeed = -xSpeed;
            ballCnt++;
            notifyObservers();
        }
        if (y < 0 || y > getHeight() - diameter) {
            ySpeed = -ySpeed;
            ballCnt++;
            notifyObservers();
        }


    }

    public void notifyObservers() {
        for (BallObserver observer : observers){
            observer.update(ballCnt);
        }
    }

    public void attach(BallObserver observer){
        observers.add(observer);
    }

    public void detach(BallObserver observer){
        observers.remove(observer);
    }

    public boolean getStatus(){
        return status;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
