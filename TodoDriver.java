
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * a class that initializes the menu for the todolist
 */
public class TodoDriver {

    public static void main(String[] args) throws IOException{
        System.out.println("Welcome to the TodoList application.");
        System.out.print("Enter your username: ");
        Scanner keyboard = new Scanner(System.in);
        String username = keyboard.nextLine();
        String userFile = username + ".txt";
        File theFile = new File(userFile);
        TodoList theTodoList;
        if (theFile.exists() == false) {
            theTodoList = new TodoList(username);
            System.out.println("An error occurred trying to read the file for your username.");
            System.out.print("Create new Todo List? (Y/N) ");
            String stringOption = keyboard.nextLine();
            if (stringOption.equals("Y") == false) {
                System.exit(0);
            }
        }
        else {
            theTodoList = TodoList.fromUsername(username);
        }
        boolean menu = true;
        while (menu == true) {
            System.out.println("Options");
            int intOption = 0;
            for (int i = 0; i < 4; i ++) {
                System.out.print((i + 1) + ")   ");
                if (i == 0) {
                    System.out.println("Show tasks sorted by date");
                } else if (i == 1) {
                    System.out.println("Show tasks sorted by importance");
                } else if (i == 2) {
                    System.out.println("Add new task");
                } else if (i == 3){
                    System.out.println("Save and exit");
                }
            }
            intOption = keyboard.nextInt();
            if (intOption == 1) {
                System.out.println(theTodoList.getAsDateSortedString()); // fix todo
            } else if (intOption == 2) {
                System.out.println(theTodoList.getAsImportanceSortedString()); // fix todo
            } else if (intOption == 3) {
                boolean isValidDate = true;
                System.out.print("Enter a date (YYYY-MM-DD): ");
                Scanner dateKeyboard = new Scanner(System.in);
                String dateString = dateKeyboard.nextLine();
                if (dateString == null || dateString.length() != 10) {
                    isValidDate = false;
                } else {
                    for (int i = 0; i < 4; i ++) {
                        if (Character.isDigit(dateString.charAt(i)) == false) {
                            isValidDate = false;
                        }
                    }
                    if ((dateString.charAt(4) != '-') || (dateString.charAt(7) != '-')) {
                        isValidDate = false;
                    }
                    for (int i = 5; i < 7; i ++) {
                        if (Character.isDigit(dateString.charAt(i)) == false) {
                            isValidDate = false;
                        }
                    }
                    for (int i = 8; i < 10; i ++) {
                        if (Character.isDigit(dateString.charAt(i)) == false) {
                            isValidDate = false;
                        }
                    }
                }
                if (isValidDate == false) {
                    System.out.println("Dates must be entered in YYYY-MM-DD format");
                    continue;
                } else {
                    Date theDate = Date.fromDashString(dateString); // format date string to date class
                    String importanceString = "";
                    System.out.print("Enter an importance (HIGH, MEDIUM, LOW): ");
                    Scanner importanceKeyboard = new Scanner(System.in);
                    importanceString = importanceKeyboard.nextLine();
                    Importance theImportance;
                    if (importanceString.equals("HIGH")) {
                        theImportance = Importance.HIGH;
                    } else if (importanceString.equals("MEDIUM")) {
                        theImportance = Importance.MEDIUM;
                    } else if (importanceString.equals("LOW")) {
                        theImportance = Importance.LOW;
                    } else {
                        System.out.println("Bad importance choice");
                        continue;
                    }
                    String descriptionString = "";
                    System.out.print("Enter a short description (no commas): ");
                    Scanner descriptionKeyboard = new Scanner(System.in);
                    descriptionString = descriptionKeyboard.nextLine();
                    if (descriptionString.contains(",")) {
                        System.out.println("No commas allowed");
                        continue;
                    } else {
                        TodoItem theTodoItem = new TodoItem(theDate, descriptionString, theImportance);
                        theTodoList.addTask(theTodoItem);	
                    }
                }

            } else if (intOption == 4) {
                theTodoList.saveToFile();
                menu = false;
            }
        } 
    }
}
