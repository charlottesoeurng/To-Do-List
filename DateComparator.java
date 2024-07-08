
import java.util.Comparator;

/**
 * a class that compares the dates of todoitems
 */
public class DateComparator implements Comparator<TodoItem>{
    /**
     * a method that compares the dates of two todoitems
     * @param one for the date of the first todoitem
     * @param two for the date of the second todoitem
     * @return compare value in int we got from comparing
     */
    @Override
    public int compare(TodoItem one, TodoItem two) {
        int compare = one.getDate().compareTo(two.getDate());
        return compare;		
    }
}