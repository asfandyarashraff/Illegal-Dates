import java.util.ArrayList;

/**
 * Abstract class representing a list of Date212 objects.
 */
public abstract class Date212List {
    protected ArrayList<Date212> list;

    public Date212List() {
        this.list = new ArrayList<>();
    }

    public void append(Date212 d) {
        list.add(d);
    }
}
