package ua.testing.controller;

import ua.testing.model.Calendar;
import ua.testing.model.Event;
import ua.testing.view.EventListValuesGenerator;
import ua.testing.view.ImportanceLevel;
import ua.testing.view.View;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import static ua.testing.view.TextConstant.*;


public class Controller {
    Calendar calendar;
    View view;
    EventActionController eventActionController;
    Scanner scanner;

    private int userInputValue;

    /**
     *
     * @param calendar
     * @param view
     */
    public Controller(Event calendar, View view) {
        this.calendar = (Calendar) calendar;
        this.view = view;
        eventActionController = new EventActionController();
        scanner = new Scanner(System.in);
    }


    public void processUser() throws ParseException {
        EventListValuesGenerator.fillEventList(EventListValuesGenerator.FIVE_EVENTS,calendar);
        initializeUI(scanner, calendar.getEventList());

    }

    public void submitUserInputWithScanner(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            view.printMessage(WRONG_INPUT_DATA);
            scanner.next();
        }
        userInputValue = scanner.nextInt();
    }


    /**
     *
     * @param scanner
     * @param eventsList
     * @throws ParseException
     */
    public void initializeUI(Scanner scanner, ArrayList<Event> eventsList) throws ParseException {
        boolean isTerminated = false;

        while (!isTerminated) {
            view.loadMainMenuWithMenuItems(View.bundle.getString(SORT_BY_DATE_MENU_ITEM),
                    View.bundle.getString(SORT_BY_IMPORTANCE_MENU_ITEM),
                    View.bundle.getString(COMING_EVENTS_MENU_ITEM),
                    View.bundle.getString(EXIT_MENU_ITEM));

            submitUserInputWithScanner(scanner);
            switch (userInputValue) {
                case 1:
                    eventActionController.sortEventsByDate(eventsList);
                    break;
                case 2:
                    eventActionController.sortByImportance(eventsList);
                    break;
                case 3:
                    view.printEventList(eventActionController.calculateComingEvents(eventsList));
                    view.printSeparator();
                    break;
                case 4:
                    isTerminated = true;
                    break;

                default:
                    view.printMessage(WRONG_INPUT_DATA);
            }
            view.printEventList(calendar.getEventList());
        }
    }



}
