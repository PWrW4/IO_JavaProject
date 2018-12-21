package Application;

import Helpers.SearchType;
import MeetingSystem.Event;
import MeetingSystem.User;

import java.util.ArrayList;

public class App {


    protected ArrayList<Event> eventList = new ArrayList<>();



    Event searchEvent(String searchData, SearchType searchType){

        switch (searchType) {
            case Name:
                break;
            case Date:
                break;
            case Place:
                break;
            case PlaceAndDate:
                break;
        }

        return new Event(new User());
    }

//     public void addEvent(User user){
//        Event e = new Event(user);
//
//        if (!eventList.contains(e)){
//           eventList.add(e);
//        }
//    }

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
