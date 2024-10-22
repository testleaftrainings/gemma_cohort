package sprint1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utility {
    public static String getTmrwDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();
        String todayAsString = dateFormat.format(today);
        String tomorrowAsString = dateFormat.format(tomorrow);

        System.out.println(todayAsString);
        System.out.println(tomorrowAsString);
        return tomorrowAsString;
    }
    public static String getTmrwDatePluse(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 2);
        Date tomorrowPulseOne = calendar.getTime();
        String tomorrowPluseOneDateAsString = dateFormat.format(tomorrowPulseOne);
        System.out.println(tomorrowPluseOneDateAsString);
        return tomorrowPluseOneDateAsString;
    }
}
