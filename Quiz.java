import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String user_answer[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton op1, op2, op3, op4;
    ButtonGroup group;
    JButton next, lifeline, submit;
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    String name;

    Quiz(String name) {
        this.name = name;
        getContentPane().setBackground(Color.white);
        setSize(1440, 800);
        setLayout(null);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(icon);
        image.setBounds(0, 0, 1440, 392);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        questions[0][0] = "Which is used to find and fix bugs in the Java programs?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as_____________";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        op1 = new JRadioButton();
        op1.setBounds(170, 520, 900, 30);
        op1.setBackground(Color.white);
        op1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(op1);

        op2 = new JRadioButton();
        op2.setBounds(170, 560, 900, 30);
        op2.setBackground(Color.white);
        op2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(op2);

        op3 = new JRadioButton();
        op3.setBounds(170, 600, 900, 30);
        op3.setBackground(Color.white);
        op3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(op3);

        op4 = new JRadioButton();
        op4.setBounds(170, 640, 900, 30);
        op4.setBackground(Color.white);
        op4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(op4);

        group = new ButtonGroup();
        group.add(op1);
        group.add(op2);
        group.add(op3);
        group.add(op4);

        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(Color.green);
        next.setForeground(Color.BLUE);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 Life-Line");
        lifeline.setBounds(1100, 630, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(Color.yellow);
        lifeline.setForeground(Color.BLUE);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(Color.red);
        submit.setForeground(Color.BLUE);
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);

        start(count);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        super.paint(g);
        String time = "Time Left: " + timer + " seconds";
        g.setColor(Color.red);
        g.setFont(new Font("MV Boli", Font.BOLD, 25));

        if (timer > 0) {
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }
        timer--;
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            op1.setEnabled(true);
            op2.setEnabled(true);
            op3.setEnabled(true);
            op4.setEnabled(true);
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) {   //submit button
                if (group.getSelection() == null) {
                    user_answer[count][0] = " ";
                } else {
                    user_answer[count][0] = group.getSelection().getActionCommand();
                }
                for (int i = 0; i < user_answer.length; i++) {
                    if (user_answer[i][0].equals(answers[i][1])) {
                        score += 10;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else {    //next button
                if (group.getSelection() == null) {
                    user_answer[count][0] = " ";
                } else {
                    user_answer[count][0] = group.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }

    }

    public void start(int count) {
        qno.setText(" " + (count + 1) + ". ");
        question.setText(questions[count][0]);
        op1.setText(questions[count][1]);
        op1.setActionCommand(questions[count][1]);

        op2.setText(questions[count][2]);
        op2.setActionCommand(questions[count][2]);

        op3.setText(questions[count][3]);
        op3.setActionCommand(questions[count][3]);

        op4.setText(questions[count][4]);
        op4.setActionCommand(questions[count][4]);

        group.clearSelection();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            repaint();
            op1.setEnabled(true);
            op2.setEnabled(true);
            op3.setEnabled(true);
            op4.setEnabled(true);
            ans_given = 1;
            if (group.getSelection() == null) {
                user_answer[count][0] = " ";
            } else {
                user_answer[count][0] = group.getSelection().getActionCommand();
            }
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        } else if (e.getSource() == lifeline) {
            if (count == 1 || count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                op2.setEnabled(false);
                op3.setEnabled(false);
            } else {
                op1.setEnabled(false);
                op4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else {
            ans_given = 1;
            if (group.getSelection() == null) {
                user_answer[count][0] = " ";
            } else {
                user_answer[count][0] = group.getSelection().getActionCommand();
            }
            for (int i = 0; i < user_answer.length; i++) {
                if (user_answer[i][0].equals(answers[i][1])) {
                    score += 10;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }
}
