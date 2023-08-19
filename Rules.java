import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Rules implements ActionListener {
    JFrame frame;
    JButton jb1, jb2;
    String name;

    Rules(String name) {
        this.name = name;
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }

        frame = new JFrame();
        frame.getContentPane().setBackground(Color.white);
        frame.setSize(1200, 600);
        frame.setLocation(200, 100);
        frame.setLayout(null);

        JLabel heading = new JLabel("Welcome " + name + " To Simple Minds");
        heading.setBounds(50, 50, 1000, 40);
        heading.setFont(new Font("MV Boli", Font.BOLD, 40));
        heading.setForeground(Color.BLUE);
        frame.add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(30, 80, 850, 400);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 18));
        rules.setText("<html>" + "<br><br>" +
                "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
                "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer"
                + "<br><br>" +
                "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
                "4. Crying is allowed but please do so quietly." + "<br><br>" +
                "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di"
                + "<br><br>" +
                "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
                "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
                "<html>");
        frame.add(rules);

        jb1 = new JButton("Start");
        jb1.setBounds(450, 500, 100, 40);
        jb1.setBackground(Color.green);
        jb1.setForeground(Color.BLACK);
        jb1.addActionListener(this);
        frame.add(jb1);

        jb2 = new JButton("Back");
        jb2.setBounds(600, 500, 100, 40);
        jb2.setBackground(Color.red);
        jb2.setForeground(Color.BLACK);
        jb2.addActionListener(this);
        frame.add(jb2);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1) {
            new Quiz(name);
            frame.setVisible(false);
        } else {
            new Login();
            frame.setVisible(false);
        }
    }
}
