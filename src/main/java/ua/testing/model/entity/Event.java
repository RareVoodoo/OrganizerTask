package ua.testing.model.entity;


import ua.testing.view.ImportanceLevel;

/**
 * Represents a simple Event with event date, name, and importance
 *
 */
public class Event  {
    /**
     * The date of planned event
     */
    private String eventDate;


    /**
     * The name of planned event
     */
    private String eventName;

    /**
     * The Importance level of planned event
     */
    private ImportanceLevel importanceLevel;

    public Event(){}

    public Event(String  eventDate, String eventName, ImportanceLevel importanceLevel) {
        this.eventDate = eventDate;
        this.eventName = eventName;
        this.importanceLevel = importanceLevel;
    }


    /**
     * Gets the events date
     * @return this events date
     */
    public String  getEventDate() {
        return eventDate;
    }

    /**
     * Changes the date of this event
     * @param eventDate
     */
    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }


    /**
     *
     * @return
     */
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public ImportanceLevel getImportanceLevel() {
        return importanceLevel;
    }

    public void setImportanceLevel(ImportanceLevel importance) {
        importanceLevel = importance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (eventDate != null ? !eventDate.equals(event.eventDate) : event.eventDate != null) return false;
        if (eventName != null ? !eventName.equals(event.eventName) : event.eventName != null) return false;
        return importanceLevel == event.importanceLevel;
    }

    @Override
    public int hashCode() {
        int result = eventDate != null ? eventDate.hashCode() : 0;
        result = 31 * result + (eventName != null ? eventName.hashCode() : 0);
        result = 31 * result + (importanceLevel != null ? importanceLevel.hashCode() : 0);
        return result;
    }
}
