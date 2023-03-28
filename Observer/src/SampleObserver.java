import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class SampleObserver  {
    private Ball ball ;
    private JFrame frameBall;
    private ControlPanel controlPanel;
    private JFrame frameControlPanel;
    public void go(){
        ball = new Ball();
        frameBall = new JFrame();
        controlPanel = new ControlPanel(ball);
        frameControlPanel = new JFrame();
        if (controlPanel.getStatus()){

        }

        frameBall.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameBall.setSize(300, 300);
        frameBall.getContentPane().add(BorderLayout.CENTER, ball);
        frameBall.setVisible(true);

        frameControlPanel.getContentPane().add(BorderLayout.NORTH, controlPanel.getLabel());
        frameControlPanel.getContentPane().add(BorderLayout.SOUTH, controlPanel.getButton());
        frameControlPanel.setSize(300, 150);
        frameControlPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameControlPanel.setVisible(true);
    }


    public static void main(String[] args) {
        SampleObserver obs = new SampleObserver();
        obs.go();
    }
}