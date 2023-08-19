import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener {
    JFrame frame;
    JButton jb1, jb2;
    JTextField jt1;

    Login() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }

        frame = new JFrame();
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setSize(1200, 600);
        frame.setLocation(200, 100);
        frame.setLayout(null);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image = new JLabel(icon);
        image.setBounds(0, 0, 600, 600);
        frame.add(image);

        JLabel heading = new JLabel("Simple Minds");
        heading.setBounds(750, 100, 400, 40);
        heading.setFont(new Font("MV Boli", Font.BOLD, 40));
        heading.setForeground(Color.BLUE);
        frame.add(heading);

        JLabel name = new JLabel("Name: ");
        name.setBounds(700, 200, 150, 30);
        name.setFont(new Font("MV Boli", Font.BOLD, 20));
        frame.add(name);

        jt1 = new JTextField();
        jt1.setBounds(800, 200, 300, 30);
        jt1.setFont(new Font("Mongolia Baiti", Font.BOLD, 18));
        frame.add(jt1);

        jb1 = new JButton("Rules");
        jb1.setBounds(750, 350, 100, 40);
        jb1.setBackground(Color.green);
        jb1.setForeground(Color.BLACK);
        jb1.addActionListener(this);
        frame.add(jb1);

        jb2 = new JButton("Cancel");
        jb2.setBounds(1000, 350, 100, 40);
        jb2.setBackground(Color.red);
        jb2.setForeground(Color.BLACK);
        jb2.addActionListener(this);
        frame.add(jb2);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String name = jt1.getText();
        if (e.getSource() == jb1) {
            if (name.equals(""))
                JOptionPane.showMessageDialog(frame, "Name Missing");
            else {
                new Rules(name);
                frame.setVisible(false);
            }
        } else {
            frame.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
