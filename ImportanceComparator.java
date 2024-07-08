
import java.util.Comparator;

/**
 * a class that compares the importance of todoitems
 */
public class ImportanceComparator implements Comparator<TodoItem>{
    /**
     * a method that compares importance levels of two todo items
     * @param one for the first item
     * @param two for the second item
     * @return compare value in int that we got from comparing
     */
    @Override
    public int compare(TodoItem one, TodoItem two) {
        int compare = one.getImportanceLevel().compareTo(two.getImportanceLevel());
        return compare;		
    }
}