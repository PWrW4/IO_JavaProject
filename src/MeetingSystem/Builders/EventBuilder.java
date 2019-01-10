package MeetingSystem.Builders;


import MeetingSystem.Event;
import MeetingSystem.Place;
import MeetingSystem.User;

public class EventBuilder {

    public String name;
    public String theme;
    public String description;
    public String time;
    public Place place;
    public int minSlots;
    public int maxSlots;
    public User eventCreator;

    public EventBuilder(String name,User eventCreator, int minSlots, int maxSlots, String time){
        this.name = name;
        this.eventCreator = eventCreator;
        this.minSlots = minSlots;
        this.maxSlots = maxSlots;
        this.time = time;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Event build(){
        return new Event(this);
    }

}
