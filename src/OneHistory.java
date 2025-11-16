import javax.swing.*;

public class OneHistory {
    String redName;
    String blueName;
    int redGoal;
    int blueGoal;
    boolean isGoal;
    boolean isTime;
    boolean isFinish;

    public OneHistory(String redName, String blueName, int redGoal, int blueGoal, boolean isGoal, boolean isTime, boolean isFinish) {
        this.redName = redName;
        this.blueName = blueName;
        this.redGoal = redGoal;
        this.blueGoal = blueGoal;
        this.isGoal = isGoal;
        this.isTime = isTime;
        this.isFinish = isFinish;
    }
}
