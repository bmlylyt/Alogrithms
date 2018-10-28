import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Tests {
    public static void main(String[] args) {
        char[][] test = new char[4][4];
        Arrays.fill(test[0], '.');
        System.out.println(Arrays.toString(test[0]));
    }
}
class Date {
    //fields
    private int YEAR;
    private int MONTH;
    private int DAY;

    //methods
    public Date(int year, int month, int day) {
        this.YEAR = year;
        this.MONTH = month % 13;
        this.DAY = day % 31;
    }
    public void roll(int num) {
        if (DAY + num > 30) {
            DAY = (DAY + num) % 31;
            MONTH ++;
        }
        if (MONTH > 12) {
            MONTH = 0;
            YEAR ++;
        }
    }
    public void printDate() {
        System.out.println(MONTH + "/" + DAY + "/" + YEAR);
    }

}


