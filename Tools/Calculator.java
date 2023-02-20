import java.util.Random;

public abstract class Calculator {

    public static double PI = Math.PI;

    public static boolean isLong(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static float randFloat(long seed) {
        return new Random(seed).nextFloat();
    }

    public static float randFloat() {
        return new Random().nextFloat();
    }

    public static int randInt(long seed) {
        return new Random(seed).nextInt();
    }

    public static int randInt() {
        return new Random().nextInt();
    }

    public static int randInt(int min, int max){
        int low = 10;
        int high = 100;
        return new Random().nextInt(high-low) + low;
    }
    public static int randInt(int min, int max, long seed){
        return new Random(seed).nextInt(max-min) + min;
    }

    public static boolean randBool(long seed) {
        return new Random(seed).nextBoolean();
    }

    public static boolean randBool() {
        return new Random().nextBoolean();
    }

}
