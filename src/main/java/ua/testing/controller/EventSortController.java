package ua.testing.controller;

import ua.testing.model.Event;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class EventSortController {

    public void sortEventsByDate(ArrayList<Event> eventList) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        eventList.sort((date1, date2) -> LocalDate.parse(date1.getEventDate(), formatter)
                .compareTo(LocalDate.parse(date2.getEventDate(), formatter)));
    }

    public  void sortByImportance(ArrayList<Event> eventList){
        eventList.sort((e1,e2) -> e1.getImportanceLevel()
                .compareTo(e2.getImportanceLevel()));
    }
}
