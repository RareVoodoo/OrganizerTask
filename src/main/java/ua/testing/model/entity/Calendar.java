package ua.testing.model.entity;

import java.util.ArrayList;


/**
 * Represents a Calendar with Event list
 *
 */
public class Calendar extends Event {

    private ArrayList<Event> eventList = new ArrayList<>();

    public ArrayList<Event> getEventList() {
        return eventList;
    }

    public void addNewEvent(Event event){
        eventList.add(event);
    }




}
