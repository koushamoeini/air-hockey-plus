import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitGame extends JFrame implements ActionListener {
    JFrame exitGame = new JFrame();
    JButton play;
    JButton exit;

    ExitGame() {
        Font font = new Font("MV Boli", Font.BOLD, 36);
        Border border = BorderFactory.createLineBorder(Color.black);
        //////////////////////////////////////////////////////////////
        exitGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        exitGame.setResizable(false);
        exitGame.setTitle("AirHokey+");
        exitGame.setSize(400, 680);
        exitGame.setLayout(null);
        exitGame.setLocationRelativeTo(null);
        exitGame.getContentPane().setBackground(Color.BLACK);
        //////////////////////////////////////////////////////////////
        exit = new JButton();
        exit.setText("Exit");
        exit.setBounds(80, 200, 240, 60);
        exit.setFocusable(false);
        exit.setFont(font);
        exit.setForeground(Color.WHITE);
        exit.setBackground(Color.BLACK);
        exit.setBorder(border);
        exit.addActionListener(this);
        exitGame.add(exit);
        //////////////////////////////////////////////////////////////
        play = new JButton();
        play.setText("Play");
        play.setBounds(80, 350, 240, 60);
        play.setFocusable(false);
        play.setFont(font);
        play.setForeground(Color.WHITE);
        play.setBackground(Color.BLACK);
        play.setBorder(border);
        play.addActionListener(this);
        exitGame.add(play);
        exitGame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            Main.history.history.add(History.addLabel(new OneHistory(TimeDetails.redName,TimeDetails.blueName,GameFrame.redScoreHistory,GameFrame.blueScoreHistory,SelectMode.isGoal,SelectMode.isTime,false)));
            Main.history.history.add(History.addLabel2(new OneHistory(TimeDetails.redName,TimeDetails.blueName,GameFrame.redScoreHistory,GameFrame.blueScoreHistory,SelectMode.isGoal,SelectMode.isTime,false)));
            new MainMenu();
            exitGame.dispose();
        }
        if(e.getSource()==play){
            GameFrame.timer.start();
            exitGame.dispose();
        }
    }
}