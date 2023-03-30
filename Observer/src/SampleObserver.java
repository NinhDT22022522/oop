import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;


public class SampleObserver  {
    public void go(){
        Ball ball = new Ball();
        JFrame frameBall = new JFrame();
        ControlPanel controlPanel = new ControlPanel(ball);
        JFrame frameControlPanel = new JFrame();


        frameBall.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameBall.setSize(300, 300);
        frameBall.getContentPane().add(BorderLayout.CENTER, ball);

        frameBall.setVisible(true);

        frameControlPanel.getContentPane().add(BorderLayout.NORTH, controlPanel.getLabel());
        frameControlPanel.getContentPane().add(BorderLayout.SOUTH, controlPanel.getButton());
        frameControlPanel.setSize(300, 150);
        frameControlPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameControlPanel.setVisible(true);

        while(true){
            if (ball.getStatus()){
                ball.moveBall();
                frameBall.repaint();
            }
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        SampleObserver obs = new SampleObserver();
        obs.go();
    }
}