package Application;

import Helpers.SearchType;
import MeetingSystem.Event;
import MeetingSystem.User;

import java.util.ArrayList;

public class App {


    private ArrayList<Event> eventList = new ArrayList<>();


    Event searchEvent(String searchData, SearchType searchType) {

        Event eToReturn = null;

        switch (searchType) {
            case Name:
                for (Event e : eventList) {
                    if (e.getName().equals(searchData)) {
                        eToReturn = e;
                        break;
                    }
                }
                break;
            case Date:
                for (Event e : eventList) {
                    if (e.getTime().toString().equals(searchData)) {
                        eToReturn = e;
                        break;
                    }
                }
                break;
            case Place:
                for (Event e : eventList) {
                    if (e.getPlace().toString().equals(searchData)) {
                        eToReturn = e;
                        break;
                    }
                }
                break;
            case HostUser:
                for (Event e : eventList) {
                    if (e.getEventCreator().toString().equals(searchData)) {
                        eToReturn = e;
                        break;
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("not entered switch");
        }

        return eToReturn;
    }


    public boolean addEvent(Event event){
        if (!eventList.contains(event)){
            eventList.add(event);
            return true;
        }
        return false;
    } 
    
    public boolean searchEventReturnsTrue(Event e) //Zwraca true je¿eli event istnieje
    {
    	if (eventList.contains(e)) return true;
    	else return false;
    } 
    
    public void acceptEvent(Event e){
        e.setAccepted(true);
    }

    public void removeEvent(Event e){
        eventList.remove(e);
    }

    public void signUserOnEvent(User u, Event e){
        if (e.getCurrentSlots()<e.getMaxSlots()){
            e.getUserList().add(u);
        }
    }

    public void checkEvent(Event e){
        if (e.getMinSlots()<e.getCurrentSlots()){
            removeEvent(e);
        }
    }

    public void signOffUserFromEvent(User u, Event e){
        e.getUserList().remove(u);
    }

    void editEvent(Event e){
    }

    public ArrayList<Event> getEventList() {
        return eventList;
    }

    public void setEventList(ArrayList<Event> eventList) {
        this.eventList = eventList;
    }
}
