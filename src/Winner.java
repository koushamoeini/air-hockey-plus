import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Winner implements ActionListener {
    JFrame win=new JFrame();
    JButton ok = new JButton();
    JLabel winner = new JLabel();

    Winner() {
        Font font = new Font("MV Boli", Font.BOLD, 36);
        Border border = BorderFactory.createLineBorder(Color.black);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setResizable(false);
        win.setTitle("AirHokey+");
        win.setSize(400, 680);
        win.setLayout(null);
        win.setLocationRelativeTo(null);
        win.getContentPane().setBackground(Color.black);
        //////////////////////////////////////////////////////////////
        if (GameFrame.isRedWinner)
            winner.setText("Red won");
        else winner.setText("Blue won");
        winner.setBounds(100, 200, 240, 60);
        winner.setFocusable(false);
        winner.setFont(font);
        winner.setForeground(Color.WHITE);
        winner.setBackground(Color.BLACK);
        winner.setBorder(border);
        win.add(winner);
        //////////////////////////////////////////////////////////////
        ok.setText("Ok");
        ok.setBounds(70, 350, 260, 60);
        ok.setFocusable(false);
        ok.setFont(font);
        ok.setForeground(Color.WHITE);
        ok.setBackground(Color.BLACK);
        ok.addActionListener(this);
        ok.setBorder(border);
        win.add(ok);
        win.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ok){
            Main.history.history.add(History.addLabel(new OneHistory(TimeDetails.redName,TimeDetails.blueName,GameFrame.redScoreHistory,GameFrame.blueScoreHistory,SelectMode.isGoal,SelectMode.isTime,true)));
            Main.history.history.add(History.addLabel2(new OneHistory(TimeDetails.redName,TimeDetails.blueName,GameFrame.redScoreHistory,GameFrame.blueScoreHistory,SelectMode.isGoal,SelectMode.isTime,true)));
           new MainMenu();
            win.dispose();
        }
    }
}
