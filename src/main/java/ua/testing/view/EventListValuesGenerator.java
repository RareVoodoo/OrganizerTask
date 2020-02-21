package ua.testing.view;

import ua.testing.model.entity.Calendar;
import ua.testing.model.entity.Event;

public enum EventListValuesGenerator {
    THREE_EVENTS, FIVE_EVENTS;

    public static void fillEventList(EventListValuesGenerator eventQuantity, Calendar calendar) {
        switch (eventQuantity) {
            case THREE_EVENTS: {
                fillEventListWithThreeValues(calendar);
                break;
            }
            case FIVE_EVENTS:
                fillEventListWithFiveValues(calendar);
                break;
        }
    }

    private static void fillEventListWithThreeValues(Calendar calendar) {
        calendar.addNewEvent(new Event("02/21/2020", "Event1", ImportanceLevel.EASY));
        calendar.addNewEvent(new Event("02/25/2020", "Event2", ImportanceLevel.MEDIUM));
        calendar.addNewEvent(new Event("02/26/2020", "Event3", ImportanceLevel.IMPORTANT));
    }

    private static void fillEventListWithFiveValues(Calendar calendar) {
        calendar.addNewEvent(new Event("02/21/2020", "Event1", ImportanceLevel.EASY));
        calendar.addNewEvent(new Event("02/25/2020", "Event2", ImportanceLevel.MEDIUM));
        calendar.addNewEvent(new Event("02/26/2020", "Event3", ImportanceLevel.IMPORTANT));
        calendar.addNewEvent(new Event("09/23/2019", "Event4", ImportanceLevel.MEDIUM));
        calendar.addNewEvent(new Event("10/27/2019", "Event5", ImportanceLevel.MEDIUM));
    }
}
