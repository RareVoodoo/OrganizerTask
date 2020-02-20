package ua.testing.view;

import ua.testing.model.Event;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import static ua.testing.view.TextConstant.IMPORTANCE_OUTPUT_MESSAGE;

public class View {

    static String BUNDLE_NAME = "resources";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    BUNDLE_NAME,
//                    new Locale("ua", "UA"));  // Ukrainian
                    new Locale("en"));        // English

    public void printMessage(String message) {
        System.out.println(message);

    }

    /**
     *
     * @param messages
     */
    public void loadMainMenuWithMenuItems(String... messages) {
        for (int i = 0; i < messages.length; i++) {
            printMessage((i + 1) + " " + messages[i]);
        }
    }

    /**
     *
     * @param events
     */
    public void printEventList(ArrayList<Event> events) {
        for (Event event : events) {
            System.out.printf("%s | %s | %s : %s \n",
                    event.getEventDate(),
                    event.getEventName(),
                    bundle.getString(IMPORTANCE_OUTPUT_MESSAGE),
                    event.getImportanceLevel());
        }
    }

    public void printSeparator() {
        for (int i = 0; i < 40; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
