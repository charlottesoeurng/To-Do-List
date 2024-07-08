import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * a class that writes the todolist class with todoitem variables
 */
public class TodoList {
    /**
     * Initialize the arraylist of todoitem called thetasks
     */
    private static ArrayList<TodoItem> theTasks;
    /**
     * initialize a string for the username
     */
    private String username;

    /**
     * sets values for the username and the tasks arraylist
     * @param username of the person entering
     */
    public TodoList(String user) {
        username = user;
        theTasks = new ArrayList<TodoItem>();
    }
    /**
     * a method that writes the todolist class from the username input
     * @param username of the user
     * @return the todolist class
     */
    public static TodoList fromUsername(String user) {
        TodoList theTodo = new TodoList(user);
        try {
            List<String> theList = Files.readAllLines(Paths.get(user + ".txt"));
            for (int i = 0; i < theList.size(); i++) {
                String theItem = theList.get(i);
                TodoItem item = TodoItem.fromCsvString(theItem);
                theTodo.addTask(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return theTodo;
    }
    /**
     * a method that add tasks to the todolist
     * @param task to be added
     */
    public void addTask(TodoItem task) {
        theTasks.add(task);
    }
    /**
     * a method that gets the todo list by sorting by date
     * @return string of the sorted todo items
     */
    public String getAsDateSortedString() {
        theTasks.sort(new DateComparator());
        return toString();
    }
    /**
     * a method that gets the todo list by sorting by importance
     * @return string of the sorted todo items
     */
    public String getAsImportanceSortedString() {
        theTasks.sort(new ImportanceComparator());
        return toString();
    }
    /**
     * a method that saves the current todo list as a csv file
     * @throws IOException in case the file doesnt save
     */
    public void saveToFile() throws IOException {
        File theFile = new File(username);
        String csv = "";
        for (int i = 0; i < theTasks.size(); i ++) {
            csv = csv + theTasks.get(i).getAsCsvString() + '\n';
        }
        Path theCsvFile = Files.write(Paths.get(username + ".txt"), csv.getBytes());
    }
    /**
     * a method that writes the sorted string from getAsDateSortedString() or getAsImportanceSortedString()
     * into a string
     * @return the string that was written
     */
    public String toString() {
        String todoListString = "";
        for (int i = 0; i < theTasks.size(); i ++) {
            todoListString = todoListString + theTasks.get(i).toString() + '\n';
        }
        return todoListString;
    }
}

