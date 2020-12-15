import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int day1 = scanner.nextInt();
        int day2 = scanner.nextInt();
        int day3 = scanner.nextInt();

        Calendar calendar = new GregorianCalendar(year, Calendar.JANUARY, 0);
        calendar.add(Calendar.DAY_OF_YEAR, day1);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = format1.format(calendar.getTime());
        System.out.println(formatted);

        calendar.set(year, Calendar.JANUARY, 0);
        calendar.add(Calendar.DAY_OF_YEAR, day2);
        formatted = format1.format(calendar.getTime());
        System.out.println(formatted);

        calendar.set(year, Calendar.JANUARY, 0);
        calendar.add(Calendar.DAY_OF_YEAR, day3);
        formatted = format1.format(calendar.getTime());
        System.out.println(formatted);
    }
}
