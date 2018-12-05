package Day4;

public class GuardListEntry {
    private int year;
    private int month;
    private int day;

    private int minute;

    private String text;

    public GuardListEntry(String entry) {
        this.year = Integer.parseInt(entry.substring(1,5));
        this.month = Integer.parseInt(entry.substring(6,8));
        this.day = Integer.parseInt(entry.substring(9,11));
        this.minute = Integer.parseInt(entry.substring(15,17));
        this.text = entry.substring(19);
    }

    @Override
    public String toString() {
        return "GuardListEntry{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", minute=" + minute +
                ", text='" + text + '\'' +
                '}';
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /*@Override
    public int compareTo(Object o) {
        GuardListEntry toTest = (GuardListEntry) o;

        if (toTest.year > this.year) {
            return 1;
        } else if (toTest.year == this.year) {

            if (toTest.month > this.month) {
                return 1;
            } else if (toTest.month == this.month) {

                if (toTest.day > this.day) {
                    return 1;
                } else if (toTest.day == this.day) {

                    if (toTest.minute > this.minute) {
                        return 1;
                    } else if (toTest.minute == this.minute) {

                        return 0;

                    } else return -1;

                } else return -1;

            } else return -1;

        } else return -1;
    }*/
}
