import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements ActionListener{
    JFrame mainMenu=new JFrame();
    JButton selectMode;
    JButton exit;
    JButton history;
    MainMenu() {
        Font font=new Font("MV Boli", Font.BOLD,36);
        Border border=BorderFactory.createLineBorder(Color.black);
        //////////////////////////////////////////////////////////////
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setResizable(false);
        mainMenu.setTitle("AirHokey+");
        mainMenu.setSize(400, 680);
        mainMenu.setLayout(null);
        mainMenu.setLocationRelativeTo(null);
        mainMenu.getContentPane().setBackground(Color.BLACK);
        //////////////////////////////////////////////////////////////
        selectMode=new JButton();
        selectMode.setText("Select mode");
        selectMode.setBounds(80,125,240,60);
        selectMode.setFocusable(false);
        selectMode.setFont(font);
        selectMode.setForeground(Color.WHITE);
        selectMode.setBackground(Color.BLACK);
        selectMode.setBorder(border);
        selectMode.addActionListener(this);
        mainMenu.add(selectMode);
        //////////////////////////////////////////////////////////////
        history=new JButton();
        history.setText("History");
        history.setBounds(80,310,240,60);
        history.setFocusable(false);
        history.setFont(font);
        history.setForeground(Color.WHITE);
        history.setBackground(Color.BLACK);
        history.setBorder(border);
        history.addActionListener(this);
        mainMenu.add(history);
        //////////////////////////////////////////////////////////////
        exit=new JButton();
        exit.setText("Exit Game");
        exit.setBounds(80,495,240,60);
        exit.setFocusable(false);
        exit.setFont(font);
        exit.setForeground(Color.WHITE);
        exit.setBackground(Color.BLACK);
        exit.setBorder(border);
        exit.addActionListener(this);
        mainMenu.add(exit);
        //////////////////////////////////////////////////////////////
        mainMenu.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==selectMode){
            SelectMode selectMode=new SelectMode();
            mainMenu.dispose();
        }
        if(e.getSource()==exit){
            System.exit(0);
        }
        if(e.getSource()==history) {
            Main.history.history.setVisible(true);
            mainMenu.dispose();
        }
    }
}
