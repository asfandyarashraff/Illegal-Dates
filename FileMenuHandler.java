import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * ActionListener for handling events from the File menu in the Date212GUI.
 * Allows the user to open a file, read dates from the file, and display them in the GUI.
 */
class FileMenuHandler implements ActionListener {
    private Date212GUI gui;

    /**
     * Constructs a FileMenuHandler with a reference to the Date212GUI.
     *
     * @param gui The Date212GUI instance.
     */
    public FileMenuHandler(Date212GUI gui) {
        this.gui = gui;
    }

    /**
     * Invoked when an action occurs. Opens a file chooser dialog, reads dates from the selected file,
     * and adds them to both unsorted and sorted lists in the GUI.
     *
     * @param e The action event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Create a file chooser dialog
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File file = fileChooser.getSelectedFile();
            try (Scanner scanner = new Scanner(file)) {
                // Loop through each line in the file
                while (scanner.hasNextLine()) {
                    // Read date string from the file
                    String dateString = scanner.nextLine();
                    try {
                        // Parse the date string and create a Date212 object
                        Date212 d = new Date212(dateString);
                        // Add the date to both unsorted and sorted lists in the GUI
                        gui.addUnsortedDate(d);
                        gui.addSortedDate(d);
                    } catch (IllegalDate212Exception ex) {
                        // Handle exceptions if the date string is invalid
                        System.out.println("Error: " + ex.getMessage());
                    }
                }
            } catch (Exception ex) {
                // Handle exceptions if there is an error reading the file
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error reading file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
