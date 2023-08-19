import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame implements ActionListener {
    Score(String name, int score) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }
        getContentPane().setBackground(Color.white);
        setBounds(400, 150, 700, 550);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 200, 300, 250);
        add(image);

        JLabel headings = new JLabel("Thank you " + name + " for playing");
        headings.setBounds(45, 30, 700, 30);
        headings.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(headings);

        JLabel your_score = new JLabel("Your score is " + score);
        your_score.setBounds(350, 200, 300, 30);
        your_score.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(your_score);

        JButton submit = new JButton("Restart");
        submit.setBounds(380, 270, 120, 30);
        submit.addActionListener(this);
        add(submit);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
}
