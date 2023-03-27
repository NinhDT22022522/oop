import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SampleObserver implements ActionListener {
    private JButton button;
    public void go(){
        button = new JButton("Start");
        button.addActionListener(this);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (button.getText().equals("Start")){
            button.setText("Stop");
        }else if (button.getText().equals("Stop")){
            button.setText("Start");
        }

    }

    public static void main(String[] args) {
        SampleObserver obs = new SampleObserver();
        obs.go();

    }
}