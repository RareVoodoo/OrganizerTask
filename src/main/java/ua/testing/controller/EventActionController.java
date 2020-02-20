package ua.testing.controller;

import ua.testing.model.Event;


import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;


public class EventActionController {

    public void sortEventsByDate(ArrayList<Event> eventList) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        eventList.sort((date1, date2) -> LocalDate.parse(date1.getEventDate(), formatter)
                .compareTo(LocalDate.parse(date2.getEventDate(), formatter)));
    }

    public  void sortByImportance(ArrayList<Event> eventList){
        eventList.sort((e1,e2) -> e1.getImportanceLevel()
                .compareTo(e2.getImportanceLevel()));
    }

    public ArrayList<Event> calculateComingEvents(ArrayList<Event>events) throws ParseException {
        ArrayList<Event> comingEventsList = new ArrayList<>(events);
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date comparingDate;
        for ( Event event : events){
            comparingDate = formatter.parse(event.getEventDate());
            Calendar eventDate = Calendar.getInstance();
            eventDate.setTime(comparingDate);
            if(!comparingDate.after(formatter.parse(formatter.format(new Date())))) {
                comingEventsList.remove(event);
            }
        }
        return comingEventsList;
    }
}
