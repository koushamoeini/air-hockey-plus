import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeDetails extends JFrame implements ActionListener {
    JFrame timeDetails = new JFrame();
    JTextField redTimeName = new JTextField();
    JTextField blueTimeName = new JTextField();
    Integer[] timesList = {30, 60, 90, 120, 150};
    Integer[] goalList = {3, 5, 7};
    JComboBox goalGoal = new JComboBox(goalList);
    JComboBox timeTime = new JComboBox(timesList);
    static int time = 0;
    static int goal = 0;
    static boolean is2Margin;
    static String redName;
    static String blueName;
    JButton backToSelectMode = new JButton();
    JButton startTimeGame = new JButton();
    JCheckBox twoMargin = new JCheckBox();

    TimeDetails() {
        Font font = new Font("MV Boli", Font.BOLD, 22);
        Font font1 = new Font("MV Boli", Font.BOLD, 36);
        Border border = BorderFactory.createLineBorder(Color.black);
        Border border1 = BorderFactory.createLineBorder(Color.WHITE, 2);
        //////////////////////////////////////////////////////////////
        timeDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        timeDetails.setResizable(false);
        timeDetails.setTitle("AirHokey+");
        timeDetails.setSize(400, 680);
        timeDetails.setLayout(null);
        timeDetails.setLocationRelativeTo(null);
        timeDetails.getContentPane().setBackground(Color.black);
        //////////////////////////////////////////////////////////////
        redTimeName.setBounds(10, 100, 180, 60);
        redTimeName.setFont(font);
        redTimeName.setText("Red Player");
        redTimeName.setCaretColor(Color.WHITE);
        redTimeName.setForeground(Color.WHITE);
        redTimeName.setBackground(Color.BLACK);
        redTimeName.setBorder(border1);
        timeDetails.add(redTimeName);
        //////////////////////////////////////////////////////////////
        blueTimeName.setBounds(210, 100, 170, 60);
        blueTimeName.setFont(font);
        blueTimeName.setText("Blue Player");
        blueTimeName.setCaretColor(Color.WHITE);
        blueTimeName.setForeground(Color.WHITE);
        blueTimeName.setBackground(Color.BLACK);
        blueTimeName.setBorder(border1);
        timeDetails.add(blueTimeName);
        //////////////////////////////////////////////////////////////
        timeTime.setBounds(200, 210, 120, 60);
        timeTime.setFont(font1);
        timeTime.setForeground(Color.WHITE);
        timeTime.setBackground(Color.BLACK);
        timeTime.setBorder(border1);
        timeDetails.add(timeTime);
        //////////////////////////////////////////////////////////////
        goalGoal.setBounds(80, 210, 95, 60);
        goalGoal.setFont(font1);
        goalGoal.setForeground(Color.WHITE);
        goalGoal.setBackground(Color.BLACK);
        goalGoal.setBorder(border1);
        timeDetails.add(goalGoal);
        //////////////////////////////////////////////////////////////
        startTimeGame.setText("Start Game");
        startTimeGame.setBounds(80, 330, 230, 60);
        startTimeGame.setFocusable(false);
        startTimeGame.setFont(font1);
        startTimeGame.setForeground(Color.WHITE);
        startTimeGame.setBackground(Color.BLACK);
        startTimeGame.setBorder(border);
        startTimeGame.addActionListener(this);
        timeDetails.add(startTimeGame);
        //////////////////////////////////////////////////////////////
        twoMargin.setText("Two Margin");
        twoMargin.setBounds(80, 425, 230, 60);
        twoMargin.setFocusable(false);
        twoMargin.setFont(font1);
        twoMargin.setForeground(Color.WHITE);
        twoMargin.setBackground(Color.BLACK);
        twoMargin.setBorder(border);
        twoMargin.addActionListener(this);
        timeDetails.add(twoMargin);
        //////////////////////////////////////////////////////////////
        backToSelectMode.setText("Back");
        backToSelectMode.setBounds(80, 515, 230, 60);
        backToSelectMode.setFocusable(false);
        backToSelectMode.setFont(font1);
        backToSelectMode.setForeground(Color.WHITE);
        backToSelectMode.setBackground(Color.BLACK);
        backToSelectMode.setBorder(border);
        backToSelectMode.addActionListener(this);
        timeDetails.add(backToSelectMode);
        //////////////////////////////////////////////////////////////
        if (!SelectMode.isTime)
            timeTime.setVisible(false);
        if (!SelectMode.isGoal)
            goalGoal.setVisible(false);
        timeDetails.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backToSelectMode) {
            new SelectMode();
            timeDetails.dispose();
        }
        if (e.getSource() == startTimeGame) {
            if (!SelectMode.isTime)
                time = -Integer.MAX_VALUE/1000;
            else
                time = (int) timeTime.getSelectedItem();
            if (!SelectMode.isGoal)
                goal = Integer.MAX_VALUE;
            else
                goal = (int) goalGoal.getSelectedItem();
            is2Margin = twoMargin.isSelected();
            redName=redTimeName.getText();
            blueName=blueTimeName.getText();
            new GameFrame();
            timeDetails.dispose();
        }
    }
}
