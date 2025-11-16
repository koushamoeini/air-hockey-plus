import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class History extends JFrame implements ActionListener, KeyListener
{
    static JFrame history=new JFrame();
    static int y;
    static int x;
    int height=10;
    JButton back=new JButton();

    History() {
        //////////////////////////////////////////////////////////////
        history.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        history.setResizable(false);
        history.setTitle("AirHokey+");
        history.setSize(400, 680);
        history.setLayout(null);
        history.setLocationRelativeTo(null);
        history.getContentPane().setBackground(Color.BLACK);
        this.addKeyListener(this);
        Border border=BorderFactory.createLineBorder(Color.black);
        y=100;
        x=150;
        //////////////////////////////////////////////////////////////
        back.setText("Back");
        back.setBounds(80,0,240,60);
        back.setFocusable(false);
        back.setFont(new Font("MV Boli", Font.BOLD,36));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBorder(border);
        back.addActionListener(this);
        history.add(back);
        history.setVisible(true);
    }
    public static Component addLabel(OneHistory oneHistory){
        Label label=new Label();
        Font font=new Font("MV Boli", Font.BOLD,14);
        label.setText("red: "+oneHistory.redName+" | blue: "+oneHistory.blueName+" | isFinished: "+oneHistory.isFinish);
        label.setBounds(0,y,400,60);
        y+=150;
        label.setFocusable(false);
        label.setFont(font);
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
        history.add(label);
        return label;
    }
    public static Component addLabel2(OneHistory oneHistory){
        Label label=new Label();
        Font font=new Font("MV Boli", Font.BOLD,14);
        label.setText("Red : "+oneHistory.redGoal+" | Blue : "+oneHistory.blueGoal+" | goal mode: "+oneHistory.isGoal+" | time mode: "+oneHistory.isTime);
        label.setBounds(0,x,400,60);
        x+=150;
        label.setFocusable(false);
        label.setFont(font);
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
        history.add(label);
        return label;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back) {
            new MainMenu();
            Main.history.history.setVisible(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

        switch (e.getKeyChar()) {
            case 'w' -> {
                if (height > 0) {
                    Main.history.history.setBounds(0, height--, 400, 680);
                }
            }
            case 's' -> {
                if (height < 680) {
                    Main.history.history.setBounds(0, height++, 400, 680);
                }
            }
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}