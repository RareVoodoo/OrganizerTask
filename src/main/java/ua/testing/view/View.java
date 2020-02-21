package ua.testing.view;

import ua.testing.controller.Controller;
import ua.testing.model.EventActionService;
import ua.testing.model.entity.Calendar;
import ua.testing.model.entity.Event;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import static ua.testing.view.GlobalConstants.*;

public class View {

    EventActionService eventActionService = new EventActionService();

    private int userInputValue;

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
        for (int i = 0; i < GlobalConstants.DEFAULT_SEPARATOR_LENGTH; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void initializeUI(Scanner scanner, ArrayList<Event> eventsList, Controller controller, Calendar calendar) throws ParseException {
        boolean isTerminated = false;

        while (!isTerminated) {
            loadMainMenuWithMenuItems(
                    View.bundle.getString(SORT_BY_DATE_MENU_ITEM),
                    View.bundle.getString(SORT_BY_IMPORTANCE_MENU_ITEM),
                    View.bundle.getString(COMING_EVENTS_MENU_ITEM),
                    View.bundle.getString(SEARCH_EVENTS_IN_RANGE_MENU_ITEM),
                    View.bundle.getString(EXIT_MENU_ITEM));

            userInputValue = controller.submitUserInputWithScanner(scanner);
            switch (userInputValue) {
                case 1:
                    eventActionService.sortEventsByDate(eventsList);
                    break;
                case 2:
                    eventActionService.sortByImportance(eventsList);
                    break;
                case 3:
                    printMessage(View.bundle.getString(COMING_EVENTS_MESSAGE));
                    printEventList(eventActionService.calculateComingEvents(eventsList));
                    printSeparator();
                    break;
                case 4:
                    printMessage(View.bundle.getString(EVENTS_IN_ENTERED_RANGE_MESSAGE));
                    printEventList(eventActionService.searchEventsInRange(eventsList,
                            GlobalConstants.DEFAULT_START_DATA_RANGE,
                            GlobalConstants.DEFAULT_END_DATA_RANGE));
                    printSeparator();
                    break;
                case 5:
                    isTerminated = true;
                    break;

                default:
                    printMessage(WRONG_INPUT_DATA);
            }
            printEventList(calendar.getEventList());
            printSeparator();

        }
    }

}
