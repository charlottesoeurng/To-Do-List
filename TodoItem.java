
/**
 * a class that writes each individual item in the todolist
 */
public class TodoItem {
    /**
     * initialize date
     */
    private Date date;
    /**
     * initialize string
     */
    private String description;
    /**
     * initialize importancelevel
     */
    private Importance importanceLevel;
    /**
     * a method that writes the todoitem class using date, description, and importance
     * @param d for date of the input
     * @param s for description of the input
     * @param i for importance of the input
     */
    public TodoItem(Date d, String s, Importance i) {
        this.date = d;
        this.description = s;
        this.importanceLevel = i;
    }
    /**
     * a method that gets todoitem from the csv
     * @param csvString that will be turned into a todo item
     * @return todo item that came from the csv string
     */
    public static TodoItem fromCsvString(String csvString){
        String[] splittedString = new String[3];
        if (csvString.contains(",")) {
            splittedString = csvString.split(",");
        }
        String dateString = splittedString[0];
        String description = splittedString[1];
        String importanceLevel = splittedString[2];
        Date theDate = Date.fromYYYYMMDD(dateString);
        Importance theImportance = Importance.valueOf(importanceLevel);
        TodoItem todo = new TodoItem(theDate, description, theImportance);
        return todo;		
    }
    /**
     * a method that turns todo item into a csv string
     * @return that csv string from the todo item
     */
    public String getAsCsvString() {
        String theCsvString = "";
        theCsvString = theCsvString + date.getAsYYYYMMDD() + "," + description + "," + getImportanceLevel();
        return theCsvString;
    }
    /**
     * a method that gets the date of the input
     * @return date from that input
     */
    public Date getDate() {
        return date;
    }
    /**
     * a method that gets importance level of the input
     * @return importance level from that input
     */
    public Importance getImportanceLevel() {
        return importanceLevel;
    }
    /** a method that gets description of the input
     * @return description from that input
     */
    public String getDescription() {
        return description;
    }
    /**
     *a method that writes the todo item into a string
     *@return string of the todo item
     */
    public String toString() {
        String theItemString = "";
        theItemString = theItemString + "*" + '\n';
        theItemString = theItemString + date.toString() + '\n';
        theItemString = theItemString + getImportanceLevel() + '\n';
        theItemString = theItemString + getDescription() + '\n';
        return theItemString;
    }
}
