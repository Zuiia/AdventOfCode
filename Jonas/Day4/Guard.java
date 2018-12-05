package Day4;

public class Guard {
    private final int ID;
    private int[] sleep = new int[60];
    private boolean awake = true;
    private int lastChange;

    public Guard(int id) {
        this.ID = id;
    }

    public int getID() {
        return ID;
    }

    public void change(int min) {
        if (awake) {
            awake = false;
            lastChange = min;
        } else {
            awake = true;
            for (int i = lastChange; i < min; i++) sleep[i]++;
        }
    }

    public int getTotalSleep() {
        int total = 0;

        for (int s : sleep) {
            total += s;
        }

        return total;
    }

    public int getMaxSleep() {
        int max = 0;
        int maxVal = 0;

        for (int i = 0; i < sleep.length; i++) {
            if (sleep[i] > maxVal) {
                max = i;
                maxVal = sleep[i];
            }
        }

        return max;
    }

    public void setAwake(boolean awake) {
        this.awake = awake;
    }

    public boolean isAwake() {
        return awake;
    }
}
