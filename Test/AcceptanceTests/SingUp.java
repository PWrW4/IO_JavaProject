package AcceptanceTests;

import Application.App;
import Helpers.SearchType;
import MeetingSystem.Builders.EventBuilder;
import MeetingSystem.Event;
import MeetingSystem.User;
import fit.ColumnFixture;


public class SingUp extends ColumnFixture {

    public int min;
    public int max;
    public int current;

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

    public String singUp(){
        App app = new App();
        Event event = createEvent();
        User user = new User();
        app.addEvent(event);
        app.signUserOnEvent(user,event);

        if (app.searchEvent(SearchType.Name, event.getName()).getUserList().contains(user)){
            return "yes";
        }else {
            return "no";
        }
    }
}


//!define TEST_SYSTEM {fit}
//        !path C:\Workspace\IO_Meetup\out\test\IO_Meetup
//        !path C:\Workspace\IO_Meetup\out\production\IO_Meetup
//
//
//        !| AcceptanceTests.SingUp |
//        | min | max | current | singUp? |
//        | 3   | 10  | 2       | yes 	|
//        | 10  | 10  | 1       | yes 	|
//        | 10  | 10  | 10      | no 	    |
//        | 10  | 10  | 11      | no 	    |
//        | 5   | 2   | 3       | no 	    |
//        | 10  | 15  | 22      | no 	    |
//        | 100 | 200 | 55      | yes 	|
//        | 50  | 51  | 50      | yes 	|