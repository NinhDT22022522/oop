import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

interface BallObserver{
    void update(int ballCnt);
}

public class Ball extends JPanel implements ActionListener {
    private int x = 0;
    private int y = 0;
    private int xSpeed = 2;
    private int ySpeed = 2;
    private int diameter = 20;
    private int ballCnt = 0;
    private List<BallObserver> observers = new ArrayList<>();

    public Ball(){

    }
    public void paintComponent(Graphics g){
        g.setColor(Color.BLUE);
        g.fillOval(20, 50, 20, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
        repaint();
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
}
