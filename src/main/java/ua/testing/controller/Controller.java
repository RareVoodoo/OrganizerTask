package ua.testing.controller;

import ua.testing.model.Calendar;
import ua.testing.model.Event;
import ua.testing.view.View;

import java.util.ArrayList;
import java.util.Scanner;


public class Controller {
    Calendar calendar;
    View view;
    EventSortController eventSortController;
    Scanner scanner;

    private int userInputValue;

    public Controller(Event calendar,  View view) {
        this.calendar = (Calendar) calendar;
        this.view = view;
        eventSortController = new EventSortController();
        scanner = new Scanner(System.in);
    }


    public void processUser(){
        fillEventList();
        initializeUI(scanner, calendar.getEventList());


//        eventSortController.sortEventsByDate(calendar.getEventList());
//        eventSortController.sortByImportance(calendar.getEventList());

//        view.printEventList(calendar.getEventList());


    }

    public void submitUserInputWithScanner(Scanner scanner){
        while (!scanner.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_INT_DATA);
            scanner.next();
        }
        userInputValue = scanner.nextInt();
    }

    public void initializeUI(Scanner scanner, ArrayList<Event> eventsList){
        boolean isTerminated = false;

        while(!isTerminated){
            view.loadMainMenuWithMessages(View.MAIN_MENU_MESSAGES);
            submitUserInputWithScanner(scanner);
            switch (userInputValue){
                case 1:
                    eventSortController.sortEventsByDate(eventsList);
                    break;
                case 2:
                    eventSortController.sortByImportance(eventsList);
                    break;
                case 3:
                    isTerminated = true;
                    break;

                default:
                    view.printMessage(View.WRONG_INPUT_INT_DATA);
            }
                view.printEventList(calendar.getEventList());
        }
    }

    public void fillEventList(){
        calendar.addNewEvent(new Event("09/25/2019", "Event1", ImportanceLevel.EASY));
        calendar.addNewEvent(new Event("10/25/2019", "Event2", ImportanceLevel.MEDIUM));
        calendar.addNewEvent(new Event("10/18/2019", "Event3", ImportanceLevel.IMPORTANT));
        calendar.addNewEvent(new Event("09/23/2019", "Event4", ImportanceLevel.MEDIUM));
    }

}
