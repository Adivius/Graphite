import java.text.SimpleDateFormat;

public abstract class Logg {

    public static void log (String log){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:s ");
        String time = simpleDateFormat.format(System.currentTimeMillis());
        System.out.println(time + log);
    }

}
