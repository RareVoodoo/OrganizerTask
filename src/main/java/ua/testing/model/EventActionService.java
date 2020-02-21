package ua.testing.model;

import ua.testing.model.entity.Event;
import ua.testing.view.GlobalConstants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Calendar;


public class EventActionService {
    SimpleDateFormat formatter = new SimpleDateFormat(GlobalConstants.DEFAULT_DATA_FORMAT_PATTERN);

    /**
     * @param eventList
     */
    public void sortEventsByDate(ArrayList<Event> eventList) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(GlobalConstants.DEFAULT_DATA_FORMAT_PATTERN);
        eventList.sort(Comparator.comparing(date -> LocalDate.parse(date.getEventDate(), formatter)));
    }

    /**
     * @param eventList
     */
    public void sortByImportance(ArrayList<Event> eventList) {
        eventList.sort(Comparator.comparing(Event::getImportanceLevel));
    }

    /**
     * Searching coming events
     *
     * @param events
     * @return comingEvents from EventList
     * @throws ParseException
     */
    public ArrayList<Event> calculateComingEvents(ArrayList<Event> events) throws ParseException {
        ArrayList<Event> comingEventsList = new ArrayList<>(events);
        Date comparingDate;
        for (Event event : events) {
            comparingDate = formatter.parse(event.getEventDate());
            java.util.Calendar eventDate = java.util.Calendar.getInstance();
            eventDate.setTime(comparingDate);
            if (!comparingDate.after(formatter.parse(formatter.format(new Date())))) {
                comingEventsList.remove(event);
            }
        }
        return comingEventsList;
    }

    /** Searching events in range from start to end
     * @param events
     * @param start
     * @param end
     * @return
     * @throws ParseException
     */
    public ArrayList<Event> searchEventsInRange(ArrayList<Event> events, String start, String end) throws ParseException {
        ArrayList<Event> eventsInRange = new ArrayList<>();
        Date comparingDate;
        for (Event event : events) {
            comparingDate = formatter.parse(event.getEventDate());
            java.util.Calendar eventDate = Calendar.getInstance();
            eventDate.setTime(comparingDate);
            if (comparingDate.after(formatter.parse(start)) &
                    comparingDate.before(formatter.parse(end))) {
                eventsInRange.add(event);
            }
        }
        return eventsInRange;
    }

}
