import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * ActionListener for handling events from the Edit menu in the Date212GUI.
 * Allows the user to filter and display dates based on a specified year.
 */
class EditMenuHandler implements ActionListener {
    private Date212GUI gui;

    /**
     * Constructs an EditMenuHandler with a reference to the Date212GUI.
     *
     * @param gui The Date212GUI instance.
     */
    public EditMenuHandler(Date212GUI gui) {
        this.gui = gui;
    }

    /**
     * Invoked when an action occurs. Presents a dialog to the user to input a year,
     * then filters and updates the GUI with dates matching the specified year.
     *
     * @param e The action event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Prompt the user to enter a year
        String yearInput = JOptionPane.showInputDialog(gui, "Enter a year:");

        if (yearInput != null) {
            try {
                // Parse the entered year
                int yearToSearch = Integer.parseInt(yearInput);

                // Filter dates by the specified year for both unsorted and sorted lists
                ArrayList<Date212> unsortedFilteredList = filterDatesByYear(gui.getUnsortedList(), yearToSearch);
                ArrayList<Date212> sortedFilteredList = filterDatesByYear(gui.getSortedList().list, yearToSearch);

                // Update the GUI with the filtered lists
                if (!unsortedFilteredList.isEmpty()) {
                    gui.updateUnsortedTextAreaWithFilter(unsortedFilteredList);
                } else {
                    JOptionPane.showMessageDialog(gui, "No dates found for the specified year.", "Info", JOptionPane.INFORMATION_MESSAGE);
                }

                if (!sortedFilteredList.isEmpty()) {
                    gui.updateSortedTextAreaWithFilter(sortedFilteredList);
                } else {
                    JOptionPane.showMessageDialog(gui, "No dates found for the specified year.", "Info", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(gui, "Invalid input. Please enter a valid year.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Filters a list of Date212 objects based on the specified year.
     *
     * @param list The list of Date212 objects to filter.
     * @param year The year to filter by.
     * @return An ArrayList containing Date212 objects matching the specified year.
     */
    private ArrayList<Date212> filterDatesByYear(ArrayList<Date212> list, int year) {
        ArrayList<Date212> filteredList = new ArrayList<>();

        // Iterate through the list and add dates with the specified year to the filtered list
        for (Date212 date : list) {
            if (date.getYear() == year) {
                filteredList.add(date);
            }
        }

        return filteredList;
    }
}
