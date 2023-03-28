import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel implements BallObserver, ActionListener {
    private JLabel label;
    private JButton button;
    private Ball ball;
    private boolean status ;

    public ControlPanel(Ball ball){
        status = true;
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
        if (status){
            button.setText("Stop");
            status = false;
        }else if (!status ){
            button.setText("Start");
            status = true;
        }
    }

    public JLabel getLabel(){
        return label;
    }

    public JButton getButton(){
        return button;
    }

    public boolean getStatus(){
        return status;
    }
}
