package AcceptanceTests;

import Application.App;
import MeetingSystem.Builders.EventBuilder;
import MeetingSystem.Event;
import MeetingSystem.User;
import fit.ColumnFixture;

public class AddEvent extends ColumnFixture {


    private int min;
    private int max;
    private String time;
    private int current;

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    private Event createEvent(){
        EventBuilder eventBuilder = new EventBuilder(name,new User(), min, max,time);
        Event e = eventBuilder.build();
        e.setCurrentSlots(current);
        return e;
    }

    public String added(){
        App app = new App();
        Event event = createEvent();
        User user = new User();
        app.addEvent(event);
        app.signUserOnEvent(user,event);
        app.addEvent(event);


        if (app.getEventList().contains(event)){
            return "yes";
        }else {
            return "no";
        }
    }
}
