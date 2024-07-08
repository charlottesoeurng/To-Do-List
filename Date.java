
/**
 *  a class that writes date using month day and year
 */
public class Date {
    /**
     * initialize month
     */
    private int month;
    /**
     * initialize day
     */
    private int day;
    /**
     * initialize year
     */
    private int year;

    /**
     * a method that use integers month day year to form a date
     * @param month from the input
     * @param day from the input
     * @param year from the input
     */
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    /**
     * a method that uses a string of date to get the values of month day year
     * @param dateString to be used
     * @return thedate we got from the datestring
     */
    public static Date fromYYYYMMDD(String dateString) {
        int month;
        int day;
        int year;
        Date theDate;
        String splitYear = dateString.substring(0, 4);
        String splitMonth = dateString.substring(4, 6);
        String splitDay = dateString.substring(6);
        year = Integer.parseInt(splitYear);
        month = Integer.parseInt(splitMonth);
        day = Integer.parseInt(splitDay);
        theDate = new Date(month, day, year);
        return theDate;
    }

    /**
     * a method that turns a date string with dash into a date object
     * @param dateString with dashes that will be deleted
     * @return thedate from the datestring
     */
    public static Date fromDashString(String dateString) {
        int month;
        int day;
        int year;
        Date theDate;
        String[] noDash;
        noDash = dateString.split("-");
        year = Integer.parseInt(noDash[0]);
        month = Integer.parseInt(noDash[1]);
        day = Integer.parseInt(noDash[2]);
        theDate = new Date(month, day, year);
        return theDate;
    }

    /**
     * a method that turns a date object into an integer
     * @return that integer of dates
     */
    public int getAsYYYYMMDD() {
        String dateString = "";
        int dateInt;
        dateString = dateString + year;
        if (month < 10) {
            dateString = dateString + "0" + month;
        } else {
            dateString = dateString + month;
        }
        if (day < 10) {
            dateString = dateString + "0" + day;
        } else {
            dateString = dateString + day;
        }
        dateInt = Integer.parseInt(dateString);
        return dateInt;
    }

    /**
     * a method that checks if two dates are equal
     * @return true if equal, false if not
     */
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (this.getClass() != other.getClass()) {
            return false;
        }
        Date otherDate = (Date)other;
        if (this.getAsYYYYMMDD() == otherDate.getAsYYYYMMDD()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * a method that compares two datestrings
     * @param otherDateString to be compared
     * @return -1 if before, 0 if equal, 1 if after
     */
    public int compareTo(Date otherDateString) {
        Date other = otherDateString;
        if (equals(other) == true) {
            return 0;
        } else if(year < other.year ) {
            return -1;
        } else if (year == other.year) {
            if (month < other.month) {
                return -1;
            } else if (month == other.month) {
                if (day < other.day) {
                    return -1;
                } else if (day == other.day) {
                    return 0;
                }
            }
        } 
        return 1;
    }
    /**
     * a method that writes the date object into a string with "/"
     * @return date method that was written
     */
    public String toString() {
        String date = "";
        date = date + month + "/" + day + "/" + year;
        return date;
    }
}