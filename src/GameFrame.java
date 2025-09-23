import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.zip.ZipEntry;

public class GameFrame extends JFrame implements ActionListener, KeyListener {
    GamePanel gamePanel;
    Random rand = new Random();
    int counter1 = TimeDetails.time * 80;
    int goal = TimeDetails.goal;
    boolean is2Margin = TimeDetails.is2Margin;
    static boolean isRedWinner;
    //////////////////////////////////////////////////////////////ball
    static Timer timer;
    int counter = 0;
    boolean isCollision = false;
    double normalVelocity = 6;
    double maxVelocity = Math.sqrt(2 * Math.pow(normalVelocity, 2));
    double xVelocity = (rand.nextInt(3) - 1) * (normalVelocity - 4);
    double yVelocity = (rand.nextInt(3) - 1) * (normalVelocity - 4);
    int xBall = 190;
    int yBall = 375;
    int rBall = 40;
    //////////////////////////////////////////////////////////////bluePlayer
    int xBlue = 175;
    int yBlue = 105;
    int rBlue = 65;
    int blueScore = 0;
    static int blueScoreHistory;
    //////////////////////////////////////////////////////////////redPlayer
    int xRed = 175;
    int yRed = 630;
    int rRed = 65;
    int redScore;
    static int redScoreHistory;
    //////////////////////////////////////////////////////////////prize
    Color color = Color.black;
    int rPrize = 40;
    int xPrize;
    int yPrize;
    boolean isFinalRed;
    int xMaxGoalBlue = 290;
    int xMinGoalBlue = 115;
    int xMaxGoalRed = 290;
    int xMinGoalRed = 115;
    boolean CollisionBlue = true;
    boolean CollisionRed = true;
    Color ballColor=Color.WHITE;
    boolean mirrorWall=false;

    GameFrame() {
        gamePanel = new GamePanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(gamePanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.addKeyListener(this);
        this.setVisible(true);
        //////////////////////////////////////////////////////////////ball
        timer = new Timer(1, this);
        //TODO
        timer.start();

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        //////////////////////////////////////////////////////////////prize
        g2D.setColor(color);
        if (color != Color.ORANGE) {
            xPrize = rand.nextInt(180) + 80;
            yPrize = rand.nextInt(300) + 200;
        }
        g2D.drawOval(xPrize, yPrize, rPrize, rPrize);
        g2D.fillOval(xPrize, yPrize, rPrize, rPrize);
        //////////////////////////////////////////////////////////////ball
        g2D.setColor(ballColor);
        g2D.setStroke(new BasicStroke(10));
        g2D.drawOval(xBall, yBall, rBall, rBall);
        g2D.setStroke(new BasicStroke(0));
        g2D.setColor(ballColor);
        g2D.fillOval(xBall, yBall, rBall, rBall);
        //////////////////////////////////////////////////////////////bluePlayer
        g2D.setColor(Color.BLUE);
        g2D.drawOval(xBlue, yBlue, rBlue, rBlue);
        g2D.fillOval(xBlue, yBlue, rBlue, rBlue);
        //////////////////////////////////////////////////////////////redPlayer
        g2D.setColor(Color.RED);
        g2D.drawOval(xRed, yRed, rRed, rRed);
        g2D.fillOval(xRed, yRed, rRed, rRed);
        //////////////////////////////////////////////////////////////
        g2D.setColor(Color.BLUE);
        g2D.setStroke(new BasicStroke(5));
        g2D.drawLine(xMinGoalBlue, 95, xMaxGoalBlue, 95);
        g2D.setColor(Color.RED);
        g2D.drawLine(xMinGoalRed, 706, xMaxGoalRed, 706);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(true);
        isWin();
        if (isPrize()) {
            counter=0;
            int randomPrize = rand.nextInt(3);
            if (randomPrize == 0) {
                fireBall();
            }
            if (randomPrize == 1) {
                mirrorWall();
            }
            if (randomPrize == 2) {
                biggerGoal();
            }
        }
        isCollision = false;
        if (xBall < xMaxGoalRed - rBall && xBall > xMinGoalRed && yBall > 703 - rBall) {
            blueScore++;
            xVelocity = 0;
            yVelocity = 0;
            xBall = 190;
            yBall = 475;
            xBlue = 175;
            yBlue = 105;
            xRed = 175;
            yRed = 630;
            xMinGoalRed=115;
            xMaxGoalRed = 280;
            xMinGoalBlue=115;
            xMaxGoalBlue = 280;
            counter = 0;
            ballColor=Color.WHITE;
            CollisionBlue=true;
            CollisionRed=true;
            normalVelocity=6;
            maxVelocity = Math.sqrt(2 * Math.pow(normalVelocity, 2));
        }
        if (xBall < xMaxGoalBlue - rBall && xBall > xMinGoalBlue && yBall < 112) {
            redScore++;
            xVelocity = 0;
            yVelocity = 0;
            xBall = 190;
            yBall = 275;
            xBlue = 175;
            yBlue = 105;
            xRed = 175;
            yRed = 630;
            xMinGoalRed=115;
            xMaxGoalRed = 280;
            xMinGoalBlue=115;
            xMaxGoalBlue = 280;
            counter = 0;
            ballColor=Color.WHITE;
            CollisionBlue=true;
            CollisionRed=true;
            normalVelocity=6;
            maxVelocity = Math.sqrt(2 * Math.pow(normalVelocity, 2));
        }
        if (xBall > 410 - rBall) {
            xVelocity *= -1;
            xBall = 411 - rBall;
            if(mirrorWall){
                mirrorWall=false;
                ballColor=Color.BLACK;
            }else ballColor=Color.WHITE;
        }
        if (xBall < 10) {
            xBall = 11;
            xVelocity *= -1;
            if(mirrorWall){
                mirrorWall=false;
                ballColor=Color.BLACK;
            }else ballColor=Color.WHITE;
        }
        else if (yBall > 705 - rBall) {
            yBall = 706 - rBall;
            yVelocity *= -1;
            if(mirrorWall){
                mirrorWall=false;
                ballColor=Color.BLACK;
            }else ballColor=Color.WHITE;
        }
        else if (yBall < 110) {
            yBall = 111;
            yVelocity *= -1;
            if(mirrorWall){
                mirrorWall=false;
                ballColor=Color.BLACK;
            }else ballColor=Color.WHITE;
        }
        if (!isCollision) {
            //////////////////////////////////////////////////////////////bluePlayer
            if (CollisionBlue) {
                if (Math.pow(rBall / 2 + rBlue / 2, 2) >= (Math.pow((2 * xBall + rBall) / 2 - (2 * xBlue + rBlue) / 2, 2) + Math.pow((2 * yBall + rBall) / 2 - (2 * yBlue + rBlue) / 2, 2))) {
                    double zB = Math.toDegrees(Math.atan(((double) (2 * yBall + rBall) - (2 * yBlue + rBlue)) / ((2 * xBall + rBall) - (2 * xBlue + rBlue))));
                    if (zB < 22.5 && zB >= 0 && xBall >= xBlue && yBall <= yBlue) {
                        xVelocity = maxVelocity;
                        yVelocity = 0;
                    }
                    if (zB <= 67.5 && zB >= 22.5 && xBall >= xBlue && yBall <= yBlue) {
                        xVelocity = normalVelocity;
                        yVelocity = normalVelocity;
                    }
                    if (zB < 90 && zB > 67.5 && xBall >= xBlue && yBall <= yBlue) {
                        xVelocity = 0;
                        yVelocity = maxVelocity;
                    }
                    if (zB < 22.5 && zB >= 0 && xBall <= xBlue && yBall <= yBlue) {
                        xVelocity = -maxVelocity;
                        yVelocity = 0;
                    }
                    if (zB <= 67.5 && zB >= 22.5 && xBall <= xBlue && yBall <= yBlue) {
                        xVelocity = -normalVelocity;
                        yVelocity = normalVelocity;
                    }
                    if (zB < 90 && zB > 67.5 && xBall <= xBlue && yBall <= yBlue) {
                        xVelocity = 0;
                        yVelocity = maxVelocity;
                    }
                    if (zB < 22.5 && zB >= 0 && xBall >= xBlue && yBall >= yBlue) {
                        xVelocity = maxVelocity;
                        yVelocity = 0;
                    }
                    if (zB <= 67.5 && zB >= 22.5 && xBall >= xBlue && yBall >= yBlue) {
                        xVelocity = normalVelocity;
                        yVelocity = -normalVelocity;
                    }
                    if (zB < 90 && zB > 67.5 && xBall >= xBlue && yBall >= yBlue) {
                        xVelocity = 0;
                        yVelocity = -maxVelocity;
                    }
                    if (zB < 22.5 && zB >= 0 && xBall <= xBlue && yBall >= yBlue) {
                        xVelocity = -maxVelocity;
                        yVelocity = 0;
                    }
                    if (zB <= 67.5 && zB >= 22.5 && xBall <= xBlue && yBall >= yBlue) {
                        xVelocity = -normalVelocity;
                        yVelocity = -normalVelocity;
                    }
                    if (zB < 90 && zB > 67.5 && xBall <= xBlue && yBall >= yBlue) {
                        xVelocity = 0;
                        yVelocity = -maxVelocity;
                    }
                    isFinalRed = false;
                    isCollision = true;
                }
            }
            //////////////////////////////////////////////////////////////redPlayer
            if (CollisionRed) {
                if (Math.pow(rBall / 2 + rRed / 2, 2) >= (Math.pow((2 * xBall + rBall) / 2 - (2 * xRed + rRed) / 2, 2) + Math.pow((2 * yBall + rBall) / 2 - (2 * yRed + rRed) / 2, 2))) {
                    double zR = Math.toDegrees(Math.atan(((double) (2 * yBall + rBall) - (2 * yRed + rRed)) / ((2 * xBall + rBall) - (2 * xRed + rRed))));
                    if (zR < 22.5 && zR >= 0 && xBall > xRed && yBall < yRed) {
                        xVelocity = maxVelocity;
                        yVelocity = 0;
                    } else if (zR < 67.5 && zR >= 22.5 && xBall >= xRed && yBall <= yRed) {
                        xVelocity = normalVelocity;
                        yVelocity = normalVelocity;
                    } else if (zR < 90 && zR >= 67.5 && xBall >= xRed && yBall <= yRed) {
                        xVelocity = 0;
                        yVelocity = maxVelocity;
                    } else if (zR < 22.5 && zR >= 0 && xBall <= xRed && yBall <= yRed) {
                        xVelocity = -maxVelocity;
                        yVelocity = 0;
                    } else if (zR < 67.5 && zR >= 22.5 && xBall <= xRed && yBall <= yRed) {
                        xVelocity = -normalVelocity;
                        yVelocity = normalVelocity;
                    } else if (zR < 90 && zR >= 67.5 && xBall <= xRed && yBall <= yRed) {
                        xVelocity = 0;
                        yVelocity = maxVelocity;
                    } else if (zR < 22.5 && zR >= 0 && xBall >= xRed && yBall >= yRed) {
                        xVelocity = maxVelocity;
                        yVelocity = 0;
                    } else if (zR < 67.5 && zR >= 22.5 && xBall >= xRed && yBall >= yRed) {
                        xVelocity = normalVelocity;
                        yVelocity = -normalVelocity;
                    } else if (zR < 90 && zR >= 67.5 && xBall >= xRed && yBall >= yRed) {
                        xVelocity = 0;
                        yVelocity = -maxVelocity;
                    } else if (zR < 22.5 && zR >= 0 && xBall <= xRed && yBall >= yRed) {
                        xVelocity = -maxVelocity;
                        yVelocity = 0;
                    } else if (zR < 67.5 && zR >= 22.5 && xBall <= xRed && yBall >= yRed) {
                        xVelocity = -normalVelocity;
                        yVelocity = -normalVelocity;
                    } else if (zR < 90 && zR >= 67.5 && xBall <= xRed && yBall >= yRed) {
                        xVelocity = 0;
                        yVelocity = -maxVelocity;
                    }
                    isFinalRed = true;
                    isCollision = true;
                }
            }
        }
        xBall += xVelocity;
        yBall -= yVelocity;
        //////////////////////////////////////////////////////////////prize
        counter++;
        //////////////////////////////////////////////////////////////prize
        if (counter < 500) {
            color = Color.BLACK;
        }
        if (counter >= 500) {
            color = Color.ORANGE;
        }
        if (counter >= 900) {
            rPrize = 50;
        }
        if (counter >= 1300) {
            rPrize = 60;
        }
        if (counter >= 1800) {
            color = Color.ORANGE;
            counter = 0;
        }
        repaint();

    }

    public boolean isPrize() {
        if(color==Color.ORANGE) {
            if (Math.pow(rBall / 2 + rPrize / 2, 2) >= (Math.pow((2 * xBall + rBall) / 2 - (2 * xPrize + rRed) / 2, 2) + Math.pow((2 * yBall + rBall) / 2 - (2 * yPrize + rRed) / 2, 2))) {
                return true;
            }
        }
        return false;
    }

    public void fireBall() {
        if(isFinalRed){
            CollisionBlue=false;
        }
        else
            CollisionRed=false;
        normalVelocity=10;
        maxVelocity = Math.sqrt(2 * Math.pow(normalVelocity, 2));
    }

    public void biggerGoal() {
        if(isFinalRed){
            xMinGoalBlue=90;
            xMaxGoalBlue = 320;
        }
        else {
            xMinGoalRed = 90;
            xMaxGoalRed = 320;
        }
    }

    public void mirrorWall() {
        mirrorWall=true;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //////////////////////////////////////////////////////////////bluePlayer
        switch (e.getKeyChar()) {
            case 'a' -> {
                if (xBlue - 13 > 10) {
                    xBlue -= 13;
                    repaint();
                } else xBlue = 10;
            }
            case 'd' -> {
                if (xBlue + 13 < 340) {
                    xBlue += 13;
                    repaint();
                } else xBlue = 340;
            }
            case 'w' -> {
                if (yBlue - 13 > 95) {
                    yBlue -= 13;
                    repaint();
                } else yBlue = 95;
            }
            case 's' -> {
                if (yBlue + 13 < 331) {
                    yBlue += 13;
                    repaint();
                } else yBlue = 331;
            }
            //////////////////////////////////////////////////////////////redPlayer
            case '4' -> {
                if (xRed - 13 > 10) {
                    xRed -= 13;
                    repaint();
                } else xRed = 10;
            }
            case '6' -> {
                if (xRed + 13 < 340) {
                    xRed += 13;
                    repaint();
                } else xRed = 340;
            }
            case '8' -> {
                if (yRed - 13 > 403) {
                    yRed -= 13;
                    repaint();
                } else yRed = 403;
            }

            case '5' -> {
                if (yRed + 13 < 643) {
                    yRed += 13;
                    repaint();
                } else yRed = 643;
            }
            case '0' -> {
                this.setVisible(false);
                timer.stop();
                redScoreHistory = redScore;
                blueScoreHistory = blueScore;
                new ExitGame();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {


    }

    public void isWin() {
        counter1--;
        if (counter1 <= 0 && counter1 > -10000) {
            if (redScore >= blueScore)
                isRedWinner = true;
            redScoreHistory = redScore;
            blueScoreHistory = blueScore;
            new Winner();
            timer.stop();
            this.dispose();
        }
        if (is2Margin) {
            if (redScore >= goal && redScore - blueScore > 1) {
                isRedWinner = true;
                redScoreHistory = redScore;
                blueScoreHistory = blueScore;
                new Winner();
                timer.stop();
                this.dispose();
            }
            if (blueScore >= goal && blueScore - redScore > 1) {
                redScoreHistory = redScore;
                blueScoreHistory = blueScore;
                new Winner();
                timer.stop();
                this.dispose();
            }
        } else {
            if (redScore == goal) {
                isRedWinner = true;
                redScoreHistory = redScore;
                blueScoreHistory = blueScore;
                new Winner();
                timer.stop();
                this.dispose();
            }
            if (blueScore == goal) {
                redScoreHistory = redScore;
                blueScoreHistory = blueScore;
                new Winner();
                timer.stop();
                this.dispose();
            }
        }
    }
}

