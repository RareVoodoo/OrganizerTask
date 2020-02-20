package ua.testing.model;


import java.util.ArrayList;

public class Calendar extends Event {
    private ArrayList<Event> eventList = new ArrayList<>();


    public ArrayList<Event> getEventList() {
        return eventList;
    }

    public void addNewEvent(Event event){
        eventList.add(event);
    }




}
