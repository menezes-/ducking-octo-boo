package org.freemars.controller.action.file;

import org.freemars.controller.FreeMarsController;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Deniz ARIKAN
 */
public class DisplayMainMenuAction extends AbstractAction {

    private FreeMarsController controller;

    public DisplayMainMenuAction(FreeMarsController controller) {
        super("Display main menu", null);
        putValue(SHORT_DESCRIPTION, "Quit to main menu");
        putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_Q));
        this.controller = controller;
    }

    public void actionPerformed(ActionEvent e) {
        controller.displayMainMenuFrame();
        controller.displayMainMenuWindow();
    }
}
