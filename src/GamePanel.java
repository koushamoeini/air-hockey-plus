import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GamePanel extends JPanel {
    final int panelWidth = 400;
    final int panelHeight = 680;

    GamePanel() {
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setBackground(Color.BLACK);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.WHITE);
        g2D.setStroke(new BasicStroke(3));
        g2D.drawLine(0, 65, 410, 65);
        g2D.drawLine(0, 677, 410, 677);

    }
}
////////////////////////////////////////////////////progressBar

//timeBar();
/*public void timeBar(){
        int counter=TimeDetails.time;
        while (counter>=0){
            timeProgress.setValue(counter);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter--;
        }
    }*/
