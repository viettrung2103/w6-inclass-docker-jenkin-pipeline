import java.util.ArrayList;
import java.util.List;

public class User {
    private static final int MINUTE = 1;
    private static final int HOUR = MINUTE * 60;
    private static final int DAY = HOUR * 24;
    private static final int MONTH = DAY * 30;
    private static final int YEAR = DAY * 365;
    private static final int SIXMONTH = MONTH * 6;

    private int startDate;
    private int curDate;
    private int endDate;
    private int totalPracticeTime; // in minute
    private int sessions;

    public User() {
        totalPracticeTime = 0;
        sessions = 0;
        startDate = 0;
    }

    // duration is in minutes
    public void addSession(String dateInput, int duration) {
        int dateToMinute = getToTalMinutes(dateInput);
        if (dateToMinute == 0) {
            return;
        }
        if (startDate == 0) {
            startDate = dateToMinute;
            endDate = startDate + SIXMONTH;
        }
        curDate = dateToMinute;
        totalPracticeTime += duration;
        sessions++;

    }

    public int findTotalTime() {
        return totalPracticeTime;
    }

    public boolean checkEligibility() {
        if (curDate > 0) {
            if (curDate >= endDate) {
                return true;
            }
            if (totalPracticeTime >= SIXMONTH) {
                return true;
            }
            if (sessions == 100) {
                return true;
            }

        }
        return false;
    }

    public int getToTalMinutes(String dateStr) {
        String[] dateArray = dateStr.trim().split("-");
        int yearVal = Integer.parseInt(dateArray[0]);
        int monthVal = Integer.parseInt(dateArray[1]);
        int dateVal = Integer.parseInt(dateArray[2]);
        if (yearVal <= 0 || monthVal > 12 || monthVal <= 0 || dateVal <= 0 || dateVal > 30) {
            System.out.println("You have input wrong date format");
            return 0;
        }
        return yearVal * YEAR + monthVal * MONTH + dateVal * DAY;
    }

    public int getCurDate(){
        return curDate;
    }

}
