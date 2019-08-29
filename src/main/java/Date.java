//import java.text.SimpleDateFormat;

public class Date {
    private int day;
    private int month;
    private int year;
    private int hour;
    private String minute;

    public Date(String dateAndTime) {
        String[] details = dateAndTime.split("[ /]");

        day = Integer.parseInt(details[0]);
        month = Integer.parseInt(details[1]);
        year = Integer.parseInt(details[2]);
        hour = Integer.parseInt(details[3].substring(0,2));
        minute = details[3].substring(2);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getHour() {
        return hour;
    }

    public String getMinute() {
        return minute;
    }

    public String getDayString() {
        if (day > 31) {
            System.out.println("Throw exception.");
            return null;
        }
        else if (day > 10 && day < 14) return Integer.toString(day) + "th";
        else if (day%10 == 1) return Integer.toString(day) + "st";
        else if (day%10 == 2) return Integer.toString(day) + "nd";
        else if (day%10 == 3) return Integer.toString(day) + "rd";
        else return Integer.toString(day) + "th";
    }

    public String getMonthString() {
        switch (month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                System.out.println("Throw an exception here.");
                return null;
        }
    }

    public String getTimeString() {
        if (hour > 12) {
            return Integer.toString(hour - 12) + ":" + minute + " pm";
        } else if (hour < 12) {
            return Integer.toString(hour) + ":" + minute + " am";
        } else if (hour == 12) {
            return "12:" + minute + " pm";
        } else {
            System.out.println("Throw some exception.");
            return null;
        }
    }

    public String returnFormattedDate() {
        return getDayString() + " of " + getMonthString() + " " + year + ", " + getTimeString();
    }

}
