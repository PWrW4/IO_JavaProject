package Application;

import Helpers.SearchType;
import MeetingSystem.Event;
import MeetingSystem.User;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

public class App {


    private List<Event> eventList = new ArrayList<>();



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

    void addEvent(User user){
        Event e = new Event(user);

        if (eventList.contains(e));
    }

    void acceptEvent(Event e){
        e.setAccepted(true);
    }

    void removeEvent(Event e){
        eventList.remove(e);
    }

    void signUserOnEvent(User u, Event e){
        if (e.getCurrentSlots()<e.getMaxSlots()){
            e.getUserList().add(u);
        }
    }

    void checkEvent(Event e){
        if (e.getMinSlots()<e.getCurrentSlots()){
            removeEvent(e);
        }
    }

    void signOffUserFromEvent(User u, Event e){
        e.getUserList().remove(u);
    }

    void editEvent(Event e){
    }
}
