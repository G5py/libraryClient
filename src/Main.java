import boundary.LibraryCli;
import controller.LibraryController;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        LibraryController controller = new LibraryController();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LibraryCli(controller);
            }
        });
    }
    // Cli를 호출해야 함.
}