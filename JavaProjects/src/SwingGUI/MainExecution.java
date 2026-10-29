// first time learning JFrame from the Swing framework (Java GUI tool)
package SwingGUI;

import javax.swing.*;

public class MainExecution {
    public static void main(String[] args) {
        // Window jFrameWindow = new Window();

        SwingUtilities.invokeLater(() -> {
            new JButtonApp();
        });
    }
}
