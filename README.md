This Java project, named Date212 GUI, provides a graphical user interface (GUI) for managing and displaying lists of Date212 objects. The Date212 class represents a date in the format MM/dd/yyyy and includes functionalities for validation and comparison.

Features
Date212 Class
Represents a date with validation for the MM/dd/yyyy format.
Provides methods for checking the validity of a date, getting the maximum days in a month, and determining leap years.
Implements the Comparable interface for date comparison.
Date212List and Date212Node
Abstract class and node representing a list of Date212 objects respectively.
The list supports appending Date212 objects.
Date212GUI Class
Main GUI class for displaying unsorted and sorted lists of Date212 objects.
Allows users to open a file, read dates, and display them in the GUI.
Supports sorting and filtering dates based on the specified year.
EditMenuHandler Class
ActionListener for handling events from the Edit menu in Date212GUI.
Enables users to filter and display dates based on a specified year.
FileMenuHandler Class
ActionListener for handling events from the File menu in Date212GUI.
Allows users to open a file, read dates, and display them in the GUI.
Usage
Run the Date212GUI application.
Use the "File" menu to open a file containing date strings.
Dates are displayed in both unsorted and sorted lists.
Utilize the "Edit" menu to filter and display dates based on a specified year.
Dependencies
Java Swing for GUI components.
Feel free to explore and contribute to this project! 
