package ua.testing.controller;

import ua.testing.model.entity.Calendar;
import ua.testing.model.entity.Event;
import ua.testing.model.EventActionService;
import ua.testing.view.EventListValuesGenerator;
import ua.testing.view.GlobalConstants;
import ua.testing.view.View;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import static ua.testing.view.GlobalConstants.*;


public class Controller {

    Calendar calendar;
    View view;
    EventActionService eventActionService;
    Scanner scanner;





    public Controller(Event calendar, View view) {
        this.calendar = (Calendar) calendar;
        this.view = view;
        eventActionService = new EventActionService();
        scanner = new Scanner(System.in);
    }


    public void processUser() throws ParseException {
        EventListValuesGenerator.fillEventList(EventListValuesGenerator.FIVE_EVENTS, calendar);
        view.initializeUI(scanner, calendar.getEventList(),this, calendar);

    }

    public int submitUserInputWithScanner(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            view.printMessage(WRONG_INPUT_DATA);
            scanner.next();
        }
        return scanner.nextInt();
    }





}
