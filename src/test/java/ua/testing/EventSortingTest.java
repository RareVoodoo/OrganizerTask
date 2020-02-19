package ua.testing;

import org.junit.Test;
import ua.testing.controller.Controller;
import ua.testing.controller.EventSortController;
import ua.testing.controller.ImportanceLevel;
import ua.testing.model.Calendar;
import ua.testing.model.Event;
import ua.testing.view.View;

import static org.junit.Assert. *;

public class EventSortingTest {
    View view = new View();
    Calendar calendar = new Calendar();
    Calendar sortedCalendar = new Calendar();
    EventSortController eventSortController = new EventSortController();
    Controller controller = new Controller(calendar,view);
    {controller.fillEventList();}
    @Test
    public void sortingEventListByDate() {
        generateSortedByDateEventList(sortedCalendar);
        eventSortController.sortEventsByDate(calendar.getEventList());
        assertEquals(calendar.getEventList(),sortedCalendar.getEventList());

    }

    @Test
    public void sortingEventListByImportance(){
        generateSortedByImportanceEventList(sortedCalendar);
        eventSortController.sortByImportance(calendar.getEventList());
        assertEquals(calendar.getEventList(),sortedCalendar.getEventList());
    }



    void generateSortedByDateEventList(Calendar calendar){
        calendar.addNewEvent(new Event("09/23/2019", "Event4", ImportanceLevel.MEDIUM));
        calendar.addNewEvent(new Event("09/25/2019", "Event1", ImportanceLevel.EASY));
        calendar.addNewEvent(new Event("10/18/2019", "Event3", ImportanceLevel.IMPORTANT));
        calendar.addNewEvent(new Event("10/25/2019", "Event2", ImportanceLevel.MEDIUM));
    }

    void generateSortedByImportanceEventList(Calendar calendar){
        calendar.addNewEvent(new Event("09/25/2019", "Event1", ImportanceLevel.EASY));
        calendar.addNewEvent(new Event("10/25/2019", "Event2", ImportanceLevel.MEDIUM));
        calendar.addNewEvent(new Event("09/23/2019", "Event4", ImportanceLevel.MEDIUM));
        calendar.addNewEvent(new Event("10/18/2019", "Event3", ImportanceLevel.IMPORTANT));
    }


}
