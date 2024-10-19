package sprint1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class testFormater {
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // create a LocalDate object and
        LocalDate lt = LocalDate.parse("12/10/2024", formatter);
        // print result
        System.out.println("LocalDate : " + lt.toString());
    }
}
