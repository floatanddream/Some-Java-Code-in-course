package DateCal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("今天是：" + today);
        for (int i = 1; i <= 100; i++) {
            LocalDate futureDate = today.plusDays(i);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
            String formattedDate = futureDate.format(formatter);
            System.out.println(i+"天以后是：" + formattedDate);
        }
    }
}
