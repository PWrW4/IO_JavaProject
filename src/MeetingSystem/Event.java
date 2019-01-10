package MeetingSystem;

import MeetingSystem.Builders.EventBuilder;

import java.util.ArrayList;
import java.util.List;

public class Event implements Comparable{

    private String name;
    private String theme;
    private String description;
    private String time;
    private Place place;
    private int minSlots;
    private int maxSlots;
    private User eventCreator;
    private int currentSlots = 0;
    private boolean accepted = false;
    private List<User> userList = new ArrayList<>();

    public Event(EventBuilder eBuilder)
    {
        this.name = eBuilder.name;
        this.theme = eBuilder.theme;
        this.description = eBuilder.description;
        this.time = eBuilder.time;
        this.place = eBuilder.place;
        this.minSlots = eBuilder.minSlots;
        this.maxSlots = eBuilder.maxSlots;
        this.eventCreator = eBuilder.eventCreator;
    }

    public int getMinSlots() {
        return minSlots;
    }

    public void setMinSlots(int minSlots) {
        this.minSlots = minSlots;
    }

    public int getMaxSlots() {
        return maxSlots;
    }

    public void setMaxSlots(int maxSlots) {
        this.maxSlots = maxSlots;
    }

    public int getCurrentSlots() {
        return currentSlots;
    }

    public void setCurrentSlots(int currentSlots) {
        this.currentSlots = currentSlots;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public User getEventCreator() {
        return eventCreator;
    }

    public void setEventCreator(User eventCreator) {
        this.eventCreator = eventCreator;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}