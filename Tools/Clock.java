import java.text.SimpleDateFormat;

public class Clock {

    private long timerStart;
    private long timerStop;

    public Clock() {
        this.timerStart = 0L;
        this.timerStop = 0L;
    }

    public static void delay(long ms, int ns) {
        try {
            Thread.sleep(ms, ns);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delay(long ms) {
        delay(ms, 0);
    }

    public static String formatDate(long millis, String pattern) {
        return new SimpleDateFormat(pattern).format(millis);
    }

    public static String getDate() {
        return formatDate(System.currentTimeMillis(), "dd.MM.yyy");
    }

    public static String getTime() {
        return formatDate(System.currentTimeMillis(), "HH:mm");
    }

    public void timerStart() {
        this.timerStart = System.currentTimeMillis();
    }

    public void timerStop() {
        this.timerStop = System.currentTimeMillis();
    }

    public long getTimer() {
        return this.timerStop - this.timerStart;
    }
}
