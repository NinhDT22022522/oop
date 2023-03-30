import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel implements BallObserver, ActionListener {
    private JLabel label;
    private JButton button;
    private Ball ball;


    public ControlPanel(Ball ball){

        label = new JLabel("Bounce 0");
        button = new JButton("Start");
        button.addActionListener(this);
        this.ball = ball;
        ball.attach(this);
    }
    @Override
    public void update(int ballCnt) {
        label.setText("Bounce " + ballCnt );
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!ball.getStatus()){
            button.setText("Stop");

            ball.setStatus(true);


        }else if (ball.getStatus()){
            button.setText("Start");

            ball.setStatus(false);


        }
    }

    public JLabel getLabel(){
        return label;
    }

    public JButton getButton(){
        return button;
    }


}