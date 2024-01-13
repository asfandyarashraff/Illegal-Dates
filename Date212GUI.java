import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The main GUI class for displaying unsorted and sorted lists of Date212 objects.
 */
public class Date212GUI extends JFrame {
    private JTextArea unsortedTextArea;
    private JTextArea sortedTextArea;
    private ArrayList<Date212> unsortedList;
    private SortedDate212List sortedList;

    /**
     * Constructs the Date212GUI with necessary components and layout.
     */
    public Date212GUI() {
        setTitle("Date GUI");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        unsortedTextArea = new JTextArea();
        sortedTextArea = new JTextArea();
        unsortedList = new ArrayList<>();
        sortedList = new SortedDate212List();

        JScrollPane unsortedScrollPane = new JScrollPane(unsortedTextArea);
        JScrollPane sortedScrollPane = new JScrollPane(sortedTextArea);

        setLayout(new GridLayout(1, 2));
        add(unsortedScrollPane);
        add(sortedScrollPane);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create the "File" menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem openItem = new JMenuItem("Open");
        fileMenu.add(openItem);
        openItem.addActionListener(new FileMenuHandler(this));

        JMenuItem quitItem = new JMenuItem("Quit");
        fileMenu.add(quitItem);
        quitItem.addActionListener(e -> System.exit(0));

        // Create the "Edit" menu
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        JMenuItem searchItem = new JMenuItem("Search");
        editMenu.add(searchItem);
        searchItem.addActionListener(new EditMenuHandler(this));
    }

    /**
     * Adds a Date212 object to the unsorted list and updates the GUI.
     *
     * @param date The Date212 object to add.
     */
    public void addUnsortedDate(Date212 date) {
        unsortedList.add(date);
        updateUnsortedTextArea();
    }

    /**
     * Adds a Date212 object to the sorted list and updates the GUI.
     *
     * @param date The Date212 object to add.
     */
    public void addSortedDate(Date212 date) {
        sortedList.add(date);
        updateSortedTextArea();
    }

    /**
     * Updates the unsorted text area with the current unsorted list.
     */
    private void updateUnsortedTextArea() {
        unsortedTextArea.setText("");
        for (Date212 date : unsortedList) {
            unsortedTextArea.append(date.toString() + "\n");
        }
    }

    /**
     * Updates the sorted text area with the current sorted list.
     */
    private void updateSortedTextArea() {
        sortedTextArea.setText("");
        for (Date212 date : sortedList.list) {
            sortedTextArea.append(date.toString() + "\n");
        }
    }

    /**
     * Updates the unsorted text area with the filtered list by year.
     *
     * @param filteredList The filtered list to display.
     */
    public void updateUnsortedTextAreaWithFilter(ArrayList<Date212> filteredList) {
        unsortedTextArea.setText("");
        for (Date212 date : filteredList) {
            unsortedTextArea.append(date.toString() + "\n");
        }
    }

    /**
     * Updates the sorted text area with the filtered list by year.
     *
     * @param filteredList The filtered list to display.
     */
    public void updateSortedTextAreaWithFilter(ArrayList<Date212> filteredList) {
        sortedTextArea.setText("");
        for (Date212 date : filteredList) {
            sortedTextArea.append(date.toString() + "\n");
        }
    }

    
     

     //Getter method for unsortedList
    public ArrayList<Date212> getUnsortedList() {
        return unsortedList;
    }

    //Getter method for sortedList
    public SortedDate212List getSortedList() {
        return sortedList;
    }
    
}

