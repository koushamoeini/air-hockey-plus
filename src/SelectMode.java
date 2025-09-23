import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectMode implements ActionListener {
    JFrame selectMode=new JFrame();
    JCheckBox timeLimited=new JCheckBox();
    JCheckBox goalLimited=new JCheckBox();
    JButton backToMainMenu=new JButton();
    JButton menuContinue=new JButton();
    static boolean isTime;
    static boolean isGoal;
    SelectMode(){
        Font font=new Font("MV Boli", Font.BOLD,36);
        Border border=BorderFactory.createLineBorder(Color.black);
        //////////////////////////////////////////////////////////////
        selectMode.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        selectMode.setResizable(false);
        selectMode.setTitle("AirHokey+");
        selectMode.setSize(400, 680);
        selectMode.setLayout(null);
        selectMode.setLocationRelativeTo(null);
        selectMode.getContentPane().setBackground(Color.black);
        //////////////////////////////////////////////////////////////(97,125,241,60);
        timeLimited.setText("Time Limited");
        timeLimited.setBounds(70,125,260,60);
        timeLimited.setFocusable(false);
        timeLimited.setFont(font);
        timeLimited.setForeground(Color.WHITE);
        timeLimited.setBackground(Color.BLACK);
        timeLimited.setBorder(border);
        timeLimited.addActionListener(this);
        selectMode.add(timeLimited);
        //////////////////////////////////////////////////////////////(80,125,240,60);
        goalLimited.setText("Goal Limited");
        goalLimited.setBounds(70,250,270,60);
        goalLimited.setFocusable(false);
        goalLimited.setFont(font);
        goalLimited.setForeground(Color.WHITE);
        goalLimited.setBackground(Color.BLACK);
        goalLimited.setBorder(border);
        goalLimited.addActionListener(this);
        selectMode.add(goalLimited);
        //////////////////////////////////////////////////////////////
        menuContinue.setText("Continue");
        menuContinue.setBounds(80,370,240,60);
        menuContinue.setFocusable(false);
        menuContinue.setFont(font);
        menuContinue.setForeground(Color.WHITE);
        menuContinue.setBackground(Color.BLACK);
        menuContinue.setBorder(border);
        menuContinue.addActionListener(this);
        selectMode.add(menuContinue);
        //////////////////////////////////////////////////////////////
        backToMainMenu.setText("Back");
        backToMainMenu.setBounds(80,495,240,60);
        backToMainMenu.setFocusable(false);
        backToMainMenu.setFont(font);
        backToMainMenu.setForeground(Color.WHITE);
        backToMainMenu.setBackground(Color.BLACK);
        backToMainMenu.setBorder(border);
        backToMainMenu.addActionListener(this);
        selectMode.add(backToMainMenu);
        //////////////////////////////////////////////////////////////
        selectMode.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backToMainMenu){
            new MainMenu();
            selectMode.dispose();
        }
        if(e.getSource()==menuContinue){
            isTime=false;isGoal=false;
            if(goalLimited.isSelected()||timeLimited.isSelected()) {
                if(goalLimited.isSelected())
                    isGoal=true;
                if(timeLimited.isSelected())
                    isTime=true;
                TimeDetails timeDetails = new TimeDetails();
                selectMode.dispose();
            }
        }
    }
}
