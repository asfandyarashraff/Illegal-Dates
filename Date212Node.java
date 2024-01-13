/**
 * Represents a node in a linked list of Date212 objects.
 */
public class Date212Node {
    protected Date212 data; // Data of the node, representing a Date212 object
    protected Date212Node next;

    /**
     * Constructs a Date212Node with the given Date212 data.
     *
     * @param d The Date212 data.
     */
    public Date212Node(Date212 d) {
        this.data = d;
        this.next = null; // Initially next node is set to null
    }
}
