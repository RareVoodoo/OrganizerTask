package ua.testing.model;


import ua.testing.view.ImportanceLevel;

public class Event  {
    private String eventDate;
    private String eventName;
    private ImportanceLevel importanceLevel;

    public Event(){}

    public Event(String  eventDate, String eventName, ImportanceLevel importanceLevel) {
        this.eventDate = eventDate;
        this.eventName = eventName;
        this.importanceLevel = importanceLevel;
    }

    public String  getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

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
