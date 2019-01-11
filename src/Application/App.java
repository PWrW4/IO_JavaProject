package Application;

import Helpers.SearchType;
import MeetingSystem.Event;
import MeetingSystem.User;

import java.util.ArrayList;

public class App {


    private ArrayList<Event> eventList = new ArrayList<>();


    public Event searchEvent(SearchType searchType,String searchData) {

        Event eToReturn = null;

        if (searchData.equals(""))
            return null;

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
                    if (e.getTime().equals(searchData)) {
                        eToReturn = e;
                        break;
                    }
                }
                break;
            case Place:
                for (Event e : eventList) {
                    if (e.getPlace()==null){
                        return null;
                    }
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

    public void checkAndRemoveSlotsEvent(Event e){
        if (e.getMinSlots()>e.getCurrentSlots()){
            removeEvent(e);
        }
    }

    public void signOffUserFromEvent(User u, Event e){
        e.getUserList().remove(u);
    }

    public ArrayList<Event> getEventList() {
        return eventList;
    }

    public void setEventList(ArrayList<Event> eventList) {
        this.eventList = eventList;
    }
}
