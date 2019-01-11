package AcceptanceTests;

import Application.App;
import Helpers.SearchType;
import MeetingSystem.Builders.EventBuilder;
import MeetingSystem.Event;
import MeetingSystem.User;
import fit.ColumnFixture;

public class SingOut extends ColumnFixture {

    public int min;
    public int max;
    public int current;

    public void setSinged(boolean singed) {
        this.singed = singed;
    }

    public boolean singed;

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    private Event createEvent(){
        EventBuilder eventBuilder = new EventBuilder("asd",new User(), min, max,"dzis");
        Event e = eventBuilder.build();
        e.setCurrentSlots(current);
        return e;
    }

    public String singOut(){
        App app = new App();
        Event event = createEvent();
        User user = new User();
        app.addEvent(event);
        app.signUserOnEvent(user,event);

        if (singed){
            app.signOffUserFromEvent(user,event);
        }

        if (app.searchEvent(SearchType.Name, event.getName()).getUserList().contains(user)){
            return "no";
        }else {
            return "yes";
        }
    }
}
